import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Car {
    Image carImage;
    int x;
    Car(){
        ImageIcon imageIcon = new ImageIcon("car.png");
        carImage = imageIcon.getImage();
        x = 300;

    }
     public void whenkeypressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key== 39) x = x+2;
        if(key== 37) x= x-2;
    }
}
