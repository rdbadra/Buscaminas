package buscaminasapplication;

import javax.swing.JFrame;

public class BuscaminasApplication {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Panel panel = new Panel();
        frame.add(panel);
        frame.setBounds(500, 200, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
