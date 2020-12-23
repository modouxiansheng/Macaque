package gc;

public class MiniorGcLongTime {

    public static Integer MB = 1024 * 1024;

    //  -XX:NewSize=10M -XX:MaxNewSize=10M -XX:InitialHeapSize=20M -XX:MaxHeapSize=20M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
    public static void main(String[] args) {

//        byte [] array1 = new byte[3 * MB];
//        array1 = new byte[3 * MB];
//        array1 = new byte[3 * MB];
//        array1 = null;
//
//        byte [] array2 = new byte[128 * 1024];
//        byte [] array3 = new byte[2 * MB];
//
//        array3 = new byte[2 * MB];
//        array3 = new byte[2 * MB];
//        array3 = new byte[128 * 1024];
//        array3 = null;
//
//        byte [] array4 = new byte[2 * MB];

        byte [] array1 = new byte[4 * MB];
        array1 = null;

        byte [] array2 = new byte[2 * MB];
        byte [] array3 = new byte[2 * MB];
        byte [] array4 = new byte[2 * MB];
        byte [] array5 = new byte[128 * 1024];

        byte [] array6 = new byte[2 * MB];

//        byte [] array1 = new byte[7 * MB];
//        array1 = null;
//
//        for (int i = 0; i < 2; i++) {
//            byte [] array2 = new byte[2 * MB];
//            array2 = new byte[2 * MB];
//            array2 = new byte[3 * MB];
//            array2 = new byte[128 * 1024];
//            array2 = null;
//
//            byte [] array3 = new byte[1 * MB];
//        }


    }


}
