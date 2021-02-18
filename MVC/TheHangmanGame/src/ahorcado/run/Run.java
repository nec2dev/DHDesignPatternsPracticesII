/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.run;

import ahorcado.controlador.Controlador;

import ahorcado.vista.Intro;

/**
 *
 * @author Comisión #60 C.F.P. n°11
 */
public class Run {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Intro.estadosIniciales(Intro.VID_INTRO);
                Controlador c = new Controlador();
            }
        });
    }
    
}
