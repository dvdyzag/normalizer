package gt.dvdyzag.normalizer;

import gt.dvdyzag.gui.Principal;
import javax.swing.SwingUtilities;

/**
 * Clase central
 * @author David Y. Gonzalez <a href="mailto:dvdyzag@gmail.com">dvdyzag@gmail.com</a>
 */
public class Normalizer implements Runnable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Normalizer() );
    }

    @Override
    public void run() {
        new Principal().setVisible(true);
    }
}
