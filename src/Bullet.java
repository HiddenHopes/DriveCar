import javax.swing.*;
import java.awt.*;

public class Bullet {
    Image bulletImage;
    int x;
    int y;
    boolean direction;

    Bullet(boolean isRight) {
        x = 120;
        y = 450;
        ImageIcon imageIcon = new ImageIcon("bullet.gif");
        bulletImage = imageIcon.getImage();
        direction = isRight;
    }

    void fireRight() {
        x = x + 15;
    }

    void fireLeft() {
        x = x - 15;
    }
}
