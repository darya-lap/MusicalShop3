package ConnectToDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name="shops")
@XmlRootElement
public class Shop {

    @Id
    //@Basic(optional = false)
    @Column(name= "number_of_shop")
    private int number_of_shop;
    @Column(name="lat")
    private float lat;
    @Column(name="lng")
    private float lng;
    @Column(name="name_of_shop")
    private String name_of_shop;

    public Shop(int number, float lt, float lg, String name){
        number_of_shop=number;
        lat=lt;
        lng=lg;
        name_of_shop=name;
    }

    public Shop() {
    }


    public int getNumber_of_shop() {return number_of_shop;}
    public void setNumber_of_shop(int number_of_shop) {
        this.number_of_shop = number_of_shop;
    }

    public float getLat() {
        return lat;
    }
    public void setLat(float lat) {
        this.lat = lat;
    }

    public String getName_of_shop() {
        return name_of_shop;
    }
    public void setName_of_shop(String name_of_shop) {
        this.name_of_shop = name_of_shop;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
}
