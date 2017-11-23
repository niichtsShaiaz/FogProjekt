<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <link href="css/styling.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
        <h1> Velkommen! Indtast dine mål</h1>
        <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.</p>
        <p>Tilbud og skitsetegning fremsendes med post hurtigst muligt.</p>
        <p>Ved bestilling medfølger standardbyggevejledning.</p>
        <p>Udfyld nedenstående omhyggeligt og klik på "Bestil tilbud"</p>
        <p>Alle mål er i centimeter</p>

        <form name="Form" action="FrontController" method="POST">
            <input type="hidden" name="command" value="carport">
            
            <p>
                <Label for="height">Højde:</label>
                <select name="height"  id="height">
                    <option value="240">240</option>
                    <option value="270">270</option>
                    <option value="300">300</option>
                </select>
            </p>
            
            <p>
                <Label for="length">Længde:</Label>
                <select name="length"  id="length">
                    <option value="240">240</option>
                    <option value="270">270</option>
                    <option value="300">300</option>
                    <option value="330">330</option>
                    <option value="360">360</option>
                    <option value="390">390</option>
                    <option value="420">420</option>
                    <option value="450">450</option>
                    <option value="480">480</option>
                    <option value="510">510</option>
                    <option value="540">520</option>
                    <option value="570">570</option>
                    <option value="600">600</option>
                    <option value="630">630</option>
                    <option value="660">660</option>
                    <option value="690">690</option>
                    <option value="720">720</option>
                    <option value="750">750</option>
                </select>
            </p>
            
            <p>
                <label for="width" >Bredde:</label>
                <select name="width"  id="width">
                    <option value="240">240</option>
                    <option value="270">270</option>
                    <option value="300">300</option>
                    <option value="330">330</option>
                    <option value="360">360</option>
                    <option value="390">390</option>
                    <option value="420">420</option>
                    <option value="450">450</option>
                    <option value="480">480</option>
                    <option value="510">510</option>
                    <option value="540">520</option>
                    <option value="570">570</option>
                    <option value="600">600</option>
                    <option value="630">630</option>
                    <option value="660">660</option>
                    <option value="690">690</option>
                    <option value="720">720</option>
                    <option value="750">750</option>
                </select>
            </p>
            
            <p>
                
                <Label for="roof">Hældning på tag i grader</Label>
                <input id="roof" type="number" name="roof">
            </p>
            <h1> Redskabsrum</h1>
            <p>
                <label for="shed">Redskabsrum bredde:</label>
                <select name="shedWidth"  id="shedWidth">
                    <option value="noshed">Ønsker ikke redskebsrum</option>
                    <option value="210">210</option>
                    <option value="240">240</option>
                    <option value="270">270</option>
                    <option value="300">300</option>
                    <option value="330">330</option>
                    <option value="360">360</option>
                    <option value="390">390</option>
                    <option value="420">420</option>
                    <option value="450">450</option>
                    <option value="480">480</option>
                    <option value="510">510</option>
                    <option value="540">520</option>
                    <option value="570">570</option>
                    <option value="600">600</option>
                    <option value="630">630</option>
                    <option value="660">660</option>
                    <option value="690">690</option>
                    <option value="720">720</option>
                    
                </select>
            </p>
            <p>
                <label for="shed">Redskabsrum længde</label>
                <select name="shedLength"  id="shedLength">
                    <option value="noshed">Ønsker ikke redskebsrum</option>
                    <option value="210">210</option>
                    <option value="240">240</option>
                    <option value="270">270</option>
                    <option value="300">300</option>
                    <option value="330">330</option>
                    <option value="360">360</option>
                    <option value="390">390</option>
                    <option value="420">420</option>
                    <option value="450">450</option>
                    <option value="480">480</option>
                    <option value="510">510</option>
                    <option value="540">520</option>
                    <option value="570">570</option>
                    <option value="600">600</option>
                    <option value="630">630</option>
                    <option value="660">660</option>
                    <option value="690">690</option>
                    <option value="720">720</option>
                    
                </select>
            </p>
            
            <br>
            <input type="submit" value="Bestil tilbud">
        </form>
    </body>
</html>