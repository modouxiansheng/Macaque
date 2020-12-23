package design;

/**
 * @program: javadevelop
 * @description:
 * @author: hu_pf
 * @create: 2020-12-10 18:19
 **/
public class TestMain {

    public static void main(String[] args) {
        DataToRedisCache dataToRedisCache = new DataToRedisCache();
        OldProductRecyclingItemDO o = new OldProductRecyclingItemDO();
        o.setId(1L);
        o.setCatId3(3L);
        dataToRedisCache.setToCache(o);

        TestDao d = new TestDao();
        d.setName("xx");
        d.setFieldName("ff");
        dataToRedisCache.setToCache(d);
    }
}
