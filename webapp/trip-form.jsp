<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${trip == null ? 'Schedule' : 'Edit'} Trip</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>

<jsp:include page="includes/admin-header.jsp"/>

<div class="admin-container">
    <jsp:include page="includes/admin-sidebar.jsp"/>
    <div class="main-content">
        <h2><i class="fas ${trip == null ? 'fa-plus' : 'fa-edit'}"></i> ${trip == null ? 'Schedule' : 'Edit'} Trip</h2>

        <form action="TripServlet" method="post" class="card" style="max-width: 600px;">
            <input type="hidden" name="tripId" value="${trip.tripId}">

            <div class="form-group">
                <label><i class="fas fa-route"></i> Route <span class="required">*</span></label>
                <select name="routeId" required>
                    <option value="">Select Route</option>
                    <c:forEach items="${routes}" var="r">
                        <option value="${r.routeId}" ${r.routeId == trip.routeId ? 'selected' : ''}>${r.routeName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label><i class="fas fa-bus"></i> Bus <span class="required">*</span></label>
                <select name="busId" required>
                    <option value="">Select Bus</option>
                    <c:forEach items="${buses}" var="b">
                        <option value="${b.busId}" ${b.busId == trip.busId ? 'selected' : ''}>${b.busNumber}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label><i class="fas fa-user-tie"></i> Driver <span class="required">*</span></label>
                <select name="driverId" required>
                    <option value="">Select Driver</option>
                    <c:forEach items="${drivers}" var="d">
                        <option value="${d.driverId}" ${d.driverId == trip.driverId ? 'selected' : ''}>${d.driverName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label><i class="fas fa-calendar"></i> Trip Date <span class="required">*</span></label>
                <input type="date" name="tripDate" value="${trip.tripDate}" required>
            </div>

            <div class="form-group">
                <label><i class="fas fa-clock"></i> Departure Time <span class="required">*</span></label>
                <input type="time" name="departureTime" value="${trip.departureTime}" required>
            </div>

            <div class="form-group">
                <label><i class="fas fa-clock"></i> Arrival Time (optional)</label>
                <input type="time" name="arrivalTime" value="${trip.arrivalTime}">
            </div>

            <div class="form-group">
                <label><i class="fas fa-chair"></i> Total Seats <span class="required">*</span></label>
                <input type="number" name="totalSeats" value="${trip.totalSeats}" min="10" max="100" required>
            </div>

            <div class="form-group">
                <label><i class="fas fa-money-bill-wave"></i> Ticket Price <span class="required">*</span></label>
                <input type="number" step="0.01" name="ticketPrice" value="${trip.ticketPrice}" required>
            </div>

            <div class="d-flex">
                <button type="submit" class="btn btn-success"><i class="fas fa-save"></i> Save</button>
                <a href="TripServlet" class="btn btn-danger"><i class="fas fa-times"></i> Cancel</a>
            </div>
        </form>

        <script>
            // Set minimum date to today
            document.addEventListener('DOMContentLoaded', function() {
                var dateInput = document.querySelector('input[name="tripDate"]');
                if (dateInput) {
                    var today = new Date();
                    var y = today.getFullYear();
                    var m = String(today.getMonth()+1).padStart(2,'0');
                    var d = String(today.getDate()).padStart(2,'0');
                    dateInput.min = y + '-' + m + '-' + d;
                }
            });
        </script>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>