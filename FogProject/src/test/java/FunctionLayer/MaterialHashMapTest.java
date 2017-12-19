/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shxnna
 */
public class MaterialHashMapTest {
    
    public MaterialHashMapTest() {
    }

    /**
     * Test of getHmap method, of class MaterialHashMap.
     */
    @Test
    public void testGetHmap() throws FogProjectException {
        System.out.println("getHmap");
        
        String key = "brædt25x150";
        MaterialHashMap instance = new MaterialHashMap();
        System.out.println(instance.getMap().size());
        String expResult = "brædt25x150";
        Material result = instance.getHmap(key);
        assertEquals(expResult, result.getName());
    }
    
    @Test
    public void testGetHmap2() throws FogProjectException {
        System.out.println("getHmap");
        
        String key = "stolpe";
        MaterialHashMap instance = new MaterialHashMap();
        System.out.println(instance.getMap().size());
        String expResult = "stolpe";
        Material result = instance.getHmap(key);
        assertEquals(expResult, result.getName());
    }
    
    @Test
    public void testGetHmap3() throws FogProjectException {
        System.out.println("getHmap");
        
        String key = "taglægte";
        MaterialHashMap instance = new MaterialHashMap();
        System.out.println(instance.getMap().size());
        String expResult = "taglægte";
        Material result = instance.getHmap(key);
        assertEquals(expResult, result.getName());
    }
    
    @Test
    public void testGetHmap4() throws FogProjectException {
        System.out.println("getHmap");
        
        String key = "bræt";
        MaterialHashMap instance = new MaterialHashMap();
        System.out.println(instance.getMap().size());
        String expResult = "bræt";
        
        try {
            Material result = instance.getHmap(key);
            assertEquals(expResult, result.getName());
            
        } catch (Exception e) {
            assert(true);
        }
        
    }
    
}
