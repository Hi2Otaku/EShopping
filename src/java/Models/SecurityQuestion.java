/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author hi2ot
 */
public class SecurityQuestion {
    private int SecurityQuestionID;
    private String Question;

    public SecurityQuestion() {
    }

    public SecurityQuestion(int SecurityQuestionID, String Question) {
        this.SecurityQuestionID = SecurityQuestionID;
        this.Question = Question;
    }

    public int getSecurityQuestionID() {
        return SecurityQuestionID;
    }

    public void setSecurityQuestionID(int SecurityQuestionID) {
        this.SecurityQuestionID = SecurityQuestionID;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }
    
}
