import javax.swing.*;

public class Frame {
    public static void main(String[]args) throws Exception {
        JFrame frame = new JFrame();
        frame.setSize(1048, 540);
        frame.add(new Board());
        frame.setVisible(true);
    }
}