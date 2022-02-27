import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Car {
    Image carImage;
    Image carStopImage;
    Image carRunningRight;
    ImageIcon carImageIcon;
    int x;
    Clip player1;
    Clip player2;
    AudioInputStream carRunningSound;
    AudioInputStream fireSound;
    List bullets;

    Car() throws Exception {
        carImageIcon = new ImageIcon("car.png");
        carStopImage = carImageIcon.getImage();

        carImageIcon = new ImageIcon("carRunningRight.gif");
        carRunningRight = carImageIcon.getImage();

        carImage = carStopImage;
        x = 120;

        carRunningSound = AudioSystem.getAudioInputStream(new File("car_drive_sound.wav"));
        player1 = AudioSystem.getClip();

        fireSound = AudioSystem.getAudioInputStream(new File("fire_sound.wav"));
        player2 = AudioSystem.getClip();
        bullets = new ArrayList();
    }

    void move(KeyEvent e) throws Exception {
        carImage = carRunningRight;
        if (e.getKeyCode() == 39) x = x + 5;
        if (e.getKeyCode() == 37) x = x - 5;
        if (player1.isOpen() == false) player1.open(carRunningSound);
        player1.loop(Clip.LOOP_CONTINUOUSLY);

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (player2.isOpen() == false) player2.open(fireSound);
            player2.start();
            rightFire();
        }
    }

    void stop() {
        carImage = carStopImage;
        player1.stop();
        player1.setFramePosition(0);
        player2.stop();
        player2.setFramePosition(0);
    }

    public void rightFire() {
        Bullet bullet = new Bullet(x, 450);
        bullets.add(bullet);
    }

    public void leftFire() {
        Bullet bullet = new Bullet(310, 450);
        bullets.add(bullet);

    }
}
