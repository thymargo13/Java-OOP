package cfd.db;

import cfd.bean.CustomerAddressBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class AddressBook_DB {

    private String url, username, password;

    public AddressBook_DB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    public boolean addUserAddress(String id, String address) { // insert method 2 by system min requirement informarion
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "insert into AddressBook (cid, address)values(?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, address);

            int rowsNum = preStatement.executeUpdate();
            if (rowsNum >= 1) {
                isSuccess = true;
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return isSuccess;
    }

    public List<CustomerAddressBean> getAddressesByCustomer(String id) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        List<CustomerAddressBean> list = null;
        String sql = "";
        try {
            list = new LinkedList<CustomerAddressBean>();
            conn = getConnection();
            sql = "select * from AddressBook where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()) {
                int aid = rs.getInt(1);
                String address = rs.getString(2);
                String cid = rs.getString(3);
                String status = rs.getString(4);
                //custBean.setStatus(rs.getString(12));
                CustomerAddressBean cab = new CustomerAddressBean(aid, cid, address, status);
                list.add(cab);
            }
            preStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<CustomerAddressBean> getValidAddressesByCustomer(String id, String status) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        List<CustomerAddressBean> list = null;
        String sql = "";
        try {
            list = new LinkedList<CustomerAddressBean>();
            conn = getConnection();
            sql = "select * from AddressBook where cid = ? and status = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, status);
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()) {
                int aid = rs.getInt(1);
                String address = rs.getString(2);
                String cid = rs.getString(3);
                String status_db = rs.getString(4);
                //custBean.setStatus(rs.getString(12));
                CustomerAddressBean cab = new CustomerAddressBean(aid, cid, address, status_db);
                list.add(cab);
            }
            preStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean isDuplicateAddress(String id, String address) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isDuplicate = false;
        try {
            conn = getConnection();
            String sql = "select count(*) from AddressBook where cid = ? and address = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, address);
            ResultSet rs = preStatement.executeQuery();
            rs.next();
            System.out.print(rs.getInt(1));
            if (rs.getInt(1) > 0) {
                isDuplicate = true;
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return isDuplicate;
    }
    
    public boolean updateUserAddress(String aid, String address) { 
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update AddressBook set address = ? where aid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(2, aid);
            preStatement.setString(1, address);

            int rowsNum = preStatement.executeUpdate();
            if (rowsNum >= 1) {
                isSuccess = true;
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return isSuccess;
    }
    
    public boolean removeUserAddress(int aid) { 
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "delete from AddressBook where aid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setInt(1, aid);
            
            int rowsNum = preStatement.executeUpdate();
            if (rowsNum >= 1) {
                isSuccess = true;
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return isSuccess;
    }
}
