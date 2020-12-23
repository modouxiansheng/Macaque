package gc;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CardTableFalseSharingTest {
    private final static ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);;
// private final static ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);


    public static void main(String[] args) throws InterruptedException {

        int loop = 10_000_000;
        int retry = 10;
        test(loop, retry);

        EXECUTOR_SERVICE.shutdown();
        EXECUTOR_SERVICE.awaitTermination(1000L, TimeUnit.MILLISECONDS);
    }

    private static void test(int loop, int retry) {
        // 在同一个线程中分配两个对象, 由于 TLAB 的存在, 理论上这两个对象相距很近
        Obj64 x1 = new Obj64();
        Obj64 x2 = new Obj64();
        // 大对象直接进入老年代, 为了得到一个 老年代 -> eden 代的引用
        HugeObj hugeObj10M = new HugeObj(10 * 1024 * 1024, x1, x2);
        testX1AndX2(loop, retry, x1, x2, hugeObj10M);
    }

    private static void testX1AndX2(final int loop, final int retry, final Obj64 x1, final Obj64 x2, final HugeObj hugeObj) {
        long all = 0L;
        int r = retry;
        long[] record = new long[retry];
        while (r-- > 0) {
            final CountDownLatch endLatch = new CountDownLatch(2);
            long l1 = System.currentTimeMillis();
            EXECUTOR_SERVICE.execute(() -> {
                int count = loop;
                while (count-- > 0) {
                    if ((count & 1) == 0) {
                        hugeObj.x1 = x1;
                    } else {
                        hugeObj.x1 = x2;
                    }
                }
                endLatch.countDown();
            });
            EXECUTOR_SERVICE.execute(() -> {
                int count = loop;
                while (count-- > 0) {
                    if ((count & 1) == 0) {
                        hugeObj.x2 = x2;
                    } else {
                        hugeObj.x2 = x1;
                    }
                }
                endLatch.countDown();
            });

            try {
                endLatch.await();
                long l2 = System.currentTimeMillis();
                all += (l2 - l1);
                record[retry - 1 - r] = l2 - l1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("average:%dms %s", all / retry, Arrays.toString(record)));

    }

    private static class Obj64 {
        long l1;
        long l2, l3, l4, l5;
    }

    private static class HugeObj {
        private byte[] hugeArray;
        private Obj64 x1;
        private Obj64 x2;

        public HugeObj(int byteLen, Obj64 x1, Obj64 x2) {
            this.hugeArray = new byte[byteLen];
            this.x1 = x1;
            this.x2 = x2;
        }
    }
}