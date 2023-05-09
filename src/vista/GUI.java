/*
 Autores:
 Sarahy Gisselle Caicedo Betancourth
 Kevin Andres Giron Villegas
 <sarahy.caicedo@correounivalle.edu.co>
 <kevin.giron@correounivalle.edu.co>
 Fecha creación: 2023-05-01
 Fecha última modificación: 2023-05-06
*/
/*
 INTENCION: Esta clase tiene como porposito capturaar el evento principal al momento de lanzar los dados.
 */
package vista;


import controlador.ControlDado;
import controlador.ControlRonda;
import modelo.Dado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private static ImagenDado dados;
    public static JFrame frame;
    private static JPanel fondo, opciones;
    private static  Titulo titulo;
    private static  Listener listener;
    public static JButton btnLanzarDado, btnValidar;
    private int conteo = 1, dado;

    private ControlDado controlDado;

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


    public static void dragon(int dra) {
        btnLanzarDado.setEnabled(true);
        JOptionPane.showConfirmDialog(null
                , "Has perdido", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
        initGUI();

    }


    private static void initGUI() {
        btnLanzarDado = new JButton("Lanzar Dado");
        btnValidar = new JButton("Validar dados");
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 145));
        panelBotones.setPreferredSize(new Dimension(200, 650));
        panelBotones.add(btnLanzarDado);
        panelBotones.add(btnValidar);
        panelBotones.setOpaque(false);
        String texto = "Opciones";
        panelBotones.setBorder(titulo.gettitulo(texto));
        frame.getContentPane().add(panelBotones, BorderLayout.EAST);
        btnLanzarDado.addActionListener(listener);


    }

    private static void reiniciar(){
        dados = new ImagenDado();
        opciones.add(dados.getDadosActivos());
        opciones.add(dados.getDadsInactivation());
        opciones.add(dados.getTablaPuntaje());
        opciones.add(dados.getDadosUtilizados());
    }


    public static void main(String[] arg) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                GUI vista = new GUI();


            }
        });
    }


    public class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnLanzarDado) {

                String texto2 = "Ronda#" + conteo;
                ControlRonda controlRonda = new ControlRonda();
                controlRonda.rondas(conteo);

                System.out.println("Entro en la primera ronda" + conteo);

                if ( controlRonda.rondas(conteo) == 1) {
                    Dado dado = new Dado();
                    ControlDado controlDado = new ControlDado(dado, dados);
                    controlDado.LanzarDado();
                    opciones.setBorder(titulo.gettitulo(texto2));
                    dados.mostrarBotones();
                    System.out.println("Entro en la primera ronda "+conteo);
                    conteo++;
                    System.out.println("Entro en la primera ronda "+conteo);
                    btnLanzarDado.setEnabled(false);
                }
                if ( controlRonda.rondas(conteo) == 2 && btnValidar==e.getSource()) {
                    btnLanzarDado.setEnabled(false);
                }
                if ( controlRonda.rondas(conteo) == 3) {
                    btnLanzarDado.setEnabled(false);
                }
                if ( controlRonda.rondas(conteo) == 4) {
                    btnLanzarDado.setEnabled(false);
                }
                if ( controlRonda.rondas(conteo) == 5) {
                    btnLanzarDado.setEnabled(false);
                }


            }



        }


    }

}





