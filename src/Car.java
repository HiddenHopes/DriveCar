import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class Car {
    Image carImage;
    Image carStopImage;
    Image carRunningRight;
    ImageIcon carImageIcon;
    int x;
    Clip player;
    AudioInputStream carRunningSound;

    Car() throws Exception{
        carImageIcon = new ImageIcon("car.png");
        carStopImage = carImageIcon.getImage();

        carImageIcon = new ImageIcon("carRunningRight.gif");
        carRunningRight = carImageIcon.getImage();

        carImage = carStopImage;
        x = 120;
        carRunningSound = AudioSystem.getAudioInputStream(new File("car_drive_sound.wav"));
        player = AudioSystem.getClip();
    }

    void move(KeyEvent e) throws Exception {
        carImage = carRunningRight;
        if(e.getKeyCode() == 39) x = x+5;
        if(e.getKeyCode() == 37) x = x-5;
        if(player.isOpen()==false) player.open(carRunningSound);
        player.loop(Clip.LOOP_CONTINUOUSLY);
    }

    void stop(){
        carImage = carStopImage;
        player.stop();
        player.setFramePosition(0);
    }
}
