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

    public List<Material> getBillOfMaterialList()
    {
        return materialList;
    }
    
    public void createBillOfMaterialv2(double width, double height, double length, boolean roof, double angel, boolean shed, double shedLength)
    {
        materialList.add(stolper(length, shed, shedLength));
        if(roof)
        {
            materialList.add(roofSpær(width, length, angel));
            materialList.add(roofLægter(width, length));
            materialList.add(roofSten(width, length, angel));
            materialList.add(roofRygSten(length));
        }
        else
        {
            materialList.add(noRoofSpær(width, length));
            materialList.add(noRoofTag(width, length));
        }
        if(shed)
        {
            
        }
    }
    
    //-+-+
    public Material vindskeder(double length)
    {
        Material material = materialHMap.getHmap("bræt");
        material.setLength(length);
        material.setComment("Vindskeder på rejsning");
        material.setQty(1);
        material.setPrice(0);
        return material;
    }
    
    //-+-+
    public Material sternBraedder(double length)
    {
        Material material = materialHMap.getHmap("bræt");
        material.setLength(length);
        material.setComment("Sternbrædder til siderne Carport del");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }
    
    //skur -+-+
    public Material sternBraedderSkur(double shedLength)
    {
        Material material = materialHMap.getHmap("bræt");
        material.setLength(shedLength);
        material.setComment("Sternbrædder til siderne Skur del ( deles )");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }
    
    //-+-+
    public Material bygSelvSpaer()
    {
        Material material = materialHMap.getHmap("byg_selv spær");
        material.setLength(0);
        material.setComment("byg-selv spær (skal samles) 8 stk.");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }
    
    public Material stolper(double length, boolean shed, double shedLength)
    {
        int i = 4;
        if(shed)
            i += ((length - shedLength - 275 - 80 - 30) / 275) * 2;
        else
            i += 7;
        
        Material material = materialHMap.getHmap("stolpe");
        material.setLength(300 + 90);
        material.setComment("Stolper nedgraves 90 cm. i jord + skråstiver");
        material.setQty(i);
        material.setPrice(0);
        return material;
    }
    
    public Material carportRemme(double length)
    {
        Material material = materialHMap.getHmap("spærtræ");
        material.setLength(length);
        material.setComment("Remme i sider, sadles ned i stolper Carport del");
        material.setQty(2);
        material.setPrice(0);
        return material;
    }
    
    //skur -+-+
    public Material skurRemme(double shedLength)
    {
        Material material = materialHMap.getHmap("spærtræ");
        material.setLength(shedLength);
        material.setComment("Remme i sider, sadles ned i stolper Skur del");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    //skur -+-+
    public Material reglarLøsholteISiderneAfSkuret(double shedLength)
    {
        Material material = materialHMap.getHmap("reglar");
        material.setLength(shedLength + 80);
        material.setComment("Løsholter i siderne af skur");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    //skur -+-+
    public Material reglarLøsholteIGavleAfSkuret(double shedLength)
    {
        Material material = materialHMap.getHmap("reglar");
        material.setLength(shedLength);
        material.setComment("Løsholter i gavle af skur");
        material.setQty(2);
        material.setPrice(0);
        return material;
    }

    //-+-+
    public Material vandBrætVindskeder(double length)
    {
        Material material = materialHMap.getHmap("brædt19x100");
        material.setLength(length);
        material.setComment("Vand bræt på vindskeder");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    //-+-+
    public Material brætBeklædningAfGavle1Og2(double length)
    {
        Material material = materialHMap.getHmap("brædt19x100");
        material.setLength(length);
        material.setComment("beklædning af gavle 1 på 2");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    //skur -+-+
    public Material brætBeklædningAfSkur1Og2(double shedLength)
    {
        Material material = materialHMap.getHmap("brædt19x100");
        material.setLength(shedLength);
        material.setComment("Beklædning af skur 1 på 2");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    //-+-+
    public Material brætTilMonteringAfTagfodslægte(double length)
    {
        Material material = materialHMap.getHmap("brædt25x50");
        material.setLength(length);
        material.setComment("til montering oven på tagfodslægte");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    // -+-+
    public Material taglægteBagsidenAfDøren()
    {
        Material material = materialHMap.getHmap("taglægte");
        material.setLength(0);
        material.setComment("til z på bagside af dør");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    // -+-+
    public Material taglægteMonteringPåSpær()
    {
        Material material = materialHMap.getHmap("taglægte");
        material.setLength(0);
        material.setComment("til montering på spær, 7 rækker lægter på hver skiftevis 1 hel & 1 halv lægte");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    // -+-+
    public Material topLægteTilMonteringAfRygsten()
    {
        Material material = materialHMap.getHmap("taglægte");
        material.setLength(0);
        material.setComment("toplægte til montering af rygsten lægges i toplægte holder");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }    
    
    // tag med rejsning -- start --
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
    // tag med rejsning -- slut --
    
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
    }
}

