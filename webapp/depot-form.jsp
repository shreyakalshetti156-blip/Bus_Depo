<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${depot == null ? 'Add' : 'Edit'} Depot</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>

<jsp:include page="includes/admin-header.jsp"/>

<div class="admin-container">
    <jsp:include page="includes/admin-sidebar.jsp"/>
    <div class="main-content">
        <h2><i class="fas ${depot == null ? 'fa-plus' : 'fa-edit'}"></i> ${depot == null ? 'Add' : 'Edit'} Depot</h2>

        <form action="DepotServlet" method="post" class="card" style="max-width: 500px;">
            <input type="hidden" name="depotId" value="${depot.depotId}">
            <div class="form-group">
                <label><i class="fas fa-building"></i> Depot Name</label>
                <input type="text" name="depotName" value="${depot.depotName}" required>
            </div>
            <div class="form-group">
                <label><i class="fas fa-map-marker-alt"></i> Location</label>
                <input type="text" name="location" value="${depot.location}" required>
            </div>
            <div class="d-flex">
                <button type="submit" class="btn btn-success"><i class="fas fa-save"></i> Save</button>
                <a href="DepotServlet" class="btn btn-danger"><i class="fas fa-times"></i> Cancel</a>
            </div>
        </form>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>