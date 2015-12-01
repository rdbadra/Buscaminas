package buscaminasapplication;

import javax.swing.JButton;

public class Comprobar {
    public static void comp(JButton boton){
        String pos =boton.getActionCommand();
        JButton[][] tabla = Panel.getTablero();
        String[] split = pos.split("-");
        int pos1 = Integer.parseInt(split[0]);
        int pos2 = Integer.parseInt(split[1]);
        System.out.println(pos1+" "+pos2);
        int count = 0;
        int message = checkSurroundings(tabla,count,pos1,pos2);
        boton.setText(""+message);
        boton.setEnabled(false);
        boton.setName("Disabled");
        if(boton.getText().equals("0")){
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    if(checkItsIn(tabla,pos1+i,pos2+j)&&!(tabla[pos1+i][pos2+j].getName().equals("Disabled"))){
                        if(!tabla[pos1+i][pos2+j].getName().equals("BOMB")){
                            comp(tabla[pos1+i][pos2+j]);
                        }
                    }
                }
            }
        }
    }
    
    private static int checkSurroundings(JButton[][] boton, int count, int posX, int posY){
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(checkItsIn(boton,posX+i,posY+j)){
                    if(boton[posX+i][posY+j].getName().equals("BOMB")){
                        count++;
                    }
                }
            }
        }
        return count;
    }
   
    private static boolean checkItsIn(JButton[][] boton, int pos1, int pos2){
        int end = boton.length;
        if(pos1>=end || pos2>=end){
            return false;
        }
        if(pos1<0 || pos2<0){
            return false;
        }
        return true;
    }
}
