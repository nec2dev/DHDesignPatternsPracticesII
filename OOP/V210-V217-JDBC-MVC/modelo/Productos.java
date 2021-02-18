/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Productos {
    
    public Productos(){
    
        nArticulo = "";
        seccion = "";
        precio = "";
        pOrigen = "";
        
}

    public String getnArticulo() {
        return nArticulo;
    }

    public void setnArticulo(String nArticulo) {
        this.nArticulo = nArticulo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getpOrigen() {
        return pOrigen;
    }

    public void setpOrigen(String pOrigen) {
        this.pOrigen = pOrigen;
    }
    
        private String nArticulo;

        private String seccion;
        
        private String precio;

        private String pOrigen;
    
}
