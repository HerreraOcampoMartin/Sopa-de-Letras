
package pkg05.sopa.de.letras;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class SopaDeLetras {

    public static void main(String[] args) {
        Ventana ven = new Ventana();
        ven.setVisible(true);
    }
    
}
class Ventana extends JFrame{
    public Ventana(){
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Sopa de letras");
        setMinimumSize(new Dimension (450, 400));
        add(new Panel()); 
    }

    static Color fondo1 = new Color(255,255,255), fondo2 = new Color(255, 0, 0)
    , fore1 = new Color(0,0,0), fore2= new Color(255,255,255);
    
}
