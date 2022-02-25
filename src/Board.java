import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Board extends JPanel implements ActionListener {
    Image carbg;
    Car car;
    Timer time;

    Board(){
        ImageIcon imageIcon = new ImageIcon("carbg.png");
        carbg = imageIcon.getImage();
        car = new Car();
        addKeyListener(new AL());
        setFocusable(true);
        time = new Timer(5,this);
        time.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(carbg, 0,0, this);
        g.drawImage(car.carImage, car.x,450, this );
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
   private class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            car.whenkeypressed(e);
        }
    }

}
