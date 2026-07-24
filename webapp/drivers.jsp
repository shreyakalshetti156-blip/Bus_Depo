<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Drivers</title>
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
            <h2><i class="fas fa-user-tie"></i> Manage Drivers</h2>
            <!-- ✅ FIXED LINK -->
            <a href="DriverServlet?action=add" class="btn btn-success"><i class="fas fa-plus"></i> Add Driver</a>
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
                    <th>Driver Name</th>
                    <th>License Number</th>
                    <th>Phone</th>
                    <th>Depot</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${drivers}" var="d">
                    <tr>
                        <td>${d.driverId}</td>
                        <td><strong>${d.driverName}</strong></td>
                        <td>${d.licenseNumber}</td>
                        <td>${d.phone}</td>
                        <td>${d.depotName}</td>
                        <td>
                            <a href="DriverServlet?action=edit&id=${d.driverId}" class="btn btn-primary btn-sm"><i class="fas fa-edit"></i></a>
                            <a href="DriverServlet?action=delete&id=${d.driverId}" class="btn btn-danger btn-sm delete-confirm"><i class="fas fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty drivers}">
                    <tr><td colspan="6" class="text-center" style="padding: 30px;">No drivers found.</td></tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>