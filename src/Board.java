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
    Enemy enemy;

    public Board() throws Exception {
        ImageIcon imageIcon = new ImageIcon("background.png");
        backgroundImage = imageIcon.getImage();
        car = new Car();
        enemy = new Enemy();
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
        g.drawImage(backgroundImage, car.backgroundX1, 0, this);
        //System.out.println("backgroundX1 = " + car.backgroundX1);
        g.drawImage(backgroundImage, car.backgroundX2, 0, this);
        //System.out.println("backgroundX2 = "+ car.backgroundX2);
        g.drawImage(car.carImage, 120, 450, this);
        for (Bullet b : car.bullets) {
            if (0 < b.x && b.x < 1048) g.drawImage(b.bulletImage, b.x, b.y, this);
        }
        g.drawImage(enemy.enemyImage, enemy.enemyX, enemy.enemyY,this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        car.move();
        for (Bullet b : car.bullets) {
            if (b.direction) b.fireRight();
            else b.fireLeft();

            if(Math.abs((b.x+15)-(enemy.enemyX+25))<10)
                if(Math.abs((b.y+15)-(enemy.enemyY+25))<10)
                enemy.destroy();
        }
        if(car.backgroundX1<=-1024) car.backgroundX1 = car.backgroundX2+1024;
        if(car.backgroundX2<=-1024) car.backgroundX2 = car.backgroundX1+1024;
        if(car.backgroundX1>=1024) car.backgroundX1 = car.backgroundX2-1024;
        if(car.backgroundX2>=1024) car.backgroundX2 = car.backgroundX1-1024;
        enemy.fly();
        repaint();
    }
}
