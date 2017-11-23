/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.OrderMapper;
import java.util.List;

/**
 *
 * @author Shxnna
 */
public class OrderFacade {
    public static void createOrder(double width, double lenght, boolean roof, double angel, boolean shed, double shedWidth, double shedLength) throws FogProjectException
    {
        User user = null;//skal slettes når login og session virker
        Order order = new Order(0, width, lenght, roof, angel, shed, shedWidth, shedLength, user);
        OrderMapper.CreateOrder(order);
        
    }
    
    public static List<Order> getAllOrders() throws FogProjectException
    {
        return OrderMapper.getAllOrders();
    }
    
}
