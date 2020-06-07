/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named(value = "ajaxListener")
@RequestScoped
public class AjaxListener implements AjaxBehaviorListener {

    @Override
    public void processAjaxBehavior(AjaxBehaviorEvent abe) throws AbortProcessingException {
        String msg;
        msg = "Phase that the Ajax Event occurs : " + abe.getPhaseId().getName();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
    }

}
