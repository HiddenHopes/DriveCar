import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.TimerTask;

public class Enemy {
    Image enemyImage;
    Image enemyAliveImage;
    Image enemyDestroyImage;
    int enemyX;
    int enemyY;
    int dy;
    boolean isFlyUp;
    int flyUpCount;

    AudioInputStream enemyDestroySound;
    Clip clip;

    Enemy() throws Exception{
        ImageIcon imageIcon = new ImageIcon("enemy.gif");
        enemyAliveImage = imageIcon.getImage();
        imageIcon = new ImageIcon("enemyDestroy.gif");
        enemyDestroyImage = imageIcon.getImage();
        enemyX = 600;
        enemyY = 100;
        dy = 1;
        isFlyUp = true;
        flyUpCount = 0;
        enemyImage = enemyAliveImage;
        enemyDestroySound = AudioSystem.getAudioInputStream(new File("enemy_destroy_sound.wav"));
        clip = AudioSystem.getClip();
        if(clip.isOpen()==false) clip.open(enemyDestroySound);
    }

    void fly(){
        if(isFlyUp){
            enemyY = enemyY + dy;
            flyUpCount++;
            if (flyUpCount == 120) isFlyUp = false;
        }
        else {
            enemyY = enemyY - dy;
            flyUpCount--;
            if(flyUpCount==0) isFlyUp = true;
        }
    }

    void destroy(){
        clip.start();
        enemyImage = enemyDestroyImage;
        new Thread() {
            @Override
            public void run() {
                try {
                    this.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                enemyImage = enemyAliveImage;
                clip.stop();
                clip.setFramePosition(0);
            }
        }.start();

    }
}
