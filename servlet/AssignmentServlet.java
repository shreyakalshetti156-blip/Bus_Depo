package com.busdepot.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import com.busdepot.dao.*;
import com.busdepot.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AssignmentServlet")
public class AssignmentServlet extends HttpServlet {
    private AssignmentDAO assignmentDAO = new AssignmentDAOImpl();
    private DriverDAO driverDAO = new DriverDAOImpl();
    private BusDAO busDAO = new BusDAOImpl();
    private RouteDAO routeDAO = new RouteDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String action = req.getParameter("action");

        // DELETE
        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            assignmentDAO.deleteAssignment(id);
            resp.sendRedirect("AssignmentServlet");
            return;
        }

        // EDIT
        if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Assignment assignment = assignmentDAO.getAssignmentById(id);
            req.setAttribute("assignment", assignment);
            req.setAttribute("drivers", driverDAO.getAllDrivers());
            req.setAttribute("buses", busDAO.getAllBuses());
            req.setAttribute("routes", routeDAO.getAllRoutes());
            req.getRequestDispatcher("assignment-form.jsp").forward(req, resp);
            return;
        }

        // ADD – loads lists for dropdowns
        if ("add".equals(action)) {
            req.setAttribute("assignment", null);
            req.setAttribute("drivers", driverDAO.getAllDrivers());
            req.setAttribute("buses", busDAO.getAllBuses());
            req.setAttribute("routes", routeDAO.getAllRoutes());
            req.getRequestDispatcher("assignment-form.jsp").forward(req, resp);
            return;
        }

        // DEFAULT: list all assignments
        List<Assignment> assignments = assignmentDAO.getAllAssignments();
        List<Driver> drivers = driverDAO.getAllDrivers();
        List<Bus> buses = busDAO.getAllBuses();
        List<Route> routes = routeDAO.getAllRoutes();

        req.setAttribute("assignments", assignments);
        req.setAttribute("drivers", drivers);
        req.setAttribute("buses", buses);
        req.setAttribute("routes", routes);
        req.getRequestDispatcher("assignments.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp");
            return;
        }

        try {
            String id = req.getParameter("assignmentId");
            int driverId = Integer.parseInt(req.getParameter("driverId"));
            int busId = Integer.parseInt(req.getParameter("busId"));
            int routeId = Integer.parseInt(req.getParameter("routeId"));
            Date date = Date.valueOf(req.getParameter("assignmentDate"));
            String shift = req.getParameter("shift");

            Assignment assignment = new Assignment(driverId, busId, routeId, date, shift);
            if (id != null && !id.isEmpty()) {
                assignment.setAssignmentId(Integer.parseInt(id));
                assignmentDAO.updateAssignment(assignment);
            } else {
                assignmentDAO.addAssignment(assignment);
            }
        } catch (Exception e) {
            session.setAttribute("errorMsg", "Error: " + e.getMessage());
        }
        resp.sendRedirect("AssignmentServlet");
    }
}