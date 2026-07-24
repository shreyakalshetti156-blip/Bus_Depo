<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="admin-header">
    <h1><i class="fas fa-bus"></i> Bus Depot Admin</h1>
    <div class="admin-info">
        <div class="avatar">
            <%= session.getAttribute("userName") != null ? session.getAttribute("userName").toString().charAt(0) : "A" %>
        </div>
        <div>
            <div class="name"><%= session.getAttribute("userName") != null ? session.getAttribute("userName") : "Admin" %></div>
            <div class="role"><i class="fas fa-shield-alt"></i> Administrator</div>
        </div>
        <a href="LogoutServlet" class="btn btn-danger btn-sm"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </div>
</div>