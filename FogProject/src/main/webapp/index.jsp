<%-- 
    Document   : index
    Created on : 22-Nov-2017, 00:53:18
    Author     : Shxnna
--%>
<%
    String msg = "";
    if(session.getAttribute("error") != null){
        msg = (String) session.getAttribute("error");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1><%=msg %></h1>
    </body>
</html>
