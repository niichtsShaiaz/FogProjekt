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
    
    public static User Login(String email, String password)throws FogProjectException{
        return UserMapper.login(email, password);
    }
    
    public static User Register(String email, String password)throws FogProjectException{
        UserMapper.Register(email, password);
        return UserMapper.login(email, password);
    }
    
    public static void main(String[] args) throws FogProjectException
    {
        User user = Login("e.z.l@live.com", "1234");
        System.out.println(user.toString());
    }
    
}
