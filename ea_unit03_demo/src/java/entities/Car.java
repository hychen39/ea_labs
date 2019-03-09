/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 * @since Mar 9, 2019
 */
public class Car {
    // car id
    private int id;
    // brand name
    private String brand;
    // engine hoursepower
    private String engine_hp;

    public Car(int id, String brand, String engine_hp) {
        this.id = id;
        this.brand = brand;
        this.engine_hp = engine_hp;
    }
    
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEngine_hp() {
        return engine_hp;
    }

    public void setEngine_hp(String engine_hp) {
        this.engine_hp = engine_hp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
