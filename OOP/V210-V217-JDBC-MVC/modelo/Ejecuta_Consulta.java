/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Ejecuta_Consulta {
    
    public Ejecuta_Consulta(){
        
        miConexion = new Conexion();
    }
    
    public ResultSet filtraBBDD(String seccion, String pais){
    
        //pruebas = "";
        
        Connection conecta = miConexion.dameConexion();
        
        rs = null;
        
        try{
        
        if(!seccion.equals("Todos") && pais.equals(("Todos"))){
            
            //pruebas = "Has seleccionado sección";
            
            enviaConsultaseccion = conecta.prepareStatement(consultaSeccion);
            
            enviaConsultaseccion.setString(1, seccion);
            
            rs = enviaConsultaseccion.executeQuery();
            
        }else if(seccion.equals("Todos") && !pais.equals(("Todos"))){
            
            //pruebas = "Has seleccionado país";
            
            enviaConsultapais = conecta.prepareStatement(consultaPais);
            
            enviaConsultapais.setString(1, pais);
            
            rs = enviaConsultapais.executeQuery();
            
        }else{
            
            //pruebas = "Has seleccionado sección y país";
            
            enviaConsultatodos = conecta.prepareStatement(consultaTodos);
            
            enviaConsultatodos.setString(1, seccion);
            
            enviaConsultatodos.setString(2, pais);
            
            rs = enviaConsultatodos.executeQuery();
        }
        
        //return pruebas;   
        
    }catch(SQLException e){
        
        
    }
        
        return rs;
}
    
    //private String pruebas;
    
    private Conexion miConexion;
    
    private ResultSet rs;
    
    private PreparedStatement enviaConsultaseccion;
        
        private PreparedStatement enviaConsultapais;
        
        private PreparedStatement enviaConsultatodos;
        
        private final String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	
        private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
        
        private final String consultaTodos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
}
