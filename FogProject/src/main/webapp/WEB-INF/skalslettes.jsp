<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
        
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
        <link href="..styling.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
            <h1> Welcome! Please input your garage dimensions</h1>
All measurements are in centimeters
                    <form name="Form" action="" method="POST">
                        <input type="hidden" name="command" value="login">
                        
                        <p>
                        <Label for="height">Height:</label>
                        <input id="height" type="number" name="height">
                        </p>
                        
                        <p>
                            <Label for="length">Length:</Label>
                        <input id="length" type="number" name="length">
                        </p>
                        
                        <p>
                        <label for="width" >Width:</label>
                        <select name="width"  id="width">
                            <option value="200">200</option>
                            <option value="230">230</option>
                            <option value="260">260</option>
                            <option value="290">290</option>
                            <option value="320">320</option>
                        </select>
                         </p>
                        
                         <p>
                             <Label for="roof">Roof type:</Label>
                        <select name="roof"  id="roof">
                            <option value="Slanted">Slanted</option>
                            <option value="Flat">Flat</option>
                            <option value="Tall">Tall</option>
                        </select>
                         </p>
                        <br>
                        <input type="submit" value="Submit">
                    </form>
    </body>
</html>
