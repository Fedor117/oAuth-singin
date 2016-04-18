<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<form method="post" action="login.jsp">
    <center>
        <table border="0" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2" align="center">Login Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="uname" value="" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="pass" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <tr>
                <form action="/facebook-login" method="post">
                    <button name="facebook"><img src="img/facebook.png"></button>
                </form>
                <form action="/twitter-login" method="post">
                    <button name="twitter"><img src="img/twitter.png"></button>
                </form>
                <form action="/google-login" method="post">
                    <button name="google"><img src="img/google.png"></button>
                </form>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>