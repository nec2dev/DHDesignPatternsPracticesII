/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.*;
import javax.swing.*;

/**
 *
 * @author Comisión #60 C.F.P. n°11
 */
public abstract class Intro {
        
    private static JFXPanel jfxPanel = new JFXPanel(); 
    private static JFrame frame = new JFrame();
    private static String path;
    public final static int VID_INTRO = 1;
    public final static int VID_WON = 2;
    public final static int VID_LOST = 3;
    private static MediaPlayer oracleVid;
    
    public static void estadosIniciales(int opcionVideo){
        switch (opcionVideo) {
            case Intro.VID_INTRO:
                path = "src\\ahorcado\\resources\\Intro.mp4";
                break;
            case Intro.VID_WON:
                path = "src\\ahorcado\\resources\\Win.mp4";
                break;
            case Intro.VID_LOST:
                path = "src\\ahorcado\\resources\\ToLose.mp4";
                break;
            default:
                path = "src\\ahorcado\\resources\\Intro.mp4";
                break;
        }
        File file = new File(path);
                oracleVid = new MediaPlayer(                                       
                    new Media(file.toURI().toString())
                );
        
        Toolkit icono = Toolkit.getDefaultToolkit();
        Image miIcono = icono.getImage("src\\ahorcado\\resources\\logo.png");
        frame.setIconImage(miIcono);
        frame.setAlwaysOnTop(true);
        frame.setTitle("The Hangman Game CFP°11");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setFrameDimensionFromVid();
         
    }
    
    private static void setFrameDimensionFromVid(){
        oracleVid.setOnReady(new Runnable() {
                    @Override
                    public void run(){
                        MediaView mv = new MediaView(oracleVid);
                        int vidHeight = oracleVid.getMedia().getHeight();
                        int vidWidth = oracleVid.getMedia().getWidth();
                        JLabel emptyLabel = new JLabel("");
                        emptyLabel.setPreferredSize(new Dimension(vidWidth, vidHeight));
                        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                        createScene();
                        frame.setLayout(new BorderLayout());
                        frame.add(jfxPanel,BorderLayout.CENTER);
                    }
                });
    }
    
    private static void createScene(){
 
                jfxPanel.setScene(new Scene(new Group(new MediaView(oracleVid))));
                oracleVid.setVolume(0.7);//volumen
                oracleVid.setCycleCount(0);
                oracleVid.play();//play video
                oracleVid.setOnEndOfMedia(new Runnable() {
                    @Override
                    public void run(){
                        frame.setVisible(false);
                    }
                });
             }
        
}    
    
