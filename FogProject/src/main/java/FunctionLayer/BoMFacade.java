/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.OrderMapper;

/**
 *
 * @author Shxnna
 */
public class BoMFacade {
    public static void createOrder(BillOfMaterial billOfMaterial) throws FogProjectException
    {
        OrderMapper.CreateOrder(billOfMaterial);
        
    }
}
