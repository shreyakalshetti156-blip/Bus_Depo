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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Trim all inputs
        String fullName = req.getParameter("fullName").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();
        String password = req.getParameter("password").trim();
        String confirm = req.getParameter("confirmPassword").trim();

        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            req.setAttribute("errorMsg", "All fields are required");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        if (!password.equals(confirm)) {
            req.setAttribute("errorMsg", "Passwords do not match");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        if (userDAO.emailExists(email)) {
            req.setAttribute("errorMsg", "Email already registered");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        User user = new User(fullName, email, password);
        user.setPhone(phone);
        // Optionally, you can allow admin registration by setting role from a hidden field,
        // but for now default is "customer".

        if (userDAO.register(user)) {
            resp.sendRedirect("login.jsp?registered=true");
        } else {
            req.setAttribute("errorMsg", "Registration failed");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
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
//
//@WebServlet("/RegisterServlet")
//public class RegisterServlet extends HttpServlet {
//    private UserDAO userDAO = new UserDAOImpl();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String fullName = req.getParameter("fullName");
//        String email = req.getParameter("email");
//        String phone = req.getParameter("phone");
//        String password = req.getParameter("password");
//        String confirm = req.getParameter("confirmPassword");
//
//        if (fullName == null || email == null || password == null) {
//            req.setAttribute("errorMsg", "All fields are required");
//            req.getRequestDispatcher("register.jsp").forward(req, resp);
//            return;
//        }
//
//        if (!password.equals(confirm)) {
//            req.setAttribute("errorMsg", "Passwords do not match");
//            req.getRequestDispatcher("register.jsp").forward(req, resp);
//            return;
//        }
//
//        if (userDAO.emailExists(email)) {
//            req.setAttribute("errorMsg", "Email already registered");
//            req.getRequestDispatcher("register.jsp").forward(req, resp);
//            return;
//        }
//
//        User user = new User(fullName, email, password);
//        user.setPhone(phone);
//
//        if (userDAO.register(user)) {
//            resp.sendRedirect("login.jsp?registered=true");
//        } else {
//            req.setAttribute("errorMsg", "Registration failed");
//            req.getRequestDispatcher("register.jsp").forward(req, resp);
//        }
//    }
//}