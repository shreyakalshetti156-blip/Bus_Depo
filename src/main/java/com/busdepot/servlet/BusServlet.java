package com.busdepot.servlet;

import java.io.IOException;
import java.util.List;
import com.busdepot.dao.BusDAO;
import com.busdepot.dao.BusDAOImpl;
import com.busdepot.dao.DepotDAO;
import com.busdepot.dao.DepotDAOImpl;
import com.busdepot.model.Bus;
import com.busdepot.model.Depot;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BusServlet")
public class BusServlet extends HttpServlet {
    private BusDAO busDAO = new BusDAOImpl();
    private DepotDAO depotDAO = new DepotDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String action = req.getParameter("action");

        // ✅ DELETE
        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            busDAO.deleteBus(id);
            resp.sendRedirect("BusServlet");
            return;
        }

        // ✅ EDIT
        if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Bus bus = busDAO.getBusById(id);
            req.setAttribute("bus", bus);
            req.setAttribute("depots", depotDAO.getAllDepots());
            req.getRequestDispatcher("bus-form.jsp").forward(req, resp);
            return;
        }

        // ✅ ADD – loads the depot list for the dropdown
        if ("add".equals(action)) {
            req.setAttribute("bus", null);
            req.setAttribute("depots", depotDAO.getAllDepots());
            req.getRequestDispatcher("bus-form.jsp").forward(req, resp);
            return;
        }

        // ✅ DEFAULT: List all buses
        List<Bus> buses = busDAO.getAllBuses();
        List<Depot> depots = depotDAO.getAllDepots();
        req.setAttribute("buses", buses);
        req.setAttribute("depots", depots);
        req.getRequestDispatcher("buses.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp");
            return;
        }

        try {
            String id = req.getParameter("busId");
            String number = req.getParameter("busNumber");
            String type = req.getParameter("busType");
            int capacity = Integer.parseInt(req.getParameter("capacity"));
            int depotId = Integer.parseInt(req.getParameter("depotId"));

            Bus bus = new Bus(number, type, capacity, depotId);
            if (id != null && !id.isEmpty()) {
                bus.setBusId(Integer.parseInt(id));
                busDAO.updateBus(bus);
            } else {
                busDAO.addBus(bus);
            }
        } catch (NumberFormatException e) {
            session.setAttribute("errorMsg", "Invalid number format. Please check your inputs.");
        } catch (Exception e) {
            session.setAttribute("errorMsg", "Error saving bus: " + e.getMessage());
        }
        resp.sendRedirect("BusServlet");
    }
}