/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogProjectException;
import FunctionLayer.OrderFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ezl
 */
public class CreateOrderCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogProjectException
    {
        OrderFacade.createOrder((double)request.getAttribute("width"), (double)request.getAttribute("length"), (boolean)request.getAttribute("roof"), (double)request.getAttribute("angel"), (boolean)request.getAttribute("shed"), (double)request.getAttribute("shedWidth"), (double)request.getAttribute("shedLength"));
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
