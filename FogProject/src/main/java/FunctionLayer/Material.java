/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author ezl
 */
public class Material implements MaterialInterface{

    String name = "";
    String comment = "";
    double sideA = 0;
    double sideB = 0;
    double length = 0;
    int qty = 0;
    double price = 0;
    String enhed = "";

    /**
     * This is a Material object that works with the FogProject Material table
     * @param name
     * @param comment
     * @param sideA
     * @param sideB
     * @param length
     * @param qty
     * @param price
     * @param enhed 
     */
    public Material(String name, String comment, double sideA, double sideB, double length, int qty, double price, String enhed) 
    {
        this.name = name;
        this.comment = comment;
        this.sideA = sideA;
        this.sideB = sideB;
        this.length = length;
        this.qty = qty;
        this.price = price;
        this.enhed = enhed;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public double getSideA() {
        return sideA;
    }

    @Override
    public double getSideB() {
        return sideB;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public int getQty() {
        return qty;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
    public String getEnhed()
    {
        return enhed;
    }
    
    public double getFullPrice()
    {
        return price * (length/30) * qty;
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public void setQty(int qty)
    {
        this.qty = qty;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    @Override
    public String toString()
    {
        return "Material{" + "name=" + name + ", comment=" + comment + ", sideA=" + sideA + ", sideB=" + sideB + ", length=" + length + ", qty=" + qty + ", price=" + price + ", enhed=" + enhed + '}';
    }
}
