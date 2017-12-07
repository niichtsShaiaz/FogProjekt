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
    String email = "";
    if(session.getAttribute("email") != null)
        email = (String)session.getAttribute("email");
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
        <title>Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="includes/menu.jsp" />
            <h1>Login</h1>

            <form action="FrontController" method="post">
                <input type="hidden" name="command" value="Login">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email</label>
                    <input type="email" name="email" value="<%=email%>" class="form-control">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" name="password" class="form-control" placeholder="********">
                </div>
                <%for (int i = 0; i < errorMsgList.size(); i++)
                    {%>
                <p class="errormsg"><%=errorMsgList.get(i)%></p>
                <%}%>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
    </body>
</html>