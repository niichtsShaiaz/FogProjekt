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
        <title>Registration</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="includes/menu.jsp" />
            <h1>Registration</h1>
            <form action="" method="post">
                <div class="form-group">
                    <label>Fornavn</label>
                    <input type="text" class="form-control" name="fornavn">
                </div>
                <div class="form-group">
                    <label>Efternavn</label>
                    <input type="text" class="form-control" name="efternavn">
                </div>
                <div class="form-group">
                    <label>Tlf.</label>
                    <input type="number" class="form-control" name="tlf">
                </div>
                <div class="form-group">
                    <label>Adresse</label>
                    <input type="text" class="form-control" name="adresse">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" class="form-control" name="email">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" name="password" placeholder="********">
                </div>
                <div class="form-group">
                    <label>Re-type Password</label>
                    <input type="password" class="form-control" name="password2" placeholder="********">
                </div>
                <button type="submit" class="btn btn-primary">Registrer</button>
            </form>
        </div>
    </body>
</html>