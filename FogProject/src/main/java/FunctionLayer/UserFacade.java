/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.UserMapper;

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
    
    
    
}
