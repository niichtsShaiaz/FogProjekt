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
 * @author jmb
 */
public class RegisterCommand extends Command{
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String firstName = request.getParameter("fornavn");
        String lastName = request.getParameter("efternavn");
        String telephone = request.getParameter("tlf");
        String address = request.getParameter("addresse");
        
        List<String> errorMsgList = new ArrayList<>();
        session.setAttribute("errorMsgList", errorMsgList);

        if(!email.contains("@") || !email.contains("."))
            errorMsgList.add("Ugyldig email");
        if(!password.equals(password2))
            errorMsgList.add("Passwordsne er ikke ens");
        if(firstName.equals("") || lastName.equals("") || telephone.equals("") || address.equals("") || password.equals(""))
            errorMsgList.add("Du skal udfylde alle felter");
        if(!errorMsgList.isEmpty())
                return "Registration";
        
        
        try{
            User user = UserFacade.register(email, password, firstName, lastName, telephone, address);
            session.setAttribute("User", user);
            return "Form";
        }
        catch(FogProjectException ex) // bliver stadig sendt til index
        {
            try 
            {
                MyLogger.log(ex, "RegisterCommand");
            } catch (IOException ex1){}
            errorMsgList.add("Der findes allerede en bruger med denne email");
        }
        return "Registration";
    }
    
}
