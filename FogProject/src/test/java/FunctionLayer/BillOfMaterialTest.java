/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class BillOfMaterialTest {
    
    public BillOfMaterialTest() {
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
     * Test of getBillOfMaterialList method, of class BillOfMaterial.
     */
    @Test
    public void testGetBillOfMaterialList() {
        try {
            System.out.println("getBillOfMaterialList");
            BillOfMaterial instance = new BillOfMaterial();
            List<Material> result = instance.getBillOfMaterialList();
            assertTrue(result != null);
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of createBillOfMaterialv2 method, of class BillOfMaterial.
     */
    @Test
    public void testCreateBillOfMaterialv2() {
        try {
            System.out.println("createBillOfMaterialv2");
            double width = 360;
            double height = 300;
            double length = 730;
            boolean roof = false;
            double angel = 0;
            boolean shed = false;
            double shedLength = 0.0;
            BillOfMaterial instance = new BillOfMaterial();
            instance.createBillOfMaterialv2(width, height, length, roof, angel, shed, shedLength);
            // TODO review the generated test code and remove the default call to fail.
            assertTrue(instance.getBillOfMaterialList().size() > 0);
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }
    
    @Test
    public void testCreateBillOfMaterialv22() {
        try {
            System.out.println("createBillOfMaterialv2 med skur");
            double width = 360;
            double height = 300;
            double length = 730;
            boolean roof = false;
            double angel = 0;
            boolean shed = true;
            double shedLength = 0.0;
            BillOfMaterial instance = new BillOfMaterial();
            instance.createBillOfMaterialv2(width, height, length, roof, angel, shed, shedLength);
            // TODO review the generated test code and remove the default call to fail.
            assertTrue(instance.getBillOfMaterialList().size() > 0);
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of vindskeder method, of class BillOfMaterial.
     */
    @Test
    public void testVindskeder() {
        try {
            System.out.println("vindskeder");
            double length = 360;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 1;
            Material result = instance.vindskeder(length);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of sternBraedder method, of class BillOfMaterial.
     */
    @Test
    public void testSternBraedder() {
        try {
            System.out.println("sternBraedder");
            double length = 0.0;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 0;
            Material result = instance.sternBraedder(length);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of sternBraedderSkur method, of class BillOfMaterial.
     */
    @Test
    public void testSternBraedderSkur() {
        try {
            System.out.println("sternBraedderSkur");
            double shedLength = 400;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 1;
            Material result = instance.sternBraedderSkur(shedLength);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
           assertTrue(false);
        }
    }

    /**
     * Test of bygSelvSpaer method, of class BillOfMaterial.
     */
    @Test
    public void testBygSelvSpaer() {
        try {
            System.out.println("bygSelvSpaer");
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 1;
            Material result = instance.bygSelvSpaer();
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of stolper method, of class BillOfMaterial.
     */
    @Test
    public void testStolper() {
        try {
            System.out.println("stolper");
            double length = 760;
            boolean shed = false;
            double shedLength = 0.0;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 6;
            Material result = instance.stolper(length, shed, shedLength);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of carportRemme method, of class BillOfMaterial.
     */
    @Test
    public void testCarportRemme() {
        try {
            System.out.println("carportRemme");
            double length = 760;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 2;
            Material result = instance.carportRemme(length);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
           assertTrue(false);
        }
    }

    /**
     * Test of skurRemme method, of class BillOfMaterial.
     */
    @Test
    public void testSkurRemme() {
        try {
            System.out.println("skurRemme");
            double shedLength = 300;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 1;
            Material result = instance.skurRemme(shedLength);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of reglarLøsholteISiderneAfSkuret method, of class BillOfMaterial.
     */
    @Test
    public void testReglarLøsholteISiderneAfSkuret() {
        try {
            System.out.println("reglarL\u00f8sholteISiderneAfSkuret");
            double shedLength = 300;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 4;
            Material result = instance.reglarLøsholteISiderneAfSkuret(shedLength);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of reglarLøsholteIGavleAfSkuret method, of class BillOfMaterial.
     */
    @Test
    public void testReglarLøsholteIGavleAfSkuret() {
        try {
            System.out.println("reglarL\u00f8sholteIGavleAfSkuret");
            double shedLength = 300;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 6;
            Material result = instance.reglarLøsholteIGavleAfSkuret(shedLength);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of vandBrætVindskeder method, of class BillOfMaterial.
     */
    @Test
    public void testVandBrætVindskeder() {
        try {
            System.out.println("vandBr\u00e6tVindskeder");
            double length = 0.0;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 0;
            Material result = instance.vandBrætVindskeder(length);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of brætBeklædningAfGavle1Og2 method, of class BillOfMaterial.
     */
    @Test
    public void testBrætBeklædningAfGavle1Og2() {
        try {
            System.out.println("br\u00e6tBekl\u00e6dningAfGavle1Og2");
            double length = 0.0;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 0;
            Material result = instance.brætBeklædningAfGavle1Og2(length);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
           assertTrue(false);
        }
    }

    /**
     * Test of brætBeklædningAfSkur1Og2 method, of class BillOfMaterial.
     */
    @Test
    public void testBrætBeklædningAfSkur1Og2() {
        try {
            System.out.println("br\u00e6tBekl\u00e6dningAfSkur1Og2");
            double shedLength = 300;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 148;
            Material result = instance.brætBeklædningAfSkur1Og2(shedLength);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of brætTilMonteringAfTagfodslægte method, of class BillOfMaterial.
     */
    @Test
    public void testBrætTilMonteringAfTagfodslægte() {
        try {
            System.out.println("br\u00e6tTilMonteringAfTagfodsl\u00e6gte");
            double length = 300;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 0;
            Material result = instance.brætTilMonteringAfTagfodslægte(length);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of taglægteBagsidenAfDøren method, of class BillOfMaterial.
     */
    @Test
    public void testTaglægteBagsidenAfDøren() {
        try {
            System.out.println("tagl\u00e6gteBagsidenAfD\u00f8ren");
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 0;
            Material result = instance.taglægteBagsidenAfDøren();
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of taglægteMonteringPåSpær method, of class BillOfMaterial.
     */
    @Test
    public void testTaglægteMonteringPåSpær() {
        try {
            System.out.println("tagl\u00e6gteMonteringP\u00e5Sp\u00e6r");
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 0;
            Material result = instance.taglægteMonteringPåSpær();
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of topLægteTilMonteringAfRygsten method, of class BillOfMaterial.
     */
    @Test
    public void testTopLægteTilMonteringAfRygsten() {
        try {
            System.out.println("topL\u00e6gteTilMonteringAfRygsten");
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 0;
            Material result = instance.topLægteTilMonteringAfRygsten();
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of main method, of class BillOfMaterial.
     */
//    @Test
//    public void testMain() throws Exception {
//        System.out.println("main");
//        String[] args = null;
//        BillOfMaterial.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of roofSpær method, of class BillOfMaterial.
     */
    @Test
    public void testRoofSpær() {
        try {
            System.out.println("roofSp\u00e6r");
            double width = 600;
            double length = 780;
            double angle = 15;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 18;
            Material result = instance.roofSpær(width, length, angle);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
           assertTrue(false);
        }
    }

    /**
     * Test of roofLægter method, of class BillOfMaterial.
     */
    @Test
    public void testRoofLægter() {
        try {
            System.out.println("roofL\u00e6gter");
            double width = 360;
            double length = 730;
             BillOfMaterial instance = new BillOfMaterial();
            int expResult = 12;
            Material result = instance.roofLægter(width, length);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of roofSten method, of class BillOfMaterial.
     */
    @Test
    public void testRoofSten() {
        try {
            System.out.println("roofSten");
            double width = 360;
            double length = 730;
            double angle = 15;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 352;
            Material result = instance.roofSten(width, length, angle);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of roofRygSten method, of class BillOfMaterial.
     */
    @Test
    public void testRoofRygSten() {
        try {
            System.out.println("roofRygSten");
            double length = 730;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 21;
            Material result = instance.roofRygSten(length);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of noRoofSpær method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofSpær() {
        try {
            System.out.println("noRoofSp\u00e6r");
            double width = 600;
            double length = 780;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 15;
            Material result = instance.noRoofSpær(width, length);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of noRoofTag method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofTag() {
        try {
            System.out.println("noRoofTag");
            double width = 600;
            double length = 780;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 1;
            Material result = instance.noRoofTag(width, length);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of noRoofTagSkruer method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofTagSkruer() {
        try {
            System.out.println("noRoofTagSkruer");
            double width = 600;
            double length = 780;
             BillOfMaterial instance = new BillOfMaterial();
            int expResult = 7;
            Material result = instance.noRoofTagSkruer(width, length);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of noRoofHulbånd method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofHulbånd() {
        try {
            System.out.println("noRoofHulb\u00e5nd");
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 2;
            Material result = instance.Hulbånd();
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of noRoofBeslagTilRemHøjre method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofBeslagTilRemHøjre() {
        try {
            System.out.println("noRoofBeslagTilRemH\u00f8jre");
            double width = 600;
            double length = 780;
            boolean roof = true;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 15;
            Material result = instance.beslagTilRemHøjre(width, length, roof);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of noRoofBeslagTilRemVenstre method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofBeslagTilRemVenstre() {
        try {
            System.out.println("noRoofBeslagTilRemVenstre");
            double width = 600;
            double length = 780;
            boolean roof = true;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 15;
            Material result = instance.beslagTilRemVenstre(width, length, roof);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
           assertTrue(false);
        }
    }

    /**
     * Test of noRoofSternOgVandbrædtSkruer method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofSternOgVandbrædtSkruer() {
        try {
            System.out.println("noRoofSternOgVandbr\u00e6dtSkruer");
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 1;
            Material result = instance.sternOgVandbrædtSkruer();
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of noRoofUniversalbeslagHulbåndSkruer method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofUniversalbeslagHulbåndSkruer() {
        try {
            System.out.println("noRoofUniversalbeslagHulb\u00e5ndSkruer");
            BillOfMaterial instance = new BillOfMaterial();
            boolean roof = true;
            int expResult = 1;
            Material result = instance.universalbeslagHulbåndSkruer(roof);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of noRoofBræddeBolte method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofBræddeBolte() {
        try {
            System.out.println("noRoofBr\u00e6ddeBolte");
            double length = 780;
            boolean shed = false;
            double shedLength = 0;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 18;
            Material result = instance.bræddeBolte(length, shed, shedLength);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of noRoofFirkantSkiver method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofFirkantSkiver() {
        try {
            System.out.println("noRoofFirkantSkiver");
            double length = 780;
            boolean shed = false;
            double shedlength = 0;
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 12;
            Material result = instance.firkantSkiver(length, shed, shedlength);
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
           assertTrue(false);
        }
    }

    /**
     * Test of noRoofYdersteBeklædningSkruer method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofYdersteBeklædningSkruer() {
        try {
            System.out.println("noRoofYdersteBekl\u00e6dningSkruer");
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 2;
            Material result = instance.ydersteBeklædningSkruer();
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }

    /**
     * Test of noRoofIndersteBeklædningSkruer method, of class BillOfMaterial.
     */
    @Test
    public void testNoRoofIndersteBeklædningSkruer() {
        try {
            System.out.println("noRoofIndersteBekl\u00e6dningSkruer");
            BillOfMaterial instance = new BillOfMaterial();
            int expResult = 2;
            Material result = instance.indersteBeklædningSkruer();
            assertEquals(expResult, result.getQty());
        } catch (FogProjectException ex) {
            assertTrue(false);
        }
    }
    
}
