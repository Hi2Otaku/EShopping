/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers;

import DAL.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import Models.*;
import jakarta.servlet.http.HttpSession;
/**
 *
 * @author hi2ot
 */
public class ForgetPassword extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String mailcheck = request.getParameter("mailcheck");
        if (mailcheck == null) {
            DAO.INS.loadAll();
            request.setAttribute("ql", DAO.INS.getQl());
        }
        request.getRequestDispatcher("/LocalWeb/ForgetPassword.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String pass = request.getParameter("pass");
        if (pass == null) {
            String mail = request.getParameter("mail");
            int sq = Integer.parseInt(request.getParameter("sq"));
            String sqa = request.getParameter("sqa");
            User x = new User();
            for (User i : DAO.INS.getUl()) {
                if (mail.equals(i.getMail()) && sq == i.getSecurityQuestionID() && sqa.equals(i.getSecurityQuestionAnswer())) {
                    HttpSession ses = request.getSession();
                    ses.setAttribute("User", i);
                    request.setAttribute("mailcheck", 1);
                }
            }
            doGet(request, response);
        } else {
            String cfpass = request.getParameter("cfpass");
            if (pass.equals(cfpass)) {
                HttpSession ses = request.getSession();
                User x = (User) ses.getAttribute("User");
                DAO.INS.changePassword(x, cfpass);
                ses.removeAttribute("User");
                response.sendRedirect(request.getContextPath() + "/HomePage");
            } else {
                request.setAttribute("mailcheck", 1);
                doGet(request, response);
            }
        }        
    }
    
    

}
