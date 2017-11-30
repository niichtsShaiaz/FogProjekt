/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogProjectException;
import FunctionLayer.Order;
import FunctionLayer.OrderFacade;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jmb
 */
public class UserOrdersCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogProjectException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        List<Order> list = OrderFacade.getUserOrders(user);
        session.setAttribute("userOrdersList", list);
        return "UserOrders";
    }
    
}
