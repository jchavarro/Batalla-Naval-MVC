/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla.naval.Vista.Controlador;

import Controlador.Tablero;
import Modelo.Archivo;
import Modelo.Barco;
import static batalla.naval.Vista.Controlador.JPanelMatriz.miModelo;
import static batalla.naval.Vista.Controlador.JPanelMatriz.pcModelo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JuanCaCha
 */
public class VistaNaval extends javax.swing.JFrame {

    static int Mitablero[][] = new int[15][15];
    static int PCtablero[][] = new int[15][15];
    public static Tablero miModelo = new Tablero();
    public static Tablero pcModelo = new Tablero();
    public static Barco barco[] = new Barco[14];
    private Archivo archivo = new Archivo();
    private int [] puntajes = new int [10];
    
    public VistaNaval() {
        initComponents();
        puntajes = archivo.Abrirpuntajes();
        pcModelo.setNumbarcos(13);
        miModelo.setNumbarcos(13);
        disparos.setText(Integer.toString(miModelo.getNumdisparos()));
        misbarcoslabel.setText(Integer.toString(miModelo.getNumbarcos()));
        pcbarcoslabel.setText(Integer.toString(pcModelo.getNumbarcos()));
        setBounds(0, 0, 990, 540);
        setLocationRelativeTo(null);
        Batalla.setLocation(495, 1);
        barco[1]= new Barco(4);
        barco[2]= new Barco(3);
        barco[3]= new Barco(3);
        for (int i = 4; i < 8; i++) {
            barco[i]= new Barco(2);
        }
        for (int i = 8; i < 14; i++) {
            barco[i]= new Barco(1);
        }
        
        addMouseListener(new MouseAdapter() {
                    @Override
                    
                    public void mouseClicked (MouseEvent e){
                    
                        if (coordenadaDisparos(e.getX(),e.getY())!=null && ClickDoble(e)) {
                            int[] disparo = new int [2];
                            miModelo.disparosAleatorios(Mitablero);
                            disparo = coordenadaDisparos(e.getX(), e.getY());
                            PCtablero = pcModelo.accionDisparar(disparo[0],disparo[1], PCtablero);
                            miModelo.menosNumdisparos();
                            
                            disparos.setText(Integer.toString(miModelo.getNumdisparos()));
                            repaint();
                            // ganar
                            if (!pcModelo.victoria()||(!miModelo.haydisparos()&& miModelo.yogano(miModelo.getNumbarcos(),pcModelo.getNumbarcos()))) {
                                JPanelMatriz.estado = 2;
                                repaint();
                                JOptionPane.showMessageDialog(null,"¡VICTORIA!");
                                archivo.añadiralalista(13 - pcModelo.getNumbarcos(), puntajes);
                                archivo.añadirArchivo(puntajes);
                                reiniciar();
                            }if (!miModelo.haydisparos() && miModelo.getNumbarcos() == pcModelo.getNumbarcos()) {
                                JPanelMatriz.estado = 2;
                                repaint();
                                JOptionPane.showMessageDialog(null,"¡EMPATE!");
                                reiniciar();
                            }
                            //perder
                            if (!miModelo.haydisparos()){
                                JPanelMatriz.estado = 2;
                                repaint();
                                JOptionPane.showMessageDialog(null, "DERROTA");
                                reiniciar();
                            }
                            misbarcoslabel.setText(Integer.toString(miModelo.getNumbarcos()));
                            pcbarcoslabel.setText(Integer.toString(pcModelo.getNumbarcos()));
                        }
                        
                    repaint();
                    }
                
                }
        );
        
                
    }
    private void reiniciar(){
        int [][] a = new int[15][15];
        int [][] b = new int[15][15];
        PCtablero= JPanelMatriz.pcModelo.barcosAleatorios(a);
        Mitablero= JPanelMatriz.miModelo.barcosAleatorios(b);
        pcModelo.setNumbarcos(13);
        miModelo.setNumbarcos(13);
        miModelo.setNumdisparos(10);
        disparos.setText(Integer.toString(miModelo.getNumdisparos()));
        repaint();
    }

