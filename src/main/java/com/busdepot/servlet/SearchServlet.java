package com.busdepot.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import com.busdepot.dao.AssignmentDAO;
import com.busdepot.dao.AssignmentDAOImpl;
import com.busdepot.dao.RouteDAO;
import com.busdepot.dao.RouteDAOImpl;
import com.busdepot.model.Assignment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private AssignmentDAO assignmentDAO = new AssignmentDAOImpl();
    private RouteDAO routeDAO = new RouteDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        // Always load routes for the dropdown (to preserve state)
        req.setAttribute("routes", routeDAO.getAllRoutes());

        String dateParam = req.getParameter("searchDate");
        String routeIdParam = req.getParameter("routeId");
        String busFilter = req.getParameter("busNumber");

        // Validate mandatory fields: date and routeId
        if (dateParam == null || dateParam.isEmpty() || routeIdParam == null || routeIdParam.isEmpty()) {
            req.setAttribute("errorMsg", "Please select a date and a route.");
            req.getRequestDispatcher("passenger-dashboard.jsp").forward(req, resp);
            return;
        }

        try {
            Date searchDate = Date.valueOf(dateParam);
            Integer routeId = Integer.parseInt(routeIdParam);

            // Step 1: Get all assignments for the given date
            List<Assignment> assignments = assignmentDAO.getAssignmentsByDate(searchDate);

            // Step 2: Filter by route (mandatory)
            assignments = assignments.stream()
                    .filter(a -> a.getRouteId() != null && a.getRouteId().equals(routeId))
                    .collect(Collectors.toList());

            // Step 3: Filter by bus number (optional, case-insensitive partial match)
            if (busFilter != null && !busFilter.trim().isEmpty()) {
                String bus = busFilter.trim().toLowerCase();
                assignments = assignments.stream()
                        .filter(a -> a.getBusNumber() != null && a.getBusNumber().toLowerCase().contains(bus))
                        .collect(Collectors.toList());
            }

            req.setAttribute("assignments", assignments);
            req.setAttribute("searchDate", dateParam);
            req.setAttribute("selectedRouteId", routeId);
            req.setAttribute("busFilter", busFilter);

        } catch (IllegalArgumentException e) {
            req.setAttribute("errorMsg", "Invalid date format or route selection.");
        }

        req.getRequestDispatcher("passenger-dashboard.jsp").forward(req, resp);
    }
}