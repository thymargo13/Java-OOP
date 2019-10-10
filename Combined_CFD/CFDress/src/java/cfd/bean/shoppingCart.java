/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.bean;

/**
 *
 * @author a1
 */
public class shoppingCart {
    private int qty;
    private String pid;
    private String size;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public shoppingCart(int qty, String pid, String size) {
        this.qty = qty;
        this.pid = pid;
        this.size = size;
    }

    public shoppingCart() {
    }

    @Override
    public String toString() {
        return "shoppingCart{" + "qty=" + qty + ", pid=" + pid + ", size=" + size + '}';
    }
    
    
    
}
