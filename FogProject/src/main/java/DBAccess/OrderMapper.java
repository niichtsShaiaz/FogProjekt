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

/**
 *
 * @author Shxnna
 */
public class OrderMapper {
    private Connection con;
        
    public static List<Order> getOrders(int id) throws FogProjectException
    {
        List<Order> orders = new ArrayList<>();
        return orders;
    }
    
    public static List<Order> getAllOrders() throws FogProjectException
    {
        try
        {
            List<Order> orders = new ArrayList<>();
            Connection con = Connector.connection();
            Statement stm = con.createStatement();
            String sql = "SELECT order_id, order_length, order_width, order_roof, order_angel, order_shed, order_shedwidth, order_shedlength, fk_user_id, user.id, user.email, user.firstname, user.lastname, user.telephone, user.address FROM `order` INNER JOIN user on fk_user_id = user.id ORDER BY order_id DESC";
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
                                rs.getString("address")
                            );
                orders.add(
                        new Order(
                                rs.getInt("order_id"),
                                rs.getDouble("order_width"), 
                                rs.getDouble("order_length"), 
                                rs.getBoolean("order_roof"), rs.getDouble("order_angel"), 
                                rs.getBoolean("order_shed"), rs.getDouble("order_shedwidth"), 
                                rs.getDouble("order_shedlength"), 
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
    
    
    public static void CreateOrder(Order order)throws FogProjectException {
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
            ps.setInt(8, 2);
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new FogProjectException( ex.getMessage() );
        }
        
    }
}
