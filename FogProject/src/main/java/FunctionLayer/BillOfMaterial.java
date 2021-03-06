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
 * This class is used to calculate bill of material for a carport.
 * @author jmb
 */
public class BillOfMaterial {
    List<Material> materialList = new ArrayList<Material>();
    List<Material> woodList = new ArrayList<Material>();
    List<Material> roofList = new ArrayList<Material>();
    
    MaterialHashMap materialHMap = null;
    
    /**
     * Creates a new instance of BillOfMaterial with a MaterialHashMap embedded.
     * @throws FogProjectException 
     */
    public BillOfMaterial()throws FogProjectException
    {
        materialHMap = new MaterialHashMap();
    }

    /**
     * This method returns a material list
     * @return 
     */
    public List<Material> getBillOfMaterialList()
    {
        return materialList;
    }
    
    /**
     * This method fills the material list with all the material determined by the parameters.
     * Must only be called once.
     * @param width
     * @param height
     * @param length
     * @param roof
     * @param angel
     * @param shed
     * @param shedLength 
     */
    public void createBillOfMaterialv2(double width, double height, double length, boolean roof, double angel, boolean shed, double shedLength)
    {
        materialList.add(stolper(length, shed, shedLength));
        
        //---
        
        
        materialList.add(Hulbånd());
        materialList.add(beslagTilRemHøjre(width, length, roof));
        materialList.add(beslagTilRemVenstre(width, length, roof));
        materialList.add(sternOgVandbrædtSkruer());
        materialList.add(universalbeslagHulbåndSkruer(roof));
        materialList.add(bræddeBolte(length, shed, shedLength));
        materialList.add(firkantSkiver(length, shed, shedLength));
        materialList.add(ydersteBeklædningSkruer());
        materialList.add(indersteBeklædningSkruer());
        materialList.add(staldDørsGreb());
        materialList.add(tHængsel());
            
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
            materialList.add(noRoofTagSkruer(width, length));
        }
        if(shed)
        {
            materialList.add(sternBraedderSkur(shedLength));
            materialList.add(skurRemme(shedLength));
            materialList.add(reglarLøsholteISiderneAfSkuret(shedLength));
            materialList.add(reglarLøsholteIGavleAfSkuret(shedLength));
            materialList.add(brætBeklædningAfSkur1Og2(shedLength));
            materialList.add(taglægteBagsidenAfDøren());
        }

    }
    
    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The length parameter determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * @param length
     * @return 
     */
    public Material vindskeder(double length)
    {
        Material material = materialHMap.getHmap("brædt25x150");
        material.setLength(length);
        material.setComment("Vindskeder på rejsning");
        material.setQty(1);
        material.setPrice(0);
        return material;
    }

    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The length parameter determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * @param length
     * @return 
     */
    public Material sternBraedder(double length)
    {
        Material material = materialHMap.getHmap("brædt25x150");
        material.setLength(length);
        material.setComment("Sternbrædder til siderne Carport del");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }
    
    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The shedLength parameter determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * @param shedLength
     * @return 
     */
    public Material sternBraedderSkur(double shedLength)
    {
        int i = 1;
        if(shedLength < 600)
        {
            i += shedLength / 600;
            if(600%shedLength < 0)
                i++;
        }
        Material material = materialHMap.getHmap("brædt25x150");
        material.setLength(shedLength);
        material.setComment("Sternbrædder til siderne Skur del ( deles )");
        material.setQty(i);
        material.setPrice(0);
        return material;
    }
    
    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * Should not be called outside of BillOfMaterial.
     * @return 
     */
    public Material bygSelvSpaer()
    {
        Material material = materialHMap.getHmap("byg_selv spær");
        material.setLength(0);
        material.setComment("byg-selv spær (skal samles) 8 stk.");
        material.setQty(1);
        material.setPrice(0);
        return material;
    }
    /**
     * This method returns a material object with custom comment, calculated quantity and price.
     * The length, roof and shedLength parameters determines the materials quantity
     * Should not be called outside of BillOfMaterial.
     * @param length
     * @param shed
     * @param shedLength
     * @return 
     */
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
    /**
     * This method returns a material object with custom length and comment.
     * The quantity will always be 2
     * Should not be called outside of BillOfMaterial.
     * @param length
     * @return 
     */
    public Material carportRemme(double length)
    {
        Material material = materialHMap.getHmap("spærtræ");
        material.setLength(length);
        material.setComment("Remme i sider, sadles ned i stolper Carport del");
        material.setQty(2);
        material.setPrice(0);
        return material;
    }
    
    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The shedLength parameter determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * @param shedLength
     * @return 
     */
    public Material skurRemme(double shedLength)
    {
        int i = 1;
        if(shedLength < 600)
        {
            i += shedLength / 600;
            if(600%shedLength < 0)
                i++;
        }
        
        Material material = materialHMap.getHmap("spærtræ");
        material.setLength(shedLength);
        material.setComment("Remme i sider, sadles ned i stolper Skur del");
        material.setQty(i);
        material.setPrice(0);
        return material;
    }

    /**
     * This method returns a material object with custom length, comment and price.
     * The shedLength parameter determines the materials length
     * The quantity will always be 4
     * Should not be called outside of BillOfMaterial.
     * @param shedLength
     * @return 
     */
    public Material reglarLøsholteISiderneAfSkuret(double shedLength)
    {
        Material material = materialHMap.getHmap("reglar");
        material.setLength(shedLength);
        material.setComment("Løsholter i siderne af skur");
        material.setQty(4);
        material.setPrice(0);
        return material;
    }

    /**
     * This method returns a material object with custom length, comment and price.
     * The shedLength parameter determines the materials length.
     * The quantity will always be 6
     * Should not be called outside of BillOfMaterial.
     * @param shedLength
     * @return 
     */
    public Material reglarLøsholteIGavleAfSkuret(double shedLength)
    {
        Material material = materialHMap.getHmap("reglar");
        material.setLength(shedLength);
        material.setComment("Løsholter i gavle af skur");
        material.setQty(6);
        material.setPrice(0);
        return material;
    }

    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The length parameter determines the materials length and quantity
     * Does not work atm
     * Should not be called outside of BillOfMaterial.
     * @param length
     * @return 
     */
    public Material vandBrætVindskeder(double length)
    {
        Material material = materialHMap.getHmap("brædt19x100");
        material.setLength(length);
        material.setComment("Vand bræt på vindskeder");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The length parameter determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * Does not work atm
     * @param length
     * @return 
     */
    public Material brætBeklædningAfGavle1Og2(double length)
    {
        Material material = materialHMap.getHmap("brædt19x100");
        material.setLength(length);
        material.setComment("beklædning af gavle 1 på 2");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The shedLength parameter determines the materials length.
     * The quantity will always be 148.
     * Should not be called outside of BillOfMaterial.
     * @param shedLength
     * @return 
     */
    public Material brætBeklædningAfSkur1Og2(double shedLength)
    {
        Material material = materialHMap.getHmap("brædt19x100");
        material.setLength(shedLength);
        material.setComment("Beklædning af skur 1 på 2");
        material.setQty(148);
        material.setPrice(0);
        return material;
    }

    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The length parameter determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * Does not work atm
     * @param length
     * @return 
     */
    public Material brætTilMonteringAfTagfodslægte(double length)
    {
        Material material = materialHMap.getHmap("brædt25x50");
        material.setLength(length);
        material.setComment("til montering oven på tagfodslægte");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The length parameter determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * Does not work atm
     * @return 
     */
    public Material taglægteBagsidenAfDøren()
    {
        Material material = materialHMap.getHmap("taglægte");
        material.setLength(0);
        material.setComment("til z på bagside af dør");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The length parameter determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * Does not work atm
     * @return 
     */
    public Material taglægteMonteringPåSpær()
    {
        Material material = materialHMap.getHmap("taglægte");
        material.setLength(0);
        material.setComment("til montering på spær, 7 rækker lægter på hver skiftevis 1 hel & 1 halv lægte");
        material.setQty(0);
        material.setPrice(0);
        return material;
    }

    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The length parameter determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * Does not work atm
     * @return 
     */
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
    public double Sinus(double sideA, double vinkelB)
    {
        double vinkelC = 90;
        double vinkelA = 180 - vinkelC - vinkelB;
        double res = (sideA *  Math.sin( Math.toRadians(vinkelC))) / (Math.sin( Math.toRadians(vinkelA)));
        return res;
    }
    
    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The width, length and angle parameters determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * @param width
     * @param length
     * @param angle
     * @return 
     */
    public Material roofSpær(double width, double length, double angle){
        double SinusLength = Sinus(width/2, angle);
        int spærQty =  (int) Math.ceil(length / 89);
        int træLængde = 30;
        while(SinusLength > træLængde)
            træLængde = træLængde + 30;
        return new Material("Spær", "Wood", 10, træLængde, 10, spærQty*2, 15, "Stk");
    }

    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The width and length parameters determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * @param width
     * @param length
     * @return 
     */
    public Material roofLægter(double width, double length){
        int lægterQty = (int) Math.ceil(width / 30.7);
        return new Material("Lægter", "Wood", 10, length, 10, lægterQty, 15, "Stk");
    }
    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The width, length and angle parameters determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * @param width
     * @param length
     * @param angle
     * @return 
     */
    public Material roofSten(double width, double length, double angle){
        double SinusLength = Sinus(width/2, angle);
        int spærQty = (int) Math.ceil(SinusLength / 30.7);
        int tagStensBrede = 30;
        int tagStenQty = (int) ((length / tagStensBrede) * (spærQty) + 6);
        return new Material("Tagsten", "Sten", tagStensBrede, 5, 35, tagStenQty*2, 15, "Stk");
    }
    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The length parameter determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * @param length
     * @return 
     */
    public Material roofRygSten(double length){
        int rygTagStensLængde = 40;
        int rygTagStensQty = (int) (length / rygTagStensLængde) + 3;
        return new Material("Rygsten", "Sten", 20, 5, rygTagStensLængde, rygTagStensQty, 15, "Stk");
    }
    // tag med rejsning -- slut --
    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The width and length parameters determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * @param width
     * @param length
     * @return 
     */
    public Material noRoofSpær(double width, double length){
        int afstandMellemSpær = 55;
        int spærQty = (int) Math.ceil(length / afstandMellemSpær);
        return new Material("45x195mm. spærtræ ubh.", "Spær, monteres på rem", 10, width, 10, spærQty, 15, "Stk"); 
    }
    
    /**
     * This method returns a material object with custom length, comment, calculated quantity and price.
     * The width and length parameters determines the materials length and quantity
     * Should not be called outside of BillOfMaterial.
     * @param width
     * @param length
     * @return 
     */
    public Material noRoofTag(double width, double length){
        int plastmoEcoliteLængde = 0;
        int plastmoEcoliteBrede = 0;
        int antalL = (int) Math.ceil(length / plastmoEcoliteLængde);
        int antalB = (int) Math.ceil(width / plastmoEcoliteBrede);
        int qty = antalL * antalB;
        return new Material("Plastmo Ecolite", "tagplader monteres på spær", 0, 0, plastmoEcoliteLængde, qty, 15.0, "stk");
    }
    
    
    // ********************************** Beslag of Skruer ****************************************************
    
    //Skruer til tagplader
    /**
     * This method returns a material object with custom comment, calculated quantity and price.
     * The width and length parameters determines the materials quantity
     * Should not be called outside of BillOfMaterial.
     * @param width
     * @param length
     * @return 
     */
    public Material noRoofTagSkruer(double width, double length){
        double arealm2 = (width * length) / 100;
        int skruerPerM2 = 12;
        double skruer50stkPris = 62.5;
        int antalSkruer = (int) (arealm2 / skruerPerM2) / 50;
        double totalPrisSkruer = (antalSkruer / 50) * skruer50stkPris;
        return new Material("Plastmo bundskruer 50 stk.", "Skruer til tagplader", 0, 0, 0, antalSkruer, totalPrisSkruer, "Pakke");
    }
    
    //Til vindkryds på spær
    /**
     * This method returns a material object with custom comment and price.
     * The quantity will always be 2
     * Should not be called outside of BillOfMaterial.
     * @return 
     */
    public Material Hulbånd(){
        double rullePris = 250;
        int qty = 2;
        return new Material("Hulbånd 1x20mm 10 mtr.", "Til vindkryds på spær", 0, 0, 0, qty, rullePris*qty, "Rulle");
    }
    
    //Til montering af spær på rem højre
    /**
     * This method returns a material object with custom comment, calculated quantity and price.
     * The width, length and roof parameters determines the materials quantity
     * Should not be called outside of BillOfMaterial.
     * @param width
     * @param length
     * @param roof
     * @return 
     */
    public Material beslagTilRemHøjre(double width, double length, boolean roof){
        int afstandMellemSpær; 
        if(roof)
            afstandMellemSpær = 55;
        else
            afstandMellemSpær = 89;
            
        int spærQty = (int) Math.ceil(length / afstandMellemSpær);
        int beslagPrisStk = 35;
        return new Material("Universal 190mm højre", "Til montering af spær på rem", 0, 0, 0, spærQty, beslagPrisStk, "Stk");
    }
    
    //Til montering af spær på rem venstre
    /**
     * This method returns a material object with custom comment, calculated quantity and price.
     * The width, length and roof parameter determines the materials quantity
     * Should not be called outside of BillOfMaterial.
     * @param width
     * @param length
     * @param roof
     * @return 
     */
    public Material beslagTilRemVenstre(double width, double length, boolean roof){
        int afstandMellemSpær;
        if(roof)
            afstandMellemSpær = 55;
        else
            afstandMellemSpær = 89;
        
        int spærQty = (int) Math.ceil(length / afstandMellemSpær);
        int beslagPrisStk = 35;
        return new Material("Universal 190mm venstre", "Til montering af spær på rem", 0, 0, 0, spærQty, beslagPrisStk, "Stk");
    }
    
    //Til montering af stern&vandbrædt
    /**
     * This method returns a material object with custom comment and price.
     * The quantity will always be 1
     * Should not be called outside of BillOfMaterial.
     * @return 
     */
    public Material sternOgVandbrædtSkruer(){
        int pris250stk = 150;
        int qty = 1;
        return new Material("4,5 x 60 mm Skruer 250 stk", "Til montering af stern&vandbrædt", 0, 0, 0, qty, pris250stk*qty, "Pakke");
    }
    
    //Til montering af universalbeslag + hulbån
    /**
     * This method returns a material object with custom comment and price.
     * The roof parameter determines the materials comment
     * The quantity will always be 1
     * Should not be called outside of BillOfMaterial.
     * @param roof
     * @return 
     */
    public Material universalbeslagHulbåndSkruer(boolean roof){
        int pris250stk = 100;
        int qty = 1;
        if(roof)
            return new Material("4,0 x 50 mm. beslagskruer 250 stk.", "Til montering af universalbeslag + hulbånd", 0, 0, 0, qty, pris250stk*qty, "Pakke");
        else
            return new Material("5,0 x 40 mm. beslagskruer 250 stk.", "Til montering af universalbeslag + hulbånd", 0, 0, 0, qty, pris250stk*qty, "Pakke");
        
    }
    
    //Til montering af rem på stolper
    /**
     * This method returns a material object with custom comment, calculated quantity and price.
     * The length, shed and shedLength parameters determines the materials quantity
     * Should not be called outside of BillOfMaterial.
     * @param length
     * @param shed
     * @param shedLength
     * @return 
     */
    public Material bræddeBolte(double length, boolean shed, double shedLength){
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
    /**
     * This method returns a material object with custom comment, calculated quantity and price.
     * The length shed and shedLength parameters determines the materials quantity
     * Should not be called outside of BillOfMaterial.
     * @param length
     * @param shed
     * @param shedLength
     * @return 
     */
    public Material firkantSkiver(double length, boolean shed, double shedLength){
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
    /**
     * This method returns a material object with custom comment and price.
     * The quantity will always be 2
     * Should not be called outside of BillOfMaterial.
     * @return 
     */
    public Material ydersteBeklædningSkruer(){
        int prisPer400stk = 600;
        int qty = 2;
        return new Material("4,5 x 70 mm. Skruer 400 stk.", "Til montering af yderste beklædning", 0, 0, 0, qty, prisPer400stk*qty, "Pakke");
    }
    
    //Til montering af inderste beklædning
    /**
     * This method returns a material object with custom length, comment and price.
     * The quantity will always be 2
     * Should not be called outside of BillOfMaterial.
     * @return 
     */
    public Material indersteBeklædningSkruer(){
        int prisPer300stk = 400;
        int qty = 2;
          return new Material("4,5 x 50 mm. Skruer 300 stk.", "Til montering af inderste beklædning", 0, 0, 0, qty, prisPer300stk*qty, "Pakke");
    }
    /**
     * This method returns a material object with custom length, comment and price.
     * The quantity will always be 1
     * Should not be called outside of BillOfMaterial.
     * @return 
     */
    public Material staldDørsGreb(){
        int qty = 1;
        int pris = 90;
        return new Material("Stalddørsgreb 50x75", "Til dør i skur", 0, 0, 0, qty, pris, "Sæt");
    }
    /**
     * This method returns a material object with custom length, comment and price.
     * The quantity will always be 2
     * Should not be called outside of BillOfMaterial.
     * @return 
     */
    public Material tHængsel(){
        int qty = 2;
        int pris = 70;
        return new Material("T-hængsel 390 mm.", "Til dør i skur", 0, 0, 0, qty, pris, "Stk");
    }
}

