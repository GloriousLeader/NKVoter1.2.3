/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.votefucker.nkvoter.console;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import net.votefucker.nkvoter.Main;
import net.votefucker.nkvoter.Version;

/**
 *
 * @author Stullig
 */
public class konsole {
    
    private static final Version VERSION = new Version(1, 2, 3);
    public static final Main NKVoter = new Main();
    
    public static JTextArea console(final InputStream out, final PrintWriter in) {
    final JTextArea area = new JTextArea();
    

    // handle "System.out"
    new SwingWorker<Void, String>() {
        @Override protected Void doInBackground() throws Exception {
            Scanner s = new Scanner(out);
            while (s.hasNextLine()) publish(s.nextLine() + "\n");
            return null;
        }
        @Override protected void process(List<String> chunks) {
            for (String line : chunks) area.append(line);
        }
    }.execute();

    // handle "System.in"
    area.addKeyListener(new KeyAdapter() {
        private StringBuffer line = new StringBuffer();
        @Override public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (c == KeyEvent.VK_ENTER) {
                in.println(line);
                line.setLength(0); 
            } else if (c == KeyEvent.VK_BACK_SPACE) { 
                line.setLength(line.length() - 1); 
            } else if (!Character.isISOControl(c)) {
                line.append(e.getKeyChar());
            }
        }
    });

    return area;
}
    public static void main(String[] args) throws IOException {

    PipedInputStream inPipe = new PipedInputStream();
    PipedInputStream outPipe = new PipedInputStream();

    System.setIn(inPipe);
    System.setOut(new PrintStream(new PipedOutputStream(outPipe), true));

    PrintWriter inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);
    JFrame frame = new JFrame("\"NKVoter\"");
    frame.add(console(outPipe, inWriter));
    frame.setSize(700, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
        try {
      Main.main();
      } catch (Exception e) {}
}



    
}
