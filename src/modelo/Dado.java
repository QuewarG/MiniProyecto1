/*
 Autores:
 Sarahy Gisselle Caicedo Betancourth
 Kevin Andres Giron Villegas
 <sarahy.caicedo@correounivalle.edu.co>
 <kevin.giron@correounivalle.edu.co>
 Fecha creación: 2023-05-05
 Fecha última modificación: 2023-05-08
*/
package modelo;

/*
 *INTENCION: Esta clase tiene como proposito representar el dado
 * que puede ser lanzando y obtener el resultado de los lanzamientos.
 */

public class Dado {
    private int volverALanzar;
    private final String[] cara = new String[]{"42", "Dragon", "Meeple", "Nave", "Heroe", "Corazon"};
    public static String Caras;

    /*
    * Constructor de la clase
    */

    public Dado() {

    }



    /*
    * Devuelve el numero de la cara del dado, exceoti si ha salido la cara 42
    * cuyo caso devuelve el 42
    */
    public int caraSuma(int dado) {
        if (1 == dado) {
            dado = dado+0;
        }
        return dado;
    }


    /*
    * Devuelve un numero aleatorio entre 1 y 6
    */

    public int lanzar() {
        return (int) (Math.random() * 6) + 1;
    }



    /*
    * Devuelve un valor booleano que indica si ha salido la cara
    * dragon
    */


    public boolean dragon(int dado) {
        if (2 == dado) {
            return true;

        } else {
            return false;
        }
    }




    /*
    * Esta funcion devuelve un numero aleatorio, que representa el resultado
    * de volver a lanzar el dado, siempre y cuando haya salido la caara
    * meeple
    */


    public int meeple(int dado) {
        if (3 == dado) {
            volverALanzar = this.lanzar();
            return volverALanzar;
        }
        return volverALanzar;

    }

    /*
    * Devuelve el numero de la cara, solo si ha salido la cara nave
    */

    public int nave(int dado) {
        if (4 == dado) {
            return dado;
        } else {
            return 0;
        }

    }


    /*
    * Devuelve el numero de la cara, solo si ha salido la cara heroe
    */


    public int heroe(int dado) {
        if (5 == dado) {
            return dado;
        } else {
            return 0;
        }

    }


    /*
     * Dada la cara del dado que ha salido, devuelve el
     * numero de la cara opuesta
     */
    public int caraOpuesta(int dado) {
        int opuesto = 7 - dado;
        return opuesto;
    }

    /*
     * Devuelve un numero eleatorio que representa el resultado de
     * volver a lanzar el dado. Solo si ha salido la cara corazon
     */

    public int corazon(int dado) {
        if (6 == dado) {
            volverALanzar = this.lanzar();
            return volverALanzar;
        } else {
            return 0;
        }
    }

    /*
     * Devuelve nombre de la cara,en forma de cadena de caracteres
     */

    public String getCaras(int dado) {
        Caras = cara[dado - 1];
        return Caras;
    }
}


