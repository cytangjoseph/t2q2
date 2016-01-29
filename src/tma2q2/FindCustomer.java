package tma2q2;
//entity to find 
import java.io.*;
import java.util.*;
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
                String[] items = s.split("\\|");
                // store in string list
                List<String> itemList= new ArrayList<String>(Arrays.asList(items));
                // string list converted to array
                
                
                 Object[] itemArray = itemList.toArray();
                //insert data into database table
                manager.getTransaction().begin();
                Customer c1 = new Customer();
                
                //add email
                String email = (String)itemArray[0];
                c1.setEmail(email);
               //System.out.println("email: " + c1.getEmail());
                
                //add pass
                String pass = (String)itemArray[1];
                c1.setPass(pass);
                //ystem.out.println("password: " + c1.getPass());
                
                //add name
                String name = (String)itemArray[2];
                c1.setName(name);
                //System.out.println("name: " + c1.getName());
                
                //add address
                String address = (String)itemArray[3];
                c1.setAddress(address);
                //System.out.println("address: " + c1.getAddress());
                
                //add yob
                String yob = (String)itemArray[4];
                c1.setYob(yob);
                //System.out.println("yob: " + c1.getYob());
                
                // change to managed state
                manager.persist(c1);
                manager.getTransaction().commit();
            }
            fr.close();

        }    
        
        //display the records
        Query q2 = manager.createNamedQuery("Customer.findAll");
        List<Customer> customers = q2.getResultList();
        for (Customer c: customers){
            System.out.println(c.getName() + ", " + c.getEmail());
        }
                
               
              
             
        
        manager.close();
        factory.close();
    }
            
}

