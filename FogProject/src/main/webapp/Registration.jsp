<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%
    List<String> errorMsgList;
    if (session.getAttribute("errorMsgList") != null)
    {
        errorMsgList = (List<String>) session.getAttribute("errorMsgList");
    } else
    {
        errorMsgList = new ArrayList<>();
    }
%>
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
        <title>Registrering</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="includes/menu.jsp" />
            <h1>Registration</h1>
            <form action="FrontController" method="post">
                <input type="hidden" name="command" value="Register">
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
                    <input type="text" class="form-control" name="addresse">
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
                    <label>Gentag Password</label>
                    <input type="password" class="form-control" name="password2" placeholder="********">
                </div>
                <%for (int i = 0; i < errorMsgList.size(); i++)
                    {%>
                <p class="errormsg"><%=errorMsgList.get(i)%></p>
                <%}%>
                <button type="submit" class="btn btn-primary">Registrer</button>
            </form>
        </div>
    </body>
</html>