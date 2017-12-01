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
    
    MaterialHashMap materialHMap = null;
    
    public BillOfMaterial()throws FogProjectException
    {
        materialHMap = new MaterialHashMap();
    }
    
    public void createBillOfMaterialv2(double width, double height, double length, boolean roof, boolean shed, double shedLength)
    {
        
    }
    
    
    public Material stolper(double height, double length, boolean shed)
    {
        int i = 4;
        i += (length - 80 - 30) / 275;        
        Material material = materialHMap.getHmap("stolpe");
        material.setLength(height + 90);
        material.setComment("Stolper nedgraves 90 cm. i jord + skråstiver");
        material.setQty(i);
        material.setPrice(0);
        return material;
    }
    
    public Material carportRemme(double length)
    {
        Material material = materialHMap.getHmap("spærtræ");
        material.setLength(length + 80);
        material.setComment("Remme i sider, sadles ned i stolper Carport del");
        material.setQty(2);
        material.setPrice(0);
        return material;
    }
    
    //skur
    public Material skurRemme(double shedLength)
    {
        Material material = materialHMap.getHmap("spærtræ");
        material.setLength(shedLength + 80);
        material.setComment("Remme i sider, sadles ned i stolper Skur del");
        material.setQty(2);
        material.setPrice(0);
        return material;
    }
    
    public Material vindskeder(double shedLength)
    {
        Material material = materialHMap.getHmap("bræt");
        material.setLength(shedLength);
        material.setComment("Vindskeder på rejsning");
        material.setQty(1);
        material.setPrice(0);
        return material;
    }
    
    public Material sternBraedder(double length)
    {
        Material material = materialHMap.getHmap("bræt");
        material.setLength(length);
        material.setComment("Sternbrædder til siderne Carport del");
        material.setQty(1);
        material.setPrice(0);
        return material;
    }
    
    //skur
    public Material sternBraedderSkur(double shedLength)
    {
        Material material = materialHMap.getHmap("bræt");
        material.setLength(shedLength);
        material.setComment("Sternbrædder til siderne Skur del (deles)");
        material.setQty(1);
        material.setPrice(0);
        return material;
    }
    
    public Material bygSelvSpaer()
    {
        Material material = materialHMap.getHmap("byg_selv spær");
        material.setLength(0);
        material.setComment("byg-selv spær (skal samles) 8 stk.");
        material.setQty(1);
        material.setPrice(0);
        return material;
    }
    
    public Material stolper(double length)
    {
        int i = 4;
        i += (length - 80 - 30) / 275;
        
        Material material = materialHMap.getHmap("stolpe");
        material.setLength(300 + 90);
        material.setComment("Stolper nedgraves 90 cm. i jord + skråstiver");
        material.setQty(i);
        material.setPrice(0);
        return material;
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
    
    private Material noRoofSpær(double width, double length){
        int afstandMellemSpær = 55;
        int spærQty = (int) (length / afstandMellemSpær);
        return new Material("45x195mm. spærtræ ubh.", "Spær, monteres på rem", 10, width, 10, spærQty, 15, "Stk");
    }
    
    private Material noRoofTag(double width, double length){
        int plastmoEcoliteLængde = 0;
        int plastmoEcoliteBrede = 0;
        int antalL = (int) (length / plastmoEcoliteLængde);
        int antalB = (int) (width / plastmoEcoliteBrede);
        int qty = antalL * antalB;
        return new Material("Plastmo Ecolite", "tagplader monteres på spær", 0, 0, plastmoEcoliteLængde, qty, 15.0, "stk");
    }
    
    public static void main(String[] args) throws FogProjectException
    {
        BillOfMaterial bom = new BillOfMaterial();
        //System.out.println(bom.carportRemme(500));
        //System.out.println(bom.carportRemme(200));
    }
}

