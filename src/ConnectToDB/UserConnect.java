package ConnectToDB;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@Entity
@Table(name="users")
@XmlRootElement
//@NamedQueries(value = {
//        @NamedQuery(name = "InstrumentBean.findAll", query = "SELECT h FROM InstrumentBean"),
//        @NamedQuery(name = "InstrumentBean.findById", query = "SELECT h FROM UserConnect h WHERE h.id = :id"),
//        @NamedQuery(name = "UserConnect.findByType", query = "SELECT h FROM InstrumentBean h WHERE h.type = :type"),
//        @NamedQuery(name = "UserConnect.findBySubtype", query = "SELECT h FROM InstrumentBean h WHERE h.subtype = :subtype")})
public class UserConnect implements Serializable {

    @Id
    //@Basic(optional = false)
    @Column(name= "user_login")
    private String login;
    @Column(name="first_name")
    private String first_name;
    @Column(name="email")
    private String email;

    public String getEmail() {
        return email;
    }

    public UserConnect(){
    }

    public UserConnect(String login,String first_name, String email){
        this.login = login;
        this.first_name = first_name;
        this.email = email;
    }


    public void setLogin(String login){this.login = login;}
    public String getLogin() {return login;}
    public void setFirst_name(String name){this.first_name = name;}
    public String getFirst_name(){return this.first_name;}
    public void setEmail(String email){this.email = email;}
}