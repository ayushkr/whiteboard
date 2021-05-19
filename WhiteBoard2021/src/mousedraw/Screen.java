/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mousedraw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author aswathy
 */
public class Screen extends javax.swing.JPanel {

    Point point;
    Map<Long, Stroke> strokes = new LinkedHashMap<>();
    Graphics g1;
    Graphics2D g2;
    Stroke stroke;
 

    /**
     * Creates new form Screen
     */
    public Screen() {
        initComponents();
        setFocusable(true);
        grabFocus();
        repaint();
    }

//    @Override
//    public void paint(Graphics g) {
//        super.paint(g); //To change body of generated methods, choose Tools | Templates.
////        g2 = (Graphics2D) g;
//        System.out.println("repainted ");
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

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

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        App.strokeStreamer.event(StrokeStreamer.STROKE,evt.getX(), evt.getY());
//        if (g2 == null) {
//            g2 = (Graphics2D) getGraphics();
//        }
//        stroke.lineTo(new Point(evt.getX(), evt.getY()));
//

        tempDraw(evt);

    }//GEN-LAST:event_formMouseDragged

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
//        System.out.println(" " + evt);
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_S:
                save();
                break;
            case KeyEvent.VK_C:
                clearMap();
                break;

            case KeyEvent.VK_R:
                strokesToScreen();
                break;

        }
    }//GEN-LAST:event_formKeyReleased

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        tempDraw(evt);
//        stroke = new Stroke();
//        stroke.moveTo(new Point(evt.getX(), evt.getY()));
        App.strokeStreamer.event(StrokeStreamer.STROKE,evt.getX(), evt.getY());
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
//        stroke.endAt(new Point(evt.getX(), evt.getY()));
//        strokes.put(System.currentTimeMillis(), stroke);

    }//GEN-LAST:event_formMouseReleased

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        g1 = getGraphics();
    }//GEN-LAST:event_formComponentResized

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        App.strokeStreamer.event(StrokeStreamer.HOVER,evt.getX(), evt.getY());
    }//GEN-LAST:event_formMouseMoved
    public void clearMap() {
        strokes.clear();
    }

    public void save() {
        System.out.println("Strokes are ");
        strokes.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });

    }

    private void strokesToScreen() {
//        repaint();
        g1 = getGraphics();
        strokes.forEach((k, v) -> {
//            System.out.println(k + " " + v);
            ((Stroke) v).drawStroke(g1);
        });
    }

    private void tempDraw(MouseEvent evt) {
        if (g1 == null) {
            g1 = getGraphics();
            g1.setColor(Color.black);
        }
        g1.drawOval(evt.getX(), evt.getY(), 5, 5);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
