<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%
    List<Order> ordersList = null;
    if((List<Order>)session.getAttribute("ordersList") != null)
        ordersList = (List<Order>)session.getAttribute("ordersList");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alle ordrer</title>
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
            <h1>Alle ordrer</h1>
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
                            <%for(int i2 = 0; i < ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().size(); i2++){%>
                            <tr>
                                <th><%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i).getWidth()%>x<%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i).getLength()%>cm. <%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i).getType()%></th>
                                <td><%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i).getHight()%></td>
                                <td><%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i).getQty()%></td>
                                <td>Stk</td>
                                <td><%=ordersList.get(i).getBillOfMaterial().getBillOfMaterialList().get(i).getMaterial()%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
            <%}%>

            <!--<div class="order">
                <p class="pBold pCenterAlign toggle">Navn: Elias Laghouila, Email: e.z.l@live.com, Tlf. 3800871, Adr. Trepkasgade 17, Mål: 300x300, tag med regsning: ja, Grader: 30 grader, redskabsskur: ja, Mål: 200x150 </p>
                <div class="styklist">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">First Name</th>
                                <th scope="col">Last Name</th>
                                <th scope="col">Username</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>-->
        </div>
    </body>
</html>