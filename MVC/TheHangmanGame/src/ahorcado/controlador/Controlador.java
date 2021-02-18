/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.controlador;

import ahorcado.modelo.Juego;
import ahorcado.vista.About;
import ahorcado.vista.Intro;
import ahorcado.vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 * Controla las acciones entre Vista y Juego
 *
 * @author Comisión #60 C.F.P. n°11
 */
public class Controlador {

    private Vista vista;
    private Juego juego;
    private About about;
    private boolean isMusicActivated = false;

    /**
     * Instancia los objetos juego, vista, about, y Handlers; ademas de
     * inicializar los estados iniciales de vista y About.
     */
    public Controlador() {
        this.juego = new Juego();
        this.vista = new Vista();
        this.about = new About();
        this.vista.setVisible(true);
        HandlerAceptar ha = new HandlerAceptar();
        HandlerCampoIngresar hci = new HandlerCampoIngresar();
        HandlerIniciar hi = new HandlerIniciar();
        HandlerAboutOk hbo = new HandlerAboutOk();
        HandlerAbout hab = new HandlerAbout();
        HandlerMusica hm = new HandlerMusica();
        this.vista.setHandlers(ha, hci, hi, hab, hm);
        this.about.setHandlers(hbo);
    }

    /**
     * Clase privada para que se encargue de los eventos cuando alguien toca la
     * tecla Enter en el campo de ingreso de texto, o si alguien hace click en
     * el boton Aceptar
     */
    private class HandlerAceptar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            revisarPalabra();
            vista.vaciarTxt();
        }
    }

    /**
     * Clase privada para que controle lo que ingrgesa el usuario en el campo de
     * texto
     */
    private class HandlerCampoIngresar implements KeyListener {

        /**
         * Solo se acepta una letra, y que sea del alfabeto.
         *
         * @param e
         */
        @Override
        public void keyTyped(KeyEvent e) {
            String txt = vista.getTxt();
            if (txt.length() > 0) {
                e.consume();
            }
            char letraTxt = e.getKeyChar();
            if (!Character.isAlphabetic(letraTxt)) {
                e.consume();
            }
            if (Character.isLowerCase(letraTxt)) {
                e.setKeyChar(Character.toUpperCase(letraTxt));
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    /**
     * Clase privada que se encarga del evento cuando alguien hace click en el
     * boton Iniciar
     */
    private class HandlerMusica implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            iniciarMusica();
        }
    }

    /**
     * Clase privada que se encarga del evento cuando alguien hace click en el
     * boton Iniciar
     */
    private class HandlerIniciar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            iniciarJuego();
        }
    }

    /**
     * Clase privada que se encarga del evento cuando alguien hace click en el
     * boton About
     */
    private class HandlerAbout implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mostrarAbout();
        }

    }

    /**
     * Clase privada que se encarga del evento cuando alguien hace click en el
     * boton Ok en About
     */
    public class HandlerAboutOk implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            about.dispose();
        }
    }

    private void iniciarMusica() {
        if (!isMusicActivated) {
            isMusicActivated=true;
            Thread_Sonido ts = new Thread_Sonido();
            ts.run();
        }
    }

    /**
     * Cada vez que el usuario ingresa una letra lo pasa a minuscula. Luego se
     * guarda en la variable palabra con lo que vale la respuesta. Se usa un if
     * para buscar si la letra está repetida, si no lo está, sigue con el
     * proceso normal, pero si está repetida, lanza un cartel con advertencia.
     * Tambien se guarda en la variable limite la cantidad de letras de la
     * respuesta. Se crea un boolean que indica si se encontró esa letra en la
     * respuesta. Se crea un int cantCoinci que sirve para controlar cuantas
     * veces el jugador acertó. Se recorre con un for la palabra para comprar la
     * letra ingresada. Si lo encuentra, settea la letra en Vista, además de
     * cambiar el estado del boolean, e incrementa cantCoinci. Si no se encontró
     * la letra, incrementa el valor de cantIntentos, además de cambiar el
     * background en Vista Si los intentos llegan a valer 6, se invoca al metodo
     * gameOver Si el usuario acerta todas las letras, se invoca al metodo
     * gameWin
     */
    private void revisarPalabra() {
        try {
            String ingreso = this.vista.getTxt().toUpperCase();
            char letra = ingreso.charAt(0);
            if (juego.isLetraRepetida(letra)) {
                JOptionPane.showMessageDialog(null, "Letra repetida", "Ingreso del dato", JOptionPane.WARNING_MESSAGE);
            } else {
                int limite = this.juego.getCantLetras();
                String palabra = this.juego.getRespuesta().toUpperCase();
                boolean encontrado = false;
                int cantCoinci = this.juego.getCantCoincidencias();
                for (int i = 0; i < limite; i++) {
                    if (letra == palabra.charAt(i)) {
                        this.vista.setLetra(letra, i);
                        encontrado = true;
                        cantCoinci++;
                        this.juego.setCantCoincidencias(cantCoinci);
                        this.juego.agregarLetraRepetida(letra, i);
                    }
                }
                if (!encontrado) {
                    int intentos = this.juego.getCantIntentos() - 1;
                    this.juego.setCantIntentos(intentos);
                    this.vista.setCantIntentos(intentos);
                    this.vista.setImageBackground(intentos);
                }
                if (this.juego.getCantIntentos() == 0) {
                    gameOver();
                } else if (cantCoinci == limite) {
                    gameWin();
                }
            }
        }//Fin del try
        catch (IndexOutOfBoundsException iofbex) {
            //Algo
        }
    }

    /**
     * Al iniciar el juego, se pone el background inicial. Se guarda en una
     * variable la cantidad de palabras (menos uno por empezar en cero) para
     * luego elegir al azar con Math.random una de las palabras Se guarda en una
     * variable la palabra y la cantida de letras, para luego inicializar los
     * atributos de la clase juego, además de preparar Vista
     */
    private void iniciarJuego() {
        this.vista.setImageBackground(6);
        int max = this.juego.getPalabrasSize();
        int i = (int) (Math.random() * max);
        String palabra = this.juego.getPalabraArrayList(i);
        String descripcion = this.juego.getDescripcionArrayList(i);
        int cantLetras = palabra.length();
        this.juego.setCantCoincidencias(0);
        this.juego.setCantLetras(cantLetras);
        this.juego.setCantIntentos(6);
        this.juego.setRespuesta(palabra);
        this.juego.setDescripcion(descripcion);
        this.juego.inicializarSizeLetrasRepetidas(cantLetras);
        this.vista.setRayasRespuesta(cantLetras);
        this.vista.setTotalLetras(cantLetras);
        this.vista.habilitarInicio();
        this.vista.setCantIntentos(6);
        this.vista.setDescripcion(descripcion);

    }

    /**
     * Cuando se llega al limite de intentos, se muestra la respuesta
     */
    private void gameOver() {
        String respuesta = this.juego.getRespuesta();
        this.vista.mostrarRespuesta(respuesta);
        //this.vista.testGif();
        //testFrame1();
        Intro.estadosIniciales(Intro.VID_LOST);
        //Intro intro = new Intro();
    }

    /**
     * Si el jugador gana el juego
     */
    private void gameWin() {
        //Hacer algo. Solo puse esto para ver si funcionaba correctamente.
        this.vista.mostrarRespuesta("LO LOGRASTE!");
        Intro.estadosIniciales(Intro.VID_WON);
    }

    /**
     * Metodo que se ejecuta cuando se toca el boton About.
     */
    private void mostrarAbout() {
        this.about.setVisible(true);
    }

}
