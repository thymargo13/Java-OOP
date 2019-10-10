/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.db;

import cfd.bean.InvoiceBean;
import java.io.IOException;
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
public class Invoice_DB {

    private String url = "";
    private String username = "";
    private String password = "";

    public Invoice_DB() {
    }

    public Invoice_DB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    public ArrayList<InvoiceBean> showAllInvoice() {
        Connection connect = null;
        PreparedStatement pStmt = null;
        InvoiceBean sBean = null;
        ArrayList<InvoiceBean> _sBean = new ArrayList<InvoiceBean>();
        try {
            connect = getConnection();
            String preQueryStatement = "SELECT * FROM Invoice";
            pStmt = connect.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmt.executeQuery();
            while (rs.next()) {
                sBean = new InvoiceBean();
                // set the record detail to the customer bean
                sBean.setInvoiceId(rs.getString("invoiceId"));
                sBean.setInvoiceDate(rs.getDate("invoiceDate"));
                sBean.setDeliveryDate(rs.getDate("deliveryDate"));
                sBean.setAddress(rs.getString("address"));
                sBean.setStatus(rs.getString("status"));
                sBean.setCid(rs.getString("cid"));
                sBean.setSid(rs.getString("sid"));
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

    public boolean changeInvoiceStatus(String status, String invoiceId) {
        Connection connect = null;
        PreparedStatement pStmt = null;
        boolean isSuccess = false;

        try {
            connect = getConnection();
            String preQueryStatement = "UPDATE Invoice SET status = ? WHERE invoiceId =?";
            pStmt = connect.prepareStatement(preQueryStatement);

            pStmt.setString(1, status);
            pStmt.setString(2, invoiceId);

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
