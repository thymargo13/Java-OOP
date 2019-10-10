/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.db;

import cfd.bean.ClothingSizeBean;
import cfd.bean.CoatBean;
import cfd.bean.CoatSizeBean;
import cfd.bean.HoodyBean;
import cfd.bean.HoodySizeBean;
import cfd.bean.PantBean;
import cfd.bean.PantSizeBean;
import cfd.bean.ProductBean;
import cfd.bean.ShortBean;
import cfd.bean.ShortSizeBean;
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
public class Product_DB {

    private String url = "";
    private String username = "";
    private String password = "";

    public Product_DB() {
    }

    public Product_DB(String url, String username, String password) {
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

    public String genPantId() {
        int id = getRowsNum("Pant");
        id++;
        return "P" + id;
    }

    public String genPantSizeId() {
        int id = getRowsNum("PantSize");
        id++;
        return "PS" + id;
    }

    public String genShortId() {
        int id = getRowsNum("Short");
        id++;
        return "S" + id;
    }

    public String genShortSizeId() {
        int id = getRowsNum("ShortSize");
        id++;
        return "SS" + id;
    }

    public String genHoodyId() {
        int id = getRowsNum("Hoody");
        id++;
        return "H" + id;
    }

    public String genHoodySizeId() {
        int id = getRowsNum("HoodySize");
        id++;
        return "HS" + id;
    }

    public String genCoatId() {
        int id = getRowsNum("Coat");
        id++;
        return "JC" + id;
    }

    public String genCoatSizeId() {
        int id = getRowsNum("CoatSize");
        id++;
        return "CS" + id;
    }

    public ArrayList<ProductBean> showAllProduct() {
        ArrayList<ProductBean> _productBean = new ArrayList();
        ArrayList<PantBean> _pant = showPant();
        ArrayList<ShortBean> _short = showShort();
        ArrayList<CoatBean> _coat = showCoat();
        ArrayList<HoodyBean> _hoody = showHoody();

        for (PantBean pant : _pant) {
            _productBean.add(pant);
        }
        for (ShortBean _sh : _short) {
            _productBean.add(_sh);
        }
        for (CoatBean coat : _coat) {
            _productBean.add(coat);
        }
        for (HoodyBean hoodie : _hoody) {
            _productBean.add(hoodie);
        }

        return _productBean;
    }

    public ArrayList<PantBean> showPant() {
        Connection connect = null;
        PreparedStatement pStmt = null;
        PantBean pantBean = null;
        ArrayList<PantBean> pantList = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Pant";
            pStmt = connect.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmt.executeQuery();
            while (rs.next()) {
                pantBean = new PantBean();
                // set the record detail to the customer bean
                pantBean.setImg(rs.getString("img"));
                pantBean.setpBrand(rs.getString("pBrand"));
                pantBean.setpName(rs.getString("pName"));
                pantBean.setDescription(rs.getString("description"));
                pantBean.setPrice(rs.getDouble("price"));
                pantBean.setPid(rs.getString("pid"));
                pantBean.setStatus(rs.getString("status"));
                pantList.add(pantBean);
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
        return pantList;
    }

    public ArrayList<ShortBean> showShort() {
        Connection connect = null;
        PreparedStatement pStmt = null;
        ShortBean shortBean = null;
        ArrayList<ShortBean> shortList = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Short";
            pStmt = connect.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmt.executeQuery();
            while (rs.next()) {
                shortBean = new ShortBean();
                // set the record detail to the customer bean
                shortBean.setImg(rs.getString("img"));
                shortBean.setpBrand(rs.getString("pBrand"));
                shortBean.setpName(rs.getString("pName"));
                shortBean.setDescription(rs.getString("description"));
                shortBean.setPrice(rs.getDouble("price"));
                shortBean.setPid(rs.getString("pid"));
                shortBean.setStatus(rs.getString("status"));
                shortList.add(shortBean);
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
        return shortList;
    }

    public ArrayList<HoodyBean> showHoody() {
        Connection connect = null;
        PreparedStatement pStmt = null;
        HoodyBean hoody = null;
        ArrayList<HoodyBean> hoodyList = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Hoody";
            pStmt = connect.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmt.executeQuery();
            while (rs.next()) {
                hoody = new HoodyBean();
                // set the record detail to the customer bean
                hoody.setImg(rs.getString("img"));
                hoody.setpBrand(rs.getString("pBrand"));
                hoody.setpName(rs.getString("pName"));
                hoody.setDescription(rs.getString("description"));
                hoody.setPrice(rs.getDouble("price"));
                hoody.setPid(rs.getString("pid"));
                hoody.setStatus(rs.getString("status"));
                hoodyList.add(hoody);
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
        return hoodyList;
    }

    public ArrayList<CoatBean> showCoat() {
        Connection connect = null;
        PreparedStatement pStmt = null;
        CoatBean coatBean = null;
        ArrayList<CoatBean> coatList = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Coat";
            pStmt = connect.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmt.executeQuery();
            while (rs.next()) {
                coatBean = new CoatBean();
                // set the record detail to the customer bean
                coatBean.setImg(rs.getString("img"));
                coatBean.setpBrand(rs.getString("pBrand"));
                coatBean.setpName(rs.getString("pName"));
                coatBean.setDescription(rs.getString("description"));
                coatBean.setPrice(rs.getDouble("price"));
                coatBean.setPid(rs.getString("pid"));
                coatBean.setStatus(rs.getString("status"));
                coatList.add(coatBean);
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
        return coatList;
    }

    public boolean addPant(String brand, String description, double price, String name, int xl, int l, int m, int s) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;

        try {
            conn = getConnection();
            //conn.setAutoCommit(false);
            String sql = "insert into Pant (pid,pBrand,description,price,pName)values(?,?,?,?,?)";
            String id = genPantId();
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, brand);
            preStatement.setString(3, description);
            preStatement.setDouble(4, price);
            preStatement.setString(5, name);

            int rowsNum = preStatement.executeUpdate();
            if (rowsNum >= 1) {
                isSuccess = true;
                if (xl != 0) {
                    addPantSize(id, xl, "XL");
                }
                if (l != 0) {
                    addPantSize(id, l, "L");
                }
                if (m != 0) {
                    addPantSize(id, m, "M");
                }
                if (s != 0) {
                    addPantSize(id, s, "s");
                }
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return isSuccess;
    }

    public boolean addShort(String brand, String description, double price, String name, int xl, int l, int m, int s) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;

        try {
            conn = getConnection();
            //  conn.setAutoCommit(false);
            String sql = "insert into Short (pid,pBrand,description,price,pName)values(?,?,?,?,?)";
            String id = genShortId();
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, brand);
            preStatement.setString(3, description);
            preStatement.setDouble(4, price);
            preStatement.setString(5, name);

            int rowsNum = preStatement.executeUpdate();
            if (rowsNum >= 1) {
                isSuccess = true;
                if (xl != 0) {
                    addShortSize(id, xl, "XL");
                }
                if (l != 0) {
                    addShortSize(id, l, "L");
                }
                if (m != 0) {
                    addShortSize(id, m, "M");
                }
                if (s != 0) {
                    addShortSize(id, s, "s");
                }
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return isSuccess;
    }

    public boolean addHoody(String brand, String description, double price, String name, int xl, int l, int m, int s) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;

        try {
            conn = getConnection();
            //conn.setAutoCommit(false);
            String sql = "insert into Hoody (pid,pBrand,description,price,pName)values(?,?,?,?,?)";
            String id = genHoodyId();
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, brand);
            preStatement.setString(3, description);
            preStatement.setDouble(4, price);
            preStatement.setString(5, name);

            int rowsNum = preStatement.executeUpdate();
            if (rowsNum >= 1) {
                isSuccess = true;
                if (xl != 0) {
                    addHoodySize(id, xl, "XL");
                }
                if (l != 0) {
                    addHoodySize(id, l, "L");
                }
                if (m != 0) {
                    addHoodySize(id, m, "M");
                }
                if (s != 0) {
                    addHoodySize(id, s, "s");
                }
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return isSuccess;
    }

    public boolean addCoat(String brand, String description, double price, String name, int xl, int l, int m, int s) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;

        try {
            conn = getConnection();
            //conn.setAutoCommit(false);
            String sql = "insert into Coat (pid,pBrand,description,price,pName)values(?,?,?,?,?)";
            String id = genCoatId();
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, brand);
            preStatement.setString(3, description);
            preStatement.setDouble(4, price);
            preStatement.setString(5, name);

            int rowsNum = preStatement.executeUpdate();
            if (rowsNum >= 1) {
                isSuccess = true;
                if (xl != 0) {
                    addCoatSize(id, xl, "XL");
                }
                if (l != 0) {
                    addCoatSize(id, l, "L");
                }
                if (m != 0) {
                    addCoatSize(id, m, "M");
                }
                if (s != 0) {
                    addCoatSize(id, s, "s");
                }
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return isSuccess;
    }

    public boolean addPantSize(String id, int stock, String size) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;

        try {
            conn = getConnection();
            // conn.setAutoCommit(false);
            String sql = "insert into PantSize (pid,PSID,stock,size)values(?,?,?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, genPantSizeId());
            preStatement.setInt(3, stock);
            preStatement.setString(4, size);

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

    public boolean addShortSize(String id, int stock, String size) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;

        try {
            conn = getConnection();
            //conn.setAutoCommit(false);
            String sql = "insert into ShortSize (pid,PSID,stock,size)values(?,?,?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, genShortSizeId());
            preStatement.setInt(3, stock);
            preStatement.setString(4, size);

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

    public boolean addHoodySize(String id, int stock, String size) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;

        try {
            conn = getConnection();
            //    conn.setAutoCommit(false);
            String sql = "insert into HoodySize (pid,PSID,stock,size)values(?,?,?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, genHoodySizeId());
            preStatement.setInt(3, stock);
            preStatement.setString(4, size);

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

    public boolean addCoatSize(String id, int stock, String size) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;

        try {
            conn = getConnection();
            //conn.setAutoCommit(false);
            String sql = "insert into CoatSize (pid,PSID,stock,size)values(?,?,?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, genCoatSizeId());
            preStatement.setInt(3, stock);
            preStatement.setString(4, size);

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

    public ProductBean queryProductById(String pid) {
        ProductBean pb = null;

        if (queryPantById(pid) != null) {
            pb = queryPantById(pid);
        } else if (queryShortById(pid) != null) {
            pb = queryShortById(pid);
        } else if (queryHoodyById(pid) != null) {
            pb = queryHoodyById(pid);
        } else if (queryCoatById(pid) != null) {
            pb = queryCoatById(pid);
        }
        return pb;
    }

    public PantBean queryPantById(String pid) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        PantBean bBean = null;
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Pant WHERE pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            pStmt.setString(1, pid);
            ResultSet rs = null;
            rs = pStmt.executeQuery();

            if (rs.next()) {
                bBean = new PantBean();
                bBean.setImg(rs.getString("img"));
                bBean.setpBrand(rs.getString("pBrand"));
                bBean.setpName(rs.getString("pName"));
                bBean.setDescription(rs.getString("description"));
                bBean.setPrice(rs.getDouble("price"));
                bBean.setPid(rs.getString("pid"));
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

    public HoodyBean queryHoodyById(String pid) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        HoodyBean bBean = null;
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Hoody WHERE pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            pStmt.setString(1, pid);
            ResultSet rs = null;
            rs = pStmt.executeQuery();

            if (rs.next()) {
                bBean = new HoodyBean();
                bBean.setImg(rs.getString("img"));
                bBean.setpBrand(rs.getString("pBrand"));
                bBean.setpName(rs.getString("pName"));
                bBean.setDescription(rs.getString("description"));
                bBean.setPrice(rs.getDouble("price"));
                bBean.setPid(rs.getString("pid"));
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

    public CoatBean queryCoatById(String pid) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        CoatBean bBean = null;
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Coat WHERE pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            pStmt.setString(1, pid);
            ResultSet rs = null;
            rs = pStmt.executeQuery();

            if (rs.next()) {
                bBean = new CoatBean();
                bBean.setImg(rs.getString("img"));
                bBean.setpBrand(rs.getString("pBrand"));
                bBean.setpName(rs.getString("pName"));
                bBean.setDescription(rs.getString("description"));
                bBean.setPrice(rs.getDouble("price"));
                bBean.setPid(rs.getString("pid"));
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

    public ShortBean queryShortById(String pid) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        ShortBean bBean = null;
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Short WHERE pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            pStmt.setString(1, pid);
            ResultSet rs = null;
            rs = pStmt.executeQuery();

            if (rs.next()) {
                bBean = new ShortBean();
                bBean.setImg(rs.getString("img"));
                bBean.setpBrand(rs.getString("pBrand"));
                bBean.setpName(rs.getString("pName"));
                bBean.setDescription(rs.getString("description"));
                bBean.setPrice(rs.getDouble("price"));
                bBean.setPid(rs.getString("pid"));
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

    public ArrayList<ClothingSizeBean> queryProductSizeById(String id) {
        ArrayList<ClothingSizeBean> _cothingSize = new ArrayList();
        ArrayList<PantSizeBean> _pant = queryPantSizeById(id);
        ArrayList<ShortSizeBean> _short = queryShortSizeById(id);
        ArrayList<CoatSizeBean> _coat = queryCoatSizeById(id);
        ArrayList<HoodySizeBean> _hoody = queryHoodySizeById(id);

        for (PantSizeBean pant : _pant) {
            _cothingSize.add(pant);
        }
        for (ShortSizeBean s : _short) {
            _cothingSize.add(s);
        }
        for (HoodySizeBean hoody : _hoody) {
            _cothingSize.add(hoody);
        }
        for (CoatSizeBean coat : _coat) {
            _cothingSize.add(coat);
        }
        return _cothingSize;
    }

    public ArrayList<PantSizeBean> queryPantSizeById(String pid) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        PantSizeBean pantBean = null;
        ArrayList<PantSizeBean> pantList = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM PantSize Where pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            pStmt.setString(1, pid);

            ResultSet rs = null;
            rs = pStmt.executeQuery();

            while (rs.next()) {
                pantBean = new PantSizeBean();
                // set the record detail to the customer bean
                pantBean.setSize(rs.getString("size"));
                pantBean.setStock(rs.getInt("stock"));
                pantBean.setPsid(rs.getString("PSID"));
                pantBean.setPid(rs.getString("pid"));

                pantList.add(pantBean);
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
        return pantList;

    }

    public ArrayList<CoatSizeBean> queryCoatSizeById(String pid) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        CoatSizeBean coatBean = null;
        ArrayList<CoatSizeBean> coatList = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM CoatSize Where pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            pStmt.setString(1, pid);
            ResultSet rs = null;
            rs = pStmt.executeQuery();

            while (rs.next()) {
                coatBean = new CoatSizeBean();
                // set the record detail to the customer bean
                coatBean.setPsid(rs.getString("PSID"));
                coatBean.setPid(rs.getString("pid"));
                coatBean.setSize(rs.getString("size"));
                coatBean.setStock(rs.getInt("stock"));

                coatList.add(coatBean);
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
        return coatList;
    }

    public ArrayList<HoodySizeBean> queryHoodySizeById(String pid) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        HoodySizeBean hoodyBean = null;
        ArrayList<HoodySizeBean> hoodyList = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM HoodySize Where pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            pStmt.setString(1, pid);
            ResultSet rs = null;
            rs = pStmt.executeQuery();

            while (rs.next()) {
                hoodyBean = new HoodySizeBean();
                // set the record detail to the customer 
                hoodyBean.setPid(rs.getString("pid"));
                hoodyBean.setPsid(rs.getString("PSID"));
                hoodyBean.setSize(rs.getString("size"));
                hoodyBean.setStock(rs.getInt("stock"));

                hoodyList.add(hoodyBean);
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
        return hoodyList;
    }

    public ArrayList<ShortSizeBean> queryShortSizeById(String pid) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        ShortSizeBean shortBean = null;
        ArrayList<ShortSizeBean> pantList = new ArrayList();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM ShortSize Where pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);
            pStmt.setString(1, pid);
            ResultSet rs = null;
            rs = pStmt.executeQuery();

            while (rs.next()) {
                shortBean = new ShortSizeBean();
                shortBean.setPsid(rs.getString("PSID"));
                shortBean.setPid(rs.getString("pid"));
                shortBean.setSize(rs.getString("size"));
                shortBean.setStock(rs.getInt("stock"));

                pantList.add(shortBean);
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
        return pantList;
    }

    public boolean updateProduct(String id, String brand, String name, String description, String price, String type, String xl, String l, String m, String s) {
        if (type.equals("pant")) {
            updatePant(id, brand, name, description, price);
            if (xl != "") {
                if (!updatePantSize(id, xl, "XL")) {
                    System.out.println(id);
                    addPantSize(id, Integer.parseInt(xl), "XL");
                }
            }
            if (l != "") {
                if (!updatePantSize(id, l, "L")) {
                    System.out.println(id);
                    addPantSize(id, Integer.parseInt(l), "L");
                }
            }
            if (m != "") {
                if (!updatePantSize(id, m, "M")) {
                    System.out.println(id);
                    addPantSize(id, Integer.parseInt(m), "M");
                }
            }
            if (s != "") {
                if (!updatePantSize(id, s, "S")) {
                    System.out.println(id);
                    addPantSize(id, Integer.parseInt(s), "S");
                }
            }
        } else if (type.equals("short")) {
            updateShort(id, brand, name, description, price);
            if (xl != "") {
                if (!updateShortSize(id, xl, "XL")) {
                    System.out.println(id);
                    addShortSize(id, Integer.parseInt(xl), "XL");
                }
            }
            if (l != "") {
                if (!updateShortSize(id, l, "L")) {
                    System.out.println(id);
                    addShortSize(id, Integer.parseInt(l), "L");
                }
            }
            if (m != "") {
                if (!updateShortSize(id, m, "M")) {
                    System.out.println(id);
                    addShortSize(id, Integer.parseInt(m), "M");
                }
            }
            if (s != "") {
                if (!updateShortSize(id, s, "S")) {
                    System.out.println(id);
                    addShortSize(id, Integer.parseInt(s), "S");
                }
            }
        } else if (type.equals("coat")) {
            updateCoat(id, brand, name, description, price);
            if (xl != "") {
                if (!updateCoatSize(id, xl, "XL")) {
                    System.out.println(id);
                    addCoatSize(id, Integer.parseInt(xl), "XL");
                }
            }
            if (l != "") {
                if (!updateCoatSize(id, l, "L")) {
                    System.out.println(id);
                    addCoatSize(id, Integer.parseInt(l), "L");
                }
            }
            if (m != "") {
                if (!updateCoatSize(id, m, "M")) {
                    System.out.println(id);
                    addCoatSize(id, Integer.parseInt(m), "M");
                }
            }
            if (s != "") {
                if (!updateCoatSize(id, s, "S")) {
                    System.out.println(id);
                    addCoatSize(id, Integer.parseInt(s), "S");
                }
            }
        } else if (type.equals("hoody")) {
            updateHoody(id, brand, name, description, price);
            if (xl != "") {
                if (!updateHoodySize(id, xl, "XL")) {
                    System.out.println(id);
                    addHoodySize(id, Integer.parseInt(xl), "XL");
                }
            }
            if (l != "") {
                if (!updateHoodySize(id, l, "L")) {
                    System.out.println(id);
                    addHoodySize(id, Integer.parseInt(l), "L");
                }
            }
            if (m != "") {
                if (!updateHoodySize(id, m, "M")) {
                    System.out.println(id);
                    addHoodySize(id, Integer.parseInt(m), "M");
                }
            }
            if (s != "") {
                if (!updateHoodySize(id, s, "S")) {
                    System.out.println(id);
                    addHoodySize(id, Integer.parseInt(s), "S");
                }
            }
        }
        return true;
    }

    public boolean updatePant(String id, String brand, String name, String description, String price) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE Pant SET  pBrand=?, pName=?, price=?, description=? WHERE pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setString(1, brand);
            pStmt.setString(2, name);
            pStmt.setDouble(3, Double.parseDouble(price));
            pStmt.setString(4, description);
            pStmt.setString(5, id);

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

    public boolean updateCoat(String id, String brand, String name, String description, String price) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE Coat SET  pBrand=?, pName=?, price=?, description=? WHERE pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setString(1, brand);
            pStmt.setString(2, name);
            pStmt.setDouble(3, Double.parseDouble(price));
            pStmt.setString(4, description);
            pStmt.setString(5, id);

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

    public boolean updateShort(String id, String brand, String name, String description, String price) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE Short SET  pBrand=?, pName=?, price=?, description=? WHERE pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setString(1, brand);
            pStmt.setString(2, name);
            pStmt.setDouble(3, Double.parseDouble(price));
            pStmt.setString(4, description);
            pStmt.setString(5, id);

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

    public boolean updateHoody(String id, String brand, String name, String description, String price) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE Hoody SET  pBrand=?, pName=?, price=?, description=? WHERE pid =?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setString(1, brand);
            pStmt.setString(2, name);
            pStmt.setDouble(3, Double.parseDouble(price));
            pStmt.setString(4, description);
            pStmt.setString(5, id);

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

    public boolean updateHoodySize(String id, String stock, String size) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE HoodySize SET  stock=? WHERE pid =? and size=?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setInt(1, Integer.parseInt(stock));
            pStmt.setString(2, id);
            pStmt.setString(3, size);

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

    public boolean updateCoatSize(String id, String stock, String size) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE CoatSize SET  stock=? WHERE pid =? and size=?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setInt(1, Integer.parseInt(stock));
            pStmt.setString(2, id);
            pStmt.setString(3, size);

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

    public boolean updatePantSize(String id, String stock, String size) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE PantSize SET  stock=? WHERE pid =? and size=?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setInt(1, Integer.parseInt(stock));
            pStmt.setString(2, id);
            pStmt.setString(3, size);

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

    public boolean updateShortSize(String id, String stock, String size) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE ShortSize SET  stock=? WHERE pid =? and size=?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setInt(1, Integer.parseInt(stock));
            pStmt.setString(2, id);
            pStmt.setString(3, size);

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

}
