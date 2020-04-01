/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.inject.Named;

/**
 *
 * @author steven
 */
@Named
@SessionScoped
public class Imitator implements Serializable {

    private String source = "Default value set in the Bean.";
    private HtmlInputText target;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
        if (source != null) {
            target.setValue(source);
        } else {
            target.setValue("No values");
        }
    }

    public HtmlInputText getTarget() {
        return target;
    }

    public void setTarget(HtmlInputText target) {
        this.target = target;
    }

}
