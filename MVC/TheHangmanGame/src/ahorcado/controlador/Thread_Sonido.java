/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.controlador;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Comisión #60 C.F.P. n°11
 */
public class Thread_Sonido implements Runnable {

    @Override
    public void run() {
        try {
            Clip sonido = AudioSystem.getClip();
            File a = new File("src\\ahorcado\\resources\\sound.wav");
            sonido.open(AudioSystem.getAudioInputStream(a));
            sonido.start();
            sonido.loop(Clip.LOOP_CONTINUOUSLY);
        } 
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
            System.out.println("" + ex);
        }
    }
}

