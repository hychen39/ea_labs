/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hychen39.webcom;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import me.hychen39.ejb.ItemFacade;
import me.hychen39.entities.Item;

/**
 *
 * @author user
 */
@Named(value = "itemBean")
@RequestScoped
public class ItemBean  {
    
    @EJB
    private ItemFacade itemFacade;
    private Item newItem;
    /**
     * Creates a new instance of ItemBean
     */
    public ItemBean() {
    }
    
    @PostConstruct
    private void init(){
        newItem = new Item();
    }
    
    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }
    
    public List<Item> findAll(){
        return itemFacade.findAll();
    }
    
    public String addItem(){
        itemFacade.create(newItem);
        this.newItem = new Item();
        return "index";
    }
}
