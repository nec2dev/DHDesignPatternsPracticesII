/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.*;
import modelo.*;
import vista.*;
import java.sql.*;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Controlador_Boton_Ejecuta implements ActionListener{
    
    public Controlador_Boton_Ejecuta(Marco_Aplicacion2 elmarco){
        
        this.elmarco = elmarco;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String seleccionSeccion = (String)elmarco.secciones.getSelectedItem();
        
        String seleccionPais = (String)elmarco.paises.getSelectedItem();
        
        resultadoConsulta = obj.filtraBBDD(seleccionSeccion, seleccionPais);
        
        try{
            
            elmarco.resultado.setText("");
        
            while(resultadoConsulta.next()){
            
            elmarco.resultado.append(resultadoConsulta.getString(1));
            
            elmarco.resultado.append(", ");
            
            elmarco.resultado.append(resultadoConsulta.getString(2));
            
            elmarco.resultado.append(", ");
            
            elmarco.resultado.append(resultadoConsulta.getString(3));
            
            elmarco.resultado.append(", ");
            
            elmarco.resultado.append(resultadoConsulta.getString(4));
            
            elmarco.resultado.append("\n");
            
        }
      
        }catch(SQLException e1){
        }
    }
    
    private Marco_Aplicacion2 elmarco;
    
    Ejecuta_Consulta obj = new Ejecuta_Consulta();
    
    private ResultSet resultadoConsulta;
    
}
