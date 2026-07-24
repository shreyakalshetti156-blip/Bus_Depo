package com.busdepot.servlet;

import java.io.IOException;
import java.util.List;
import com.busdepot.dao.DriverDAO;
import com.busdepot.dao.DriverDAOImpl;
import com.busdepot.dao.DepotDAO;
import com.busdepot.dao.DepotDAOImpl;
import com.busdepot.model.Driver;
import com.busdepot.model.Depot;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DriverServlet")
public class DriverServlet extends HttpServlet {
    private DriverDAO driverDAO = new DriverDAOImpl();
    private DepotDAO depotDAO = new DepotDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String action = req.getParameter("action");

        // Handle Delete
        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            driverDAO.deleteDriver(id);
            resp.sendRedirect("DriverServlet");
            return;
        }

        // Handle Edit
        if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Driver driver = driverDAO.getDriverById(id);
            req.setAttribute("driver", driver);
            req.setAttribute("depots", depotDAO.getAllDepots());
            req.getRequestDispatcher("driver-form.jsp").forward(req, resp);
            return;
        }

        // ✅ NEW: Handle Add
        if ("add".equals(action)) {
            req.setAttribute("driver", null);           // empty driver object
            req.setAttribute("depots", depotDAO.getAllDepots());
            req.getRequestDispatcher("driver-form.jsp").forward(req, resp);
            return;
        }

        // Default: List all drivers
        List<Driver> drivers = driverDAO.getAllDrivers();
        List<Depot> depots = depotDAO.getAllDepots();
        req.setAttribute("drivers", drivers);
        req.setAttribute("depots", depots);
        req.getRequestDispatcher("drivers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp");
            return;
        }

        try {
            String id = req.getParameter("driverId");
            String name = req.getParameter("driverName");
            String license = req.getParameter("licenseNumber");
            String phone = req.getParameter("phone");
            int depotId = Integer.parseInt(req.getParameter("depotId"));

            Driver d = new Driver(name, license, phone, depotId);
            if (id != null && !id.isEmpty()) {
                d.setDriverId(Integer.parseInt(id));
                driverDAO.updateDriver(d);
            } else {
                driverDAO.addDriver(d);
            }
        } catch (NumberFormatException e) {
            session.setAttribute("errorMsg", "Invalid number format. Please check your inputs.");
        } catch (Exception e) {
            session.setAttribute("errorMsg", "Error saving driver: " + e.getMessage());
        }
        resp.sendRedirect("DriverServlet");
    }
}