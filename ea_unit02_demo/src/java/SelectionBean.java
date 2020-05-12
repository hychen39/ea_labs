/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Car;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

/**
 *
 * @author user
 */
@Named(value = "selectionBean")
@SessionScoped
public class SelectionBean implements Serializable {
    
    private String itemLabelToAdd;
    private String itemValueToAdd;
    private List<SelectItem> options;
    private String selectedValue;
    private String selectedValue2;
    private List<Car> cars;
    private String selectedCarID;

    public String getSelectedCarID() {
        return selectedCarID;
    }

    public void setSelectedCarID(String selectedCarID) {
        this.selectedCarID = selectedCarID;
    }
    
    public List<Car> getCars() {
        return cars;
    }
    
    public Collection<Car> getCarsCollection(){
        return cars;
    }
    
    public Set<Car> getCarsSet(){
        return new HashSet<>(cars);
    }
    public ArrayList<Car> getCarsArrayList(){
        return (ArrayList<Car>) cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    
    public SelectionBean() {
        
    }
    
    @PostConstruct
    public void initBean(){
        options = new LinkedList<>();
        options.add(new SelectItem(1, "Item 1"));
        options.add(new SelectItem(2, "Item 2"));
        cars = new ArrayList<>();
        cars.add(new Car(1, "Toyta YARIS", "90 hp"));
        cars.add(new Car(2, "Toyta SIENTA", "100 hp"));
        cars.add(new Car(3, "Toyta VIOS", "100 hp"));
        
        
    }

    public String getSelectedValue2() {
        return selectedValue2;
    }

    public void setSelectedValue2(String selectedValue2) {
        this.selectedValue2 = selectedValue2;
    }

    
    public String getItemLabelToAdd() {
        return itemLabelToAdd;
    }

    public void setItemLabelToAdd(String itemLabelToAdd) {
        this.itemLabelToAdd = itemLabelToAdd;
    }

    public String getItemValueToAdd() {
        return itemValueToAdd;
    }

    public void setItemValueToAdd(String itemValueToAdd) {
        this.itemValueToAdd = itemValueToAdd;
    }

    
    
    public List<SelectItem> getOptions() {
        return options;
    }

    public void setOptions(List<SelectItem> options) {
        this.options = options;
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }
    
    public void addItem(){
        options.add(new SelectItem(this.itemValueToAdd, this.itemLabelToAdd));
    }
    
    
}
