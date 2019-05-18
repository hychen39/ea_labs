/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Customer;
import entities.MicroMarket;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 */
public class QueryInterfaceTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public QueryInterfaceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("DerbySampleTestPU");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDownClass() {
        em.close();
        emf.close();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testDynamicSelectStmt() {
        final String stmt = "select cust from Customer cust";
        Query query = em.createQuery(stmt);
        List results = query.getResultList();
        assertNotNull("Test dynamic ql statement using Query object", results);
        System.out.println("testDynamicSelectStmt()");
        printCustomerInfo(results);
    }

    @Test
    public void testNamedSelectStmt() {
        final String namedStmt = "Customer.findByCity";
        final String cityToFind = "Dearborn";
        // SELECT c FROM Customer c WHERE c.city = :city
        Query query = em.createNamedQuery(namedStmt).setParameter("city", cityToFind);
        List results = query.getResultList();
        assertNotNull(results);
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
        assertNotNull(results);
        System.out.println("testTypeNamedQuery()");
        printCustomerInfo(results);
    }

    @Test
    public void testCombineExpression() {
        final String stmt = "select cust.name, cust.phone, cust.zip from Customer cust";

        // SELECT c FROM Customer c WHERE c.city = :city
        Query query;
        query = em.createQuery(stmt);
        List<Object[]> results = query.getResultList();
        assertNotNull(results);
        System.out.println("testCombineExpression()");
        for (Object[] objs : results) {
            System.out.printf("Name: %s, Phone: %s ", (String) objs[0], (String) objs[1]);
            System.out.println(" Zip Code:" + ((MicroMarket) objs[2]).getZipCode());
        }

        System.out.println("---------");
    }

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
}
