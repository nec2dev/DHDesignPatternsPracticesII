/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.*;
import java.sql.*;

/**
 *
 * @author Nahuel E Correa
 */
public class Conexion {
    
    Connection miConexion = null;

    public Conexion() {
        
        
    }
    
    /**
     *
     * @return
     * 
     */
    public Connection dameConexion(){
        
        try{
            
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?&useSSL=false", "root","BrizuelaMySQL1999");
            
        }catch(SQLException e){
            
            e.printStackTrace();
            
        }
        
            return miConexion;
    }
    
    
}
