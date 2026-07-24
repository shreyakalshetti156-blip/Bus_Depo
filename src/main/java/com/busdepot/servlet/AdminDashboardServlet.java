package com.busdepot.servlet;

import java.io.IOException;
import com.busdepot.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp");
            return;
        }

        DepotDAO depotDAO = new DepotDAOImpl();
        BusDAO busDAO = new BusDAOImpl();
        DriverDAO driverDAO = new DriverDAOImpl();
        RouteDAO routeDAO = new RouteDAOImpl();
       

        req.setAttribute("totalDepots", depotDAO.getAllDepots().size());
        req.setAttribute("totalBuses", busDAO.getAllBuses().size());
        req.setAttribute("totalDrivers", driverDAO.getAllDrivers().size());
        req.setAttribute("totalRoutes", routeDAO.getAllRoutes().size());
       

        req.getRequestDispatcher("admin-dashboard.jsp").forward(req, resp);
    }
}