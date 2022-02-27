import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Board extends JPanel {
    Image backgroundImage;
    Car car = new Car();

    Board() throws Exception {
        ImageIcon imageIcon = new ImageIcon("background.png");
        backgroundImage = imageIcon.getImage();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                try {
                    car.move(e);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                car.stop();
            }
        });
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, this);
        g.drawImage(car.carImage, car.x, 450, this);

        for (int w = 0; w < car.bullets.size(); w++) {
            Bullet m = (Bullet) car.bullets.get(w);
            m.fireRight();
            g.drawImage(m.bulletImage, m.x + 85, m.y + 10, null);
        }
        repaint();
    }
}