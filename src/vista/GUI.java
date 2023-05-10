/*
 Autores:
 Sarahy Gisselle Caicedo Betancourth
 Kevin Andres Giron Villegas
 <sarahy.caicedo@correounivalle.edu.co>
 <kevin.giron@correounivalle.edu.co>
 Fecha creación: 2023-05-01
 Fecha última modificación: 2023-05-09
*/

package vista;


import controlador.ControlDado;
import controlador.ControlRonda;
import modelo.Dado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* INTENCION: Esta clase tiene como porposito capturaar el evento principal
* al momento de lanzar los dados.
*/

public class GUI extends JFrame {
    private static ImagenDado dados;
    public static JFrame frame;
    private static JPanel fondo, opciones;
    private static Titulo titulo;
    private static Listener listener;
    public static JButton btnLanzarDado;
    private int conteo = 1, dado;


    private ControlDado controlDado;

    /*
    * Contructor de GUI class, se inicializan varios objetos, como el listener, el título, el frame , el fondo
    * y los dados. Luego se agregan los componentes al panel de opciones,  que se establece como el contenido
    * principal del frame. Finalmente, se establecen algunas propiedades del frame, como su ícono, su tamaño y
    * su ubicación en la pantalla. Se muestra el frame y se establece el comportamiento  de cierre cuando se
    * presiona el botón de cierre.
    */


    public GUI() {

        listener = new Listener();
        titulo = new Titulo();
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        opciones = new JPanel(new GridLayout(2, 2));
        String texto = "De clic en el botón 'Lanzar Dados'";
        opciones.setBorder(titulo.gettitulo(texto));
        opciones.setOpaque(false);

        fondo = new Fondo(new ImageIcon(getClass().getResource("/recursos/Fondo.png")).getImage());
        frame.setContentPane(fondo);

        dados = new ImagenDado();
        opciones.add(dados.getDadosActivos());
        opciones.add(dados.getDadsInactivation());
        opciones.add(dados.getTablaPuntaje());
        opciones.add(dados.getDadosUtilizados());

        frame.getContentPane().add(opciones, BorderLayout.CENTER);

        initGUI();
        frame.setIconImage(new ImageIcon(getClass().getResource("/recursos/Logo.png")).getImage());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setTitle("GEEK OUT! MASTERS");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /*
    * Crea una instancia de la clase Ayuda, en donde muestra el dado que se crea en esa clase
    * como tambien crea dos dados, LanzarDado y ValidarDados. Agregandolos a un panel de botones
    * llamado panelBotones que se define como un diseño FlowLayout.
    */


    private static void initGUI() {
        Ayuda ayuda = new Ayuda();
        btnLanzarDado = new JButton("Lanzar Dado");
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 145));
        panelBotones.setPreferredSize(new Dimension(200, 650));
        panelBotones.add(btnLanzarDado);
        panelBotones.add(ayuda.botonAyuda);
        panelBotones.setOpaque(false);
        String texto = "Opciones";
        panelBotones.setBorder(titulo.gettitulo(texto));
        frame.getContentPane().add(panelBotones, BorderLayout.EAST);
        btnLanzarDado.addActionListener(listener);


    }


    /*
    *   Crea una instancia de un objeto ImagenDado, restableciendo y actualizando la
    *   GUI del juego, reiniciando el juego o una nueva ronda.
    */

    private static void reiniciar(){

        dados = new ImagenDado();
        opciones.add(dados.getDadosActivos());
        opciones.add(dados.getDadsInactivation());
        opciones.add(dados.getTablaPuntaje());
        opciones.add(dados.getDadosUtilizados());
    }



    /*
    * Este metodo es el principal y muestra la ventana de la aplicacion.
    */


    public static void main(String[] arg) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                GUI vista = new GUI();


            }
        });
    }

    /*
    * Esta clase captura el evento y se activa cada vez que se produce una accion (clic)
    * comprobando que se haya hecho clic en el boton LanzarDado y boton Validar. Si el boton es el de LanzarDado,
    * Se crea una instancia de la clase ImagenDado, comprobando en que ronda se encuentra el juego
    * (utilizando la clase ControlRonda) lanzando un dado, actualizando la interfaz grafica e incrementando
    * la variable conteo. Por otro lado, si es el boton Validar, se crea una instancia de la clase ImagenDAdo y se recorren
    * todos los componentes obteneiendo las etiquetas de de todos los botones y se imporimen en consola.
    */

    public class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ImagenDado imagenDado = new ImagenDado();

            if (e.getSource() == btnLanzarDado) {
                String texto2 = "Ronda#" + conteo;
                ControlRonda controlRonda = new ControlRonda();
                controlRonda.rondas(conteo);
                imagenDado.actualizar();

                System.out.println("Entro en la primera ronda" + conteo);

                if (controlRonda.rondas(conteo) == 1) {
                    Dado dado = new Dado();
                    ControlDado controlDado = new ControlDado(dado, dados);
                    controlDado.LanzarDado();
                    opciones.setBorder(titulo.gettitulo(texto2));
                    dados.mostrarBotones();
                    System.out.println("Entro a la ronda " + conteo);
                    btnLanzarDado.setEnabled(false);
                }
                if (controlRonda.rondas(conteo) == 2) {
                    opciones.removeAll();
                    reiniciar();
                    Dado dado = new Dado();
                    ControlDado controlDado = new ControlDado(dado, dados);
                    controlDado.LanzarDado();
                    opciones.setBorder(titulo.gettitulo(texto2));
                    dados.mostrarBotones();
                    System.out.println("Entro a la ronda " + conteo);
                    btnLanzarDado.setEnabled(true);
                }
                if (controlRonda.rondas(conteo) == 3) {
                    opciones.removeAll();
                    reiniciar();
                    Dado dado = new Dado();
                    ControlDado controlDado = new ControlDado(dado, dados);
                    controlDado.LanzarDado();
                    opciones.setBorder(titulo.gettitulo(texto2));
                    dados.mostrarBotones();
                    System.out.println("Entro a la ronda " + conteo);
                    btnLanzarDado.setEnabled(true);
                }
                if (controlRonda.rondas(conteo) == 4) {
                    opciones.removeAll();
                    reiniciar();
                    Dado dado = new Dado();
                    ControlDado controlDado = new ControlDado(dado, dados);
                    controlDado.LanzarDado();
                    opciones.setBorder(titulo.gettitulo(texto2));
                    dados.mostrarBotones();
                    System.out.println("Entro a la ronda " + conteo);
                    btnLanzarDado.setEnabled(true);
                }
                if (controlRonda.rondas(conteo) == 5) {
                    opciones.removeAll();
                    reiniciar();
                    Dado dado = new Dado();
                    ControlDado controlDado = new ControlDado(dado, dados);
                    controlDado.LanzarDado();
                    opciones.setBorder(titulo.gettitulo(texto2));
                    dados.mostrarBotones();
                    System.out.println("Entro a la ronda " + conteo);
                    btnLanzarDado.setEnabled(true);
                }
                frame.revalidate();
                frame.repaint();
                conteo++;

            }


        }


    }

}





