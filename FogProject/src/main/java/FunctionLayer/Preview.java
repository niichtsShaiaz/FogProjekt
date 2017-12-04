/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Shxnna
 */
public class Preview {
    
    public static String draw(int width, int length) {
         StringBuilder sb = new StringBuilder();
         
         sb.append (cornerPoles(width, length));
         sb.append (poles(width, length));
         sb.append (poles2(width, length)); //error når bredde er <= 300
         sb.append (outerLines(width, length));
         sb.append (flatRoof(width, length));
         sb.append (rem(width, length)); //error når bredde er <= 300
       
        return sb.toString();
    }
    public static String rem(int width, int length){
        int space = 0;
        StringBuilder sb = new StringBuilder();
        
        int j = (width) / 300 - 1;
        
        if (j != 0)
            space = width/(j+1);
        else 
            space = width;
        
        for (int i = 600; i<=width; i+=300)
        {
            sb.append( "<rect x='"+(length-length-10)+"' y='"+(space)+"' height='"+5+"' width='"+(length+12)+"' style='stroke:#000000; fill:#ff0000 '/>");
            space += space;
        }
        sb.append( "<rect x='"+(length-length-10)+"' y='"+(width-width+70)+"' height='"+5+"' width='"+(length+12)+"' style='stroke:#000000; fill:#ff0000 '/>");
        sb.append( "<rect x='"+(length-length-10)+"' y='"+(width-70)+"' height='"+5+"' width='"+(length+12)+"' style='stroke:#000000; fill:#ff0000 '/>");
        System.out.println("j = "+j);
        System.out.println("space = " + space);
        return sb.toString();
    }
    public static String flatRoof(int width, int length){
        StringBuilder sb = new StringBuilder();
        
        
        for (int i = 55; i < length; i+=55) {
            sb.append( "<rect x='"+(i)+"' y='"+(0)+"' height='"+width+"' width='"+2+"' style='stroke:#000000; fill: #8b4513'/>");
            
        }
        
        return sb.toString();
    }
    public static String outerLines(int width, int length){
         StringBuilder sb = new StringBuilder();

        sb.append( "<rect x='"+(length-length)+"' y='"+(width-width)+"' height='"+2+"' width='"+length+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length-length)+"' y='"+(width-width)+"' height='"+width+"' width='"+2+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length-length)+"' y='"+(width)+"' height='"+2+"' width='"+(length+2)+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length)+"' y='"+(width-width)+"' height='"+width+"' width='"+2+"' style='stroke:#000000; fill: #000000'/>");
   
    
    return sb.toString();
    }
    
    public static String cornerPoles(int width, int length){
        int sizeX = 10;
        int sizeY = 10;
        
        StringBuilder sb = new StringBuilder();

        sb.append( "<rect x='"+(length-length+10)+"' y='"+(width-width+70)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length-10)+"' y='"+(width-width+70)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length-length+10)+"' y='"+(width-70)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length-10)+"' y='"+(width-70)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
        
        return sb.toString();
    }
    
    public static String poles(int width, int length){
        int sizeX = 10;
        int sizeY = 10;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 275; i<length-275; i+=275)
        {
            sb.append( "<rect x='"+(i)+"' y='"+(width-width+70)+"' height='"+(sizeY)+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
            sb.append( "<rect x='"+(i)+"' y='"+(width-70)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
        }
        
        return sb.toString();
    }
    
    public static String poles2(int width, int length){
        int sizeX = 10;
        int sizeY = 10;
        int space = 0;
        StringBuilder sb = new StringBuilder();
        
        int j = (width) / 300 - 1;
        
        if (j != 0)
            space = width/(j+1);
        else 
            space = width;
        
        for (int i = 600; i<=width; i+=300)
        {
            sb.append( "<rect x='"+(length-10)+"' y='"+(space)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
            sb.append( "<rect x='"+(length-length+10)+"' y='"+(space)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
            space += space;
        }
        System.out.println("j = "+j);
        System.out.println("space = " + space);
        return sb.toString();
    }
        
    public static void main(String[] args) {
        
       // System.out.println(poles2(680,780));
    }
}
