/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;

/**
 *
 * @author ezl
 */
public class Order
{
    private int id;
    private BillOfMaterial billOfMaterial;
    private User user;
    private double width;
    private double length;
    private boolean roof;
    private double angel;
    private boolean shed;
    private double shedWidth;
    private double shedLength;

    public Order(int id, double width, double length, boolean roof, double angel, boolean shed, double shedWidth, double shedLength, User user)
    {
        this.id = id;
        this.width = width;
        this.length = length;
        this.roof = roof;
        this.angel = angel;
        this.shed = shed;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        
        //create bill of material here
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public BillOfMaterial getBillOfMaterial()
    {
        return billOfMaterial;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getLength()
    {
        return length;
    }

    public void setLenght(double length)
    {
        this.length = length;
    }

    public boolean getRoof()
    {
        return roof;
    }

    public void setRoof(boolean roof)
    {
        this.roof = roof;
    }

    public double getAngel()
    {
        return angel;
    }

    public void setAngel(double angel)
    {
        this.angel = angel;
    }

    public boolean getShed()
    {
        return shed;
    }

    public void setShed(boolean shed)
    {
        this.shed = shed;
    }

    public double getShedWidth()
    {
        return shedWidth;
    }

    public void setShedWidth(double shedWidth)
    {
        this.shedWidth = shedWidth;
    }

    public double getShedLength()
    {
        return shedLength;
    }

    public void setShedLength(double shedLength)
    {
        this.shedLength = shedLength;
    }
    
    
    
}
