package cdibeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author user
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {
    
    private String username;
    private String passwd;
    private boolean isLoginEnable;
    /**
     * Creates a new instance of Login
     */
    public Login() {
    }

    public boolean isIsLoginEnable() {
        return isLoginEnable;
    }

    public void setIsLoginEnable(boolean isLoginEnable) {
        this.isLoginEnable = isLoginEnable;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public String loginAction(){
        if ("u01".equals(this.username) && "welcome".equals(this.passwd))
            return "P1";
        else 
            return "P2";
    }
}
