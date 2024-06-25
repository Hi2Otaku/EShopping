/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author hi2ot
 */
public class DAO {

    private Connection con;
    private List<User> ul;
    private List<Product> pl;
    private List<Category> cl;
    private List<Cart> ctl;
    private List<Feedback> fl;
    private List<Session> sl;
    private List<Order> ol;
    private List<SecurityQuestion> ql;

    public List<SecurityQuestion> getQl() {
        return ql;
    }

    public void setQl(List<SecurityQuestion> ql) {
        this.ql = ql;
    }

    public List<User> getUl() {
        return ul;
    }

    public void setUl(List<User> ul) {
        this.ul = ul;
    }

    public List<Product> getPl() {
        return pl;
    }

    public void setPl(List<Product> pl) {
        this.pl = pl;
    }

    public List<Category> getCl() {
        return cl;
    }

    public void setCl(List<Category> cl) {
        this.cl = cl;
    }

    public List<Cart> getCtl() {
        return ctl;
    }

    public void setCtl(List<Cart> ctl) {
        this.ctl = ctl;
    }

    public List<Feedback> getFl() {
        return fl;
    }

    public void setFl(List<Feedback> fl) {
        this.fl = fl;
    }

    public List<Session> getSl() {
        return sl;
    }

    public void setSl(List<Session> sl) {
        this.sl = sl;
    }

    public List<Order> getOl() {
        return ol;
    }

    public void setOl(List<Order> ol) {
        this.ol = ol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private String status = "OK";
    public static DAO INS = new DAO();

    private DAO() {
        if (INS == null) {
            try {
                con = new DBContext().getConnection();
            } catch (Exception e) {
                status = "Error at Connection" + e.getMessage();
            }
        } else {
            INS = this;
        }
    }

    public void loadAll() {
        String sql = "Select * From [Product]";
        pl = new Vector<Product>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                float Price = rs.getFloat("Price");
                String Description = rs.getString("Description");
                String Image = rs.getString("Image");
                pl.add(new Product(ProductID, ProductName, Price, Description, Image));
            }

        } catch (Exception e) {
            status = "Error at load Product " + e.getMessage();
            System.out.println(status);
        }

