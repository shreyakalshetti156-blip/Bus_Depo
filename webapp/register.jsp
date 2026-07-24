<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>

<div class="container" style="max-width: 500px; margin: 50px auto;">
    <h2><i class="fas fa-user-plus"></i> Register</h2>

    <% if (request.getAttribute("errorMsg") != null) { %>
        <div class="alert alert-danger"><i class="fas fa-exclamation-circle"></i> <%= request.getAttribute("errorMsg") %></div>
    <% } %>

    <form action="RegisterServlet" method="post" id="registerForm">
        <div class="form-group">
            <label><i class="fas fa-user"></i> Full Name</label>
            <input type="text" name="fullName" placeholder="Enter your full name" required>
        </div>
        <div class="form-group">
            <label><i class="fas fa-envelope"></i> Email</label>
            <input type="email" name="email" placeholder="Enter your email" required>
        </div>
        <div class="form-group">
            <label><i class="fas fa-phone"></i> Phone</label>
            <input type="tel" name="phone" id="phone" placeholder="Enter your phone number" required>
        </div>
        <div class="form-group">
            <label><i class="fas fa-lock"></i> Password</label>
            <input type="password" name="password" id="password" placeholder="Min 6 characters" required minlength="6">
        </div>
        <div class="form-group">
            <label><i class="fas fa-check-circle"></i> Confirm Password</label>
            <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Re-enter password" required>
        </div>
        <button type="submit" class="btn btn-success btn-lg" style="width: 100%;"><i class="fas fa-user-plus"></i> Register</button>
    </form>

    <div class="text-center mt-3">
        <p>Already have an account? <a href="login.jsp" style="color: #3498db; font-weight: 600;">Login here</a></p>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>