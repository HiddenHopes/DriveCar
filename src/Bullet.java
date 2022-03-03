import javax.swing.*;
import java.awt.*;

public class Bullet {
    Image bulletImage;
    int x;
    int y;
    boolean direction;

    Bullet(int startX, int startY, boolean isRight) {
        x = startX;
        y = startY;
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
