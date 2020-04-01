/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author steven
 */
@Named
@ConversationScoped
public class AuctionItemsBean implements Serializable {
    private String newItemName;
    private List<String> items = new ArrayList<String>();
    private String newItem;

    public String getNewItem() {
        return newItem;
    }

    public void setNewItem(String newItem) {
        this.newItem = newItem;
    }
    @Inject Conversation conversation;

    public String getNewItemName() {
        return newItemName;
    }

    public void setNewItemName(String newItemName) {
        this.newItemName = newItemName;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public void deleteItem(String item ){
        items.remove(item);
    }
    
    @PostConstruct
    public void init(){
        conversation.begin();
        items.add("Jaguar Mk2");
        items.add("Alfa Romeo GT & GTV");
        items.add("Ford Mustang");
        items.add("Lancia Aurelia");
    }
    
    public int size(){
        return items.size();
    }
    
    public String end(){
        conversation.end();
        return "index";
    }
    
    /**
     * Add item to the list
     */
    public void addItem(){
        if (!"".equals(newItemName)){
            items.add(newItemName);
        } else {
            String msg = "You give me no name!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
        }
    }
    
}
