package workWithServletes;

import MyContainer.BucketContainer;

public class addItemToBean {
    public static void addItemToBean(String id1, String value, BucketContainer bean){
        int i = 0;
        while (id1.charAt(i) != '&') {
            i++;
        }
        String id = id1.substring(0, i);
        String price = id1.substring(i + 1);
        if (value != null) {
            bean.addItem(Integer.parseInt(id), Integer.parseInt(value));
            bean.addId(Integer.parseInt(id));
            bean.addItemPr(Integer.parseInt(id), Integer.parseInt(price));
        }
    }
}
