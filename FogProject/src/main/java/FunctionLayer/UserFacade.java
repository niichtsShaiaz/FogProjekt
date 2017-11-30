/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.UserMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jbakke
 */
public class UserFacade {
    
    public static User login(String email, String password)throws FogProjectException{
        return UserMapper.login(email, password);
    }
    
    public static User register(String email, String password, String firstName, String lastName, String telephone, String address)throws FogProjectException{
        UserMapper.register(email, password, firstName, lastName, telephone, address);
        return UserMapper.login(email, password);
    }
    public static void main(String[] args) {
        try {
            User user = login("jonatan@bakke.net", "1234");
            System.out.println(user.getAddress());
        } catch (FogProjectException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
