/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb3.session;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class TimeServiceBeanTest {
    
    public TimeServiceBeanTest() {
    }

    /**
     * Test of getTime method, of class TimeServiceBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetTime() throws Exception {
        // Not using the injection service from the app server.
        TimeServiceBean timeServiceBean = new TimeServiceBean();
        String outcome = timeServiceBean.getTime();
        System.out.println(outcome);
        assertNotNull(outcome);
    }
    
}
