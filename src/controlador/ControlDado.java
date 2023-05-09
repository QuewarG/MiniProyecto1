package controlador;

import modelo.Dado;
import vista.ImagenDado;


public class ControlDado {

    private Dado modeloDado;
    private ImagenDado imagenDado;

    public static int lanzamientos, indice, nuevo, dados, cantidad;

    public static String[] caraPrincipal = new String[10];

    public static String[] caraOpuesta = new String[10];

    public ControlDado(Dado modeloDado, ImagenDado imagenDado) {

        this.modeloDado = modeloDado;
        this.imagenDado = imagenDado;

    }

    public ControlDado() {
        modeloDado = new Dado();
        imagenDado = new ImagenDado();
        this.nuevo = nuevo;

    }

    public void LanzarDado() {
        for (indice = 0; indice < 10; indice++) {
            lanzamientos = modeloDado.lanzar();
            imagenDado.imagenDelDado(lanzamientos, indice);
            caraPrincipal[indice] = String.valueOf(lanzamientos);
            int opuesto = modeloDado.caraOpuesta(lanzamientos);
            caraOpuesta[indice] = String.valueOf(opuesto);
        }
    }

    public String[] getCaraPrincipal() {
        return caraPrincipal;
    }

    public void metodo(int dado) {
        if (dado == 1) {
            dados = 1;
            nuevo = modeloDado.caraSuma(dado);
            ImagenDado.exitoso = true;
            imagenDado.mensaje(dado);

            System.out.println("Dado suma: " + nuevo);
        }
        if (dado == 2) {
            dados = 2;
            nuevo = modeloDado.corazon(dado);
            ImagenDado.exitoso = true;
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

    public int Estado(int cantidades) {
        ControlRonda controlRonda = new ControlRonda();
        if (dados == 1) {
            System.out.println("Entro al 42");
            dados = 1;
            cantidad = cantidades - 1;
            controlRonda.validacion(cantidad, dados);
            return dados;
        }
        if (dados == 2) {
            System.out.println("Entro al dragon");
            dados = 2;
            cantidad = cantidades - 1;
            controlRonda.validacion(cantidad, dados);
            return dados;
        }
        if (dados == 3) {
            System.out.println("Entro al meeple");
            dados = 3;
            cantidad = cantidades - 1;
            controlRonda.validacion(cantidad, dados);
            return dados;
        }
        if (dados == 4) {
            System.out.println("Entro a nave");
            dados = 4;
            cantidad = cantidades - 1;
            controlRonda.validacion(cantidad, dados);
            return dados;
        }
        if (dados == 5) {
            System.out.println("Entro a heroe");
            dados = 5;
            cantidad = cantidades - 1;
            controlRonda.validacion(cantidad, dados);
            return dados;
        }
        if (dados == 6) {
            System.out.println("Entro a corazon");
            dados = 6;
            cantidad = cantidades - 1;
            controlRonda.validacion(cantidad, dados);
            return dados;
        } else {
            return 0;
        }

    }


}


