/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb3.session;

import ejb.session.TimeServiceRemote;
import java.util.Calendar;
import java.util.Formatter;
import javax.ejb.Stateless;

/**
 *
 * @author steven
 */
@Stateless
public class TimeServiceBean implements TimeServiceRemote {

    @Override
    public String getTime() {
        Formatter  fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt.format("%tr", cal);
        return fmt.toString();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
