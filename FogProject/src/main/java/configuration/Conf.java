/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

import java.util.logging.Logger;

/**
 *
 * @author jmb
 */
public class Conf {
    public static final boolean PRODUCTION = true;
    public static final String LOGFILEPATH = "/var/log/tomcat8/demoApp.log";
    public static Logger myLogger = Logger.getLogger("");
    
}
