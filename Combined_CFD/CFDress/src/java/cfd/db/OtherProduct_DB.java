/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.db;

import cfd.bean.AccessoryBean;
import cfd.bean.BagBean;
import cfd.bean.OtherProductBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author thymmm
 */
public class OtherProduct_DB {

    private String url = "";
    private String username = "";
    private String password = "";

    public OtherProduct_DB() {
    }

    public OtherProduct_DB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    public int getRowsNum(String item) {
        Connection conn = null;
        Statement statement = null;
        int rowCount = 0;
        try {
            conn = getConnection();
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM " + item);
            rs.next();
            rowCount = rs.getInt(1);
            System.out.println(rowCount);

            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return rowCount;
    }

    public String genBagId() {
        int id = getRowsNum("Bag");
        id++;
        return "B" + id;
    }

    public String genAccessoryId() {
        int id = getRowsNum("Accessory");
        id++;
        return "A" + id;
    }

    public boolean addBag(String pBrand, String description, double price, String pName, int stock) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;

        try {
            conn = getConnection();
            String sql = "insert into Bag (PSID,pBrand,description,price,pName,stock)values(?,?,?,?,?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, genBagId());
            preStatement.setString(2, pBrand);
            preStatement.setString(3, description);
            preStatement.setDouble(4, price);
            preStatement.setString(5, pName);
            preStatement.setInt(6, stock);

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

    public ArrayList<AccessoryBean> showAccessory() {

        Connection connect = null;
        PreparedStatement pStmt = null;
        AccessoryBean opBean = null;
        ArrayList<AccessoryBean> op = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Accessory";
            pStmt = connect.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmt.executeQuery();
            while (rs.next()) {
                opBean = new AccessoryBean();
                // set the record detail to the customer bean
                opBean.setImg(rs.getString("img"));
                opBean.setpBrand(rs.getString("pBrand"));
                opBean.setpName(rs.getString("pName"));
                opBean.setDescription(rs.getString("description"));
                opBean.setPrice(rs.getDouble("price"));
                opBean.setRedeemPoint(rs.getInt("redeemPoint"));
                opBean.setpType(rs.getString("pType"));
                opBean.setPid(rs.getString("PSID"));
                opBean.setStock(rs.getInt("stock"));
                opBean.setStatus(rs.getString("status"));
                op.add(opBean);
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
        return op;
    }

    public boolean addAccessory(String pBrand, String description, double price, String pName, int redeem, int stock, String type) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;

        try {
            conn = getConnection();
            String sql = "insert into Accessory (PSID,pBrand,description,price,pName,stock,redeemPoint,pType)values(?,?,?,?,?,?,?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, genAccessoryId());
            preStatement.setString(2, pBrand);
            preStatement.setString(3, description);
            preStatement.setDouble(4, price);
            preStatement.setString(5, pName);
            preStatement.setInt(6, stock);
            preStatement.setInt(7, redeem);
            preStatement.setString(8, type);

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

    public ArrayList<BagBean> showBag() {

        Connection connect = null;
        PreparedStatement pStmt = null;
        BagBean opBean = null;
        ArrayList<BagBean> op = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Bag";
            pStmt = connect.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmt.executeQuery();
            while (rs.next()) {
                opBean = new BagBean();
                // set the record detail to the customer bean
                opBean.setImg(rs.getString("img"));
                opBean.setpBrand(rs.getString("pBrand"));
                opBean.setpName(rs.getString("pName"));
                opBean.setDescription(rs.getString("description"));
                opBean.setPrice(rs.getDouble("price"));
                opBean.setPid(rs.getString("PSID"));
                opBean.setStock(rs.getInt("stock"));
                opBean.setStatus(rs.getString("status"));
                op.add(opBean);
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
        return op;
    }

    public ArrayList<OtherProductBean> showAllOtherProduct() {
        ArrayList<OtherProductBean> _opal = new ArrayList();
        ArrayList<AccessoryBean> _acc = showAccessory();
        ArrayList<BagBean> _bag = showBag();

        for (AccessoryBean ab : _acc) {
            _opal.add(ab);
        }
        for (BagBean bb : _bag) {
            _opal.add(bb);
        }
        return _opal;
    }

    public OtherProductBean queryOtherProductById(String id) {
        OtherProductBean opb =null;
        if (queryAccessoryById(id) != null) {
            opb = queryAccessoryById(id);
        } else if (queryBagById(id) != null) {
            opb = queryBagById(id);
        }
        return opb;
    }

    public BagBean queryAccessoryById(String id) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        BagBean bBean = null;
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Bag WHERE PSID =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            pStmt.setString(1, id);
            ResultSet rs = null;
            rs = pStmt.executeQuery();

            if (rs.next()) {
                bBean = new BagBean();
                bBean.setImg(rs.getString("img"));
                bBean.setpBrand(rs.getString("pBrand"));
                bBean.setpName(rs.getString("pName"));
                bBean.setDescription(rs.getString("description"));
                bBean.setPrice(rs.getDouble("price"));
                bBean.setPid(rs.getString("PSID"));
                bBean.setStock(rs.getInt("stock"));
                bBean.setStatus(rs.getString("status"));
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
        return bBean;
    }

    public AccessoryBean queryBagById(String id) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        AccessoryBean aBean = null;
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Accessory WHERE PSID =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            pStmt.setString(1, id);
            ResultSet rs = null;
            rs = pStmt.executeQuery();

            if (rs.next()) {
                aBean = new AccessoryBean();
                aBean.setImg(rs.getString("img"));
                aBean.setpBrand(rs.getString("pBrand"));
                aBean.setpName(rs.getString("pName"));
                aBean.setDescription(rs.getString("description"));
                aBean.setPrice(rs.getDouble("price"));
                aBean.setRedeemPoint(rs.getInt("redeemPoint"));
                aBean.setpType(rs.getString("pType"));
                aBean.setPid(rs.getString("PSID"));
                aBean.setStock(rs.getInt("stock"));
                aBean.setStatus(rs.getString("status"));
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
        return aBean;
    }
    public boolean updateAccessory(String id,String brand,String name,String description,String price,String stock,String status,String redeem,String pType){        
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;
        
        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE Accessory SET stock = ?, pBrand=?, pName=?, price=?, pType=?,"
                    +" redeemPoint=? , description=?, status=? WHERE PSID =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            
            pStmt.setInt(1, Integer.parseInt(stock));
            pStmt.setString(2, brand);
            pStmt.setString(3, name);
            pStmt.setDouble(4, Double.parseDouble(price));
            pStmt.setString(5, pType);
            pStmt.setInt(6, Integer.parseInt(redeem));
            pStmt.setString(7, description);
            pStmt.setString(8, status);
            pStmt.setString(9, id);
            

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
    public boolean updateBag(String id,String brand,String name,String description,String price,String stock,String status){
    Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE Bag SET stock = ?, pBrand=?, pName=?, price=?,"
                    +"description=?, status=? WHERE PSID =?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setInt(1, Integer.parseInt(stock));
            pStmt.setString(2, brand);
            pStmt.setString(3, name);
            pStmt.setDouble(4, Double.parseDouble(price));
  
            pStmt.setString(5, description);
            pStmt.setString(6, status);
            pStmt.setString(7, id);

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
    public ArrayList<AccessoryBean> showHat() {

        Connection connect = null;
        PreparedStatement pStmt = null;
        AccessoryBean opBean = null;
        ArrayList<AccessoryBean> op = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Accessory where pType='hat'";
            pStmt = connect.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmt.executeQuery();
            while (rs.next()) {
                opBean = new AccessoryBean();
                // set the record detail to the customer bean
                opBean.setImg(rs.getString("img"));
                opBean.setpBrand(rs.getString("pBrand"));
                opBean.setpName(rs.getString("pName"));
                opBean.setDescription(rs.getString("description"));
                opBean.setPrice(rs.getDouble("price"));
                opBean.setRedeemPoint(rs.getInt("redeemPoint"));
                opBean.setpType(rs.getString("pType"));
                opBean.setPid(rs.getString("PSID"));
                opBean.setStock(rs.getInt("qty"));
                opBean.setStatus(rs.getString("status"));
                op.add(opBean);
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
        return op;
    }
    public ArrayList<AccessoryBean> showGlasses() {

        Connection connect = null;
        PreparedStatement pStmt = null;
        AccessoryBean opBean = null;
        ArrayList<AccessoryBean> op = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Accessory where pType='glasses'";
            pStmt = connect.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmt.executeQuery();
            while (rs.next()) {
                opBean = new AccessoryBean();
                // set the record detail to the customer bean
                opBean.setImg(rs.getString("img"));
                opBean.setpBrand(rs.getString("pBrand"));
                opBean.setpName(rs.getString("pName"));
                opBean.setDescription(rs.getString("description"));
                opBean.setPrice(rs.getDouble("price"));
                opBean.setRedeemPoint(rs.getInt("redeemPoint"));
                opBean.setpType(rs.getString("pType"));
                opBean.setPid(rs.getString("PSID"));
                opBean.setStock(rs.getInt("qty"));
                opBean.setStatus(rs.getString("status"));
                op.add(opBean);
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
        return op;
    }
        public ArrayList<AccessoryBean> showWatches() {

        Connection connect = null;
        PreparedStatement pStmt = null;
        AccessoryBean opBean = null;
        ArrayList<AccessoryBean> op = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Accessory where pType='watches'";
            pStmt = connect.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmt.executeQuery();
            while (rs.next()) {
                opBean = new AccessoryBean();
                // set the record detail to the customer bean
                opBean.setImg(rs.getString("img"));
                opBean.setpBrand(rs.getString("pBrand"));
                opBean.setpName(rs.getString("pName"));
                opBean.setDescription(rs.getString("description"));
                opBean.setPrice(rs.getDouble("price"));
                opBean.setRedeemPoint(rs.getInt("redeemPoint"));
                opBean.setpType(rs.getString("pType"));
                opBean.setPid(rs.getString("PSID"));
                opBean.setStock(rs.getInt("qty"));
                opBean.setStatus(rs.getString("status"));
                op.add(opBean);
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
        return op;
    }
}
