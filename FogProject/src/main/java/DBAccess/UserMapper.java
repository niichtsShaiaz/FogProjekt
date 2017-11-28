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
    
    public static User login( String email, String password ) throws FogProjectException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, email, firstname, lastname, telephone, address FROM user WHERE email=? AND password=?";
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
    
    public static void main(String[] args) {
        try {
            User u1 = login("e.z.l@live.com", "1234");
            System.out.println(u1.getEmail());
        } catch (FogProjectException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
