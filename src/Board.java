import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Board extends JPanel {
    Image backgroundImage;
    Car car;

    Board() {
        ImageIcon imageIcon = new ImageIcon("background.png");
        backgroundImage = imageIcon.getImage();
        car = new Car();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==39) car.x = car.x + 5;
                if(e.getKeyCode()==37) car.x = car.x - 5;
            }
        });
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, this);
        g.drawImage(car.carImage, car.x, 450, this);
        repaint();
    }
}
