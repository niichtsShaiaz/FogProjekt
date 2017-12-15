/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogProjectException;
import static FunctionLayer.Preview.draw;
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
        String str = draw(width, length,false,0);
        request.setAttribute("svgDrawing", str);
        return "Form";
    }
    
}
