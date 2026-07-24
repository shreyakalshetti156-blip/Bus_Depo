package com.busdepot.servlet;

import java.io.IOException;
import com.busdepot.dao.UserDAO;
import com.busdepot.dao.UserDAOImpl;
import com.busdepot.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email == null || password == null || email.trim().isEmpty() || password.trim().isEmpty()) {
            req.setAttribute("errorMsg", "Email and password are required");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        // Trim credentials before passing to DAO
        email = email.trim();
        password = password.trim();

        User user = userDAO.login(email, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName", user.getFullName());
            session.setAttribute("role", user.getRole());

            if ("admin".equalsIgnoreCase(user.getRole())) {
                resp.sendRedirect("AdminDashboardServlet");
            } else {
                resp.sendRedirect("PassengerDashboardServlet");
            }
        } else {
            req.setAttribute("errorMsg", "Invalid email or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}




//package com.busdepot.servlet;
//
//import java.io.IOException;
//import com.busdepot.dao.UserDAO;
//import com.busdepot.dao.UserDAOImpl;
//import com.busdepot.model.User;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet("/LoginServlet")
//public class LoginServlet extends HttpServlet {
//    private UserDAO userDAO = new UserDAOImpl();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//
//        if (email == null || password == null || email.trim().isEmpty() || password.trim().isEmpty()) {
//            req.setAttribute("errorMsg", "Email and password are required");
//            req.getRequestDispatcher("login.jsp").forward(req, resp);
//            return;
//        }
//
//        User user = userDAO.login(email.trim(), password.trim());
//
//        if (user != null) {
//            HttpSession session = req.getSession();
//            session.setAttribute("userId", user.getUserId());
//            session.setAttribute("userName", user.getFullName());
//            session.setAttribute("role", user.getRole());
//
//            if ("admin".equalsIgnoreCase(user.getRole())) {
//                resp.sendRedirect("AdminDashboardServlet");
//            } else {
//                resp.sendRedirect("RouteServlet");
//            }
//        } else {
//            req.setAttribute("errorMsg", "Invalid email or password");
//            req.getRequestDispatcher("login.jsp").forward(req, resp);
//        }
//    }
//}