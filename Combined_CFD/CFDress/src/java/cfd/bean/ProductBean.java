/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.bean;

import java.util.ArrayList;

/**
 *
 * @author thymmm
 */
public class ProductBean {

    private String pid;
    private String pBrand;
    private String pName;
    private String description;
    private double price;
    private String img;
    private String status;
    private ArrayList<ClothingSizeBean> _cs;

    public ProductBean() {
        _cs = new ArrayList();
    }

    public ArrayList<ClothingSizeBean> getCs() {
        return _cs;
    }
     public void setCs(ArrayList<ClothingSizeBean> _cs) {
        this._cs =_cs;
    }
    public void removeCS(ClothingSizeBean csb) {
        _cs.remove(csb);
    }
    
    public void addCS(ClothingSizeBean csb) {
        _cs.add(csb);
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getpBrand() {
        return pBrand;
    }

    public void setpBrand(String pBrand) {
        this.pBrand = pBrand;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductBean{" + "pid=" + pid + ", pBrand=" + pBrand + ", pName=" + pName + ", description=" + description + ", price=" + price + ", img=" + img + ", status=" + status + ", _cs=" + _cs + '}';
    }

}
