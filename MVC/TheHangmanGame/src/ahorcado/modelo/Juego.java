/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.modelo;

import java.util.ArrayList;

/**
 * Juego es la clase modelo de este proyecto
 * @author Comisión #60 C.F.P. n°11
 */
public class Juego {
    private ArrayList<String> palabras;
    private ArrayList<String> descripciones;
    private int cantIntentos;
    private int cantLetras;
    private String respuesta;
    private int cantCoincidencias;
    private String descripcion;
    private char[] letrasRepetidas;
    
    /**
     * Constructor que crea los ArrayList y llama a los metodos para iniciarlos
     */
    public Juego(){
        this.palabras = new ArrayList();
        this.descripciones = new ArrayList();
        inicializarPalabras();
        inicializarDescripciones();
    }
    
    /**
     * Settea el atributo cantIntentos
     * @param cantIntentos Cantidad de intentos que tiene el jugador 
     */
    public void setCantIntentos(int cantIntentos) {
        this.cantIntentos = cantIntentos;
    }

    /**
     * Settea el atributo cantLetras
     * @param cantLetras Cantidad de letras que tiene la palabra del ArrayList
     */
    public void setCantLetras(int cantLetras) {
        this.cantLetras = cantLetras;
    }

    /** 
     * Settea el atributo respuesta
     * @param respuesta String que contiene la respuesta, una palabra del ArrayList, del juego
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    /**
     * Settea el atributo cantCoincidencias
     * @param cantCoincidencias Cantidad de coincidencias acertadas por el jugador
     */
    public void setCantCoincidencias(int cantCoincidencias) {
        this.cantCoincidencias = cantCoincidencias;
    }
    
    /**
     * Settea el atributo descripcion
     * @param descripcion String que describe lo que significa la palabra
     */
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    /**
     * Devuelve el valor de cantIntentos
     * @return Cantidad de intentos que tiene el jugador
     */
    public int getCantIntentos() {
        return this.cantIntentos;
    }
    
    /**
     * Devuelve el valor de cantLetras
     * @return Cantidad de letras que tiene la palabra
     */
    public int getCantLetras() {
        return this.cantLetras;
    }
    
    /**
     * Devuelve el valor de respuesta
     * @return La respuesta, palabra, del juego
     */
    public String getRespuesta(){
        return this.respuesta;
    }
    
    
    /**
     * Devuelve el valor del atributo cantCoincidencias
     * @return Cantidad de coincidencias
     */
    public int getCantCoincidencias() {
        return this.cantCoincidencias;
    }
    
    /**
     * Devuelve el tamaño del ArrayList palabras
     * @return Cantidad de palabras que tiene el ArrayList
     */
    public int getPalabrasSize(){
        return this.palabras.size();
    }
    
    /**
     * Devuelve un String con la palabra del ArrayList en la posicion indicada
     * @param i Posicion a ingresar del ArrayList
     * @return La palabra a usar para el juego
     */
    public String getPalabraArrayList(int i){
        return this.palabras.get(i);
    }
    
    /**
     * Devuelve un String con la descripcion del ArrayList correspondiente a la palabra, 
     * en la posicion indicada
     * @param i Posicion a ingresar del ArrayList
     * @return String que es la descripcion de la palabra
     */
    public String getDescripcionArrayList(int i){
        return this.descripciones.get(i);
    }
    
    /**
     * Devuelve un String con la descripcion correspondiente a la sesion actual del juego
     * @return String que es la descripcion de la palabra
     */
    public String getDescripcion(){
        return this.descripcion;
    }
    
    /**
     * Inicializa el ArrayList palabras con palabras relacionadas a programacion
     * Funcion para inicializar el ArrayList de palabras
     */
    public void inicializarPalabras(){
        this.palabras.add("POLIMORFISMO");
        this.palabras.add("ALGORITMO");
        this.palabras.add("METODO");
        this.palabras.add("FUNCIONES");
        this.palabras.add("HERENCIA");
        this.palabras.add("CONSTANTE");
        this.palabras.add("INTERFAZ");//7
        this.palabras.add("JUNIOR");
        this.palabras.add("SISTEMA");
        //Seguir añadiendo 
    }
    
    /**
     * Inicializa el ArrayList de descripciones de acuerdo a lo que significa cada 
     * palabra en el ArrayList de palabras
     */
    public void inicializarDescripciones(){
        this.descripciones.add("<html>En programación orientada a objetos es la propiedad por la que es posible<br>enviar mensajes sintácticamente iguales a objetos de tipos distintos.<html>");
        this.descripciones.add("<html>Secuencia de pasos lógicos que permiten solucionar un problema.</html>");
        this.descripciones.add("<html>Serie de sentencias para llevar a cabo una acción, un juego de parámetros de entrada que regularán<br>dicha acción o, posiblemente, un valor de salida (o valor de retorno) de algún tipo<html>");
        this.descripciones.add("<html>Acepta varios parámetros de entrada, pero solo retorna uno de salida.</html>");
        this.descripciones.add("<html>Propiedad esencial de la Programación Orientada a Objetos<br>que consiste en la creación de nuevas clases a partir de otras ya existentes.<html>");
        this.descripciones.add("<html>Valor que no puede ser alterado o modificado<br>durante la ejecución de un programa, únicamente puede ser leído.</html>");
        this.descripciones.add("<html>Colección de declaraciones de métodos sin definirse y<br>que se implementan en una clase para poder modelar el comportamiento en común.<html>");
        this.descripciones.add("<html>Dentro de una empresa, es un tipo de programador.</html>");
        this.descripciones.add("<html>Conjunto de elementos relacionados entre sí<br>que tienen un cierto orden u organización y que cumplen una función.<html>");
    }
    
    /**
     * Instancia un vector de char, cuyo tamaño es la cantidad de letras de la palabra
     * @param i Tamaño del vector  
     */
    public void inicializarSizeLetrasRepetidas(int i){
        this.letrasRepetidas = new char[i];
    }
    
    /**
     * Si la letra que ingresó el usuario está repetida, entonces la agrega al vector
     * @param letra char a agregar
     * @param i Posición donde agregar
     */
    public void agregarLetraRepetida(char letra, int i){
        this.letrasRepetidas[i] = letra;
    }
    
    /**
     * Se compara la letra ingresada por el usuario en el vector
     * @param letra char a buscar
     * @return boolean que si es verdadero, significa que lo encontró. Caso contrario, es falso
     */
    public boolean isLetraRepetida(char letra){
        boolean encontrado = false;
        int i = 0;
        int limite = this.letrasRepetidas.length;
        while(i < limite && !encontrado){
            if(this.letrasRepetidas[i] == letra)
                encontrado = true;
            else
                i++;
        }
        return encontrado;
    }
}
