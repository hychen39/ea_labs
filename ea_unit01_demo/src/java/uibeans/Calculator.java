/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uibeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 */
@Named(value = "calculator")
@RequestScoped
public class Calculator {

    private float value1 = 0;
    private float value2 = 0;
    private float result = 0;

    /**
     * Get the value of value1
     *
     * @return the value of value1
     */
    public float getValue1() {
        return value1;
    }

    /**
     * Set the value of value1
     *
     * @param value1 new value of value1
     */
    public void setValue1(float value1) {
        this.value1 = value1;
    }

    /**
     * Get the value of value2
     *
     * @return the value of value2
     */
    public float getValue2() {
        return value2;
    }

    /**
     * Set the value of value2
     *
     * @param value2 new value of value2
     */
    public void setValue2(float value2) {
        this.value2 = value2;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    
    /**
     * Creates a new instance of Calculator
     */
    public Calculator() {
    }
    
    /**
     * Action method to sum value1 and value2.
     * @return the name of the target page.
     */
    public String sumAction(){
        result = value1 + value2;
        return "result";
    }
}
