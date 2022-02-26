import java.io.File;

import javax.sound.sampled.*;
import javax.swing.*;


public class Frame {
	
	
	public static void main(String[]args) throws Exception{
		JFrame frame = new JFrame("Drive Car");
		
		frame.add(new Board());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024,548);
		frame.setVisible(true);
		
		AudioInputStream sample;
		sample = AudioSystem.getAudioInputStream(new File("rap.wav"));
		
		Clip clip = AudioSystem.getClip();
		clip.open(sample);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
