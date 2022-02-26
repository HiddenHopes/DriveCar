import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Car {
    Image carImage;
    Image carStopImage;
    Image carRunningRight;
    ImageIcon carImageIcon;
    int x;

    Car() {
        carImageIcon = new ImageIcon("car.png");
        carStopImage = carImageIcon.getImage();

        carImageIcon = new ImageIcon("carRunningRight.gif");
        carRunningRight = carImageIcon.getImage();

        carImage = carStopImage;
        x = 120;
    }

    void move(KeyEvent e) {
        carImage = carRunningRight;
        if(e.getKeyCode() == 39) x = x+5;
        if(e.getKeyCode() == 37) x = x-5;
    }

    void stop(){
        carImage = carStopImage;
    }
}
