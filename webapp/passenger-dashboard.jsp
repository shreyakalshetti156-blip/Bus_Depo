<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Passenger Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>
    <jsp:include page="includes/header.jsp" />
    <div class="container" style="max-width: 1000px; margin: 30px auto;">
        <h2><i class="fas fa-search"></i> Search Available Buses & Routes</h2>
        <p>Select a date and a route to see which bus and driver are assigned.</p>

        <!-- Display error messages -->
        <c:if test="${not empty errorMsg}">
            <div class="alert alert-danger"><i class="fas fa-exclamation-circle"></i> ${errorMsg}</div>
        </c:if>

        <!-- Search Form -->
        <form action="SearchServlet" method="get" class="card">
            <div class="form-row">
                <div class="form-group">
                    <label><i class="fas fa-calendar-alt"></i> Date <span class="required">*</span></label>
                    <input type="date" name="searchDate" value="${param.searchDate}" required>
                </div>
                <div class="form-group">
                    <label><i class="fas fa-route"></i> Route <span class="required">*</span></label>
                    <select name="routeId" required>
                        <option value="">-- Select Route --</option>
                        <c:forEach items="${routes}" var="r">
                            <option value="${r.routeId}" ${r.routeId == selectedRouteId ? 'selected' : ''}>${r.routeName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label><i class="fas fa-bus"></i> Bus Number (optional)</label>
                    <input type="text" name="busNumber" placeholder="e.g. B-101" value="${busFilter}">
                </div>
            </div>
            <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i> Search</button>
        </form>

        <!-- Results -->
        <c:if test="${not empty searchDate}">
            <h3 style="margin-top: 25px;">Results for ${searchDate}</h3>
            <c:if test="${empty assignments}">
                <div class="alert alert-info">No buses match your criteria on this date and route.</div>
            </c:if>
            <c:if test="${not empty assignments}">
                <table>
                    <thead>
                        <tr>
                            <th>Bus Number</th>
                            <th>Route Name</th>
                            <th>Driver</th>
                            <th>Shift</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${assignments}" var="a">
                            <tr>
                                <td><strong>${a.busNumber}</strong></td>
                                <td>${a.routeName}</td>
                                <td>${a.driverName}</td>
                                <td><span class="badge ${a.shift == 'Morning' ? 'badge-primary' : a.shift == 'Evening' ? 'badge-warning' : 'badge-secondary'}">${a.shift}</span></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </c:if>

        <div style="margin-top: 30px;">
            <a href="LogoutServlet" class="btn btn-danger"><i class="fas fa-sign-out-alt"></i> Logout</a>
        </div>
    </div>
    <jsp:include page="includes/footer.jsp" />
</body>
</html>