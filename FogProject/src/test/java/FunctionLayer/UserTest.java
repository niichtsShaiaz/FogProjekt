/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

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
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRole method, of class User.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        User instance = new User(1, "test@test.dk", "firstnametest", "lastnametest", "testnumber", "testvejen 7", "testrole");
        String expResult = "testrole";
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrderList method, of class User.
     */
    @Test
    public void testSetOrderList() {
        System.out.println("setOrderList");
        List<Order> orderList = null;
        User instance = new User(1, "test@test.dk", "firstnametest", "lastnametest", "testnumber", "testvejen 7", "testrole");
        instance.setOrderList(orderList);
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = new User(1, "test@test.dk", "firstnametest", "lastnametest", "testnumber", "testvejen 7", "testrole");
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User(1, "test@test.dk", "firstnametest", "lastnametest", "testnumber", "testvejen 7", "testrole");
        String expResult = "test@test.dk";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User(1, "test@test.dk", "firstnametest", "lastnametest", "testnumber", "testvejen 7", "testrole");
        String expResult = "firstnametest";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        User instance = new User(1, "test@test.dk", "firstnametest", "lastnametest", "testnumber", "testvejen 7", "testrole");
        String expResult = "lastnametest";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelephone method, of class User.
     */
    @Test
    public void testGetTelephone() {
        System.out.println("getTelephone");
        User instance = new User(1, "test@test.dk", "firstnametest", "lastnametest", "testnumber", "testvejen 7", "testrole");
        String expResult = "testnumber";
        String result = instance.getTelephone();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class User.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        User instance = new User(1, "test@test.dk", "firstnametest", "lastnametest", "testnumber", "testvejen 7", "testrole");
        String expResult = "testvejen 7";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }



    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User(1, "test@test.dk", "firstnametest", "lastnametest", "testnumber", "testvejen 7", "testrole");
        String expResult = "User{id=1, email=test@test.dk, firstName=firstnametest, lastName=lastnametest, telephone=testnumber, address=testvejen 7}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
