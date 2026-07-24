<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<aside class="sidebar">
    <div class="sidebar-brand">
        <h2><i class="fas fa-bus"></i> BusDepot</h2>
    </div>
    <ul class="sidebar-menu">
        <li><a href="AdminDashboardServlet" class="<%= request.getRequestURI().contains("AdminDashboard") ? "active" : "" %>"><i class="fas fa-chart-pie"></i> <span>Dashboard</span></a></li>
        <li><a href="DepotServlet" class="<%= request.getRequestURI().contains("DepotServlet") ? "active" : "" %>"><i class="fas fa-warehouse"></i> <span>Depots</span></a></li>
        <li><a href="BusServlet" class="<%= request.getRequestURI().contains("BusServlet") ? "active" : "" %>"><i class="fas fa-bus"></i> <span>Buses</span></a></li>
        <li><a href="DriverServlet" class="<%= request.getRequestURI().contains("DriverServlet") ? "active" : "" %>"><i class="fas fa-user-tie"></i> <span>Drivers</span></a></li>
        <li><a href="RouteServlet" class="<%= request.getRequestURI().contains("RouteServlet") ? "active" : "" %>"><i class="fas fa-route"></i> <span>Routes</span></a></li>
        <li><a href="AssignmentServlet" class="<%= request.getRequestURI().contains("AssignmentServlet") ? "active" : "" %>"><i class="fas fa-tasks"></i> <span>Assignments</span></a></li>
        
        <li><a href="LogoutServlet" style="margin-top: 20px; border-top: 1px solid #34495e; padding-top: 15px;"><i class="fas fa-sign-out-alt"></i> <span>Logout</span></a></li>
    </ul>
</aside>