package design;

import lombok.Data;

/**
 * @program: javadevelop
 * @description:
 * @author: hu_pf
 * @create: 2020-12-10 18:19
 **/

@Data
public class TestDao implements RedisMap{

    private String name;

    private String fieldName;

    @Override
    public String getMapKey() {
        return this.name;
    }

    @Override
    public String getMapField() {
        return this.fieldName;
    }
}
