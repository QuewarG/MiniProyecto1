/*
 Autores:
 Sarahy Gisselle Caicedo Betancourth
 Kevin Andres Giron Villegas
 <sarahy.caicedo@correounivalle.edu.co>
 <kevin.giron@correounivalle.edu.co>
 Fecha creación: 2023-05-04
 Fecha última modificación: 2023-05-07
*/
package controlador;

import modelo.Ronda;
import vista.GUI;
import vista.ImagenDado;

/*
*INTENCION: Tiene como proposito controlar y manejar la logica del juego para
*  determinar cuantas ondas se han jugado y validar si se ha llegado al final
*/

public class ControlRonda  {
    private Ronda num;
    private ImagenDado numero;

    public static int dado;
    private GUI vista;

    /*
    * Constructor de la clase
    */

    public ControlRonda(){
    }

    /*
    * Recibe como parametro el numero actual de la ronda y crea una instancia de la
    * clase ronda para verificar si se ha alcanzado el limite de 5 rondas.
    */

    public int rondas(int ron){
        num = new Ronda(ron);
        if(num.inhabilitar()<=5){
            return num.getNum();
        }else{
            return num.getNum();
        }
    }

    /*
    * Recibe la cantidad de caras en una ronda y el numero de dado correspondiente,
    * crea una instancia de la clase Ronda y llama a la funcion estadoFinal, determinando
    * si se ha llegado al final del juego.
    */

    public void validacion(int cantidad, int numero){
        num = new Ronda();
        if(num.estadoFinal(cantidad, numero)){
            if(num.getNum()==1){
                System.out.println("Verdadero para suma " + num.getNum());
            }
            if(num.getNum()==2){
                System.out.println("Estamos aqui verdadero para dragon " + num.getNum());
            }
            if(num.getNum()==3){
                System.out.println("Estamos aqui verdadero para meeple " + num.getNum());
            }
            if(num.getNum()==4){
                System.out.println("Estamos aqui verdadero para nave " + num.getNum());
            }
            if(num.getNum()==5){
                System.out.println("Estamos aqui verdadero para corazon " + num.getNum());
            }
        }else if(!num.estadoFinal(cantidad, numero)){
            System.out.println("Llego hasta aqui: "+ numero);
        }

    }





}
