/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Material;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
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
public class MaterialMapperTest {
    
    public MaterialMapperTest() {
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
            stmt.execute( "drop table if exists material" );
            stmt.execute( "create table material like materialtest" );
            stmt.execute( "insert into material select * from materialtest" );
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
     * Test of getAllMaterials method, of class MaterialMapper.
     */
    @Test
    public void testGetAllMaterials() throws Exception {
        System.out.println("getAllMaterials");
        int expResult= 17;
        HashMap<String, Material> result = MaterialMapper.getAllMaterials();
        assertEquals(expResult, result.size());
    }
    
}