    private boolean ClickDoble(MouseEvent e) {
        return e.getClickCount() == 2;
    }
    private int[] coordenadaDisparos(int x, int y){
        
        int [] a = new int [2];
        if (x > 480 && x < 960) {
            a[0] = (x-510)/30;
            a[1] = (y-60)/30;
            return a;
        }
        return null;
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        disparos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Batalla = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        misbarcoslabel = new javax.swing.JLabel();
        pcbarcoslabel = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        BJugar = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        acerca = new javax.swing.JMenuItem();
        Puntuaciones = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("Disparos disponibles:");

        jLabel2.setText("Mi tablero");

        jLabel3.setText("Tablero pc");

        Batalla.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Batalla.setText("BATALLA NAVAL");

        jLabel4.setText("Mis barcos a flote:");

        jLabel5.setText("Barcos enemigos a flote:");

        jMenu4.setText("MENU");

        BJugar.setText("Jugar");
        BJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BJugarActionPerformed(evt);
            }
        });
        jMenu4.add(BJugar);

        jMenuItem5.setText("Acerca de");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        acerca.setText("Ayuda");
        acerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaActionPerformed(evt);
            }
        });
        jMenu4.add(acerca);

        Puntuaciones.setText("Mejores puntajes");
        Puntuaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuntuacionesActionPerformed(evt);
            }
        });
        jMenu4.add(Puntuaciones);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jMenu4.add(Salir);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disparos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Batalla)
                        .addGap(176, 176, 176)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(misbarcoslabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(229, 229, 229)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(pcbarcoslabel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Batalla)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(misbarcoslabel)
                        .addComponent(pcbarcoslabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 445, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(disparos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaActionPerformed
        JOptionPane.showMessageDialog(this, "Meta: disparar a todos los barcos hasta undirlos \n"
                + "Disparar: Doble clic en el tablero de la PC \n"
                + "Numero de disparos: Tienes 100 disparos para undir los barcos", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_acercaActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void BJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BJugarActionPerformed
        reiniciar();
    }//GEN-LAST:event_BJugarActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JOptionPane.showMessageDialog(this, "Batalla Naval vs CPU \n"
                + "Proyecto Programacion 4 \n"
                + "Por Juan Camilo Chavarro Acosta \n"
                + "Universidad Tecnologica de Pereira", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void PuntuacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuntuacionesActionPerformed
        JOptionPane.showMessageDialog(this, "Tabla de puntajes\n"
                + "1. puesto: " + puntajes[0] + "\n"
                + "2. puesto: " + puntajes[1] + "\n"
                + "3. puesto: " + puntajes[2] + "\n"
                + "4. puesto: " + puntajes[3] + "\n"
                + "5. puesto: " + puntajes[4] + "\n"
                + "6. puesto: " + puntajes[5] + "\n"
                + "7. puesto: " + puntajes[6] + "\n"
                + "8. puesto: " + puntajes[7] + "\n"
                + "9. puesto: " + puntajes[8] + "\n"
                + "10. puesto: " + puntajes[9] + "\n"
                , "Puntuaciones", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_PuntuacionesActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaNaval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaNaval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaNaval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaNaval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaNaval().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BJugar;
    private javax.swing.JLabel Batalla;
    private javax.swing.JMenuItem Puntuaciones;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem acerca;
    private javax.swing.JLabel disparos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JLabel misbarcoslabel;
    private javax.swing.JLabel pcbarcoslabel;
    // End of variables declaration//GEN-END:variables
}

class JPanelMatriz extends JPanel {
    public static Tablero miModelo = new Tablero();
    public static Tablero pcModelo = new Tablero();    int [][] a = VistaNaval.PCtablero;
    int [][] b = VistaNaval.Mitablero;
    public static int estado=0; // 0 es inciar el juego 1 juego en ejecucion 2 juego terminado
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (estado==0) {
            VistaNaval.PCtablero= pcModelo.barcosAleatorios(a);
            VistaNaval.Mitablero= miModelo.barcosAleatorios(b);
            estado=1;
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                g.setColor(Color.BLUE);
                g.fillRect(i * 30, j * 30, 30, 30);
                g.fillRect(480+i * 30, j * 30, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(480 + i * 30, j * 30, 30, 30);
                if (VistaNaval.Mitablero[i][j] == 0) {
                    g.setColor(Color.BLUE);
                    g.fillRect(i * 30, j * 30, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * 30, j * 30, 30, 30);
                }if (VistaNaval.Mitablero[i][j] >= 1) {
                    g.setColor(Color.GRAY);
                    g.fillRect(i * 30, j * 30, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * 30, j * 30, 30, 30);
                }if (VistaNaval.Mitablero[i][j] == -1) {
                    g.setColor(Color.RED);
                    g.fillRect(i * 30, j * 30, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * 30, j * 30, 30, 30);
                }if (VistaNaval.Mitablero[i][j] == -2) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(i * 30, j * 30, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * 30, j * 30, 30, 30);
                }if (VistaNaval.Mitablero[i][j] == -3) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(i * 30, j * 30, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * 30, j * 30, 30, 30);
                }if (VistaNaval.PCtablero[i][j] == -1) {
                    g.setColor(Color.RED);
                    g.fillRect(480 + i * 30, j * 30, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(480 + i * 30, j * 30, 30, 30);
                }if (VistaNaval.PCtablero[i][j] == -2) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(480 + i * 30, j * 30, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(480 + i * 30, j * 30, 30, 30);
                }if (VistaNaval.PCtablero[i][j] == -3) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(480 + i * 30, j * 30, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(480 + i * 30, j * 30, 30, 30);
                }if (estado==2 && VistaNaval.Mitablero[i][j] >= 1) {
                    g.setColor(Color.GRAY);
                    g.fillRect(i * 30, j * 30, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * 30, j * 30, 30, 30);
                }
            }
        }
        if (estado==2) {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    if (VistaNaval.Mitablero[i][j] >= 1) {
                    g.setColor(Color.GRAY);
                    g.fillRect(i * 30, j * 30, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(i * 30, j * 30, 30, 30);
                }
                }
            }
            //estado=1;
        }
        
    }

    
    
}
