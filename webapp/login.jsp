<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<div class="container" style="max-width: 500px; margin: 50px auto;">
    <h2><i class="fas fa-sign-in-alt"></i> Bus Depot Login</h2>

    <% if (request.getParameter("registered") != null) { %>
        <div class="alert alert-success"><i class="fas fa-check-circle"></i> Registration successful! Please login.</div>
    <% } %>

    <% if (request.getAttribute("errorMsg") != null) { %>
        <div class="alert alert-danger"><i class="fas fa-exclamation-circle"></i> <%= request.getAttribute("errorMsg") %></div>
    <% } %>

    <form action="LoginServlet" method="post">
        <div class="form-group">
            <label><i class="fas fa-envelope"></i> Email</label>
            <input type="email" name="email" placeholder="Enter your email" required>
        </div>
        <div class="form-group">
            <label><i class="fas fa-lock"></i> Password</label>
            <input type="password" name="password" placeholder="Enter your password" required>
        </div>
        <button type="submit" class="btn btn-primary btn-lg" style="width: 100%;"><i class="fas fa-sign-in-alt"></i> Login</button>
    </form>

    <div class="text-center mt-3">
        <p>Don't have an account? <a href="register.jsp" style="color: #3498db; font-weight: 600;">Register here</a></p>
    </div>

    <div class="card mt-4" style="background: #f0f4ff; border: 1px solid #d1ecf1;">
        <p style="margin: 0; font-size: 13px; color: #555;"><strong>Demo Credentials:</strong></p>
        <p style="margin: 0; font-size: 13px; color: #555;">Admin: admin@busdepot.com / admin123</p>
        <p style="margin: 0; font-size: 13px; color: #555;">Customer: john@example.com / pass123</p>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>