/*
 Autores:
 Sarahy Gisselle Caicedo Betancourth
 Kevin Andres Giron Villegas
 <sarahy.caicedo@correounivalle.edu.co>
 <kevin.giron@correounivalle.edu.co>
 Fecha creación: 2023-05-07
 Fecha última modificación: 2023-05-09
*/

package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
*INTENCION: Esta clase tiene como proposito definir una ventana de ayuda
* que muestre una imagen al hacer clic en el boton.
*/

public class Ayuda extends JFrame {
    public static JButton botonAyuda;
    private JPanel contenedorBoton, contenedorImagen;
    private JLabel imagenLabel;
    private Listener listener;

    /*
    * Constructor de la clase, inicializa los atibutos, el boton Heelp es agregado
    * al panel contenedorBoton y la etiqueta de la imagen se agrega al panel contenedorImagen.
    * Tambien agrega un logo a la ventana con la imagen del juego Geek Out! Master.
    */

    public Ayuda(){

        super("AYUDA");
        botonAyuda= new JButton("Help");
        listener=new Listener();
        botonAyuda.addActionListener(listener);
        imagenLabel=new JLabel();


        contenedorBoton= new JPanel();
        contenedorImagen=new JPanel();
        contenedorBoton.add(botonAyuda);
        contenedorImagen.add(imagenLabel);


        this.add(contenedorBoton, BorderLayout.SOUTH);
        this.add(contenedorImagen,BorderLayout.CENTER);

        add(contenedorBoton, BorderLayout.SOUTH);
        getContentPane().add(contenedorImagen, BorderLayout.CENTER);
        int x = 400;
        int y = 150;
        setLocation(x,y);
        setIconImage(new ImageIcon(getClass().getResource("/recursos/Logo.png")).getImage());
        pack();

    }

    /*
    * Se encarga de manejar el evento de dar clic al boton Help, al dar clic, la imagen en la
    * etiqueta se actualia con la imagen de ayuda y se ajusta el tamaño de la ventana.
    */

    public class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == botonAyuda){

                System.out.println("Evento capturado");
                imagenLabel.setIcon(null);
                ImageIcon imagen = new ImageIcon(getClass().getResource("/recursos/ayuda.png"));
                Image imageEscala = imagen.getImage().getScaledInstance(480, 420, Image.SCALE_SMOOTH);
                ImageIcon imagenFinal = new ImageIcon(imageEscala);
                imagenLabel.setIcon(imagenFinal);
                setSize(500,470);
                setVisible(true);

            }

        }
    }
}
