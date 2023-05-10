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
import java.awt.*;

/*
 INTENCION: Esta clase tiene como porposito establecer un fondo a traves del metodo paintComponent.
 */

public class Fondo extends JPanel {
    private Image imagenFondo;

    /*
    * Constructor de la clase
    */

    public Fondo(Image imagenFondo) {
        this.imagenFondo = imagenFondo;
    }

    /*
    * Este metodo es llamado automaticamente por el sistema grafico cada vez
    * que se necesita pintar o volver  pintar el componente, verificando si hay una imagen
    * de fondo, y de ser afirmativo, dibuja en el panel utilizando el objeto Graphics.
    */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), null);
        }
    }
}