
package modelo;

import javax.swing.*;

public class Ronda {
    public static int num = 1;
    public Ronda(int num) {
        this.num = num;
    }

    public Ronda(){}

    public int inhabilitar() {
        if (num >= 5) {
            return 5;
        } else {
            return 0;
        }
    }

    public boolean estadoFinal(int cantidades, int numero){
        if(cantidades<1 && numero==1){
            num = numero;
            return true;
        }else{
            if(cantidades<1 && numero==2){
                num = numero;
                return true;
            }else{
                return false;
            }
        }
    }
    public int getNum() {
        return num;
    }

}
