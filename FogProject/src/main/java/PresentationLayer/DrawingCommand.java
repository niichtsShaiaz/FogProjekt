/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogProjectException;
import static FunctionLayer.Preview.draw;
import static FunctionLayer.Preview.draw2;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ezl
 */
public class DrawingCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogProjectException
    {
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        boolean shed = false;
        if(request.getParameter("shed") != null)
            shed = true;
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        String str = draw(width, length,shed,shedLength);
        String str2 = draw2(width, length,shed,shedLength);
        request.setAttribute("svgDrawing", str);
        request.setAttribute("svgDrawing2", str2);
        return "Form";
    }
    
}
