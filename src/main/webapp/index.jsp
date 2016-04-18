<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.servlets.facebook.FbConnection" %>
<%
    FbConnection connection = new FbConnection();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Example</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<center>
    <a href="<%=connection.getFbAuthUrl()%>">
        <div style="margin: 0 auto; background-image: url(img/facebook.png);height: 100px; width: 100px;"></div>
    </a>
</center>
</body>
</html>