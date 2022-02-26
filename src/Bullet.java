import java.awt.*;

import javax.swing.ImageIcon;

public class Bullet {
    int x, y;
    Image img;
    boolean visible = true;

    public Bullet(int startX, int startY) {
        x = startX;
        y = startY;
        ImageIcon newBullet = new ImageIcon("D:/eclipse/DriveCar/bullet.gif");
        img = newBullet.getImage();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getVisible() {
        return visible;
    }

    public Image getImage() {
        return img;
    }

    public void rightMove() {
        x = x + 5;
        if (x > 1024) visible = false;
    }

    public void leftMove() {
        x = x - 5;
        if (x < 0) visible = false;
    }
}
