package controlador;

import modelo.Ronda;
import vista.GUI;
import vista.ImagenDado;

public class ControlRonda  {
    private Ronda num;
    private ImagenDado numero;

    public static int dado;
    private GUI vista;
    public ControlRonda(){
    }

    public int rondas(int ron){
        num = new Ronda(ron);
        if(num.inhabilitar()<=5){
            return num.getNum();
        }else{
            return num.getNum();
        }
    }

    public void validacion(int cantidad, int numero){
        num = new Ronda();
        if(num.estadoFinal(cantidad, numero)){
            if(num.getNum()==1){
                System.out.println("Verdadero para suma " + num.getNum());
            }else{
                GUI.dragon(num.getNum());
                System.out.println("Estamos aqui verdadero para dragon " + num.getNum());
            }

        }else{
            System.out.println("Llego hasta aqui: "+ cantidad);
            num.estadoFinal(cantidad, numero);
        }

    }



}
