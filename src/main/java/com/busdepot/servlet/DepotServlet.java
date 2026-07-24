package com.busdepot.servlet;

import java.io.IOException;
import java.util.List;
import com.busdepot.dao.DepotDAO;
import com.busdepot.dao.DepotDAOImpl;
import com.busdepot.model.Depot;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DepotServlet")
public class DepotServlet extends HttpServlet {
    private DepotDAO depotDAO = new DepotDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            depotDAO.deleteDepot(id);
            resp.sendRedirect("DepotServlet");
            return;
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Depot d = depotDAO.getDepotById(id);
            req.setAttribute("depot", d);
            req.getRequestDispatcher("depot-form.jsp").forward(req, resp);
            return;
        }

        List<Depot> depots = depotDAO.getAllDepots();
        req.setAttribute("depots", depots);
        req.getRequestDispatcher("depots.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String id = req.getParameter("depotId");
        String name = req.getParameter("depotName");
        String location = req.getParameter("location");

        Depot d = new Depot(name, location);
        if (id != null && !id.isEmpty()) {
            d.setDepotId(Integer.parseInt(id));
            depotDAO.updateDepot(d);
        } else {
            depotDAO.addDepot(d);
        }
        resp.sendRedirect("DepotServlet");
    }
}