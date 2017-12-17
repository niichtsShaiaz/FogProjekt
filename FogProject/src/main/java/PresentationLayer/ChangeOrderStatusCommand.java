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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jbakke
 */
public class ChangeOrderStatusCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogProjectException {
        HttpSession session = request.getSession();
        int changeId = Integer.parseInt(request.getParameter("change"));
        OrderFacade.changeOrderStatus(changeId);
        session.setAttribute("ordersList", OrderFacade.getAllOrders());
        return "AllOrders";
    }
    
}
