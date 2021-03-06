/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.BillOfMaterial;
import FunctionLayer.FogProjectException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shxnna
 */
public class OrderMapper {
    
    /**
     * This method retrieves all the orders from the order table in the FogProject database. 
     * @return
     * @throws FogProjectException 
     */
    public static List<Order> getAllOrders() throws FogProjectException
    {
        try
        {
            List<Order> orders = new ArrayList<>();
            Connection con = Connector.connection();
            Statement stm = con.createStatement();
            String sql = "SELECT order_id, order_length, order_width, order_roof, order_angel, order_shed, order_shedwidth, order_shedlength, fk_user_id, order_status, user.id, user.email, user.firstname, user.lastname, user.telephone, user.address, user.role FROM `order` INNER JOIN user on fk_user_id = user.id ORDER BY order_id DESC";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                User user = 
                        new User(
                                rs.getInt("id"), 
                                rs.getString("email"), 
                                rs.getString("firstname"), 
                                rs.getString("lastname"), 
                                rs.getString("telephone"), 
                                rs.getString("address"),
                                rs.getString("role")
                            );
                orders.add(
                        new Order(
                                rs.getInt("order_id"),
                                rs.getDouble("order_width"), 
                                rs.getDouble("order_length"), 
                                rs.getBoolean("order_roof"), rs.getDouble("order_angel"), 
                                rs.getBoolean("order_shed"), rs.getDouble("order_shedwidth"), 
                                rs.getDouble("order_shedlength"), rs.getBoolean("order_status"), 
                                user
                            )
                        );
            }
            return orders;
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new FogProjectException( ex.getMessage() );
        }
    }
    
    /**
     * This method inserts a new order into the order table in the FogProject database.
     * The order id in the order given will not be used since the value is auto-incremented in the table
     * @param order
     * @throws FogProjectException 
     */
    public static void createOrder(Order order)throws FogProjectException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `order` SET order_length = ?, order_width = ?, order_roof = ?, order_angel = ?, order_shed = ?, order_shedwidth = ?, order_shedlength = ?, fk_user_id = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setDouble(1, order.getLength());
            ps.setDouble(2, order.getWidth());
            ps.setBoolean(3, order.getRoof());
            ps.setDouble(4, order.getAngel());
            ps.setBoolean(5, order.getShed());
            ps.setDouble(6, order.getShedWidth());
            ps.setDouble(7, order.getShedLength());
            ps.setInt(8, order.getUser().getId());
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new FogProjectException( ex.getMessage() );
        }
        
    }
    
    /**
     * This method retrieves all the orders for a specific user from the order table.
     * @param user
     * @return
     * @throws FogProjectException 
     */
    public static List<Order> getUserOrders(User user)throws FogProjectException{
        List<Order> orderList = new ArrayList();
        Statement stm;
        try {
            stm = Connector.connection().createStatement();
            String sql = "SELECT order_id, order_length, order_width, order_roof, order_angel, order_shed, order_shedwidth, order_shedlength, order_status, fk_user_id FROM `order` WHERE fk_user_id = "+ user.getId()+ ";";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                orderList.add(new Order(
                                rs.getInt("order_id"),
                                rs.getDouble("order_width"), 
                                rs.getDouble("order_length"), 
                                rs.getBoolean("order_roof"), rs.getDouble("order_angel"), 
                                rs.getBoolean("order_shed"), rs.getDouble("order_shedwidth"), 
                                rs.getDouble("order_shedlength"), rs.getBoolean("order_status"), 
                                user
                            ));
            }
            return orderList;
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new FogProjectException(ex.getMessage());
        }
    }
    
    /**
     * This method is used to change the order status of an order in the order table.
     * It uses the userId and orderId til determine which order status to change.
     * @param userId
     * @param orderId 
     */
    public static void changeOrderStatus(int userId, int orderId){
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE `order` SET order_status = true WHERE fk_user_id = ? AND order_id = ?;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, userId);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
