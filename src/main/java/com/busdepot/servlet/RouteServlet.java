package com.busdepot.servlet;

import java.io.IOException;
import java.util.List;
import com.busdepot.dao.RouteDAO;
import com.busdepot.dao.RouteDAOImpl;
import com.busdepot.model.Route;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RouteServlet")
public class RouteServlet extends HttpServlet {
    private RouteDAO routeDAO = new RouteDAOImpl();

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
            routeDAO.deleteRoute(id);
            resp.sendRedirect("RouteServlet");
            return;
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Route r = routeDAO.getRouteById(id);
            req.setAttribute("route", r);
            req.getRequestDispatcher("route-form.jsp").forward(req, resp);
            return;
        }

        List<Route> routes = routeDAO.getAllRoutes();
        req.setAttribute("routes", routes);
        req.getRequestDispatcher("routes.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String id = req.getParameter("routeId");
        String name = req.getParameter("routeName");
        String start = req.getParameter("startPoint");
        String end = req.getParameter("endPoint");

        Route r = new Route(name, start, end);
        if (id != null && !id.isEmpty()) {
            r.setRouteId(Integer.parseInt(id));
            routeDAO.updateRoute(r);
        } else {
            routeDAO.addRoute(r);
        }
        resp.sendRedirect("RouteServlet");
    }
}