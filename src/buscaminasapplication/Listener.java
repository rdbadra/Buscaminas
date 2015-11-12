package buscaminasapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Listener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        String dir ="/Users/roberto/NetBeansProjects/BuscaminasApplication/buscaminas.png";
        JButton boton = (JButton) e.getSource();
        if(boton.getName().equals("BOMB")){
            Icon image = new ImageIcon(dir);
            boton.setIcon(image);
            //boton.setText("BOMB");
        } else {
            Comprobar.comp(boton);
        }
    }
}
