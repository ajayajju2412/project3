<!-- ****************************DONE*********************** -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /*If user tries to click on browser back button then he/ she should not be able to access this page*/
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
	/**
	* TODO: 4.11. If a user is logged in then, redirect the user to the Home.jsp page.
	* (Hint: Make use of the email id stored in the session object)
	*/
%>
<%
String foo=(String)session.getAttribute("sEmailId");
if (null != foo){
%>
<jsp:forward page="/Home.jsp" />
<% } %>


<!--
	TODO: 4.3. Right now we have the structure of the form ready, however it's Sign In and
	Sign Up buttons are not functioning. Add 'method' and 'action' attributes to the form such
	that when the user clicks on the Sign In/ Sign Up button after filling the form data,
	the UserServlet gets invoked based on the URL mapping mentioned in the Deployment Descriptor.
-->
<html>
<head>
    <title>Login / Register</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
</head>
<body>
<div class="form_wrapper">
    <form action="/blog/user" method="post" id="login_form">
        <div id="email_div">
            <label for="emailId">User Email</label>
            <input type="text" placeholder="example@email.com" name="emailId" id="emailId"/>
            <p><span name="error" style="color:red">${messages.emailId}</span><p>
        </div>
        <div id="password_div">
            <label for="password">Password</label>
            <input type="password" placeholder="********" name="password" id="password"/>
            <p><span name="error" style="color:red">${messages.password}</span><p>
        </div>
        <input type="submit" value="Sign In" name="actionType"/>
        <input type="submit" value="Sign Up" name="actionType"/>
        <div class="error">

            <%--    Check if there is any error set in request.--%>
            <!--
            	TODO: 4.12. Write the Java code to display the error message
				present in the request object. These error messages will be
				set inside the UserServlet.
			-->
            <%

            %>
        </div>
    </form>
</div>

</body>
</html>