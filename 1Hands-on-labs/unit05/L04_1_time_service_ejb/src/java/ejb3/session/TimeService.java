/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb3.session;

import javax.ejb.Remote;

/**
 * The remote view to provide time service methods
 * @author steven
 */
@Remote
public interface TimeService {
    public String getTime();
}
