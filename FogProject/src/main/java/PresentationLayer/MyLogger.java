/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogProjectException;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author ezl
 */
public class MyLogger
{
    private static final Logger LOGGER = Logger.getLogger(MyLogger.class.getName());
    private static boolean bool = true;
    public static void log(FogProjectException ex , String str) throws IOException
    {
        if(bool)
        {
            FileHandler fh;
            fh = new FileHandler("/var/log/tomcat8/MyLogFile.log"); 
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
            bool = false; 
        }
        LOGGER.log(Level.SEVERE, str, ex); 
    }
}
