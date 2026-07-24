<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${bus == null ? 'Add' : 'Edit'} Bus</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>

<jsp:include page="includes/admin-header.jsp"/>
<div class="admin-container">
    <jsp:include page="includes/admin-sidebar.jsp"/>
    <div class="main-content">
        <h2><i class="fas ${bus == null ? 'fa-plus' : 'fa-edit'}"></i> ${bus == null ? 'Add' : 'Edit'} Bus</h2>
        <form action="BusServlet" method="post" class="card" style="max-width: 500px;">
            <input type="hidden" name="busId" value="${bus.busId}">
            <div class="form-group">
                <label><i class="fas fa-hashtag"></i> Bus Number</label>
                <input type="text" name="busNumber" value="${bus.busNumber}" required>
            </div>
            <div class="form-group">
                <label><i class="fas fa-tag"></i> Bus Type</label>
                <select name="busType" required>
                    <option value="AC" ${bus.busType == 'AC' ? 'selected' : ''}>AC</option>
                    <option value="Non-AC" ${bus.busType == 'Non-AC' ? 'selected' : ''}>Non-AC</option>
                    <option value="Sleeper" ${bus.busType == 'Sleeper' ? 'selected' : ''}>Sleeper</option>
                    <option value="Premium" ${bus.busType == 'Premium' ? 'selected' : ''}>Premium</option>
                </select>
            </div>
            <div class="form-group">
                <label><i class="fas fa-chair"></i> Capacity</label>
                <input type="number" name="capacity" value="${bus.capacity}" min="10" max="100" required>
            </div>
            <div class="form-group">
                <label><i class="fas fa-warehouse"></i> Depot</label>
                <select name="depotId" required>
                    <option value="">Select Depot</option>
                    <c:forEach items="${depots}" var="d">
                        <option value="${d.depotId}" ${d.depotId == bus.depotId ? 'selected' : ''}>${d.depotName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="d-flex">
                <button type="submit" class="btn btn-success"><i class="fas fa-save"></i> Save</button>
                <a href="BusServlet" class="btn btn-danger"><i class="fas fa-times"></i> Cancel</a>
            </div>
        </form>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>