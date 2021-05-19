/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import mousedraw.Stroke;
import mousedraw.Point;

/**
 *
 * @author aswathy
 */
public class TestPath {

    public static void main(String[] args) {
        Stroke pathu = new Stroke();
        pathu.moveTo(new Point(200, 220));
        pathu.lineTo(new Point(210, 220));
        pathu.lineTo(new Point(220, 220));
        pathu.lineTo(new Point(230, 220));
        pathu.lineTo(new Point(230, 225));
        pathu.lineTo(new Point(232, 227));
         pathu.endAt(new Point(234, 228));
         
        System.out.println("pathu="+pathu.getDataAsString());
    }
}
