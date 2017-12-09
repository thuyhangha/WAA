/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author hangha
 */
@ManagedBean
@RequestScoped
public class LoginJSFManagedBean {

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    private String userID;
    private String password;
    private String fullName;
    /**
     * Creates a new instance of LoginJSFManagedBean
     */
    public LoginJSFManagedBean() {
    }
    public String login() {
            if ((userID.equals("kl01")) && (password.equals("yoyo"))) {
                    fullName = "Frank Brown";
                    return "success";
            }
            return "fail";
    }
}
