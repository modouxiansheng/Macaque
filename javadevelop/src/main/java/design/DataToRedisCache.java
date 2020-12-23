package design;

/**
 * @program: javadevelop
 * @description: 数据入Redis
 * @author: hu_pf
 * @create: 2020-12-10 18:12
 **/
public class DataToRedisCache implements DataToCache<RedisMap>{

    @Override
    public void setToCache(RedisMap o) {
        System.out.printf("key:"+o.getMapKey()+" field:"+o.getMapField());
    }
}
