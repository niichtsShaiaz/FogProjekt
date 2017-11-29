/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.FogProjectException;
import FunctionLayer.Material;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author ezl
 */
public class MaterialMapper
{
    private Connection con;
    
    public static HashMap<String, Material> getAllMaterials() throws FogProjectException
    {
        try{
        HashMap<String, Material> materialHmapDB = new HashMap<>();
        
        Connection con = Connector.connection();
        Statement stm = con.createStatement();
        String sql = "SELECT material_id, material_name, material_comment, material_sideA, material_sideB FROM material;";
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next())
        {
            materialHmapDB.put(rs.getString("material_name"), new Material(rs.getString("material_comment"), "", rs.getDouble("material_sideA"), rs.getDouble("material_sideB"), 0, 0, 0, rs.getString("material_enhed")));
        }
        
        return materialHmapDB;
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new FogProjectException( ex.getMessage() );
        }
    }
}
