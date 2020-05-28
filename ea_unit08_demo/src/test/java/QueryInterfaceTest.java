/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import me.hychen39.unit08_demo.entities.Customer;
import me.hychen39.unit08_demo.entities.MicroMarket;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 *
 * @author user
 */
public class QueryInterfaceTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public QueryInterfaceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("eaUnit08PU");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDownClass() {
        em.close();
        emf.close();
    }

   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    private void printCustomerInfo(List customers) {
        for (Object o : customers) {
            if (o instanceof Customer) {
                Customer cust = (Customer) o;
                System.out.println(cust.getCustomerId() + " " + cust.getName());
            }
        }
        System.out.println("---------");
    }

    private void printTypedCustomerInfo(List<Customer> customers) {
        customers.forEach((cust) -> {
            System.out.println(cust.getCustomerId() + " " + cust.getName());
        });
        System.out.println("---------");
    }

    @Test
    public void testDynamicSelectStmt() {
        final String stmt = "select cust from Customer cust";
        Query query = em.createQuery(stmt);
        List results = query.getResultList();
        Assert.assertNotNull("Test dynamic ql statement using Query object", results);
        System.out.println("testDynamicSelectStmt()");
        printCustomerInfo(results);
    }
    
    @Test
    public void selectStmt() {
        final String stmt = "select cust from Customer cust";
        TypedQuery<Customer> query = em.createQuery(stmt, Customer.class);
        List<Customer> customers = query
                                    .setFirstResult(5)
                                    .setMaxResults(5)
                                    .getResultList();
        Assert.assertNotNull(customers);
        System.out.println("selectStmt()");
        printTypedCustomerInfo(customers);
    }


    @Test
    public void testNamedSelectStmt() {
        final String namedStmt = "Customer.findByCity";
        final String cityToFind = "Dearborn";
        // SELECT c FROM Customer c WHERE c.city = :city
        Query query = em.createNamedQuery(namedStmt).setParameter("city", cityToFind);
        List results = query.getResultList();
        Assert.assertNotNull(results);
//        assertNotNull(results);
        System.out.println("testNamedSelectStmt()");
        printCustomerInfo(results);

    }
    
     @Test
    public void testTypeNamedQuery() {
        final String namedStmt = "Customer.findByCity";
        final String cityToFind = "Dearborn";
        // SELECT c FROM Customer c WHERE c.city = :city
        TypedQuery<Customer> query;
        query = em.createNamedQuery(namedStmt, Customer.class).setParameter("city", cityToFind);
        List<Customer> results = query.getResultList();
        Assert.assertNotNull(results);
        System.out.println("testTypeNamedQuery()");
        printCustomerInfo(results);
    }
    
    @Test
    public void testCombineExpression() {
        final String stmt = "select cust.name, cust.phone, cust.zip from Customer cust";
        
        // SELECT c FROM Customer c WHERE c.city = :city
        Query query;
        query = em.createQuery(stmt);
        List<Object []> results = query.getResultList();
        Assert.assertNotNull(results);
        System.out.println("testCombineExpression()");
        for (Object [] objs: results){
            System.out.printf("Name: %s, Phone: %s ", (String) objs[0], (String) objs[1]);
            System.out.println(" Zip Code:" + ((MicroMarket) objs[2]).getZipCode());       
        }
        
        System.out.println("---------");
    }
}
