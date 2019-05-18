/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session_beans;

import entities.PurchaseOrder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 * @since May 18, 2019
 */
@Stateless
public class PurchaseOrderFacade extends AbstractFacade<PurchaseOrder> {

    @PersistenceContext(unitName = "ea_unit09_demoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PurchaseOrderFacade() {
        super(PurchaseOrder.class);
    }

}
