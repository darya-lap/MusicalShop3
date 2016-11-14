package MyContainer;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderContainer implements Serializable {
    private String number = "";
    private String lat = "";
    private String lng = "";
    private String names = "";
    private Integer amount_of_shops = 0;
    private List<String> names_array = new ArrayList<>();
    private List<Integer> ids = new ArrayList<>();

    public List<Integer> getCount() {
        return count;
    }

    public void setCount(List<Integer> count) {
        this.count = count;
    }

    private List<Integer> count = new ArrayList<>();

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }


    public List<String> getNames_array() {
        return names_array;
    }

    public void setNames_array(List<String> names_array) {
        this.names_array = names_array;
    }



    public String getSecretMessage() {
        return secretMessage;
    }

    public void setSecretMessage(String secretMessage) {
        this.secretMessage = secretMessage;
    }

    private String secretMessage;
//    private List<?> ids = new ArrayList<>();
//
//    public List<?> getIds() {
//        return ids;
//    }
//
//    public void setIds(List<?> ids) {
//        this.ids = ids;
//    }


    public Integer getAmount_of_shops() {
        return amount_of_shops;
    }

    public void setAmount_of_shops(Integer amount_of_shops) {
        this.amount_of_shops = amount_of_shops;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public static OrderContainer get(HttpSession session){
        OrderContainer container = (OrderContainer) session.getAttribute("order");
        if (container == null){
            container = new OrderContainer();
            session.setAttribute("order",container);
        }
        return container;
    }

}