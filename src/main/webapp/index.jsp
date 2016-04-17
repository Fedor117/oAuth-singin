<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC  "-//W3C//DTD HTML 4.01 Transitional//EN" "www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="JSP-Servlets - aipos lab5" name="twitter:description">
    <meta name="description" content="JSP-Servlets - aipos lab5">
    <title>
        АИПОС, лабораторная работа №5
    </title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="tabbed">
    <input name="tabbed" id="tabbed1" type="radio" checked>
    <section>
        <h1>
            <label for="tabbed1">Create</label>
        </h1>
        <div>
            <p><h3>Введите определение</h3>
            <input type="text" name="name" />
            <p><h3>Введите описание</h3>
            <input type="text" name="description" />
            <p>
                <input type="submit" name="Submit" value="Создать новую запись" />
            </p>
        </div>
    </section>
    <input name="tabbed" id="tabbed2" type="radio">
    <section>
        <h1>
            <label for="tabbed2">Read</label>
        </h1>
        <div>
            <p><h3>Введите определение</h3>
            <input type="text" name="name" />
            <p>
                <input type="submit" name="Submit" value="Получить описание" />
            </p>
        </div>
    </section>
    <input name="tabbed" id="tabbed3" type="radio">
    <section>
        <h1>
            <label for="tabbed3">Update</label>
        </h1>
        <div>
            <p><h3>Введите определение</h3>
            <input type="text" name="name" />
            <p><h3>Введите описание</h3>
            <input type="text" name="description" />
            <p>
                <input type="submit" name="Submit" value="Обновить запись" />
            </p>
        </div>
    </section>
    <input name="tabbed" id="tabbed4" type="radio">
    <section>
        <h1>
            <label for="tabbed4">Delete</label>
        </h1>
        <div>
            <p>
            <h3>Введите определение</h3>
            <input type="text" name="name" />
            <p>
                <input type="submit" name="Submit" value="Удалить запись" />
            </p>
        </div>
    </section>
</div>
</body>
</html>
