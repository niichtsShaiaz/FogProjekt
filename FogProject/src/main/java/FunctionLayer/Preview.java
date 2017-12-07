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
    
    public static String draw(int width, int length, boolean shed, int shedLength) {
         StringBuilder sb = new StringBuilder();
         
         
          if (shed)
         {
          sb.append(shed(width,length,shedLength));
             
         }
         
         sb.append (cornerPoles(width, length));
         sb.append (poles(width, length));
         if (width > 300)
         sb.append (poles2(width, length));
         sb.append (outerLines(width, length));
         sb.append (flatRoof(width, length));
         if(width > 300)
         sb.append (rem(width, length));
         sb.append(rem2(width,length));
         sb.append(arrows(width,length));
         sb.append(arrowHead(width,length));
         sb.append(text(width,length));
         
         
        
         
       
        return sb.toString();
    }
    public static String rem(int width, int length){
        int space = 0;
        StringBuilder sb = new StringBuilder();
        
        
        
        int j = 0;
        j = (width) / 300 - 1;
        space = width/(j+1);
        
        
        for (int i = 599; i<width; i+=300)
        {
            sb.append( "<rect x='"+(length-length-10+100+10)+"' y='"+(space+100)+"' height='"+5+"' width='"+(length)+"' style='stroke:#000000; fill:#ff0000 '/>");
            space += space;
        }
        sb.append( "<rect x='"+(length-length-10+100+10)+"' y='"+(width-width+70+100)+"' height='"+5+"' width='"+(length)+"' style='stroke:#000000; fill:#ff0000 '/>");
        sb.append( "<rect x='"+(length-length-10+100+10)+"' y='"+(width-70+100)+"' height='"+5+"' width='"+(length)+"' style='stroke:#000000; fill:#ff0000 '/>");
        System.out.println("j = "+j);
        System.out.println("space = " + space);
        return sb.toString();
    }
    public static String rem2(int width, int length){
        StringBuilder sb = new StringBuilder();
        
        
            sb.append( "<rect x='"+(100)+"' y='"+(width-width+70+100)+"' height='"+5+"' width='"+length+"' style='stroke:#000000; fill: #FF0000'/>");
            sb.append( "<rect x='"+(100)+"' y='"+(width-70+100)+"' height='"+5+"' width='"+length+"' style='stroke:#000000; fill: #FF0000'/>");
        
        return sb.toString();
    }
    public static String flatRoof(int width, int length){
        StringBuilder sb = new StringBuilder();
        
        
        for (int i = 55; i < length; i+=55) {
            sb.append( "<rect x='"+(i+100)+"' y='"+(0+100)+"' height='"+width+"' width='"+2+"' style='stroke:#000000; fill: #8b4513'/>");
            
        }
        
        return sb.toString();
    }
    public static String outerLines(int width, int length){
         StringBuilder sb = new StringBuilder();

        sb.append( "<rect x='"+(length-length+100)+"' y='"+(width-width+100)+"' height='"+2+"' width='"+length+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length-length+100)+"' y='"+(width-width+100)+"' height='"+width+"' width='"+2+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length-length+100)+"' y='"+(width+100)+"' height='"+2+"' width='"+(length+2)+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length+100)+"' y='"+(width-width+100)+"' height='"+width+"' width='"+2+"' style='stroke:#000000; fill: #000000'/>");
   
    
    return sb.toString();
    }
    public static String cornerPoles(int width, int length){
        int sizeX = 10;
        int sizeY = 10;
        
        StringBuilder sb = new StringBuilder();

        sb.append( "<rect x='"+(length-length+10+100)+"' y='"+(width-width+70+100)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length-10+100)+"' y='"+(width-width+70+100)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length-length+10+100)+"' y='"+(width-70+100)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
        sb.append( "<rect x='"+(length-10+100)+"' y='"+(width-70+100)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
        
        return sb.toString();
    }
    public static String poles(int width, int length){
        int sizeX = 10;
        int sizeY = 10;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 275; i<length; i+=275)
        {
            sb.append( "<rect x='"+(i+100)+"' y='"+(width-width+70+100)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
            sb.append( "<rect x='"+(i+100)+"' y='"+(width-70+100)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
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
        
        for (int i = 599; i<width; i+=300)
        {
            sb.append( "<rect x='"+(length-10+100)+"' y='"+(space+100)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
            sb.append( "<rect x='"+(length-length+10+100)+"' y='"+(space+100)+"' height='"+sizeY+"' width='"+sizeX+"' style='stroke:#000000; fill: #000000'/>");
            space += space;
        }
        System.out.println("j = "+j);
        System.out.println("space = " + space);
        return sb.toString();
    }
    public static String shed(int width, int length, int shedLength){
        StringBuilder sb = new StringBuilder();
        
        sb.append( "<rect x='"+(length-shedLength-15+100)+"' y='"+(width-width+70+100)+"' height='"+(width-140)+"' width='"+(shedLength)+"' style='stroke:#000000; fill:#3d3d3d '/>");
        return sb.toString();
    }
    public static String arrows(int width, int length){
        StringBuilder sb = new StringBuilder();
        sb.append("<line x1='100' y1='80' x2='"+(length+100)+"' y2='80' style='stroke:rgb(0,0,0);stroke-width:2' />");
        sb.append("<line x1='80' y1='100' x2='80' y2='"+(width+100) +"' style='stroke:rgb(0,0,0);stroke-width:2' />");
        
        return sb.toString();
    }
    public static String arrowHead(int width, int length){
        StringBuilder sb = new StringBuilder();
        sb.append("<polygon points='100,80 110,70 110,90' style='fill:lime;stroke:purple;stroke-width:1' />");
        sb.append("<polygon points='80,100, 90,110 70,110' style='fill:lime;stroke:purple;stroke-width:1' />");
        
        sb.append("<polygon points='"+(length+100)+",80 "+(length+90)+",70 "+(length+90)+",90' style='fill:lime;stroke:purple;stroke-width:1' />");
        sb.append("<polygon points='80,"+(width+100)+", 90,"+(width+90)+" 70,"+(width+90)+"' style='fill:lime;stroke:purple;stroke-width:1' />");
        
        
        return sb.toString();
    }
    public static String text(int width, int length){
        StringBuilder sb = new StringBuilder();
        
        sb.append("<text x='40' y='"+(width/2+100)+"' fill='black' transform='rotate(-90 40,"+(width/2+100)+")'> "+width+" cm</text>");
        sb.append("<text x='"+(length/2+100)+"' y='60' fill='black'> "+length+" cm</text>");
               
        //<text x="0" y="15" fill="red">I love SVG!</text>
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        
       // System.out.println(poles2(680,780));
    }
}
