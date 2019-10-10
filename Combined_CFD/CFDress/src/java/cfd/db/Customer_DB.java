package cfd.db;

import cfd.bean.CustomerBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Customer_DB {

    private String url, username, password;

    public Customer_DB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    public boolean addRecord(CustomerBean bean) { // insert method 1 by full informarion
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "insert into customer values(?,?,?,?,?,?,?,?,?,?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, bean.getId());
            preStatement.setString(2, bean.getEmail());
            preStatement.setString(3, bean.getPwd());
            preStatement.setString(4, bean.getFname());
            preStatement.setString(5, bean.getLname());
            preStatement.setString(6, bean.getPhone());
            preStatement.setDate(7, bean.getDob());
            preStatement.setString(8, bean.getGender());
            preStatement.setDate(9, bean.getRegDate());
            preStatement.setInt(10, bean.getBonusPoint());
            preStatement.setString(11, bean.getStatus());

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

    public boolean addRecordByMinRequirement(String id, String email, String fname, String lname) { // insert method 2 by system min requirement informarion
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "insert into Customer (cid, email, fname, lname)values(?,?,?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, email);
            preStatement.setString(3, fname);
            preStatement.setString(4, lname);

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

    public boolean hasSameEmail(String email) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isDuplicate = false;
        try {
            conn = getConnection();
            String sql = "select count(*) from Customer where email = ?";
            conn = getConnection();
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, email);

            ResultSet rs = preStatement.executeQuery();
            rs.next();
            System.out.println("input email number in db: " + rs.getLong(1));
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

    public List<CustomerBean> getAllCustomers() {

        List<CustomerBean> customers = new LinkedList<CustomerBean>();
        Connection conn = null;
        PreparedStatement preStatement = null;

        try {
            conn = getConnection();
            String sql = "select * from Customer";
            preStatement = conn.prepareStatement(sql);

            ResultSet rs = preStatement.executeQuery();
            while (rs.next()) {
                CustomerBean custBean = new CustomerBean();
                custBean.setId(rs.getString(1));
                custBean.setEmail(rs.getString(2));
                custBean.setPwd(rs.getString(3));
                custBean.setFname(rs.getString(4));
                custBean.setLname(rs.getString(5));
                custBean.setBalance(rs.getDouble(6));
                custBean.setPhone(rs.getString(7));
                custBean.setDob(rs.getDate(8));
                custBean.setGender(rs.getString(9));
                custBean.setRegDate(rs.getDate(10));
                custBean.setBonusPoint(rs.getInt(11));
                custBean.setStatus(rs.getString(12));

                customers.add(custBean);
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return customers;
    }

    public List<CustomerBean> getRequestedCustomers() {

        List<CustomerBean> customers = new LinkedList<CustomerBean>();
        Connection conn = null;
        PreparedStatement preStatement = null;

        try {
            conn = getConnection();
            String sql = "select * from Customer where status = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, "requested");
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()) {
                CustomerBean custBean = new CustomerBean();
                custBean.setId(rs.getString(1));
                custBean.setEmail(rs.getString(2));
                custBean.setPwd(rs.getString(3));
                custBean.setFname(rs.getString(4));
                custBean.setLname(rs.getString(5));
                custBean.setBalance(rs.getDouble(6));
                custBean.setPhone(rs.getString(7));
                custBean.setDob(rs.getDate(8));
                custBean.setGender(rs.getString(9));
                custBean.setRegDate(rs.getDate(10));
                custBean.setBonusPoint(rs.getInt(11));
                custBean.setStatus(rs.getString(12));

                customers.add(custBean);
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return customers;
    }

    public boolean verifyCustomer(String id) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set status =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(2, id);
            preStatement.setString(1, "confirmed");

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

    public int getRowsNum() {
        Connection conn = null;
        Statement statement = null;
        int rowCount = 0;
        try {
            conn = getConnection();
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Customer");
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

    public CustomerBean getCustomer(String id) {

        Connection conn = null;
        PreparedStatement preStatement = null;
        CustomerBean custBean = null;
        try {
            conn = getConnection();
            String sql = "select * from Customer where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);

            ResultSet rs = preStatement.executeQuery();
            while (rs.next()) {
                custBean = new CustomerBean();
                custBean.setId(rs.getString(1));
                custBean.setEmail(rs.getString(2));
                custBean.setPwd(rs.getString(3));
                custBean.setFname(rs.getString(4));
                custBean.setLname(rs.getString(5));
                custBean.setBalance(rs.getDouble(6));
                custBean.setPhone(rs.getString(7));
                custBean.setDob(rs.getDate(8));
                custBean.setGender(rs.getString(9));
                custBean.setRegDate(rs.getDate(10));
                custBean.setBonusPoint(rs.getInt(11));
                custBean.setStatus(rs.getString(12));

            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return custBean;
    }

    public boolean updateUserFname(String id, String fname) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set fname =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, fname);
            preStatement.setString(2, id);
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

    public boolean updateUserLname(String id, String lname) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set lname =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, lname);
            preStatement.setString(2, id);
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

    public boolean updateUserEmail(String id, String email) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set email =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, email);
            preStatement.setString(2, id);
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

    public boolean updateUserPhone(String id, String phone) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set phone =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, phone);
            preStatement.setString(2, id);
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

    public boolean updateUserGender(String id, String gender) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set gender =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, gender);
            preStatement.setString(2, id);
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

    public boolean updateUserDob(String id, Date dob) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set dob =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setDate(1, dob);
            preStatement.setString(2, id);
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

    public boolean updateUserBalance(String id, Double balance) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set balance =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setDouble(1, balance);
            preStatement.setString(2, id);
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

    public boolean updateUserBonus(String id, int bonus) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set bonus =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setDouble(1, bonus);
            preStatement.setString(2, id);
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

    public boolean deniedUser(String id) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set status =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, "denieded");
            preStatement.setString(2, id);
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

    public List<CustomerBean> getCustomersByStatus(String status) {

        List<CustomerBean> customers = new LinkedList<CustomerBean>();
        Connection conn = null;
        PreparedStatement preStatement = null;

        try {
            conn = getConnection();
            String sql = "select * from Customer where status = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, status);
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()) {
                CustomerBean custBean = new CustomerBean();
                custBean.setId(rs.getString(1));
                custBean.setEmail(rs.getString(2));
                custBean.setPwd(rs.getString(3));
                custBean.setFname(rs.getString(4));
                custBean.setLname(rs.getString(5));
                custBean.setBalance(rs.getDouble(6));
                custBean.setPhone(rs.getString(7));
                custBean.setDob(rs.getDate(8));
                custBean.setGender(rs.getString(9));
                custBean.setRegDate(rs.getDate(10));
                custBean.setBonusPoint(rs.getInt(11));
                custBean.setStatus(rs.getString(12));

                customers.add(custBean);
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return customers;
    }

    public List<CustomerBean> getCustomersByFirstName(String fName) {

        List<CustomerBean> customers = new LinkedList<CustomerBean>();
        Connection conn = null;
        Statement statement = null;

        try {
            conn = getConnection();
            String sql = "select * from Customer where fName like \"%" + fName + "%\"";
            statement = conn.createStatement();
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                CustomerBean custBean = new CustomerBean();
                custBean.setId(rs.getString(1));
                custBean.setEmail(rs.getString(2));
                custBean.setPwd(rs.getString(3));
                custBean.setFname(rs.getString(4));
                custBean.setLname(rs.getString(5));
                custBean.setBalance(rs.getDouble(6));
                custBean.setPhone(rs.getString(7));
                custBean.setDob(rs.getDate(8));
                custBean.setGender(rs.getString(9));
                custBean.setRegDate(rs.getDate(10));
                custBean.setBonusPoint(rs.getInt(11));
                custBean.setStatus(rs.getString(12));

                customers.add(custBean);
            }
            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return customers;
    }

    public List<CustomerBean> getCustomersByLastName(String lName) {

        List<CustomerBean> customers = new LinkedList<CustomerBean>();
        Connection conn = null;
        Statement statement = null;

        try {
            conn = getConnection();
            String sql = "select * from Customer where lName like \"%" + lName + "%\"";
            statement = conn.createStatement();
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                CustomerBean custBean = new CustomerBean();
                custBean.setId(rs.getString(1));
                custBean.setEmail(rs.getString(2));
                custBean.setPwd(rs.getString(3));
                custBean.setFname(rs.getString(4));
                custBean.setLname(rs.getString(5));
                custBean.setBalance(rs.getDouble(6));
                custBean.setPhone(rs.getString(7));
                custBean.setDob(rs.getDate(8));
                custBean.setGender(rs.getString(9));
                custBean.setRegDate(rs.getDate(10));
                custBean.setBonusPoint(rs.getInt(11));
                custBean.setStatus(rs.getString(12));

                customers.add(custBean);
            }
            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return customers;
    }

    public boolean generatePwdForRequestedUser(String id, String pwd) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set password =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, pwd);
            preStatement.setString(2, id);
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

    public boolean login(String email, String pwd) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "select count(*) from Customer where email = ? and password = ? and status = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, email);
            preStatement.setString(2, pwd);
            preStatement.setString(3, "confirmed");
            ResultSet rs = preStatement.executeQuery();
            rs.next();
            System.out.print("Account login pair Number: " + rs.getInt(1));
            if (rs.getInt(1) == 1) {
                isSuccess = true;
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return isSuccess;
    }

    public CustomerBean getCustomerByEmailAndPwd(String email, String pwd) {

        Connection conn = null;
        PreparedStatement preStatement = null;
        CustomerBean custBean = null;
        try {
            conn = getConnection();
            String sql = "select * from Customer where email = ? and password = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, email);
            preStatement.setString(2, pwd);
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()) {
                custBean = new CustomerBean();
                custBean.setId(rs.getString(1));
                custBean.setEmail(rs.getString(2));
                custBean.setPwd(rs.getString(3));
                custBean.setFname(rs.getString(4));
                custBean.setLname(rs.getString(5));
                custBean.setBalance(rs.getDouble(6));
                custBean.setPhone(rs.getString(7));
                custBean.setDob(rs.getDate(8));
                custBean.setGender(rs.getString(9));
                custBean.setRegDate(rs.getDate(10));
                custBean.setBonusPoint(rs.getInt(11));
                custBean.setStatus(rs.getString(12));

            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return custBean;
    }

    public boolean changePwd(String id, String pwd) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isSuccess = false;
        try {
            conn = getConnection();
            String sql = "update Customer set password =? where cid = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, pwd);
            preStatement.setString(2, id);
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

    public boolean isValidPwd(String id, String pwd) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        boolean isValid = false;
        try {
            conn = getConnection();
            String sql = "select count(*) from Customer where cid = ? and password = ?";
            conn = getConnection();
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, pwd);

            ResultSet rs = preStatement.executeQuery();
            rs.next();
            System.out.println("input pwd number in db: " + rs.getLong(1));
            if (rs.getInt(1) > 0) {
                isValid = true;
            }
            preStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return isValid;
    }
}
