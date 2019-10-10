/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author thymmm
 */
public class StaffBean implements Serializable {

    private String fName;
    private String id;
    private String lName;
    private String position;
    private String pwd;
    private String shop;
    private Date entryTime;

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPosition() {
        return position;
    }

    public StaffBean(String fName, String lName, String position, String shop) {
        this.fName = fName;
        this.lName = lName;
        this.position = position;
        this.shop = shop;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public StaffBean() {
    }

}
