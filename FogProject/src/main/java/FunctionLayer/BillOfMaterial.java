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
    
    
    public Material stolper(double length, boolean shed, double shedLength)
    {
        int i = 4;
        if(shed)
        {
            i += ((length - shedLength - 275 - 80 - 30) / 275) * 2;
            i += 7;
        }
        else
            i += ((length - 275 - 80 - 30) / 275) * 2;
        
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
    
    // ********************************** Beslag of Skruer ****************************************************
    
    //Skruer til tagplader
    private Material noRoofTagSkruer(double width, double length){
        double arealm2 = (width * length) / 100;
        int skruerPerM2 = 12;
        double skruer50stkPris = 62.5;
        int antalSkruer = (int) (arealm2 * skruerPerM2);
        double totalPrisSkruer = (antalSkruer / 50) * skruer50stkPris;
        return new Material("Plastmo bundskruer 50 stk.", "Skruer til tagplader", 0, 0, 0, skruerPerM2, totalPrisSkruer, "Pakke");
    }
    
    //Til vindkryds på spær
    private Material Hulbånd(){
        double rullePris = 250;
        int qty = 2;
        return new Material("Hulbånd 1x20mm 10 mtr.", "Til vindkryds på spær", 0, 0, 0, qty, rullePris*qty, "Rulle");
    }
    
    //Til montering af spær på rem højre
    private Material beslagTilRemHøjre(double width, double length, boolean roof){
        int afstandMellemSpær;
        if(roof)
            afstandMellemSpær = 55;
        else
            afstandMellemSpær = 89;
            
        int spærQty = (int) (length / afstandMellemSpær);
        int beslagPrisStk = 35;
        return new Material("Universal 190mm højre", "Til montering af spær på rem", 0, 0, 0, spærQty, beslagPrisStk, "Stk");
    }
    
    //Til montering af spær på rem venstre
    private Material beslagTilRemVenstre(double width, double length, boolean roof){
        int afstandMellemSpær;
        if(roof)
            afstandMellemSpær = 55;
        else
            afstandMellemSpær = 89;
        
        int spærQty = (int) (length / afstandMellemSpær);
        int beslagPrisStk = 35;
        return new Material("Universal 190mm venstre", "Til montering af spær på rem", 0, 0, 0, spærQty, beslagPrisStk, "Stk");
    }
    
    //Til montering af stern&vandbrædt
    private Material sternOgVandbrædtSkruer(){
        int pris250stk = 150;
        int qty = 1;
        return new Material("4,5 x 60 mm Skruer 250 stk", "Til montering af stern&vandbrædt", 0, 0, 0, qty, pris250stk*qty, "Pakke");
    }
    
    //Til montering af universalbeslag + hulbånd
    private Material universalbeslagHulbåndSkruer(boolean roof){
        int pris250stk = 100;
        int qty = 1;
        if(roof)
            return new Material("4,0 x 50 mm. beslagskruer 250 stk.", "Til montering af universalbeslag + hulbånd", 0, 0, 0, qty, pris250stk*qty, "Pakke");
        else
            return new Material("5,0 x 40 mm. beslagskruer 250 stk.", "Til montering af universalbeslag + hulbånd", 0, 0, 0, qty, pris250stk*qty, "Pakke");
        
    }
    
    //Til montering af rem på stolper
    private Material bræddeBolte(double length, boolean shed, double shedLength){
        int boltePerStople = 3;
        int prisPerBolt = 5;
        int antalStopler = 4;
        if(shed)
        {
            antalStopler += ((length - shedLength - 275 - 80 - 30) / 275) * 2;
            antalStopler += 7;
        }
        else
            antalStopler += ((length - 275 - 80 - 30) / 275) * 2;
        
        int qtyBolte = boltePerStople * antalStopler;
        int totalPris = qtyBolte * prisPerBolt;
        return new Material("Bræddebolt 10 x 120 mm.", "Til montering af rem på stolper", 0, 0, 0, qtyBolte, totalPris, "stk");
    }
    
    //Til montering af rem på stolper
    private Material firkantSkiver(double length, boolean shed, double shedLength){
        int firkantSkivePris = 12;
        int firkantSkiverPerStople = 2;
        int antalStopler = 4;
        if(shed)
        {
            antalStopler += ((length - shedLength - 275 - 80 - 30) / 275) * 2;
            antalStopler += 7;
        }
        else
            antalStopler += ((length - 275 - 80 - 30) / 275) * 2;
        
        int qtyFirkantSkiver = antalStopler * firkantSkiverPerStople;
        int totalPris = qtyFirkantSkiver * firkantSkivePris;
        return new Material("firkantskiver 40x40x11 mm", "Til montering af rem på stopler", 0, 0, 0, qtyFirkantSkiver, totalPris, "stk");
    }
    
    //Til montering af yderste beklædning
    private Material ydersteBeklædningSkruer(){
        int prisPer400stk = 600;
        int qty = 2;
        return new Material("4,5 x 70 mm. Skruer 400 stk.", "Til montering af yderste beklædning", 0, 0, 0, qty, prisPer400stk*qty, "Pakke");
    }
    
    //Til montering af inderste beklædning
    private Material indersteBeklædningSkruer(){
        int prisPer300stk = 400;
        int qty = 2;
          return new Material("4,5 x 50 mm. Skruer 300 stk.", "Til montering af inderste beklædning", 0, 0, 0, qty, prisPer300stk*qty, "Pakke");
    }
    
    private Material staldDørsGreb(){
        int qty = 1;
        int pris = 90;
        return new Material("Stalddørsgreb 50x75", "Til dør i skur", 0, 0, 0, qty, pris, "Sæt");
    }
    
    private Material tHængsel(){
        int qty = 2;
        int pris = 70;
        return new Material("T-hængsel 390 mm.", "Til dør i skur", 0, 0, 0, qty, pris, "Stk");
    }
}

