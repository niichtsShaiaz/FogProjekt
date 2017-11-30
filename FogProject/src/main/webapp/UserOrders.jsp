<%-- 
    Document   : UserOrders
    Created on : 30-Nov-2017, 09:34:38
    Author     : jmb
--%>
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%
    List<Order> userOrdersList = null;
    if((List<Order>)session.getAttribute("userOrderList") != null)
        userOrdersList = (List<Order>)session.getAttribute("userOrderList");
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
            <h1>User Orders</h1>
            <%for(int i = 0; i < userOrdersList.size(); i++){%>
            <div class="order">
                <p class="pBold pCenterAlign toggle">Navn: <%=userOrdersList.get(i).getUser().getFirstName()%> <%=userOrdersList.get(i).getUser().getLastName()%>, Email: <%=userOrdersList.get(i).getUser().getEmail()%>, Tlf. <%=userOrdersList.get(i).getUser().getTelephone()%>, Addr. <%=userOrdersList.get(i).getUser().getAddress()%>, Mål: <%=userOrdersList.get(i).getWidth()%>x<%=userOrdersList.get(i).getLength()%>, <%if(userOrdersList.get(i).getRoof()){%>taghældning: <%=userOrdersList.get(i).getAngel()%> grader <%}%>, <%if(userOrdersList.get(i).getShed()){%>redskabsskur mål: <%=userOrdersList.get(i).getShedWidth()%>x<%=userOrdersList.get(i).getShedLength()%><%}%></p>
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
                            <%for(int i2 = 0; i2 < userOrdersList.get(i).getBillOfMaterial().getBillOfMaterialList().size(); i2++){%>
                            <tr>
                                <th><%=userOrdersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getWidth()%>x<%=userOrdersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getLength()%>cm. <%=userOrdersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getType()%></th>
                                <td><%=userOrdersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getHight()%></td>
                                <td><%=userOrdersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getQty()%></td>
                                <td>Stk</td>
                                <td><%=userOrdersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i2).getMaterial()%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
            <%}%>
    </body>
</html>
