/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.Timer;

/**
 *
 * @author ayush
 */
public class JPanelTimedDraw extends javax.swing.JPanel {
   Toolkit toolkit = Toolkit.getDefaultToolkit();
    int x = 0, y = 20;

    public JPanelTimedDraw() {
        initComponents();
//setIgnoreRepaint(true);
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public void start() {

        Timer timer = new Timer(1, l -> {
            getGraphics().drawOval(x++, y, 10, 10);
            if (x > 800) {
                y += 10;
                x = 0;
            }
            
            toolkit.sync();
        });
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
