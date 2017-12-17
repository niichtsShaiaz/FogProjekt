/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogProjectException;
import FunctionLayer.User;
import FunctionLayer.UserFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jbakke
 */
public class LoginCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response){
        
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user;
        try
        {
            user = UserFacade.login(email, password);
            session.setAttribute("User", user);
            return "Form";
        } catch (FogProjectException ex)
        {
            try
            {
                MyLogger.log(ex, "LoginCommand");
            } catch (IOException ex1){}
            
            List<String> errorMsgList = errorMsgList = new ArrayList<String>();
            session.setAttribute("errorMsgList", errorMsgList);
            errorMsgList.add("Forkert Email og eller Password, prøv igen eller kontakt support");
        }
        return "Login";
    }
    
}