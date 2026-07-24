<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Buses</title>
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
            <h2><i class="fas fa-bus"></i> Manage Buses</h2>
            <!-- ✅ FIXED: Goes through servlet to load depots -->
            <a href="BusServlet?action=add" class="btn btn-success"><i class="fas fa-plus"></i> Add Bus</a>
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
                    <th>Bus Number</th>
                    <th>Type</th>
                    <th>Capacity</th>
                    <th>Depot</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${buses}" var="b">
                    <tr>
                        <td>${b.busId}</td>
                        <td><strong>${b.busNumber}</strong></td>
                        <td>${b.busType}</td>
                        <td>${b.capacity}</td>
                        <td>${b.depotName}</td>
                        <td>
                            <a href="BusServlet?action=edit&id=${b.busId}" class="btn btn-primary btn-sm"><i class="fas fa-edit"></i></a>
                            <a href="BusServlet?action=delete&id=${b.busId}" class="btn btn-danger btn-sm delete-confirm"><i class="fas fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty buses}">
                    <tr><td colspan="6" class="text-center" style="padding: 30px;">No buses found.</td></tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>