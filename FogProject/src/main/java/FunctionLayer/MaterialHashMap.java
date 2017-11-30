/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.MaterialMapper;
import java.util.HashMap;

/**
 *
 * @author ezl
 */
public class MaterialHashMap
{
    private HashMap<String, Material> hmap = null;
    
    public MaterialHashMap() throws FogProjectException
    {
           hmap =  MaterialMapper.getAllMaterials();
    }
    
    public void putHmap(String key, Material value)
    {
        hmap.put(key, value);
    }
    
    public Material getHmap(String key)
    {
        return new Material(key, hmap.get(key).getComment(), hmap.get(key).getSideA(), hmap.get(key).getSideB(), 0, 0, 0, hmap.get(key).getEnhed());
    }
}
