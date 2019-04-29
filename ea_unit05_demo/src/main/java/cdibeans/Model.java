/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 */
@Named(value = "model")
@RequestScoped
public class Model {

    /**
     * Creates a new instance of Model
     */
    public Model() {
    }
    
    public String toPage01() {
        return "page01";
    }
    
}
