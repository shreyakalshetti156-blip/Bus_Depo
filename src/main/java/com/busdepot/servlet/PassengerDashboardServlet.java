package com.busdepot.servlet;

import java.io.IOException;
import com.busdepot.dao.RouteDAO;
import com.busdepot.dao.RouteDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PassengerDashboardServlet")
public class PassengerDashboardServlet extends HttpServlet {
    private RouteDAO routeDAO = new RouteDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"customer".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp");
            return;
        }

        // Load all routes
        req.setAttribute("routes", routeDAO.getAllRoutes());
        req.getRequestDispatcher("passenger-dashboard.jsp").forward(req, resp);
    }
}