/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ezl
 */
public class BillOfMaterialTest
{
//    
//    public BillOfMaterialTest()
//    {
//    }
//
//    @Test
//    public void testGetHmap() throws FogProjectException
//    {
//        System.out.println("getHmap");
//        BillOfMaterial instance = new BillOfMaterial();
//        HashMap<String, Material> expResult = null;
//        HashMap<String, Material> result = instance.getHmap();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testCreateBillOfMaterial()
//    {
//        System.out.println("createBillOfMaterial");
//        double width = 0.0;
//        double height = 0.0;
//        double length = 0.0;
//        boolean roof = false;
//        boolean shed = false;
//        double shedLength = 0.0;
//        BillOfMaterial instance = new BillOfMaterial();
//        instance.createBillOfMaterial(width, height, length, roof, shed, shedLength);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testCreateBillOfMaterialv2()
//    {
//        System.out.println("createBillOfMaterialv2");
//        double width = 0.0;
//        double height = 0.0;
//        double length = 0.0;
//        boolean roof = false;
//        boolean shed = false;
//        double shedLength = 0.0;
//        BillOfMaterial instance = new BillOfMaterial();
//        instance.createBillOfMaterialv2(width, height, length, roof, shed, shedLength);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    @Test
    public void testStolper() throws FogProjectException
    {
        System.out.println("stolper");
        double height = 600.0;
        double length = 780.0;
        boolean shed = false;
        BillOfMaterial instance = new BillOfMaterial();
        int exp = 4;
        if(shed)
            exp += 7;
        else
            exp += 2;
        
        Material result = instance.stolper(height, length, shed);
        assertEquals(exp, result.getQty());
        // TODO review the generated test code and remove the default call to fail.
    }

//    @Test
//    public void testCarportRemme()
//    {
//        System.out.println("carportRemme");
//        double length = 0.0;
//        BillOfMaterial instance = new BillOfMaterial();
//        Material expResult = null;
//        Material result = instance.carportRemme(length);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testSkurRemme()
//    {
//        System.out.println("skurRemme");
//        double shedLength = 0.0;
//        BillOfMaterial instance = new BillOfMaterial();
//        Material expResult = null;
//        Material result = instance.skurRemme(shedLength);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetBillOfMaterialList()
//    {
//        System.out.println("getBillOfMaterialList");
//        BillOfMaterial instance = new BillOfMaterial();
//        List<Material> expResult = null;
//        List<Material> result = instance.getBillOfMaterialList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testMain() throws Exception
//    {
//        System.out.println("main");
//        String[] args = null;
//        BillOfMaterial.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
