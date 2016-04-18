<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%=request.getAttribute("type")%> <%=request.getParameter("name")%>
    </title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="answer">
    <p><span>Пользователь:</span> <%=request.getAttribute("type")%> <%=request.getParameter("name")%>
    </p>
    <p><span>Залогинен.</span>
    </p>
    <input type="button" value="Вернуться на страницу авторизации" onclick="(function(){window.location='/'})()"/>
</div>
</body>
</html>
