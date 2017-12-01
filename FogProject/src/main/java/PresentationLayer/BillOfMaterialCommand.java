/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;


import FunctionLayer.FogProjectException;
import FunctionLayer.User;
import FunctionLayer.BillOfMaterial;
import FunctionLayer.OrderFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shxnna
 */
public class BillOfMaterialCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogProjectException {
       HttpSession session = request.getSession();
       
       int width = Integer.parseInt(request.getParameter("Width"));
       int length = Integer.parseInt(request.getParameter("Length"));
       int heigth = Integer.parseInt(request.getParameter("Height"));
       boolean roof = Boolean.parseBoolean(request.getParameter("roof"));
       boolean shed = Boolean.parseBoolean(request.getParameter("shed"));
       
       BillOfMaterial bom = new BillOfMaterial();
       bom.createBillOfMaterialv2(width, heigth, length, roof, shed, 0);
           
        return "";
    }
    
    
}
