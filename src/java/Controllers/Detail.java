/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import java.util.*;
import Models.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hi2ot
 */
public class Detail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ses.removeAttribute("InProduct");
        int ProductID = -1;
        request.setAttribute("ProductID", -1);
        try {
            ProductID = Integer.parseInt(request.getParameter("ProductID"));
        } catch (Exception e) {
        }
        if (ProductID != -1) {
            DAO.INS.loadAll();
            request.setAttribute("pl", DAO.INS.getPl());
            request.setAttribute("cl", DAO.INS.getCl());
            request.setAttribute("INS", DAO.INS);
            for (Product x : DAO.INS.getPl()) {
                if (x.getProductID() == ProductID) {                    
                    ses.setAttribute("InProduct", x);
                    request.setAttribute("ProductID", ProductID);
                    break;
                }
            }
        }
        request.getRequestDispatcher("/LocalWeb/Detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String AddToCart = request.getParameter("AddToCart");
        if (AddToCart != null) {
            HttpSession ses = request.getSession();
            User UserLogged = (User) ses.getAttribute("UserLogged");
            if (UserLogged == null) {
                response.sendRedirect(request.getContextPath() + "/Login");
            } else {
                Product x = (Product) ses.getAttribute("InProduct");
                DAO.INS.addCart(x, UserLogged.getUserID());
                ses.removeAttribute("InProduct");
                ses.setAttribute("AddedToCart", 1);
                response.sendRedirect(request.getContextPath() + "/Redirecting");
            }
        } else {
            doGet(request, response);
        }
    }
}
