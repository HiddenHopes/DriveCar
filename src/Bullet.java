import javax.swing.*;
import java.awt.*;

public class Bullet {
    int x;
    int y;
    Image bulletImage;

    Bullet(int startX, int startY) {
        x = startX;
        y = startY;
        ImageIcon imageIcon = new ImageIcon("bullet.gif");
        bulletImage = imageIcon.getImage();
    }

    void fireRight() {
        x = x + 5;
    }

    void fireLeft() {
        x = x - 5;
    }
}
