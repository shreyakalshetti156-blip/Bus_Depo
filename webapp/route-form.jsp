<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${route == null ? 'Add' : 'Edit'} Route</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>

<jsp:include page="includes/admin-header.jsp"/>

<div class="admin-container">
    <jsp:include page="includes/admin-sidebar.jsp"/>
    <div class="main-content">
        <h2><i class="fas ${route == null ? 'fa-plus' : 'fa-edit'}"></i> ${route == null ? 'Add' : 'Edit'} Route</h2>

        <form action="RouteServlet" method="post" class="card" style="max-width: 500px;">
            <input type="hidden" name="routeId" value="${route.routeId}">

            <div class="form-group">
                <label><i class="fas fa-tag"></i> Route Name <span class="required">*</span></label>
                <input type="text" name="routeName" value="${route.routeName}" required>
            </div>

            <div class="form-group">
                <label><i class="fas fa-map-marker-alt"></i> Start Point <span class="required">*</span></label>
                <input type="text" name="startPoint" value="${route.startPoint}" required>
            </div>

            <div class="form-group">
                <label><i class="fas fa-map-marker-alt"></i> End Point <span class="required">*</span></label>
                <input type="text" name="endPoint" value="${route.endPoint}" required>
            </div>

            <div class="d-flex">
                <button type="submit" class="btn btn-success"><i class="fas fa-save"></i> Save</button>
                <a href="RouteServlet" class="btn btn-danger"><i class="fas fa-times"></i> Cancel</a>
            </div>
        </form>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>