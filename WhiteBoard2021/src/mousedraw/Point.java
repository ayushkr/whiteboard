/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mousedraw;

/**
 *
 * @author aswathy
 */
public class Point {

    short x, y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = (short) x;
        this.y = (short) y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

}
