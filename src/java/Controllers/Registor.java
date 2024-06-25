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
/**
 *
 * @author hi2ot
 */
public class Registor extends HttpServlet {  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DAO.INS.loadAll();
        request.setAttribute("ql", DAO.INS.getQl());
        request.getRequestDispatcher("/LocalWeb/Registor.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String mail = request.getParameter("mail");
        String fullname = request.getParameter("fullname");
        String dob = request.getParameter("dob");
        int sq = Integer.parseInt(request.getParameter("sq"));
        String sqa = request.getParameter("sqa");        
        String ck = check(user, mail);
        if (ck != null) {
            request.setAttribute("err", ck);
            doGet(request, response);
        } else if (pass.equals(repass) == false) {
            request.setAttribute("err", "Two password are not the same!");
            doGet(request, response);
        } else {
            DAO.INS.addUser(DAO.INS.getUl().size() + 1, user, pass, mail, fullname, dob, sq, sqa, 0);
            response.sendRedirect(request.getContextPath() + "/Login");
        }        
    }
    
    public String check(String user, String mail) {
        for (User x : DAO.INS.getUl()) {
            if (x.getUserName().equals(user)) {
                return "UserName Has Already Been Used";
            }                
            if (x.getMail().equals(mail)) {
                return "Mail Has Already Been Used";
            }
        }
        return null;
    }
}
