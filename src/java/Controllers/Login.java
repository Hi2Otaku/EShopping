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
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/LocalWeb/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        if (user != null) {
            DAO.INS.loadAll();
            List<User> ul = DAO.INS.getUl();
            int logged = 0;
            for (User x : ul) {
                if (x.getUserName().equals(user) && x.getPassword().equals(pass)) {
                    HttpSession ses = request.getSession();
                    ses.setAttribute("UserLogged", x);
                    logged = 1;
                    response.sendRedirect(request.getContextPath() + "/HomePage");
                }
            }
            request.setAttribute("WrongInfo", 1);
            if (logged == 0) {
                doGet(request, response);
            }
        }        
    }

}
