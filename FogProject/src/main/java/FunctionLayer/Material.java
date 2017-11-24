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

    String type = "";
    String material = "";
    double width = 0;
    double hight = 0;
    double length = 0;
    int qty = 0;
    double price = 0;

    public Material(String type, String material, double width, double hight, double length, int qty, double price) 
    {
        this.type = type;
        this.material = material;
        this.width = width;
        this.hight = hight;
        this.length = length;
        this.qty = qty;
        this.price = price;
    }
    
    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHight() {
        return hight;
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
    
    public double getFullPrice()
    {
        return price * (length/30) * qty;
    }
    
}
