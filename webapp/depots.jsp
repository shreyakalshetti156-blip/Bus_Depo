<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Depots</title>
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
            <h2><i class="fas fa-warehouse"></i> Manage Depots</h2>
            <a href="depot-form.jsp" class="btn btn-success"><i class="fas fa-plus"></i> Add Depot</a>
        </div>

        <c:if test="${not empty sessionScope.successMsg}">
            <div class="alert alert-success"><i class="fas fa-check-circle"></i> ${sessionScope.successMsg}</div>
            <c:remove var="successMsg" scope="session"/>
        </c:if>

        <table>
            <thead>
                <tr><th>ID</th><th>Depot Name</th><th>Location</th><th>Actions</th></tr>
            </thead>
            <tbody>
                <c:forEach items="${depots}" var="d">
                    <tr>
                        <td>${d.depotId}</td>
                        <td><strong>${d.depotName}</strong></td>
                        <td>${d.location}</td>
                        <td>
                            <a href="DepotServlet?action=edit&id=${d.depotId}" class="btn btn-primary btn-sm"><i class="fas fa-edit"></i></a>
                            <a href="DepotServlet?action=delete&id=${d.depotId}" class="btn btn-danger btn-sm delete-confirm"><i class="fas fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty depots}">
                    <tr><td colspan="4" class="text-center">No depots found.</td></tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>