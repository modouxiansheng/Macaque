package design;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OldProductRecyclingItemDO implements RedisMap{

    private long id;
    private long catId1;
    private long catId2;
    private long catId3;
    private String catName1;
    private String catName2;
    private String catName3;
    private String attribute;
    private String ageLimitMoney;
    private String creator;
    private String modifier;
    private String name;




    public String getMapKey(){
        return String.valueOf(this.catId3);
    }

    public String getMapField(){
        return String.valueOf(this.id);
    }


}