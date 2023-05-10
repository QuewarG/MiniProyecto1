/*
 Autores:
 Sarahy Gisselle Caicedo Betancourth
 Kevin Andres Giron Villegas
 <sarahy.caicedo@correounivalle.edu.co>
 <kevin.giron@correounivalle.edu.co>
 Fecha creación: 2023-05-05
 Fecha última modificación: 2023-05-07
*/
package controlador;

import modelo.Dado;
import vista.ImagenDado;

/*
*INTENCION:Tiene como proposito controlar y manejar la logica de los dados
*/

public class ControlDado {

    private Dado modeloDado;
    private ImagenDado imagenDado;

    public static int lanzamientos, indice, nuevo, dados, cantidad;
    public static boolean determinante = false;
    public static String[] caraPrincipal = new String[10];

    public static String[] caraOpuesta = new String[10];


    /*
    * Contructor de la clase
    */

    public ControlDado(Dado modeloDado, ImagenDado imagenDado) {

        this.modeloDado = modeloDado;
        this.imagenDado = imagenDado;

    }

    /*
     * Constructor de la clase, Crea objetos de la clase Dado e ImagenDado, como tambien de la clase
     * ControlDado
     */

    public ControlDado() {
        modeloDado = new Dado();
        imagenDado = new ImagenDado();
        this.nuevo = nuevo;

    }

    /*
    * Lanza el dado y almacena los resultados enlos arreglos caraPrincipal y
    * caraOpuesta
    */

    public void LanzarDado() {
        for (indice = 0; indice < 10; indice++) {
            lanzamientos = modeloDado.lanzar();
            imagenDado.imagenDelDado(lanzamientos, indice);
            caraPrincipal[indice] = String.valueOf(lanzamientos);
            int opuesto = modeloDado.caraOpuesta(lanzamientos);
            caraOpuesta[indice] = String.valueOf(opuesto);
        }
    }

    /*
    * Devuelve el arreglo caraPrincipal
    */

    public String[] getCaraPrincipal() {
        return caraPrincipal;
    }

    /*
    * Determina el valor del lanzamiento actual y muestra la imagen correspondiente
    * del dado en la interfaz.
    */

    public void metodo(int dado) {
        if (dado == 1) {
            dados = 1;
            nuevo = modeloDado.caraSuma(dado);
            imagenDado.mensaje(dado);
            determinante = true;
            System.out.println("Dado suma: " + nuevo);
        }
        if (dado == 2) {
            dados = 2;
            nuevo = modeloDado.corazon(dado);
            imagenDado.mensaje(dado);
            System.out.println("Dado perdedor: " + nuevo);
        }

        if (dado == 3) {
            dados = 3;
            nuevo = modeloDado.meeple(dado);
            ImagenDado.exitoso = true;
            imagenDado.mensaje(dado);


            System.out.println("Dado nuevo: " + nuevo);
        }
        if (modeloDado.nave(dado) == 4) {
            dados = 4;
            nuevo = modeloDado.nave(dado);
            ImagenDado.exitoso = true;
            imagenDado.mensaje(dado);
            System.out.println("Dado inactivo: " + nuevo);

        }
        if (modeloDado.heroe(dado) == 5) {
            dados = 5;
            nuevo = modeloDado.heroe(dado);
            ImagenDado.exitoso = true;
            imagenDado.mensaje(dado);
            System.out.println("Cara opuesta: " + nuevo);

        }
        if (dado == 6) {
            dados = 6;
            nuevo = modeloDado.corazon(dado);
            ImagenDado.exitoso = true;
            imagenDado.mensaje(dado);
            System.out.println("Dado volverse activar: " + nuevo);

        } else if (modeloDado.caraSuma(dado) == 42) {
            System.out.println("Si paso" + dado);
        }

    }

    /*
    * Se utiliza para determinar el estado actual del juego y llevar a cabo acciones
    * cprrespondientes
    */

    public int Estado(int cantidades) {
        ControlRonda controlRonda = new ControlRonda();
        if (dados == 1) {
            System.out.println("Entro al 42");
            dados = 1;
            cantidad = cantidades;
            controlRonda.validacion(cantidad, dados);
            return dados;
        }
        if (dados == 2) {
            System.out.println("Entro al dragon");
            dados = 2;
            cantidad = cantidades;
            controlRonda.validacion(cantidad, dados);
            return dados;
        }
        if (dados == 3) {
            System.out.println("Entro al meeple");
            dados = 3;
            cantidad = cantidades;
            controlRonda.validacion(cantidad, dados);
            return dados;
        }
        if (dados == 4) {
            System.out.println("Entro a nave");
            dados = 4;
            cantidad = cantidades;
            System.out.println("Hay " + cantidad);
            controlRonda.validacion(cantidad, dados);
            return dados;
        }
        if (dados == 5) {
            System.out.println("Entro a heroe");
            dados = 5;
            cantidad = cantidades;
            controlRonda.validacion(cantidad, dados);
            return dados;
        }
        if (dados == 6) {
            System.out.println("Entro a corazon");
            dados = 6;
            cantidad = cantidades;
            controlRonda.validacion(cantidad, dados);
            return dados;
        } else {
            return 0;
        }

    }


}


