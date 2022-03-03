import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {
    Image backgroundImage;
    Car car;
    Timer timer;

    public Board() throws Exception {
        ImageIcon imageIcon = new ImageIcon("background.png");
        backgroundImage = imageIcon.getImage();
        car = new Car();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                try {
                    car.whenKeyPressed(e);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                car.whenKeyReleased(e);
            }
        });
        setFocusable(true);
        timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, this);
        g.drawImage(car.carImage, car.x, 450, this);
        for (Bullet b : car.bullets) {
            if (0 < b.x && b.x < 1048) g.drawImage(b.bulletImage, b.x, 450, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        car.move();
        for (Bullet b : car.bullets) {
            if (b.direction) b.fireRight();
            else b.fireLeft();
        }

        repaint();
    }
}
