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
    /**
     * This method creates an Order object and inserts it into the FogProject order table
     * @param width
     * @param lenght
     * @param roof
     * @param angel
     * @param shed
     * @param shedWidth
     * @param shedLength
     * @param orderStatus
     * @param user
     * @throws FogProjectException 
     */
    public static void createOrder(double width, double lenght, boolean roof, double angel, boolean shed, double shedWidth, double shedLength, boolean orderStatus, User user) throws FogProjectException
    {
        Order order = new Order(0, width, lenght, roof, angel, shed, shedWidth, shedLength, orderStatus, user);
        OrderMapper.createOrder(order);
    }
    /**
     * This method uses the OrderMapper to retrieve all orders in the FogProject order table
     * @return
     * @throws FogProjectException 
     */
    public static List<Order> getAllOrders() throws FogProjectException
    {
        return OrderMapper.getAllOrders();
    }
    /**
     * This method uses the OrderMapper to retrieve the specific users orders from the FogProject order table
     * @param user
     * @return
     * @throws FogProjectException 
     */
    public static List<Order> getUserOrders(User user)throws FogProjectException{
        return OrderMapper.getUserOrders(user);
    }
    /**
     * This method updates the specific order order status to true.
     * The order is found by userId and orderId 
     * @param userId
     * @param orderId 
     */
    public static void changeOrderStatus(int userId, int orderId){
        OrderMapper.changeOrderStatus(userId, orderId);
    }
    
}
