<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Assignments</title>
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
            <h2><i class="fas fa-tasks"></i> Manage Assignments</h2>
            <!-- ✅ FIXED: Goes through servlet -->
            <a href="AssignmentServlet?action=add" class="btn btn-success"><i class="fas fa-plus"></i> New Assignment</a>
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
                    <th>Driver</th>
                    <th>Bus</th>
                    <th>Route</th>
                    <th>Date</th>
                    <th>Shift</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${assignments}" var="a">
                    <tr>
                        <td>${a.assignmentId}</td>
                        <td>${a.driverName}</td>
                        <td>${a.busNumber}</td>
                        <td>${a.routeName}</td>
                        <td>${a.assignmentDate}</td>
                        <td>
                            <span class="badge ${a.shift == 'Morning' ? 'badge-primary' : a.shift == 'Evening' ? 'badge-warning' : 'badge-secondary'}">
                                ${a.shift}
                            </span>
                        </td>
                        <td>
                            <a href="AssignmentServlet?action=edit&id=${a.assignmentId}" class="btn btn-primary btn-sm"><i class="fas fa-edit"></i></a>
                            <a href="AssignmentServlet?action=delete&id=${a.assignmentId}" class="btn btn-danger btn-sm delete-confirm"><i class="fas fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty assignments}">
                    <tr><td colspan="7" class="text-center" style="padding: 30px;">No assignments found.</td></tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
