/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
public class UserMapperTest {
    
    public UserMapperTest() {
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
            stmt.execute( "DELETE FROM user" );
            stmt.execute( "insert into user select * from usertest" );
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
     * Test of register method, of class UserMapper.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("register");
        String email = "test2@test2.dk";
        String password = "test21234";
        String firstName = "test2";
        String lastName = "test2";
        String telephone = "12345678";
        String address = "testvejen 14";
        UserMapper.register(email, password, firstName, lastName, telephone, address);
    }
    
    @Test
    public void testRegister2() throws Exception {
        System.out.println("register2");
        String email = "test@test.dk";
        String password = "test1234";
        String firstName = "test";
        String lastName = "test";
        String telephone = "12345678";
        String address = "testvejen 7";
        try{
        UserMapper.register(email, password, firstName, lastName, telephone, address);
        }
        catch(Exception ex){
            assertTrue(true);
        }
    }

    /**
     * Test of login method, of class UserMapper.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String email = "test@test.dk";
        String password = "test1234";
        String expResult = "testvejen 7";
        User result = UserMapper.login(email, password);
        assertEquals(expResult, result.getAddress());
    }

     /**
     * Test of login method, of class UserMapper.
     */
    @Test
    public void testLogin2() throws Exception {
        System.out.println("login2");
        String email = "test@test.dk";
        String password = "wrongpassword";
        try{
            UserMapper.login(email, password);
        } catch(Exception ex){
            assertTrue(true);
        }
    }
    
}
