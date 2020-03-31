/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cdibeans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 * @since Mar 22, 2019
 */
@Named(value = "orderBean")
@SessionScoped
public class orderBean implements Serializable {
    private String  item;
    private double price ;
    private double total;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    @PostConstruct
    public void init(){
        this.item ="Microsoft 微軟 Surface Pro 6 LGP-0001";
        this.price = 28888;
        this.total = 0;
    }
    
    public String placeOrder(){
        total += price;
        return "confirm";
    }
    
}
