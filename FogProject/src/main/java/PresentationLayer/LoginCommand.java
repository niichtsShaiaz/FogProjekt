/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogProjectException;
import FunctionLayer.User;
import FunctionLayer.UserFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jbakke
 */
public class LoginCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogProjectException {
<<<<<<< HEAD
        User user = UserFacade.Login((String)request.getAttribute("email"), (String)request.getAttribute("password"));
        if(user == null)
            return "Login";
        else
            return "Form";
=======
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = UserFacade.Login(email, password);
        session.setAttribute("User", user);
        return "";
>>>>>>> Jbakke
    }
    
}
