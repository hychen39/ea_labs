/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb3.session;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.ejb.Stateless;

/**
 * Portable JNDI names for EJB TimeServiceBean: 
 * [java:global/u06_time_service_ejb/TimeServiceBean, 
 * java:global/u06_time_service_ejb/TimeServiceBean!ejb3.session.TimeService]
 * @author steven
 */
@Stateless()
public class TimeServiceBean implements TimeService{

    @Override
    public String getTime() {
//        Java SE 7
//        Formatter fmt = new Formatter();
//        Calendar cal = Calendar.getInstance();
//        fmt.format("%tr", cal);
        
        // New DateTime API in Java SE 8
        LocalDateTime current = LocalDateTime.now(); // get the current date
        DateTimeFormatter df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String dataTimeStr = current.format(df);
        return dataTimeStr;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
