/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author hi2ot
 */
public class Feedback {
    private int ProductID;
    private int FeecbackID;
    private int UserID;
    private String Title;
    private String Description;

    public Feedback() {
    }

    public Feedback(int ProductID, int FeecbackID, int UserID, String Title, String Description) {
        this.ProductID = ProductID;
        this.FeecbackID = FeecbackID;
        this.UserID = UserID;
        this.Title = Title;
        this.Description = Description;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getFeecbackID() {
        return FeecbackID;
    }

    public void setFeecbackID(int FeecbackID) {
        this.FeecbackID = FeecbackID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
