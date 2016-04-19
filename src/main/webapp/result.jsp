<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>result</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="answer">
    <p><span>Результат:</span>
        <%=request.getParameter("facebookId")%>
        <%=request.getParameter("firstName")%>
        <%=request.getParameter("middleNames")%>
        <%=request.getParameter("lastName")%>
        <%=request.getParameter("email")%>
    </p>
    <p><span>Залогинен.</span>
    </p>
    <input type="button" value="Вернуться на страницу авторизации" onclick="(function(){window.location='/'})()"/>
</div>

</body>
</html>
