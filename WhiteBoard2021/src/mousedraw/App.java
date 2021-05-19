/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mousedraw;

import java.io.File;

/**
 *
 * @author ayush
 */
public class App {
        
    public static File fileStreamed=new File("USER/" + System.currentTimeMillis() + ".txt");
    public static StrokeStreamer strokeStreamer=new StrokeStreamer();
}
