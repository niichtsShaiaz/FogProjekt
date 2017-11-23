/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.BillOfMaterial;
import FunctionLayer.FogProjectException;
import FunctionLayer.Material;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shxnna
 */
public class OrderMapper {
    
    public static List<Material> getOrders(int id) throws FogProjectException
    {
        List<Material> orders = new ArrayList<>();
        return orders;
    }
    
    public static void CreateOrder(BillOfMaterial billOfMaterial )throws FogProjectException {
        
        
    }
}
