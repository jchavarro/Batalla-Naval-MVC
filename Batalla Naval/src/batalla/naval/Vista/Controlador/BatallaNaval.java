/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla.naval.Vista.Controlador;



import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JuanCaCha
 */
public class BatallaNaval {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaNaval ventana = new VistaNaval();
        ventana.setVisible(true);
        JPanel panel = new JPanelMatriz();
        panel.setVisible(true);
        panel.setLocation(30, 30);
        panel.setSize(931, 451);
        ventana.add(panel);
        

        //ventana.validate();
        //ventana.repaint();
        
        
        
    }
    
}
