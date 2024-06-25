/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author hi2ot
 */
public class Session {
    private int UserID;
    private int SessionID;
    private float Total;

    public Session() {
    }

    public Session(int UserID, int SessionID, float Total) {
        this.UserID = UserID;
        this.SessionID = SessionID;
        this.Total = Total;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getSessionID() {
        return SessionID;
    }

    public void setSessionID(int SessionID) {
        this.SessionID = SessionID;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
    
}
