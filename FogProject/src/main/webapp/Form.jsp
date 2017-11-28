<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/styling.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="wrapper">
    <jsp:include page="includes/menu.jsp" />
    <h1> Velkommen! Indtast dine mål</h1>
    <p class="pCenterAlign">Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.</p>
    <p class="pCenterAlign">Tilbud og skitsetegning fremsendes med post hurtigst muligt.</p>
    <p class="pCenterAlign">Ved bestilling medfølger standardbyggevejledning.</p>
    <p class="pCenterAlign">Udfyld nedenstående omhyggeligt og klik på "Bestil tilbud"</p>
    <p class="pCenterAlign">Alle mål er i centimeter</p>

    <form action="FrontController" method="post">
        <input type="hidden" name="command" value="Carport">
        <div class="form-group">
            <label>Højde</label>
            <select name="height">
                <option value="0">0</option>
            </select>
        </div>

        <div class="form-group">
            <label>Bredde</label>
            <select name="width">
            <%for(int i = 240; i < 750; i += 30){%>
                <option value="<%=i%>"><%=i%></option>
            <%}%>
            </select>
        </div>

        <div class="form-group">
            <label>Længde</label>
            <select name="length">
            <%for(int i = 240; i < 750; i += 30){%>
                <option value="<%=i%>"><%=i%></option>
            <%}%>
            </select>
        </div>

        <div class="form-group">
            <label>Tag med hældning?</label>
            <input type="checkbox" name="roof" class="form-control" value="1">
        </div>
    
        <div class="form-group">
            <label>Taghældning</label>
            <select name="angel">
                <option value="0">Ønsker ikke tag med hældning</option>
            <%for(int i = 15; i < 45; i += 5){%>
                <option value="<%=i%>"><%=i%></option>
            <%}%>
            </select>
        </div>

        <p class="pBold">Redskabsrum:</p>
        <p class="">NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet*</p>

        <div class="form-group">
            <label>Redskabsrum?</label>
            <input type="checkbox" name="shed" class="form-control" value="1">
        </div>

        <div class="form-group">
            <label>Redskabsrum bredde</label>
            <select name="shedWidth">
                <option value="0">Ønsker ikke redskabsrum</option>
            <%for(int i = 210; i < 720; i += 30){%>
                <option value="<%=i%>"><%=i%></option>
            <%}%>
            </select>
        </div>

        <div class="form-group">
            <label>Redskabsrum længde</label>
            <select name="shedLength">
                <option value="0">Ønsker ikke redskabsrum</option>
            <%for(int i = 210; i < 720; i += 30){%>
                <option value="<%=i%>"><%=i%></option>
            <%}%>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Bestil Tilbud</button>
    </form>
</div>
    </body>
</html>