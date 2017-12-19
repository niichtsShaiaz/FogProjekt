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
    /**
     * This method uses the UserMapper to retrieve an user if the given email and password is related to an user in the user table in the FogProject database.
     * If the email or password is wrong a FogProjectException will be thrown with "Could not validate user".
     * @param email
     * @param password
     * @return
     * @throws FogProjectException 
     */
    public static User login(String email, String password)throws FogProjectException{
        return UserMapper.login(email, password);
    }
    /**
     * This method uses the UserMapper to insert a new user in the user table in the FogProject database.
     * It is not possible to insert an user that already exists since email is unique.
     * All the parameters are used to fill the table.
     * @param email
     * @param password
     * @param firstName
     * @param lastName
     * @param telephone
     * @param address
     * @return
     * @throws FogProjectException 
     */
    public static User register(String email, String password, String firstName, String lastName, String telephone, String address)throws FogProjectException{
        UserMapper.register(email, password, firstName, lastName, telephone, address);
        return UserMapper.login(email, password);
    }
       
}
