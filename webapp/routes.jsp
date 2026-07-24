<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Routes</title>
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
            <h2><i class="fas fa-route"></i> Manage Routes</h2>
            <a href="route-form.jsp" class="btn btn-success"><i class="fas fa-plus"></i> Add Route</a>
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
                    <th>Route Name</th>
                    <th>Start Point</th>
                    <th>End Point</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${routes}" var="r">
                    <tr>
                        <td>${r.routeId}</td>
                        <td><strong>${r.routeName}</strong></td>
                        <td>${r.startPoint}</td>
                        <td>${r.endPoint}</td>
                        <td>
                            <a href="RouteServlet?action=edit&id=${r.routeId}" class="btn btn-primary btn-sm"><i class="fas fa-edit"></i></a>
                            <a href="RouteServlet?action=delete&id=${r.routeId}" class="btn btn-danger btn-sm delete-confirm"><i class="fas fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty routes}">
                    <tr><td colspan="5" class="text-center" style="padding: 30px;">No routes found.</td></tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>