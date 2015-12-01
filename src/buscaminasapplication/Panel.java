package buscaminasapplication;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel{
    private final static int numberRows = 6;
    private final static int numberColumns = 6;
    ArrayList<String> list = new ArrayList<>();
    private static JButton[][] tablero = new JButton[numberRows][numberColumns];
    Listener listener = new Listener();
    
    public Panel(){
        initBombs();
        initComponents();
    }

    private void initBombs() {
        for (int i = 1; i <= 30; i++) {
            list.add(String.valueOf(i));
        }
        for (int i = 31; i <= 36; i++) {
            list.add("BOMB");
        }
        Collections.shuffle(list);
    }

    private void initComponents() {
        GridLayout layout = new GridLayout(numberRows, numberColumns, 2, 2);
        this.setLayout(layout);
        int index=0;
        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberColumns; j++) {
                tablero[i][j] = new JButton();
                tablero[i][j].setName(list.get(index));
                tablero[i][j].setActionCommand(i+"-"+j);
                tablero[i][j].addActionListener(listener);
                this.add(tablero[i][j]);
                index++;
            }
        }
    }
    
    public static JButton[][] getTablero(){
        return tablero;
    }
}
