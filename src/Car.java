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

    Image carRightImage;
    Image carLeftImage;
    Image carRunningRight;
    Image carRunningLeft;
    ImageIcon imageIcon;

    int x;

    AudioInputStream carDriveSound;
    Clip carSoundPlayer;
    AudioInputStream fireSound;
    Clip fireSoundPlayer;

    List<Bullet> bullets;
    boolean isRight;

    boolean isRightKeyPressed;
    boolean isLeftKeyPressed;
    boolean isSpaceKeyPressed;

    Car() throws Exception {
        imageIcon = new ImageIcon("carRight.png");
        carRightImage = imageIcon.getImage();

        imageIcon = new ImageIcon("carLeft.png");
        carLeftImage = imageIcon.getImage();

        imageIcon = new ImageIcon("runningRight.gif");
        carRunningRight = imageIcon.getImage();

        imageIcon = new ImageIcon("runningLeft.gif");
        carRunningLeft = imageIcon.getImage();

        carImage = carRightImage;
        x = 300;


        carDriveSound = AudioSystem.getAudioInputStream(new File("car_drive_sound.wav"));
        carSoundPlayer = AudioSystem.getClip();
        if (carSoundPlayer.isOpen() == false) carSoundPlayer.open(carDriveSound);

        fireSound = AudioSystem.getAudioInputStream(new File("fire_sound.wav"));
        fireSoundPlayer = AudioSystem.getClip();
        if (fireSoundPlayer.isOpen() == false) fireSoundPlayer.open(fireSound);

        bullets = new ArrayList<>();
        isRight = true;

        isRightKeyPressed = false;
        isLeftKeyPressed = false;
        isSpaceKeyPressed = false;

    }

    void whenKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39) {
            isRightKeyPressed = true;
        }
        if (e.getKeyCode() == 37) {
            isLeftKeyPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isSpaceKeyPressed = true;
            fireSoundPlayer.stop();
            fireSoundPlayer.setFramePosition(0);
        }
    }

    void whenKeyReleased(KeyEvent e) {
        if (e.getKeyCode() == 39) {
            isRightKeyPressed = false;
            carImage = carRightImage;
            carSoundPlayer.stop();
            carSoundPlayer.setFramePosition(0);
        }
        if (e.getKeyCode() == 37) {
            isLeftKeyPressed = false;
            carImage = carLeftImage;
            carSoundPlayer.stop();
            carSoundPlayer.setFramePosition(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE && isSpaceKeyPressed) {
            isSpaceKeyPressed = false;
            Bullet bullet = new Bullet(x, 450, isRight);
            bullets.add(bullet);
            fireSoundPlayer.start();
        }
    }

    void move() {
        if (isRightKeyPressed) {
            carImage = carRunningRight;
            x = x + 5;
            carSoundPlayer.loop(Clip.LOOP_CONTINUOUSLY);
            isRight = true;
        }
        if (isLeftKeyPressed) {
            carImage = carRunningLeft;
            x = x - 5;
            carSoundPlayer.loop(Clip.LOOP_CONTINUOUSLY);
            isRight = false;
        }
    }
}
