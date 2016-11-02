package MyContainer;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class BucketContainer implements Serializable {
    private HashMap<Integer,Integer> id_amount = new HashMap<>();
    private HashSet<Integer> ids = new HashSet<>();
    private HashMap<Integer,Integer> id_price = new HashMap<>();
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

    public HashSet<Integer> getIds() {
        return ids;
    }

    public HashMap<Integer, Integer> getId_amount(){return id_amount;}

    public HashMap<Integer,Integer> getId_price(){return id_price;}

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

}