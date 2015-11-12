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
            if(checkItsIn(tabla,pos1-1,pos2)&&!(tabla[pos1-1][pos2].getName().equals("Disabled"))){
                if(!tabla[pos1-1][pos2].getName().equals("BOMB")){
                    comp(tabla[pos1-1][pos2]);
                }
            }
            if(checkItsIn(tabla,pos1-1,pos2-1)&&!(tabla[pos1-1][pos2-1].getName().equals("Disabled"))){
                if(!tabla[pos1-1][pos2-1].getName().equals("BOMB")){
                    comp(tabla[pos1-1][pos2-1]);
                }
            }
            if(checkItsIn(tabla,pos1-1,pos2+1)&&!(tabla[pos1-1][pos2+1].getName().equals("Disabled"))){
                if(!tabla[pos1-1][pos2+1].getName().equals("BOMB")){
                    comp(tabla[pos1-1][pos2+1]);
                }
            }
            if(checkItsIn(tabla,pos1,pos2+1)&&!(tabla[pos1][pos2+1].getName().equals("Disabled"))){
                if(!tabla[pos1][pos2+1].getName().equals("BOMB")){
                    comp(tabla[pos1][pos2+1]);
                }
            }
            if(checkItsIn(tabla,pos1,pos2-1)&&!(tabla[pos1][pos2-1].getName().equals("Disabled"))){
                if(!tabla[pos1][pos2-1].getName().equals("BOMB")){
                    comp(tabla[pos1][pos2-1]);
                }
            }
            if(checkItsIn(tabla,pos1+1,pos2)&&!(tabla[pos1+1][pos2].getName().equals("Disabled"))){
                if(!tabla[pos1+1][pos2].getName().equals("BOMB")){
                    comp(tabla[pos1+1][pos2]);
                }
            }
        
            if(checkItsIn(tabla,pos1+1,pos2-1)&&!(tabla[pos1+1][pos2-1].getName().equals("Disabled"))){
                if(!tabla[pos1+1][pos2-1].getName().equals("BOMB")){
                    comp(tabla[pos1+1][pos2-1]);
                }   
            }
            if(checkItsIn(tabla,pos1+1,pos2+1)&&!(tabla[pos1+1][pos2+1].getName().equals("Disabled"))){
                if(!tabla[pos1+1][pos2+1].getName().equals("BOMB")){
                    comp(tabla[pos1+1][pos2+1]);
                }
            }
        }
    }
    
    private static int checkSurroundings(JButton[][] boton, int count, int posX, int posY){
        count+=checkUp(boton, 0, posX, posY)+checkSides(boton,0, posX, posY)+checkDown(boton,0, posX, posY);
        return count;
    }
    private static int checkUp(JButton[][] boton, int count, int pos1, int pos2){
        if(checkItsIn(boton,pos1-1,pos2)){
            if(boton[pos1-1][pos2].getName().equals("BOMB")){
                count++;
            }
        }
        if(checkItsIn(boton,pos1-1,pos2-1)){
            if(boton[pos1-1][pos2-1].getName().equals("BOMB")){
                count++;
            }
        }
        if(checkItsIn(boton,pos1-1,pos2+1)){
            if(boton[pos1-1][pos2+1].getName().equals("BOMB")){
                count++;
            }
        }
        return count;
    }
    private static int checkSides(JButton[][] boton, int count, int pos1, int pos2){
        if(checkItsIn(boton,pos1,pos2+1)){
            if(boton[pos1][pos2+1].getName().equals("BOMB")){
                count++;
            }
        }
        if(checkItsIn(boton,pos1,pos2-1)){
            if(boton[pos1][pos2-1].getName().equals("BOMB")){
                count++;
            }
        }
        return count;
    }
    private static int checkDown(JButton[][] boton, int count, int pos1, int pos2){
        if(checkItsIn(boton,pos1+1,pos2)){
            if(boton[pos1+1][pos2].getName().equals("BOMB")){
                count++;
            }
        }
        
        if(checkItsIn(boton,pos1+1,pos2-1)){
            if(boton[pos1+1][pos2-1].getName().equals("BOMB")){
                count++;
            }
        }
        if(checkItsIn(boton,pos1+1,pos2+1)){
            if(boton[pos1+1][pos2+1].getName().equals("BOMB")){
                count++;
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
