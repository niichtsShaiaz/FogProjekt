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
    
    private double addPoleWidth = 300;
    private double addPoleLength = 300;
    
    private double addPoleRoofWidth = 300;
    private double addPoleRoofLength = 100;


    
    public void CreateBillOfMaterial(double width, double hight, double length)
    {
        double tmpWidth = width;
        double tmpHight = hight;
        double tmpLength = length;
        
        tmpLength -= addPoleLength * 2;
        int tmpInt = 4;
        while(tmpLength >= addPoleLength)
        {
            tmpInt += 2;
            tmpLength -= addPoleLength;
        }
        tmpWidth -= addPoleWidth;
        while(tmpWidth >= addPoleWidth)
        {
            tmpInt += 2;
            tmpWidth -= addPoleWidth;
        }
        materialList.add(new Material("Pole", "Wood", 30, hight, 30, tmpInt, 50));
        tmpLength = length - addPoleRoofLength;
        tmpInt = 0;
        while(tmpLength >= addPoleRoofLength)
        {
            tmpInt++;
            tmpLength -= addPoleRoofLength;
        }
        if(length == width)
        {
            tmpWidth = width - addPoleRoofWidth;
            while(tmpWidth >= addPoleRoofWidth)
            {
                tmpInt++;
                tmpWidth -= addPoleRoofLength;
            }
            materialList.add(new Material("Beam", "Wood", 30, 60, length, tmpInt, 50));
        }
        else
        {
            materialList.add(new Material("Beam", "Wood", 30, 60, length, tmpInt, 50));
            tmpWidth = width - addPoleRoofWidth;
            tmpInt = 0;
            while(tmpWidth >= addPoleRoofWidth)
            {
                tmpInt++;
                tmpWidth -= addPoleRoofLength;
            }
            materialList.add(new Material("Beam", "Wood", 30, 60, width, tmpInt, 50));
            
        }
    }
    
    public List<Material> getBillOfMaterial()
    {
        return materialList;
    }
    
    public double Sinus(double sideA, double vinkelB)
    {
        double vinkelC = 90;
        double vinkelA = 180 - 90 - vinkelB;
        return (sideA * Math.sin(vinkelC)) / (Math.sin(vinkelA));
    }
    
    public void roof(double width, double length, double height, double vinkel){
        int lengthSpace = (int) (length / 89);
        double lengthLeft = length % 89;
        double SinusLength = Sinus(width/2, 20);
        int angleSpace = (int) (SinusLength / 30.7);
        double angleLeft = SinusLength % 30.7;
        
        materialList.add(new Material("Length Space", "Wood", 10, 10, length, lengthSpace +1, 15));
        materialList.add(new Material("Angle Space", "Wood", 10, 10, SinusLength, lengthSpace +1, 15));
        
//        System.out.println(lengthSpace);
//        System.out.println(lengthLeft);
//        System.out.println(angleSpace);
//        System.out.println(angleLeft);
    }
    
    public static void main(String[] args) {
        BillOfMaterial billOfMaterial = new BillOfMaterial();
        billOfMaterial.roof(200, 500, 300, 20);
        billOfMaterial.CreateBillOfMaterial(300, 300, 1500);
        List<Material> materialList = billOfMaterial.getBillOfMaterial();
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

