package ConnectToDB;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@Entity
@Table(name="instruments")
@XmlRootElement
@NamedQueries({
      //  @NamedQuery(name = "InstrumentBean.findAll", query = "SELECT h FROM InstrumentBean"),
        @NamedQuery(name = "InstrumentBean.findById", query = "SELECT h FROM InstrumentBean h WHERE h.id = :id"),
        @NamedQuery(name = "InstrumentBean.findByType", query = "SELECT h FROM InstrumentBean h WHERE h.type = :type"),
        @NamedQuery(name = "InstrumentBean.findBySubtype", query = "SELECT h FROM InstrumentBean h WHERE h.subtype = :subtype")})
public class InstrumentBean implements Serializable {

    @Id
    //@Basic(optional = false)
    @Column(name= "instrument_id")
    private Integer id;
    @Column(name="type")
    private String type;
    @Column(name="subtype")
    private String subtype;
    private String name;
    @Column(name="price")
    private int price;
    private String image;
    private String description;
    private String reviews;
    private String details;
    private static int countOfInstrument;

    public InstrumentBean(){
        countOfInstrument = 0;
    }

    public InstrumentBean(String type,String subtype, Integer price){
        this.type = type;
        this.subtype = subtype;
        this.price = price;
    }

    public void incCount(){countOfInstrument++;}

    public void setId(Integer id){this.id = id;}
    public Integer getId() {return id;}
    public void setType(String type){this.type = type;}
    public String getType(){return this.type;}
    public void setSubtype(String type){this.subtype = type;}
    public String getSubtype(){return this.subtype;}
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {return this.name;}
    public void setPrice(int price) {this.price = price;}
    public int getPrice() {return this.price;}
    public void setImage(String image) {this.image = image;}
    public String getImage() {return this.image;}
    public void setDescription(String description) {this.description = description;}
    public String getDescription() {return this.description;}
    public void setReviews(String reviews) {this.reviews = reviews;}
    public String getReviews() {return this.reviews;}
    public void setDetails(String details) {this.details = details;}
    public String getDetails() {return this.details;}
}

