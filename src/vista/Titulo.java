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

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/*
* INTENCION: Esta clase tiene como proposito agregar el titulo de los  JPanel a traves de atributo Border.
*/

public class Titulo extends JLabel {

    private Border border;

    /*
    * Constructor de la clase
    */

    public Titulo() {

    }

    /*
    * Crea y devuelve un borde con un titulo centrado y un texto especifico
    */

    public Border gettitulo(String text){
        Font font = new Font("Arial", Font.BOLD, 24);
        border = BorderFactory.createCompoundBorder(
                new LineBorder(Color.GRAY, 2),
                new TitledBorder(
                        new LineBorder(Color.blue, 4),
                        text,
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        font,
                        Color.decode("#b0bbc2")
                )
        );

        return  border;

    }

}