        sql = "Select * From [Category]";
        cl = new Vector<Category>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int CategoryID = rs.getInt("CategoryID");
                String CategoryName = rs.getString("CategoryName");
                cl.add(new Category(CategoryID, CategoryName));
            }
        } catch (Exception e) {
            status = "Error at load Category " + e.getMessage();
            System.out.println(status);
        }

        sql = "Select * From [User]";
        ul = new Vector<User>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int UserID = rs.getInt("UserID");
                String UserName = rs.getString("UserName");
                String Password = rs.getString("Password");
                String Mail = rs.getString("Mail");
                String FullName = rs.getString("FullName");
                java.sql.Date DoB = rs.getDate("DoB");
                int SecurityQuestionID = rs.getInt("SecurityQuestionID");
                String SecurityQuestionAnswer = rs.getString("SecurityQuestionAnswer");
                int Role = rs.getInt("Role");
                ul.add(new User(UserID, UserName, Password, Mail, FullName, DoB, SecurityQuestionID, SecurityQuestionAnswer, Role));
            }

        } catch (Exception e) {
            status = "Error at load User" + e.getMessage();
            System.out.println(status);
        }

        sql = "Select * From [Session]";
        sl = new Vector<Session>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int UserID = rs.getInt("UserID");
                int SessionID = rs.getInt("SessionID");
                float Total = rs.getFloat("Total");
                sl.add(new Session(UserID, SessionID, Total));
            }

        } catch (Exception e) {
            status = "Error at load Session" + e.getMessage();
            System.out.println(status);
        }

        sql = "Select * From [Cart]";
        ctl = new Vector<Cart>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int SessionID = rs.getInt("SessionID");
                int ProductID = rs.getInt("ProductID");
                int Quantity = rs.getInt("Quantity");
                ctl.add(new Cart(SessionID, ProductID, Quantity));
            }

        } catch (Exception e) {
            status = "Error at load Cart" + e.getMessage();
            System.out.println(status);
        }

        sql = "Select * From [Order]";
        ol = new Vector<Order>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int OrderID = rs.getInt("OrderID");
                int UserID = rs.getInt("UserID");
                float Total = rs.getFloat("Total");
                String Address = rs.getString("Address");
                int Status = rs.getInt("Status");
                ol.add(new Order(OrderID, UserID, Total, Address, Status));
            }

        } catch (Exception e) {
            status = "Error at load Order" + e.getMessage();
            System.out.println(status);
        }

        sql = "Select * From [Feedback]";
        fl = new Vector<Feedback>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                int FeedbackID = rs.getInt("FeedbackID");
                int UserID = rs.getInt("UserID");
                String Title = rs.getString("Title");
                String Description = rs.getString("Description");
                fl.add(new Feedback(ProductID, FeedbackID, UserID, Title, Description));
            }

        } catch (Exception e) {
            status = "Error at load Feedback" + e.getMessage();
            System.out.println(status);
        }

        sql = "Select * From [SecurityQuestion]";
        ql = new Vector<SecurityQuestion>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int SecurityQuestionID = rs.getInt("SecurityQuestionID");
                String Question = rs.getString("Question");
                ql.add(new SecurityQuestion(SecurityQuestionID, Question));

            }
        } catch (Exception e) {
            status = "Error at load Security Question" + e.getMessage();
            System.out.println(status);
        }
    }

    public void addUser(int UserID, String UserName, String Password, String Mail, String FullName, String DoB, int SecurityQuestionID, String SecurityQuestionAnswer, int Role) {
        String sql = "Insert Into [User] Values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, UserID);
            ps.setString(2, UserName);
            ps.setString(3, Password);
            ps.setString(4, Mail);
            ps.setString(5, FullName);
            ps.setString(6, DoB);
            ps.setInt(7, SecurityQuestionID);
            ps.setString(8, SecurityQuestionAnswer);
            ps.setInt(9, Role);
            ps.execute();

        } catch (Exception e) {
            status = "Error at Insert User " + e.getMessage();
        }
    }

    public void changePassword(User x, String NewPass) {
        String sql = "Update [User] Set Password = ? Where UserID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, NewPass);
            ps.setInt(2, x.getUserID());
            ps.execute();

        } catch (Exception e) {
            status = "Error at Change User Password " + e.getMessage();
        }
    }

    public int getCategory(Product x) {
        String sql = "Select * From [ProductCategory] Where ProductID = ?";
        int ans = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, x.getProductID());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ans = rs.getInt("CategoryID");
            }
        } catch (Exception e) {
            status = "Error at Get Category " + e.getMessage();
        }
        return ans;
    }

    public float getRealPrice(Product x) {
        String sql = "Select * From [Discount] Where ProductID = ?";
        float ans = x.getPrice();
        float percent = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, x.getProductID());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                percent = rs.getInt("Percentage");
            }
        } catch (Exception e) {
            status = "Error at Get Real Price " + e.getMessage();
        }
        return ans - (ans * percent / 100);
    }

    public void addCart(Product x, int SessionID) {
        int Quantity = 0;
        String sql = "Select * From [Cart] Where ProductID = ? and SessionID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, x.getProductID());
            ps.setInt(2, SessionID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Quantity = rs.getInt("Quantity");
            }
        } catch (Exception e) {

        }
        if (Quantity != 0) {
            sql = "Update [Cart] Set Quantity = ? Where ProductID = ? and SessionID = ?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(3, SessionID);
                ps.setInt(2, x.getProductID());
                ps.setInt(1, Quantity + 1);           
                ps.execute();
            } catch (Exception e) {
            }
        } else {
            sql = "Insert Into [Cart] Values(?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, SessionID);
                ps.setInt(2, x.getProductID());
                ps.setInt(3, Quantity + 1);         
                ps.execute();
            } catch (Exception e) {
                status = "Error" + e.getMessage();
                System.out.println(status);
            }
        }
    }

    public static void main(String[] agrs) {
        DAO.INS.loadAll();
        DAO.INS.addCart(DAO.INS.getPl().get(1), 1);
        DAO.INS.loadAll();
        System.out.println(DAO.INS.getCtl().size());
    }
}
