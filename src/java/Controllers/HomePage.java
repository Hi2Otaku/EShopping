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
public class HomePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        User UserLogged = (User) ses.getAttribute("UserLogged");
        if (UserLogged == null) {

        } else {
            String Logout = request.getParameter("Logout");
            if (Logout != null) {
                ses.removeAttribute("UserLogged");
            }
        }
        
        DAO.INS.loadAll();
        request.setAttribute("cl", DAO.INS.getCl());
        request.setAttribute("pl", DAO.INS.getPl());
        request.setAttribute("INS", DAO.INS);
        request.getRequestDispatcher("/LocalWeb/HomePage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
