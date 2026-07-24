<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ include file="includes/header.jsp" %>

<div class="container" style="text-align:center; padding: 60px 20px; max-width: 600px;">
    <div style="font-size: 64px; margin-bottom: 20px;">⚠️</div>
    <h2>Something Went Wrong</h2>
    <p>We're sorry, but an unexpected error occurred.</p>

    <div style="background: #f8f9fa; padding: 15px; border-radius: 8px; text-align: left; margin: 20px 0; overflow-x: auto;">
        <h4 style="color: #dc3545;">Error Details:</h4>
        <pre style="font-size: 12px; color: #333; white-space: pre-wrap; word-wrap: break-word;">
            <%= exception != null ? exception.toString() : "No exception details available. Check Tomcat logs." %>
        </pre>
        <%
            if (exception != null) {
                out.println("<hr/><b>Stack Trace:</b><br/>");
                for (StackTraceElement ste : exception.getStackTrace()) {
                    out.println(ste.toString() + "<br/>");
                }
            }
        %>
    </div>

    <div class="d-flex justify-center">
        <a href="login.jsp" class="btn btn-primary"><i class="fas fa-home"></i> Go to Login</a>
        <a href="javascript:history.back()" class="btn btn-secondary"><i class="fas fa-arrow-left"></i> Go Back</a>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>