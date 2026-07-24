<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Trips</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>

<jsp:include page="includes/admin-header.jsp"/>

<div class="admin-container">
    <jsp:include page="includes/admin-sidebar.jsp"/>
    <div class="main-content">
        <div class="d-flex justify-between">
            <h2><i class="fas fa-calendar-check"></i> Manage Trips</h2>
            <!-- ✅ FIXED: Goes through servlet -->
            <a href="TripServlet?action=add" class="btn btn-success"><i class="fas fa-plus"></i> Schedule Trip</a>
        </div>

        <c:if test="${not empty sessionScope.successMsg}">
            <div class="alert alert-success"><i class="fas fa-check-circle"></i> ${sessionScope.successMsg}</div>
            <c:remove var="successMsg" scope="session"/>
        </c:if>
        <c:if test="${not empty sessionScope.errorMsg}">
            <div class="alert alert-danger"><i class="fas fa-exclamation-circle"></i> ${sessionScope.errorMsg}</div>
            <c:remove var="errorMsg" scope="session"/>
        </c:if>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Route</th>
                    <th>Bus</th>
                    <th>Driver</th>
                    <th>Date</th>
                    <th>Departure</th>
                    <th>Seats</th>
                    <th>Price</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${trips}" var="t">
                    <tr>
                        <td>${t.tripId}</td>
                        <td>${t.routeName}</td>
                        <td>${t.busNumber}</td>
                        <td>${t.driverName}</td>
                        <td>${t.tripDate}</td>
                        <td>${t.departureTime}</td>
                        <td>${t.availableSeats}/${t.totalSeats}</td>
                        <td>$${t.ticketPrice}</td>
                        <td>
                            <span class="badge ${t.tripStatus == 'scheduled' ? 'badge-primary' : t.tripStatus == 'cancelled' ? 'badge-danger' : 'badge-success'}">
                                ${t.tripStatus}
                            </span>
                        </td>
                        <td>
                            <a href="TripServlet?action=edit&id=${t.tripId}" class="btn btn-primary btn-sm"><i class="fas fa-edit"></i></a>
                            <a href="TripServlet?action=delete&id=${t.tripId}" class="btn btn-danger btn-sm delete-confirm"><i class="fas fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty trips}">
                    <tr><td colspan="10" class="text-center" style="padding: 30px;">No trips scheduled.</td></tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>