/*
 Autores:
 Sarahy Gisselle Caicedo Betancourth
 Kevin Andres Giron Villegas
 <sarahy.caicedo@correounivalle.edu.co>
 <kevin.giron@correounivalle.edu.co>
 Fecha creación: 2023-05-01
 Fecha última modificación: 2023-05-06
*/

package vista;

import controlador.ControlDado;
import controlador.ControlRonda;
import modelo.Dado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;



/*
 INTENCION: Esta clase tiene como porposito crear los dados y escuchar los eventos.
 */


public class ImagenDado {
    private ControlDado controlito;
    private Titulo titulo;
    public static boolean exitoso;
    public JButton[] dadito, puntaje;
    private String texto;
    private JPanel dadosActivos, dadosInactivos, dadosUtilizados, tablaPuntaje;
    public static JButton botonPresionado;
    public static Component[] components;
    private Listener listener;
    public static String[] etiquetasArray;
    private static String[] numero = new String[]{"", "", "1", "3", "6", "10", "15", "21", "28", "36", "45", "55"};
    private int botonPresionadoSinPoder;
    public static int respuesta,dadosEnelPanel, dadosEnelpanelIna, dadosEnelPanelUti;

    private Fondo fondo;

    /*
    * Constructor de la clase, este crea un array de 10 botones llamado dadito
    * y los divide en dos paneles, dadosActivos y dadosInactivos. Los primeros
    * 7 botones se agregan al panel dadosActivos, los otros 3 a los dadosInactivos.
    * Tambien se establecen algunas propiedadesde los botones, como el tamaño, visibilidad
    * y estado habilitado/deshabilitado.
    */


    public ImagenDado() {
        dadito = new JButton[10];
        listener = new Listener();
        titulo = new Titulo();
        dadosActivos = new JPanel(new GridLayout(3, 3, 10, 10));
        dadosActivos.setOpaque(false);
        dadosInactivos = new JPanel();
        dadosInactivos.setOpaque(false);
        dadosInactivos.setPreferredSize(new Dimension(200, 200));
        for (int i = 0; i < 10; i++) {
            if (i < 7) {
                dadito[i] = new JButton();
                dadito[i].setPreferredSize(new Dimension(80, 80));
                dadito[i].addActionListener(listener);
                dadito[i].addMouseListener(listener);
                dadito[i].setVisible(false);
                dadosActivos.add(dadito[i]);
                texto = "Dados activos";
                dadosActivos.setBorder(titulo.gettitulo(texto));

            } else if (i > 6) {
                dadito[i] = new JButton();
                dadito[i].setPreferredSize(new Dimension(80, 80));
                dadosInactivos.add(dadito[i], BorderLayout.CENTER);
                dadito[i].setEnabled(false);
                dadito[i].setVisible(false);
                dadito[i].addActionListener(listener);
                dadito[i].addMouseListener(listener);
                texto = "Dados inactivos";
                dadosInactivos.setBorder(titulo.gettitulo(texto));
            }

        }
    }

    /*
    * Hace que los botones de una arrelo de botones se vuelvan visibes
    * en la pantalla. El while itera a traves del arreglo de botones y
    * establece la visibilidad de cada boton en true.
    */

    public boolean mostrarBotones() {
        int i = 0;
        while (i < 10) {
            dadito[i].setVisible(true);
            i++;
        }
        return true;
    }

    /*
    * Muestra una imagen de un dado en un boton en un arreglo de botones,
    * recibe como parametros el valor del dado (un numero entre 1 y 6) y
    * el indice del boton. Luego, carga la imagen correspndiente a la cara
    * en un imageIcon, estableciendo el valor del dado como el comando de
    * accion del boton mostrandolo en consola.
    */

