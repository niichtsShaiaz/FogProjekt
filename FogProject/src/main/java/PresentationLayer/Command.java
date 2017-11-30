/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogProjectException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jbakke
 */
abstract class Command {
    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("Login", new LoginCommand());
        commands.put("Carport", new CreateOrderCommand());
        commands.put("AllOrders", new AllOrdersCommand());
        commands.put("Register", new RegisterCommand());
        commands.put("UserOrders", new UserOrdersCommand());
    }
    
    public static int getSize()
    {
        return commands.size();
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        System.out.println(commandName);
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) throws FogProjectException;
}
