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
    <p><span>Запрос:</span> <%=request.getAttribute("type")%> <%=request.getParameter("name")%>
    </p>
    <p><span>Ответ на запрос:</span> <%=request.getAttribute("answer")%>
    </p>
    <input type="button" value="Вернуться на страницу запросов" onclick="(function(){window.location='/index.jsp'})()"/>
</div>
</body>
</html>
