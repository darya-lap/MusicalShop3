package ConnectToDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name="orders")
@XmlRootElement
public class Order {
    @Id
    //@Basic(optional = false)
    @Column(name= "order_id")
    private int order_id;
    @Column(name="user")
    private String user;
    @Column(name="instrument_id")
    private int instrument_id;
    @Column(name="amount")
    private int amount;
    @Column(name="date")
    private Date curDate;
    @Column(name="courier")
    private String courier;
    @Column(name = "shop")
    private String shop;


    public Order(int order_id, String user, int instrument_id, int amount, Date date){
        this.order_id=order_id;
        this.user =user;
        this.instrument_id = instrument_id;
        this.amount = amount;
        this.curDate = date;
    }

    public Order() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getUser() {
        return user;
    }

    public int getInstrument_id() {
        return instrument_id;
    }

    public int getAmount() {
        return amount;
    }

    public Date getCurDate() {
        return curDate;
    }

    public String getCourier() {
        return courier;
    }

    public String getShop() {
        return shop;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setInstrument_id(int instrument_id) {
        this.instrument_id = instrument_id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }



}