    public void imagenDelDado(int dados, int indice) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("/recursos/Cara-" + dados + ".png"));
        Image imageEscala = imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon imagenFinal = new ImageIcon(imageEscala);
        dadito[indice].setIcon(imagenFinal);
        texto = "" + dados;
        dadito[indice].setActionCommand(texto);
        System.out.println("Entra a la función y colocan la imagen " + dadito[indice].getActionCommand() + "este es el indice" + indice);
    }

    /*
    * Retorna los dadosActivos
    */

    public JPanel getDadosActivos() {
        return dadosActivos;
    }

    /*
    * Establece el diseño de cuadrícula, agrega los componentes al panel y
    * devuelve el panel. También establece la opacidad del panel en falso
    * para que el fondo del panel debajo de él sea visible.
    */

    public JPanel getDadosUtilizados() {
        dadosUtilizados = new JPanel(new GridLayout(3, 3, 10, 10));
        texto = "Dados Utilizados";
        dadosUtilizados.setBorder(titulo.gettitulo(texto));
        dadosUtilizados.setOpaque(false);
        return dadosUtilizados;
    }

    /*
    * Devuelve un JPanel que representa una tabla de puntajes. La tabla tiene 3 filas y 4 columnas,
    * y cada celda es un botón que contiene un número del 0 al 9 y dos botones adicionales que están ocultos.
    * La imagen del fondo se carga desde un archivo de recursos en la carpeta «recursos» del proyecto.
    */

    public JPanel getTablaPuntaje() {
        tablaPuntaje = new JPanel();
        tablaPuntaje = new Fondo(new ImageIcon(getClass().getResource("/recursos/FondoPuntaje.png")).getImage());
        tablaPuntaje.setLayout(new GridLayout(3, 4, 10, 10));
        texto = "Marcador de puntaje";
        tablaPuntaje.setBorder(titulo.gettitulo(texto));
        puntaje = new JButton[12];
        tablaPuntaje.setOpaque(false);
        for (int i = 0; i < puntaje.length; i++) {
            puntaje[i] = new JButton(numero[i]);
            puntaje[i].setPreferredSize(new Dimension(80, 80));
            puntaje[i].setBackground(new Color(0, 0, 0, 0));
            puntaje[i].setForeground(Color.black);
            puntaje[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            puntaje[i].setBorderPainted(true);
            puntaje[i].setOpaque(false);
            puntaje[i].setFont(new Font(puntaje[i].getFont().getName(), Font.PLAIN, 40));
            tablaPuntaje.add(puntaje[i], BorderLayout.CENTER);
        }
        puntaje[0].setVisible(false);
        puntaje[1].setVisible(false);
        return tablaPuntaje;
    }

    /*
    * Retorna los dadosInactivos
    */

    public JPanel getDadsInactivation() {
        return dadosInactivos;
    }

    /*
    * Muestra un mensaje emergente, se utiliza un swicth-case para determinar
    * que mensaje se debe mostrar.
    */

    public void mensaje(int dado) {

        switch (dado) {
            case 1:
                JOptionPane.showConfirmDialog(null,
                        "De clic en validar dados", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                break;
            case 2:
                JOptionPane.showConfirmDialog(null,
                        "De clic en validar dados", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                break;
            case 3:
                JOptionPane.showConfirmDialog(null,
                        "Por favor de doble clic sobre el dado que desea reelanzar", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                break;
            case 4:
                JOptionPane.showConfirmDialog(null,
                        "Por favor de doble clic sobre el dado que desea inactivar", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                break;
            case 5:
                JOptionPane.showConfirmDialog(null
                        , "Por favor de doble clic sobre el dado que desea ver su cara opuesta", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);

                break;
            case 6:
                JOptionPane.showConfirmDialog(null,
                        "De doble clic sobre el dado de los dados\n" + "inactivos que desea activar", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                break;
            default:
                System.out.println("FALLO");
                break;
        }

    }



    /*
    *  Devuelve un arreglo de los componenetes que estan dentro del panel
    * dadosActivos y los imprime en la consola.
    */
    public Component[] actualizar(){
        Component[] componentes = dadosActivos.getComponents();
        return componentes;
    }

    /*
    * Maneja los eventos de boton y realiza una serie de acciones que incluyen
    * la eliminacion de un boton presionado y su traslado a otra aera de la
    * interfaz grafica, el metodo mouseClicked maneja los eventos de clics del mouse
    * y realiza acciones adicionales en el boton presionado reubicandolo en la interfaz.
    */

    public class Listener implements ActionListener, MouseListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            controlito = new ControlDado();
            components = actualizar();
            botonPresionado = (JButton) e.getSource();
            dadosEnelPanel = dadosActivos.getComponentCount();
            dadosEnelPanelUti = dadosUtilizados.getComponentCount();
            dadosEnelpanelIna = dadosInactivos.getComponentCount();

            if (exitoso == false) {
                for (int i = 0; i < controlito.getCaraPrincipal().length; i++) {
                    botonPresionadoSinPoder = Integer.parseInt(e.getActionCommand());
                    if (botonPresionado == dadito[i] && botonPresionadoSinPoder != 1 && botonPresionadoSinPoder != 2) {
                        dadosActivos.remove(dadito[i]);
                        dadosUtilizados.add(dadito[i]).setEnabled(false);
                        dadosUtilizados.revalidate();
                        dadosInactivos.revalidate();
                        dadosActivos.revalidate();
                        dadosUtilizados.repaint();
                        dadosInactivos.repaint();
                        dadosActivos.repaint();
                        controlito.metodo(Integer.parseInt(e.getActionCommand()));
                        break;
                    }
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            controlito = new ControlDado();
            ControlRonda controlRonda = new ControlRonda();
            Dado modeloDado = new Dado();
            String dado = "";
            String opuesto = "";
            System.out.println("Iniciamos con " + dadosEnelPanel + " dados activos, "
                    + dadosEnelpanelIna + " dados inactivos y dados utilizados " + dadosEnelPanelUti);

            try {
                if (botonPresionadoSinPoder == 1) {
                    controlito.metodo(botonPresionadoSinPoder);
                    if(controlito.determinante == true) {

                        int dices = -1;
                        for (int j = 0; j < dadito.length; j++) {
                            if (dadito[j] == e.getSource()) {
                                dices = j;
                                exitoso = false;
                                break;
                            }
                        }
                        if (dices != -1 && exitoso == false) {
                            ImageIcon imagen = new ImageIcon(getClass().getResource("/recursos/Cara-" + botonPresionadoSinPoder + ".png"));
                            Image imageEscala = imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                            ImageIcon imagenFinal = new ImageIcon(imageEscala);
                            puntaje[2].setIcon(imagenFinal);
                            dadosActivos.remove(dadito[dices]);
                            dadosUtilizados.revalidate();
                            dadosInactivos.revalidate();
                            dadosActivos.revalidate();
                            dadosUtilizados.repaint();
                            dadosInactivos.repaint();
                            dadosActivos.repaint();
                            components = actualizar();
                        }
                        System.out.println("Sale 42");
                    }
                }
                if (botonPresionadoSinPoder == 2) {
                    controlito.metodo(botonPresionadoSinPoder);
                    System.out.println("sale dragon");
                    components = actualizar();
                }
                if (exitoso == true && controlito.Estado(dadosEnelPanel) == 3) {
                    if (e.getClickCount() == 2 && botonPresionado.getParent() == dadosActivos) {
                        int dices = -1;
                        for (int i = 0; i < dadito.length; i++) {
                            if (dadito[i] == e.getSource()) {
                                dices = i;
                                exitoso = false;

                                break;
                            }
                        }

                        if (dices != -1 && exitoso == false) {
                            int caraNueva = controlito.nuevo;
                            imagenDelDado(caraNueva, dices);
                            dadosUtilizados.revalidate();
                            dadosInactivos.revalidate();
                            dadosActivos.revalidate();
                            dadosUtilizados.repaint();
                            dadosInactivos.repaint();
                            dadosActivos.repaint();
                            respuesta=JOptionPane.showConfirmDialog(null, "La cara cambio a : "
                                    + modeloDado.getCaras(caraNueva), "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                            components = actualizar();

                        }

                        System.out.println("sale meeple");
                    }
                } else if (exitoso == true && controlito.Estado(dadosEnelPanel) == 4) {

                    if (e.getClickCount() == 2 && botonPresionado.getParent() == dadosActivos) {

                        int dices = -1;
                        for (int i = 0; i < dadito.length; i++) {
                            if (dadito[i] == e.getSource()) {
                                dado = dadito[i].getActionCommand();
                                dices = i;
                                exitoso = false;
                                break;
                            }
                        }
                        if (dices != -1 && exitoso == false) {
                            dadosActivos.remove(dadito[dices]);
                            dadito[dices].setEnabled(false);
                            dadosInactivos.add(dadito[dices]);
                            dadosInactivos.revalidate();
                            dadosUtilizados.revalidate();
                            dadosInactivos.revalidate();
                            dadosActivos.revalidate();
                            dadosUtilizados.repaint();
                            dadosInactivos.repaint();
                            dadosActivos.repaint();
                            respuesta=JOptionPane.showConfirmDialog(null,
                                    "Se inactivo el dado: " + modeloDado.getCaras(Integer.parseInt(dado)),
                                    "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                            components = actualizar();
                        }
                        System.out.println("sale nave");
                    }
                } else if (exitoso == true && controlito.Estado(dadosEnelPanel) == 5) {

                    if (e.getClickCount() == 2 && botonPresionado.getParent() == dadosActivos) {

                        int dices = -1;
                        for (int i = 0; i < dadito.length; i++) {
                            if (dadito[i] == e.getSource()) {
                                opuesto = dadito[i].getActionCommand();
                                dices = i;
                                exitoso = false;
                                break;
                            }
                        }
                        if (dices != -1 && exitoso == false) {
                            int caraOpuesta = modeloDado.caraOpuesta(Integer.parseInt(opuesto));
                            imagenDelDado(caraOpuesta, dices);
                            dadosUtilizados.revalidate();
                            dadosInactivos.revalidate();
                            dadosActivos.revalidate();
                            dadosUtilizados.repaint();
                            dadosInactivos.repaint();
                            dadosActivos.repaint();
                            respuesta=JOptionPane.showConfirmDialog(null, "Cara opuesta del dado: " + modeloDado.getCaras(caraOpuesta), "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                            components = actualizar();
                        }
                        System.out.println("sale heroe");
                    }
                } else if (exitoso == true && controlito.Estado(dadosEnelPanel) == 6) {
                    if (e.getClickCount() == 2) {
                        int dices = -1;
                        for (int i = 7; i < dadito.length; i++) {
                            if (dadito[i] == e.getSource()) {
                                dices = i;
                                exitoso = false;
                                break;
                            }

                        }
                        if (dices != -1 && exitoso == false) {
                            int nuevoDadoActivo = controlito.nuevo;
                            imagenDelDado(nuevoDadoActivo, dices);
                            dadosInactivos.remove(dadito[dices]);
                            dadito[dices].setEnabled(true);
                            dadosActivos.add(dadito[dices]);
                            respuesta=JOptionPane.showConfirmDialog(null, "El nuevo dado activo es: " + modeloDado.getCaras(nuevoDadoActivo), "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                            dadosInactivos.revalidate();
                            dadosInactivos.repaint();
                            dadosActivos.revalidate();
                            dadosActivos.repaint();
                            components = actualizar();

                        }
                        System.out.println("sale corazon");

                    }
                }
                if(respuesta == JOptionPane.OK_OPTION){
                    try {

                        ArrayList<String> etiquetas = new ArrayList<>();
                        for (Component component : components) {
                            if (component instanceof JButton) {
                                JButton boton = (JButton) component;
                                String etiqueta = boton.getActionCommand();
                                etiquetas.add(etiqueta);
                            }
                        }
                        etiquetasArray = etiquetas.toArray(new String[0]);
                        dadosEnelPanel = components.length;
                        System.out.println(Arrays.toString(etiquetasArray));
                    }catch (NullPointerException E){
                        JOptionPane.showConfirmDialog(null,
                                "Usted no ha realizado ninguna jugada",
                                "INFORMACIÓN", JOptionPane.CLOSED_OPTION);

                    }
                }


            } catch (NullPointerException ex) {

            }
            components = actualizar();
            dadosInactivos.revalidate();
            dadosUtilizados.revalidate();
            dadosActivos.revalidate();
            dadosUtilizados.repaint();
            dadosInactivos.repaint();
            dadosActivos.repaint();
            System.out.println("Terminamos con " + dadosEnelPanel + " dados activos, "
                    + dadosEnelpanelIna + " dados inactivos y dados utilizados " + dadosEnelPanelUti);

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {


        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }

}
