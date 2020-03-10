/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.MemberCenter;
import entities.MemberCenter.Member;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
//  SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author admin
 */
@Named("memberBean")
//@RequestScoped
@SessionScoped
public class MemberBean implements java.io.Serializable {

    private Member selectedMember;
    
    private String number;
    private String name;
    private String type;

    public MemberBean() {
       
    }

    public Member getSelectedMember() {
        return selectedMember;
    }

    public void setSelectedMember(Member selectedMember) {
        this.selectedMember = selectedMember;
    }

    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Action Listener
     * @param event 
     */
    public void selectTypeAction(ActionEvent event) {
        
        // get the Attribut Map of the Component
        Map<String, Object> attributes = event.getComponent().getAttributes();
        String custType = (String) attributes.get("custType");
        
        this.selectedMember = "GOLD".equals(custType)?
                                   MemberCenter.getGoldMember():MemberCenter.getPlatinumMember();
        System.out.println("Invoke the Action Event");
    }
    /**
     * Action Method
     * @return target page name
     */
    public String showMemberInfo(){
        // get parameter values from f:param f
        String custType;
        custType = FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .getRequestParameterMap().get("custType");
        // put the data to the bean property.
        this.selectedMember = "GOLD".equals(custType)?
                                   MemberCenter.getGoldMember():MemberCenter.getPlatinumMember();
            
        System.out.println("Invoke the Action Method");
        return "/core_tags/memberInfo?faces-redirect=true";
    }

}
