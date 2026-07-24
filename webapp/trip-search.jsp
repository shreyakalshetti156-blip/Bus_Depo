<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="includes/header.jsp" %>

<div class="container">
    <h2><i class="fas fa-search"></i> Search Trips</h2>

    <form action="TripSearchServlet" method="get" class="card">
        <div class="form-row">
            <div class="form-group">
                <label><i class="fas fa-map-marker-alt"></i> From</label>
                <input type="text" name="from" placeholder="Starting point" required>
            </div>
            <div class="form-group">
                <label><i class="fas fa-map-marker-alt"></i> To</label>
                <input type="text" name="to" placeholder="Destination" required>
            </div>
        </div>
        <div class="form-group">
            <label><i class="fas fa-calendar"></i> Date</label>
            <input type="date" name="date" required>
        </div>
        <button type="submit" class="btn btn-primary btn-lg"><i class="fas fa-search"></i> Search</button>
    </form>

    <c:if test="${not empty trips}">
        <h3>Available Trips</h3>
        <table>
            <thead>
                <tr>
                    <th>Route</th>
                    <th>Bus</th>
                    <th>Departure</th>
                    <th>Available Seats</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${trips}" var="t">
                    <tr>
                        <td><strong>${t.routeName}</strong><br><small>${t.startPoint} → ${t.endPoint}</small></td>
                        <td>${t.busNumber}</td>
                        <td>${t.departureTime}</td>
                        <td><span class="badge ${t.availableSeats > 10 ? 'badge-success' : t.availableSeats > 0 ? 'badge-warning' : 'badge-danger'}">${t.availableSeats}</span></td>
                        <td>$${t.ticketPrice}</td>
                        <td><a href="BookingServlet?tripId=${t.tripId}" class="btn btn-primary btn-sm"><i class="fas fa-ticket-alt"></i> Book</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty trips and param.from != null}">
        <div class="alert alert-warning"><i class="fas fa-exclamation-triangle"></i> No trips found. Please try different search criteria.</div>
    </c:if>
</div>

<%@ include file="includes/footer.jsp" %>