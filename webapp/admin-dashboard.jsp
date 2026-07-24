<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>

<!-- Admin Header -->
<jsp:include page="includes/admin-header.jsp"/>

<div class="admin-container">
    <!-- Sidebar -->
    <jsp:include page="includes/admin-sidebar.jsp"/>

    <!-- Main Content -->
    <div class="main-content">
        <h2><i class="fas fa-chart-pie"></i> Dashboard</h2>
        <div class="stats-grid">
            <div class="stat-card primary">
                <div class="stat-icon"><i class="fas fa-warehouse"></i></div>
                <div class="stat-number">${totalDepots}</div>
                <div class="stat-label">Total Depots</div>
            </div>
            <div class="stat-card success">
                <div class="stat-icon"><i class="fas fa-bus"></i></div>
                <div class="stat-number">${totalBuses}</div>
                <div class="stat-label">Total Buses</div>
            </div>
            <div class="stat-card warning">
                <div class="stat-icon"><i class="fas fa-user-tie"></i></div>
                <div class="stat-number">${totalDrivers}</div>
                <div class="stat-label">Total Drivers</div>
            </div>
            <div class="stat-card primary">
                <div class="stat-icon"><i class="fas fa-route"></i></div>
                <div class="stat-number">${totalRoutes}</div>
                <div class="stat-label">Total Routes</div>
            </div>
            <div class="stat-card success">
                <div class="stat-icon"><i class="fas fa-calendar-check"></i></div>
                <div class="stat-number">${totalTrips}</div>
                <div class="stat-label">Total Trips</div>
            </div>
        </div>

        <div class="card">
            <h3><i class="fas fa-cog"></i> Quick Actions</h3>
            <div class="d-flex">
                <a href="DepotServlet" class="btn btn-primary"><i class="fas fa-warehouse"></i> Depots</a>
                <a href="BusServlet" class="btn btn-success"><i class="fas fa-bus"></i> Buses</a>
                <a href="DriverServlet" class="btn btn-warning"><i class="fas fa-user-tie"></i> Drivers</a>
                <a href="RouteServlet" class="btn btn-info"><i class="fas fa-route"></i> Routes</a>
                <a href="AssignmentServlet" class="btn btn-primary"><i class="fas fa-tasks"></i> Assignments</a>
                <a href="TripServlet" class="btn btn-success"><i class="fas fa-calendar-check"></i> Trips</a>
            </div>
        </div>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>