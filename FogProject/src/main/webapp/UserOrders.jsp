<%-- 
    Document   : UserOrders
    Created on : 30-Nov-2017, 09:34:38
    Author     : jmb
--%>
<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%
    List<Order> ordersList = null;
    if(session.getAttribute("User") != null){
        User user = (User)session.getAttribute("User");
        ordersList = user.getOrderList();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Orders</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="js/main.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="includes/menu.jsp" />
            <h1>Mine ordrer</h1>
            <%for(int i = 0; i < ordersList.size(); i++){%>
            <div class="order">
                <p class="pBold pCenterAlign toggle">Navn: <%=ordersList.get(i).getUser().getFirstName()%> <%=ordersList.get(i).getUser().getLastName()%>, Email: <%=ordersList.get(i).getUser().getEmail()%>, Tlf. <%=ordersList.get(i).getUser().getTelephone()%>, Addr. <%=ordersList.get(i).getUser().getAddress()%>, Mål: <%=ordersList.get(i).getWidth()%>x<%=ordersList.get(i).getLength()%>, <%if(ordersList.get(i).getRoof()){%>taghældning: <%=ordersList.get(i).getAngel()%> grader <%}%>, <%if(ordersList.get(i).getShed()){%>redskabsskur mål: <%=ordersList.get(i).getShedWidth()%>x<%=ordersList.get(i).getShedLength()%><%}%></p>
                <div class="styklist">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Materiale</th>
                                <th scope="col">Længde</th>
                                <th scope="col">Antal</th>
                                <th scope="col">Enhed</th>
                                <th scope="col">Beskrivelse</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(int i2 = 0; i2 < ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().size(); i2++){%>
                            <tr>
                                <th><%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getSideA()%> x <%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getLength()%>cm. <%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getName()%></th>
                                <td><%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getSideB()%></td>
                                <td><%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getQty()%></td>
                                <td><%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getEnhed()%></td>
                                <td><%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getComment()%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
            <%}%>
    </body>
</html>
