/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogProjectException;
import FunctionLayer.OrderFacade;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ezl
 */
public class CreateOrderCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogProjectException
    {   
        boolean roof = false;
        boolean shed = false;
        if(request.getParameter("roof") != null)
            roof = true;
        if(request.getParameter("shed") != null)
            shed = true;
        HttpSession session = request.getSession();
        OrderFacade.createOrder(Double.parseDouble(request.getParameter("width")), Double.parseDouble(request.getParameter("length")), roof, Double.parseDouble(request.getParameter("angel")), shed, Double.parseDouble(request.getParameter("shedWidth")), Double.parseDouble(request.getParameter("shedLength")), (User)session.getAttribute("User"));
        return "ConfirmationPage";
    }
    
}
