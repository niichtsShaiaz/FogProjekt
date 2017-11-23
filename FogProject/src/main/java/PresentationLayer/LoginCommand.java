/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogProjectException;
import FunctionLayer.UserFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jbakke
 */
public class LoginCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogProjectException {
        if(UserFacade.Login((String)request.getAttribute("email"), (String)request.getAttribute("Password")) != null)
            return "Form";
        else
            return "Login";
    }
    
}
