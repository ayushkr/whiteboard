/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mousedraw;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author aswathy
 */
public class Stroke {
    
    public Point pointStart = new Point();
    public Point pointEnd = new Point();
    public List<Delta> listDelta = new LinkedList<>();
    
    public void moveTo(Point p) {
        pointStart = p;
    }
    
    public void lineTo(Point p) {
        Delta delta = new Delta();
        delta.dx = (byte) (p.x - pointStart.x);
        delta.dy = (byte) (p.y - pointStart.y);
        listDelta.add(delta);
    }
    
    public void endAt(Point p) {
        pointEnd = p;
        lineTo(p);
//        System.out.println("Stroke=" + getDataAsString());
    }
    
    @Override
    public String toString() {
        return "\nStroke{" + "pointStart=" + pointStart + ", pointEnd=" + pointEnd + ", listDelta=" + listDelta + '}';
    }
    
    public String getDataAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("M").append(pointStart);
        listDelta.forEach(delta -> {
            sb.append(delta);
        });
        
        return sb.toString();
    }
    
    void drawStroke(Graphics g1) {
        listDelta.forEach(delta -> {
            g1.setColor(Color.blue);
            g1.drawOval(pointStart.x + delta.dx, pointStart.y + delta.dy, 6, 6);
        });
    }
    
}
