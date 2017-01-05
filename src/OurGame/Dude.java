package OurGame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Dude {
int x, dx , y, dy, nx2, nx, h, b;
Image still, rstill, car, rcar, fly;
ImageIcon i = new ImageIcon("still.gif");
ImageIcon m = new ImageIcon("car.png");
ImageIcon n = new ImageIcon("rcar.png");
ImageIcon j = new ImageIcon("rstill.gif");
ImageIcon k = new ImageIcon("fly.gif");

public Dude(){
	still = m.getImage();
	fly = k.getImage();
	x = 50;
	y = 435;
	nx2 = 1024;
	nx = 0;
	dy = 0;
	h = 2;
	bullets = new ArrayList();
	b = 1;
}

static ArrayList bullets;

public void rightFire(){
    Bullet z = new Bullet(390, y+20);
    bullets.add(z);
    
}

public void leftFire(){
    Bullet z = new Bullet(310, y+20);
    bullets.add(z);
    
}
public static ArrayList getBullets(){
	return bullets;
}

public void move(){
	x = x + dx + dx;
	nx2 = nx2 + dx + dx;
	nx = nx + dx + dx;
	y = y + dy;
}

public int getX(){
	return x;
}

public int getY(){
	return y;
}

public int getdx(){
	return dx;
}

public int getnx2(){
	return nx2;
}

public int getnx(){
	return nx;
}

public void keyPressed(KeyEvent e){
	int key = e.getKeyCode();
	
	if (key == KeyEvent.VK_LEFT)
	{dx = -1; still = j.getImage();b = -1;}
	
	if (key == KeyEvent.VK_RIGHT)
	{dx = 1; still = i.getImage();b = 1;}
	
	if (key == KeyEvent.VK_UP)
		{dy = -1; h = 1;}
	
	if (key == KeyEvent.VK_SPACE && b == 1){
		rightFire();
	}
	
	if (key == KeyEvent.VK_SPACE && b == -1){
		leftFire();
	}
}

public void keyReleased(KeyEvent e){
	int key = e.getKeyCode();
	
	if (key == KeyEvent.VK_LEFT)
	{dx = 0; still = n.getImage();b = -1;}
	
	if (key == KeyEvent.VK_RIGHT)
	{dx = 0; still = m.getImage();b = 1;}
	
	if (key == KeyEvent.VK_UP)
		{dy = 2; h = 2;}
}

public Image getImage(){
	return still;
}

public Image getFlyImage(){
	return fly;
}

}
