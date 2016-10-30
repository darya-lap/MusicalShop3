package MyContainer;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BucketContainer implements Serializable {

    private Map<Integer,Integer> id_amount = new HashMap<>();


    public void addItem(Integer id, Integer a) {
        id_amount.put(id,a);
    }

    public static BucketContainer get(HttpSession session){
        BucketContainer container = (BucketContainer) session.getAttribute("container");
        if (container == null){
            container = new BucketContainer();
            session.setAttribute("container",container);
        }
        return container;
    }

    public Set<Integer> getIds(){
        return id_amount.keySet();
    }

}