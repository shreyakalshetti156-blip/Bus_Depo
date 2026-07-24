<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${driver == null ? 'Add' : 'Edit'} Driver</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>

<jsp:include page="includes/admin-header.jsp"/>

<div class="admin-container">
    <jsp:include page="includes/admin-sidebar.jsp"/>
    <div class="main-content">
        <h2><i class="fas ${driver == null ? 'fa-plus' : 'fa-edit'}"></i> ${driver == null ? 'Add' : 'Edit'} Driver</h2>

        <form action="DriverServlet" method="post" class="card" style="max-width: 500px;">
            <input type="hidden" name="driverId" value="${driver.driverId}">

            <div class="form-group">
                <label><i class="fas fa-user"></i> Driver Name <span class="required">*</span></label>
                <input type="text" name="driverName" value="${driver.driverName}" required>
            </div>

            <div class="form-group">
                <label><i class="fas fa-id-card"></i> License Number <span class="required">*</span></label>
                <input type="text" name="licenseNumber" value="${driver.licenseNumber}" required>
            </div>

            <div class="form-group">
                <label><i class="fas fa-phone"></i> Phone <span class="required">*</span></label>
                <input type="tel" name="phone" value="${driver.phone}" required>
            </div>

            <div class="form-group">
                <label><i class="fas fa-warehouse"></i> Depot <span class="required">*</span></label>
                <select name="depotId" required>
                    <option value="">Select Depot</option>
                    <c:forEach items="${depots}" var="d">
                        <option value="${d.depotId}" ${d.depotId == driver.depotId ? 'selected' : ''}>${d.depotName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="d-flex">
                <button type="submit" class="btn btn-success"><i class="fas fa-save"></i> Save</button>
                <a href="DriverServlet" class="btn btn-danger"><i class="fas fa-times"></i> Cancel</a>
            </div>
        </form>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>