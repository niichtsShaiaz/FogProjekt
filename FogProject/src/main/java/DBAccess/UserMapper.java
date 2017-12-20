/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.FogProjectException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jbakke
 */
public class UserMapper {
    
    /**
     * This method inserts a new user in the user table in the FogProject database.
     * It is not possible to insert an user that already exists since email is unique.
     * All the parameters are used to fill the table.
     * @param email
     * @param password
     * @param firstName
     * @param lastName
     * @param telephone
     * @param address
     * @throws FogProjectException 
     */
    public static void register(String email, String password, String firstName, String lastName, String telephone, String address) throws FogProjectException{
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password, firstname, lastname, telephone, address) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, telephone);
            ps.setString(6, address);
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new FogProjectException( ex.getMessage() );
        }
    }
    
    /**
     * This method retrieves an user if the given email and password is related to an user in the user table in the FogProject database.
     * If the email or password is wrong a FogProjectException will be thrown with "Could not validate user".
     * @param email
     * @param password
     * @return
     * @throws FogProjectException 
     */
    public static User login( String email, String password ) throws FogProjectException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, email, firstname, lastname, telephone, address, role FROM user WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                int id = rs.getInt( "id" );
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String telephone = rs.getString("telephone");
                String address = rs.getString("address");
                String role = rs.getString("role");
                User user = new User( id, email, firstName, lastName, telephone, address, role);
                return user;
            } else {
                throw new FogProjectException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new FogProjectException(ex.getMessage());
        }
    }
    
}
