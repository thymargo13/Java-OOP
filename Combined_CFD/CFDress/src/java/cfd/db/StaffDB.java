/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.db;

import cfd.bean.StaffBean;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thymmm
 */
public class StaffDB {

    private String url = "";
    private String username = "";
    private String password = "";

    public StaffDB() {
    }

    public StaffDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    public String getLatestId() {
        Connection connect = null;
        PreparedStatement pStmt = null;
        StaffBean sBean = null;
        String latestId = "";
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT sid FROM Staff "
                    + "ORDER BY entryTime DESC "
                    + "LIMIT 1";
            pStmt = connect.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmt.executeQuery();
            if (rs.next()) {
                latestId = rs.getString("sid");
            }
            pStmt.close();
            connect.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return latestId;
    }

    public String generateId() {
        String latestId = getLatestId();

        String id = "";
        String temp = "";
        if (latestId != "") {
            temp = latestId.substring(1);
            int temporary = Integer.parseInt(temp);
            temporary++;
            id = "S" + temporary;
        } else {
            id = "S1";
        }
        return id;
    }

    public boolean addStaff(String fName, String lName, String post, String workPlace) { // insert method 1 by full informarion
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        SecureRandom random = new SecureRandom();
        String temp = new BigInteger(130, random).toString(32);

        try {
            conn = getConnection();
            String sql = "insert into Staff (fName,lName,password,position,shop,sid)values(?,?,?,?,?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, fName);
            preStatement.setString(2, lName);
            preStatement.setString(3, temp.substring(0, 8));
            preStatement.setString(4, post);
            preStatement.setString(5, workPlace);
            preStatement.setString(6, generateId());

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

    public StaffBean queryStaffById(String id) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        StaffBean sBean = null;
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Staff WHERE sid =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            pStmt.setString(1, id);
            ResultSet rs = null;
            rs = pStmt.executeQuery();

            if (rs.next()) {
                sBean = new StaffBean();
                // set the record detail to the customer bean
                sBean.setId(rs.getString("sid"));
                sBean.setfName(rs.getString("fName"));
                sBean.setlName(rs.getString("lName"));
                sBean.setPwd(rs.getString("password"));
                sBean.setEntryTime(rs.getDate("entryTime"));
                sBean.setPosition(rs.getString("position"));
                sBean.setShop(rs.getString("shop"));
            }
            pStmt.close();
            connect.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sBean;
    }

    public ArrayList<StaffBean> showAllStaff() {
        Connection connect = null;
        PreparedStatement pStmt = null;
        StaffBean sBean = null;
        ArrayList<StaffBean> _sBean = new ArrayList<StaffBean>();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Staff";
            pStmt = connect.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmt.executeQuery();
            while (rs.next()) {
                sBean = new StaffBean();
                // set the record detail to the customer bean
                sBean.setId(rs.getString("sid"));
                sBean.setfName(rs.getString("fName"));
                sBean.setlName(rs.getString("lName"));
                sBean.setPwd(rs.getString("password"));
                sBean.setEntryTime(rs.getDate("entryTime"));
                sBean.setPosition(rs.getString("position"));
                sBean.setShop(rs.getString("shop"));
                _sBean.add(sBean);
            }
            pStmt.close();
            connect.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return _sBean;
    }

    public boolean updateStaff(String id, String pwd, String fName, String lName, String post, String work) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE Staff SET fName = ?, lName=?, password=?, position=?, shop=? WHERE sid =?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setString(1, fName);
            pStmt.setString(2, lName);
            pStmt.setString(3, pwd);
            pStmt.setString(4, post);
            pStmt.setString(5, work);
            pStmt.setString(6, id);

            if (pStmt.execute()) {
                isSuccess = true;
            }

            pStmt.close();
            connect.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public boolean deleteStaff(String id) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "DELETE FROM Staff WHERE sid =?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setString(1, id);

            if (pStmt.execute()) {
                isSuccess = true;
            }

            pStmt.close();
            connect.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
     public boolean login(String id, String pwd){
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "select count(*) from Staff where sid = ? and password = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, pwd);
            ResultSet rs = preStatement.executeQuery();
            rs.next();
            System.out.print(rs.getInt(1));
            if(rs.getInt(1) == 1)
                isSuccess = true;
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return isSuccess;
    }

}
