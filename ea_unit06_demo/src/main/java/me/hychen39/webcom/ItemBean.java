/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hychen39.webcom;

import java.io.Serializable;
import javax.inject.Named;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

import me.hychen39.ejb.ItemFacade;
import me.hychen39.entities.Item;

/**
 *
 * @author user
 */
@Named(value = "itemBean")
// A @ViewScoped bean lives as long as you're interacting with the same JSF view by postbacks which call action methods returning null/void without any navigation/redirect.
// A view scoped bean needs to implement the Serializable interface 
@ViewScoped
public class ItemBean implements Serializable{
    
    @EJB
    private ItemFacade itemFacade;
    private Item newItem;
    private boolean isEditMode;
    /**
     * Creates a new instance of ItemBean
     */
    public ItemBean() {
        
    }
    
    @PostConstruct
    public void init(){
        newItem = new Item();
        System.out.println("init. new Item()");
    }
    
    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }

    public boolean isIsEditMode() {
        return isEditMode;
    }

    public void setIsEditMode(boolean isEditMode) {
        this.isEditMode = isEditMode;
    }
    
    
    
    public List<Item> findAll(){
        return itemFacade.findAll();
    }
    
    private void cleanForm(){
        this.newItem = new Item();
    }
    public String addItem(){
        itemFacade.create(newItem);
        this.cleanForm();
        return null;
    }
    
    /**
     * Delete item from the DB
     * @param id
     * @return 
     */
    public String delItem(int id){
        // get item 
        Item item = itemFacade.find(Long.valueOf(id));
        itemFacade.remove(item);
        return null;
    }
    
    public String editItem(int id){
        System.out.println("EditItem");
        this.isEditMode = true;
        this.newItem = itemFacade.find(Long.valueOf(id));
        return null;
    }
    
    public String updateItem(){
        this.isEditMode = false;
        itemFacade.edit(newItem);
        cleanForm();
        return null;
    }
}
