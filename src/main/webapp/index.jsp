<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="controller.servlets.facebook.FbConnection" %>
<%@ page import="controller.servlets.vk.VkConnection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>АИПОС, лаб. р. №6</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" href="http://anijs.github.io/lib/anicollection/anicollection.css">
</head>
<body data-anijs="if: mouseover, do: rubberBand animated, to: img" style="background: #000; text-align: center; margin: 0 auto; ">

<div  style="margin: 0 auto; background-image: url(./img/fbloginbckgrnd.jpg); height: 360px; width: 610px;">
    <a href="<%=FbConnection.getAuthUrl()%>">
        <img data-anijs="if: click, do: bounceOut animated, to: div" style="margin-top: 138px;" src="img/fbloginbutton.png"/>
    </a>
</div>
<div  style="margin: 0 auto; background-image: url(./img/vkloginbckgrnd.jpg); height: 360px; width: 610px;">
    <a href="<%=VkConnection.getAuthUrl()%>">
        <img data-anijs="if: click, do: rotateOut animated, to: div" style="margin-top: 138px;" src="img/vkloginbutton.png"/>
    </a>
</div>
<script src="anijs/anijs-min.js"></script>
</body>
</html>