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
    public static void createOrder(double width, double lenght, boolean roof, double angel, boolean shed, double shedWidth, double shedLength, User user) throws FogProjectException
    {
        Order order = new Order(0, width, lenght, roof, angel, shed, shedWidth, shedLength, user);
        OrderMapper.CreateOrder(order);
        
    }
    
    public static List<Order> getAllOrders() throws FogProjectException
    {
        return OrderMapper.getAllOrders();
    }
    
    public static List<Order> getUserOrders(User user)throws FogProjectException{
        return OrderMapper.getUserOrders(user);
    }
    
    public static void main(String[] args) throws FogProjectException
    {
        //User user = new User(1,"awdawd", "adwd", "adwd", "adwda", "awdwad", "adwd");
        List<Order> orders = getAllOrders();
        for(int i = 0; i < orders.size(); i++)
            System.out.println("Order: " + orders.get(i).toString());
    }
    
}
