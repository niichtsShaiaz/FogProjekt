    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.MaterialMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ezl
 */
public class BillOfMaterial {
    List<Material> materialList = new ArrayList<Material>();
    
    List<Material> woodList = new ArrayList<Material>();
    List<Material> roofList = new ArrayList<Material>();
    
    HashMap<String, Material> materialHmapDB = new HashMap<String, Material>();
    public HashMap<String, Material> getHmap(){return materialHmapDB;}
    
    public BillOfMaterial() throws FogProjectException
    {
        materialHmapDB = MaterialMapper.getAllMaterials();
    }
    
    public void createBillOfMaterial(double width, double height, double length, boolean roof, boolean shed, double shedLength)
    {
        materialList.add(pools(height, length));
        materialList.add(beams(width, height, length));
        if(roof){
            int angle = 20;
            materialList.add(roofSpær(width, length, angle));
            materialList.add(roofLægter(width, length));
            materialList.add(roofSten(width, length, angle));
            materialList.add(roofRygSten(length));
        }
        if(shed){}
    }
    
    public void createBillOfMaterialv2(double width, double height, double length, boolean roof, boolean shed, double shedLength)
    {
        
    }
    
    
    public Material stolper(double height, double length)
    {
        int i = 4;
        i += (length - 80 - 30) / 275;
        materialHmapDB.get("stolpe").setLength(height + 90);
        materialHmapDB.get("stolpe").setComment("Stolper nedgraves 90 cm. i jord + skråstiver");
        materialHmapDB.get("stolpe").setQty(i);
        materialHmapDB.get("stolpe").setQty(0);
        return materialHmapDB.get("stolpe");
    }
    
    public Material carportRemme(double length)
    {
        materialHmapDB.get("spærtræ").setLength(length + 80);
        materialHmapDB.get("spærtræ").setComment("Remme i sider, sadles ned i stolper Carport del");
        materialHmapDB.get("spærtræ").setQty(2);
        materialHmapDB.get("spærtræ").setPrice(0);
        return materialHmapDB.get("spærtræ");
    }
    
    //skur
    public Material skurRemme(double shedLength)
    {
        materialHmapDB.get("spærtræ").setLength(shedLength + 80);
        materialHmapDB.get("spærtræ").setComment("Remme i sider, sadles ned i stolper Skur del");
        materialHmapDB.get("spærtræ").setQty(2);
        materialHmapDB.get("spærtræ").setPrice(0);
        return materialHmapDB.get("spærtræ");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private Material pools(double height, double length)
    {
        int i = 4;
        i += (length - 80 - 30) / 275;
        materialHmapDB.get("stolpe").setLength(height + 90);
        materialHmapDB.get("stolpe").setQty(i);
        return materialHmapDB.get("stolpe");
        
    }
    
    //remme
    private Material beams(double width, double height, double length)
    {
        return new Material("spærtræ ubh.", "Remme i sider, sadles ned i stolper", 04.5, 1.95, length + 80 + 30, 2, 50, "Stk");
    }
    
    public List<Material> getBillOfMaterialList()
    {
        return materialList;
    }
    
    private double Sinus(double sideA, double vinkelB)
    {
        double vinkelC = 90;
        double vinkelA = 180 - 90 - vinkelB;
        return (sideA * Math.sin(vinkelC)) / (Math.sin(vinkelA));
    }
    
    private Material roofSpær(double width, double length, double angle){
        double SinusLength = Sinus(width/2, angle);
        int spærQty = (int) (length / 89);
        double angleLeft = SinusLength % 89;
        return new Material("Spær", "Wood", 10, SinusLength, 10, spærQty*2, 15, "Stk");
    }
    //30.7     89
    private Material roofLægter(double width, double length){
        int lægterQty = (int) (width / 30.7);
        double lengthLeft = length % 30.7;
        return new Material("Lægter", "Wood", 10, length, 10, lægterQty*2, 15, "Stk");
    }
    private Material roofSten(double width, double length, double angle){
        double SinusLength = Sinus(width/2, angle);
        int spærQty = (int) (SinusLength / 30.7);
        int tagStensBrede = 30;
        int tagStenQty = (int) ((length / tagStensBrede) * (spærQty) + 6);
        return new Material("Tagsten", "Sten", tagStensBrede, 5, 35, tagStenQty*2, 15, "Stk");
    }
    private Material roofRygSten(double length){
        int rygTagStensLængde = 40;
        int rygTagStensQty = (int) (length / rygTagStensLængde);
        return new Material("Rygsten", "Sten", 20, 5, rygTagStensLængde, rygTagStensQty, 15, "Stk");
    }
    
    public static void main(String[] args) throws FogProjectException
    {
        BillOfMaterial billOfMaterial = new BillOfMaterial();
        HashMap<String, Material> hmap = billOfMaterial.getHmap();
        System.out.println("---- start ----");
        for(String name: hmap.keySet())
        {
            System.out.println("Material: " + hmap.get(name).toString());
        }
        System.out.println("---- end ----");
        
    }
}

