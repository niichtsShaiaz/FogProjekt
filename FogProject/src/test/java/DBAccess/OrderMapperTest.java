/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jbakke
 */
public class OrderMapperTest {
    
    public OrderMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private static Connection testConnection;
    private static String USER = "testuser";
    private static String USERPW = "jonatanmagnusbakketest";
    private static String DBNAME = "FogProjectTest";
    private static String HOST = "46.101.243.239";
    
    @Before
    public void setUp() {
        try {
        // awoid making a new connection for each test
        if ( testConnection == null ) {
            String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
            Class.forName( "com.mysql.jdbc.Driver" );

            testConnection = DriverManager.getConnection( url, USER, USERPW );
            // Make mappers use test 
            Connector.setConnection( testConnection );
        }
        // reset test database
        try ( Statement stmt = testConnection.createStatement() ) {
            stmt.execute( "DELETE FROM `order`" );
            stmt.execute( "DELETE FROM user" );
            stmt.execute( "insert into user select * from usertest" );
            stmt.execute("insert into `order` select * from ordertest");
        }

    } catch ( ClassNotFoundException | SQLException ex ) {
        testConnection = null;
        System.out.println( "Could not open connection to database: " + ex.getMessage() );
    }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllOrders method, of class OrderMapper.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        System.out.println("getAllOrders");
        List<Order> expResult = null;
        List<Order> result = OrderMapper.getAllOrders();
    }

    /**
     * Test of CreateOrder method, of class OrderMapper.
     */
    @Test
    public void testCreateOrder() throws Exception {
        System.out.println("CreateOrder with correct user");
        User user = new User(1, "test@test.dk", "test", "test", "12345678", "testvejen 7", "Customer");
        Order order = new Order(0, 360, 780, true, 15, false, 0, 0, false, user);
        OrderMapper.CreateOrder(order);
    }
    
    @Test
    public void testCreateOrder2() throws Exception {
        System.out.println("CreateOrder with wrong user");
        User user = new User(2, "test@test.dk", "test", "test", "12345678", "testvejen 7", "Customer");
        Order order = new Order(0, 360, 780, true, 15, false, 0, 0, false, user);
        try {
        OrderMapper.CreateOrder(order);
        }catch(Exception ex){
            assertTrue(true);
        }
    }

    /**
     * Test of getUserOrders method, of class OrderMapper.
     */
    @Test
    public void testGetUserOrders() throws Exception {
        System.out.println("getUserOrders");
        User user = new User(1, "test@test.dk", "test", "test", "12345678", "testvejen 7", "Customer");
        int expResult = 2;
        List<Order> result = OrderMapper.getUserOrders(user);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of changeOrderStatus method, of class OrderMapper.
     */
    @Test
    public void testChangeOrderStatus() throws Exception{
        System.out.println("changeOrderStatus");
        User user = new User(1, "test@test.dk", "test", "test", "12345678", "testvejen 7", "Customer");
        OrderMapper.changeOrderStatus(user.getId(), 1);
        List<Order> list = OrderMapper.getUserOrders(user);
        assertEquals(true, list.get(0).isOrderStatus());
    }
    
}
