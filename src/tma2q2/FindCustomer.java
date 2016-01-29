package tma2q2;
//entity to find 
import java.io.*;
import java.util.*;
//import javax.persistence.Temporal;//2
//import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;
//import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FindCustomer  {


      
    public static void main(String[] args)throws Exception {
        System.out.println("hello from Customer.java");
        

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("customerPU");
        EntityManager manager = factory.createEntityManager();
        Query q1 = manager.createQuery("SELECT COUNT(c) FROM Customer c");
        Long count = (Long) q1.getSingleResult();
        if(count==0){
            //record is empty, read from data.txst
            System.out.println("record empty, read from data.txt...");
            //try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s = br.readLine()) != null) {
                
                //System.out.println(s);
                //split the string s
                Object [] items = s.split("\\|");
                // store in string list
                //List<String> itemList= new ArrayList<String>(Arrays.asList(items));
                // string list converted to array
                
                
                //Object[] itemArray = itemList.toArray();
                //insert data into database table
                manager.getTransaction().begin();
                Customer c = new Customer();
                
                //add email
                c.setEmail((String)items[0]);
                 
                //add pass
                c.setPass((String)items[1]);
                
                //add name
                c.setName((String)items[2]);
                
                //add address
                c.setAddress((String)items[3]);
                 
                //add yob
                c.setYob((String)items[4]);
                 
                // change to managed state
                manager.persist(c);
                manager.getTransaction().commit();
            }
            fr.close();

        }    
        
        //display the records
        Query q2 = manager.createNamedQuery("Customer.findAll");
        List<Customer> customers = q2.getResultList();
        for (Customer c : customers) {
            System.out.println(c.getName() + ", " + c.getEmail());
        }
            
        manager.close();
        factory.close();
    }
            
}

