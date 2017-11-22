<%--
Document   : Login
Created on : 21-11-2017, 20:58:31
Author     : ezl
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="includes/menu.jsp" />
            <h1>Login</h1>
            <form action="" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email</label>
                    <input type="email" class="form-control">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" placeholder="********">
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
    </body>
</html>