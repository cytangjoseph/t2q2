package tma2q2;
// ---- Entity class ----
//import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;//2
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CUSTOMER")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
    @NamedQuery(name = "Customer.findByPass", query = "SELECT c FROM Customer c WHERE c.pass = :pass"),
    @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name"),
    @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address"),
    @NamedQuery(name = "Customer.findByYob", query = "SELECT c FROM Customer c WHERE c.yob = :yob"),
    @NamedQuery(name = "customer.recordCount", query = "SELECT count(c) from Customer c")
})
//public class Customer implements Serializable {//2
public class Customer {
    //private static final long serialVersionUID = 1L;//2
    @Id
    @GeneratedValue//2 auto generate unique id
    @Basic(optional = false)//3
    @Column(name = "ID")//3
    private int id;
    @Column(name = "EMAIL")//3
    private String email;
    @Column(name = "PASS")//3
    private String pass;
    @Column(name = "NAME")//3
    private String name;
    @Column(name = "ADDRESS")//3
    private String address;
    @Column(name = "YOB")//3
    private String yob;

    public Customer() {
    }

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    //@Override
    //public int hashCode() {
    //    int hash = 0;
    //    hash += (id != null ? id.hashCode() : 0);
    //    return hash;
    //}

    //@Override
    //public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
    //    if (!(object instanceof Customer)) {
    //        return false;
    //    }
    //    Customer other = (Customer) object;
    //    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
    //        return false;
    //    }
    //    return true;
    //}

    @Override
    public String toString() {
        return "Customer{" + "id=" + id  + ", name =" + name + ", pass =" + pass + ", address =" + address  + ", youb =" + yob;
    }
    
                
}
