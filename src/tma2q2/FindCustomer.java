package tma2q2;
//entity to find 
import java.io.*;
//import java.io.Serializable;
//import javax.persistence.Temporal;//2
//import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;
//import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FindCustomer  {

    //private static final long serialVersionUID = 1L;
    //@Id
    //@Basic(optional = false)
    //@Column(name = "ID")
    //private Integer id;
    //@Column(name = "EMAIL")
    //private String email;
    //@Column(name = "PASS")
    //private String pass;
    //@Column(name = "NAME")
    //private String name;
    //@Column(name = "ADDRESS")
    //private String address;
    //@Column(name = "YOB")
    //private String yob;

    //public Customer() {
    //}

    //public Customer(Integer id) {
    //    this.id = id;
    //}

    //public Integer getId() {
    //    return id;
    //}

    //public void setId(Integer id) {
    //    this.id = id;
    //}

    //public String getEmail() {
    //    return email;
    //}

    //public void setEmail(String email) {
    //    this.email = email;
    //}

    //public String getPass() {
    //    return pass;
    //}

    //public void setPass(String pass) {
    //    this.pass = pass;
    //}

    //public String getName() {
    //    return name;
    //}

    //public void setName(String name) {
    //    this.name = name;
    //}

    //public String getAddress() {
    //    return address;
    //}

    //public void setAddress(String address) {
    //    this.address = address;
    //}

    //public String getYob() {
    //    return yob;
    //}

    //public void setYob(String yob) {
    //    this.yob = yob;
    //}

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

    //@Override
    //public String toString() {
    //    return "tma2q2.Customer[ id=" + id + " ]";
    //}
    
    public static void main(String[] args)throws Exception {
        System.out.println("hello from Customer.java");
        //Customer cust1 = new Customer();
        //cust1.setId(1);
        //cust1.setEmail("peter@example.com");
        //cust1.setPass("peterpass");
        //cust1.setName("Peter Lee");
        //cust1.setAddress("2, Good Road");
        //cust1.setYob("2001");
        
        //System.out.println("email: " + cust1.getEmail());
        //System.out.println("name: " + cust1.getName());
        //@Query(query = "SELECT c FROM customer c");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("customerPU");
        EntityManager manager = factory.createEntityManager();
        Query q1 = manager.createQuery("SELECT COUNT(c) FROM Customer c");
        Long count = (Long) q1.getSingleResult();
        if(count==0){
            //record is empty, read from data.txst
            System.out.println("record empty, read from data.txt");
            //try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s = br.readLine()) != null) {
                System.out.println(s);
            }
            fr.close();
            //insert data into database table
            //display the records

        }    
        else
            //display the records
            System.out.println("Number of customers: " + count);
        // transaction
        manager.getTransaction().begin();
        //Customer c1 = new Customer();
        //c1.setName("Julia");
        //c1.setEmail("julia@example.com");
        //c1.setPass("juliapass");
        //manager.persist(c1);
        //System.out.println("created customer ID: " + c1.getId());
        manager.getTransaction().commit();
        
        manager.close();
        factory.close();
    }
            
}

