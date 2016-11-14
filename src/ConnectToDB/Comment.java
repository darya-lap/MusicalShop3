package ConnectToDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name="comment")
@XmlRootElement
public class Comment implements Serializable {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUser(String user) {
        this.user = user;
    }


    @Id
    //@Basic(optional = false)
    @Column(name= "date")
    private String date;
    @Column(name="user")
    private String user;

    public Comment(){
    }
}
