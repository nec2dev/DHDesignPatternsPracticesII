/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.*;
import java.sql.SQLException;
import modelo.*;
import vista.*;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Controlador_Carga_Menu extends WindowAdapter{
    
    public Controlador_Carga_Menu(Marco_Aplicacion2 elmarco){
        
        this.elmarco = elmarco;
        
    }
    
    @Override
    public void windowOpened(WindowEvent e){
        
        obj.ejecutaConsultas();
        
        try{
            
            while(obj.rs.next()){
                
                elmarco.secciones.addItem(obj.rs.getString(1));
                
            }
            
            while(obj.rs2.next()){
                
                elmarco.paises.addItem(obj.rs2.getString(1));
                
            }
            
            
        }catch(SQLException e2){
            
            e2.printStackTrace();
            
        }
        
    }
    
    Carga_Menu obj = new Carga_Menu();
    
    private Marco_Aplicacion2 elmarco;
    
}
