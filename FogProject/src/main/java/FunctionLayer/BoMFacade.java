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
public class BoMFacade {
    public static void createOrder(Order order) throws FogProjectException
    {
        OrderMapper.CreateOrder(order);
        
    }
    
    public static List<Order> getAllOrders() throws FogProjectException
    {
        return OrderMapper.getAllOrders();
    }
    
}
