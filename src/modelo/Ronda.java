/*
 Autores:
 Sarahy Gisselle Caicedo Betancourth
 Kevin Andres Giron Villegas
 <sarahy.caicedo@correounivalle.edu.co>
 <kevin.giron@correounivalle.edu.co>
 Fecha creación: 2023-05-05
 Fecha última modificación: 2023-05-09
*/

package modelo;



/*
 *INTENCION: Tiene como proposito modelar el estado y comportamiento de la ronda de juego
 */


public class Ronda {
    public static int num = 1;

    public Ronda(int num) {

        this.num = num;
    }

    /*
    * Constructor de la clase
    */

    public Ronda(){}



    /*
    * Devuelve un valor que representa el numero maximo de veces que
    * se puede lanzar un dado en una ronda.
    */

    public int inhabilitar() {
        if (num >= 5) {
            return 5;
        } else {
            return 0;
        }
    }

    /*
    * Devuelve booleano que indica si la ronda ha llegado a su estado final o no.
    */

    public boolean estadoFinal(int cantidades, int numero){
        if(cantidades<1 && numero==1){

            num = numero;
            return true;
        }
        if (cantidades == 1 && numero == 2) {
            num = numero;
            return true;
        }
        if (cantidades == 1 && numero == 3) {
            num = numero;
            return true;
        }
        if (cantidades == 1 && numero == 4) {
            num = numero;
            return true;
        }
        if (cantidades == 1 && numero == 5) {
            num = numero;
            return true;
        } else {
            System.out.println("Valida y no");
            return false;
        }
    }


    /*
    * Devuelve el valor actual de la variable num
    */


    public int getNum() {
        return num;
    }

}
