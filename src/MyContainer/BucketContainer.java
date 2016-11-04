package MyContainer;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class BucketContainer implements Serializable {
    private LinkedHashMap<Integer,Integer> id_amount = new LinkedHashMap<>();
    private LinkedHashSet<Integer> ids = new LinkedHashSet<>();
    private LinkedHashMap<Integer,Integer> id_price = new LinkedHashMap<>();
    private Integer fullCost = 0;

    public void addItem(Integer id, Integer a) {
        id_amount.put(id,a);
    }
    public void addItemPr(Integer id, Integer p){
        id_price.put(id,p);
    }

    public static BucketContainer get(HttpSession session){
        BucketContainer container = (BucketContainer) session.getAttribute("container");
        if (container == null){
            container = new BucketContainer();
            session.setAttribute("container",container);
        }
        return container;
    }

    public LinkedHashSet<Integer> getIds() {
        return ids;
    }

    public LinkedHashMap<Integer, Integer> getId_amount(){return id_amount;}

    public LinkedHashMap<Integer,Integer> getId_price(){return id_price;}

    public Integer getAmount(Integer id){
        return id_amount.get(id);
    }

    public Integer getPrice(Integer id){ return id_price.get(id);}

    public void addId(Integer id){
        ids.add(id);
    }

    public void addToFullCost(Integer k, Integer pr){
        fullCost+=multi(k,pr);
    }

    public Integer getFullCost(){
        return fullCost;
    }

    public void clearFullCost(){
        fullCost = 0;
    }

    public static Integer multi(Integer k, Integer pr){
        return k*pr;
    }

    public boolean isEmpty(){
        return (ids.size() == 0);
    }

}