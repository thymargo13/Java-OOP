package cfd.bean;

import java.io.Serializable;

/**
 *
 * @author Daniel
 */
public class CustomerAddressBean implements Serializable{
    
    private int aid;
    private String cid, address, status;

    public CustomerAddressBean() {
    }

    public CustomerAddressBean(int aid, String cid, String address, String status) {
        this.aid = aid;
        this.cid = cid;
        this.address = address;
        this.status = status;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerAddressBean{" + "aid=" + aid + ", cid=" + cid + ", address=" + address + ", status=" + status + '}';
    }
    
}
