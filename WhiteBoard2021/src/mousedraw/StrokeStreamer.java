/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mousedraw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author ayush
 */
public class StrokeStreamer {

    FileWriter fileWriter;
    String str;
    public static final short END = 0, HOVER = 1, STROKE = 2;
    Timer playClock;
    boolean isRecording = false;
    long playtTime = 0;
    int speed = 1;
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    /* get AWT toolkit */

    private void stopPlayClock() {
        playClock.stop();
    }

    public void initWriter() {
        try {
            fileWriter = new FileWriter(App.fileStreamed);
            isRecording = true;
        } catch (IOException ex) {
            Logger.getLogger(StrokeStreamer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class SEvent {

        short type;
        int x, y;

        private SEvent(short type, short x, short y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "\nSEvent{" + "type=" + type + ", x=" + x + ", y=" + y + '}';
        }

    }

    public StrokeStreamer() {

    }

    void event(short type, int x, int y) {
        str = Home.time + "\t" + type + "\t" + x + "\t" + y + "\n";
        try {
            if (isRecording) {
                fileWriter.write(str);
            }
        } catch (IOException ex) {
            Logger.getLogger(StrokeStreamer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void save() {
        try {

            event(END, 0, 0);
            fileWriter.flush();
            fileWriter.close();
            isRecording = false;

        } catch (IOException ex) {
            Logger.getLogger(StrokeStreamer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playRecording(Graphics2D g) {
        g.clearRect(0, 0, 1000, 1000);
        Map<Long, SEvent> map = new HashMap<>();
        try {
            List<String> readAllLines = Files.readAllLines(App.fileStreamed.toPath());
            readAllLines.forEach(line -> {
                String[] split = line.split("\t");
                map.put(Long.parseLong(split[0]), new SEvent(Short.parseShort(split[1]), Short.parseShort(split[2]),
                        Short.parseShort(split[3])));
            });

//            System.out.println("map=" + map);
            playtTime = 0;
            g.setColor(Color.RED);
            playClock = new Timer(speed, l -> {
                playtTime++;
                SEvent event = map.get(playtTime);
//                System.out.println("playing time\t" + playtTime + "\t" + event);
                if (event != null) {
                    switch (event.type) {
                        case StrokeStreamer.END:
                            stopPlayClock();
                            break;
                        case StrokeStreamer.STROKE:
                            g.setColor(Color.RED);
                            g.drawOval(event.x, event.y, 5, 5);
                            break;
                        case StrokeStreamer.HOVER:
                            g.setColor(Color.BLUE);
                            g.drawOval(event.x, event.y, 2, 2);
                            break;
                        default:
                            break;
                    }
                }
                 toolkit.sync();
            });
            playClock.start();

        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
