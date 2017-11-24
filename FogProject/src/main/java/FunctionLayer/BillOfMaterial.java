    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ezl
 */
public class BillOfMaterial {
    List<Material> materialList = new ArrayList<Material>();
    
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
    
    private Material pools(double height, double length)
    {
        int i = 4;
        i += (length - 80 - 30) / 275;
        return new Material("trykimp.	Stolpe", "Stolper nedgraves 90 cm. i jord", 0.97, height + 90, 0.97, i, 50);
        
    }
    
    //remme
    private Material beams(double width, double height, double length)
    {
        return new Material("?", "?", 0, 0, length + 80 + 30, 2, 50);
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
        return new Material("Spær", "Wood", 10, SinusLength, 10, spærQty*2, 15);
    }
    //30.7     89
    private Material roofLægter(double width, double length){
        int lægterQty = (int) (width / 30.7);
        double lengthLeft = length % 30.7;
        return new Material("Lægter", "Wood", 10, length, 10, lægterQty*2, 15);
    }
    private Material roofSten(double width, double length, double angle){
        double SinusLength = Sinus(width/2, angle);
        int spærQty = (int) (SinusLength / 30.7);
        int tagStensBrede = 30;
        int tagStenQty = (int) ((length / tagStensBrede) * (spærQty) + 6);
        return new Material("Tagsten", "Sten", tagStensBrede, 5, 35, tagStenQty*2, 15);
    }
    private Material roofRygSten(double length){
        int rygTagStensLængde = 40;
        int rygTagStensQty = (int) (length / rygTagStensLængde);
        return new Material("Rygsten", "Sten", 20, 5, rygTagStensLængde, rygTagStensQty, 15);
    }
    
    public static void main(String[] args) {
        BillOfMaterial billOfMaterial = new BillOfMaterial();
        billOfMaterial.createBillOfMaterial(300, 300, 540, true, false, 0);
        List<Material> materialList = billOfMaterial.getBillOfMaterialList();
        for(int i = 0; i < materialList.size(); i++)
        {
            Material material = materialList.get(i);
            System.out.println(
                    "Material: " 
                    + i + 
                    " : " 
                    + material.getType() + 
                    ", " 
                    + material.getMaterial() + 
                    ", " 
                    + material.getWidth() + 
                    "cm x " 
                    + material.getHight() + 
                    "cm x " 
                    + material.getLength() +
                    "cm, "
                    + material.getQty() +
                    ", "
                    + material.getFullPrice() +
                    " dkk"
                    );
        }
    }
}

