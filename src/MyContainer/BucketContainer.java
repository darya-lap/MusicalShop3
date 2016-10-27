package MyContainer;

import java.util.LinkedHashMap;

public class BucketContainer {
    public static LinkedHashMap<Integer,Integer> bucket = new LinkedHashMap<>();

    public static void addToBucketList(Integer id,Integer amount){
        bucket.put(id,amount);
    }
}
