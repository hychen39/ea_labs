/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UICommand;

/**
 *
 * @author user
 */
@Named(value = "registerBean")
@RequestScoped
public class RegisterBean {
    private String name;
    private String tel;
    private UICommand commandComponent;
    
    /**
     * Creates a new instance of RegisterBean
     */
    public RegisterBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public String cancel() {
        return "index";
    }

    public UICommand getCommandComponent() {
        return commandComponent;
    }

    public void setCommandComponent(UICommand commandComponent) {
        this.commandComponent = commandComponent;
    }
    
    public void turnImmediateOn(){
        commandComponent.setImmediate(true);
    }
    
    public void turnImmediateOff(){
        commandComponent.setImmediate(false);
    }
    public boolean getImmediateStatus(){
        return commandComponent.isImmediate();
    }
}
