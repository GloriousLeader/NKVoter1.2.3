package net.votefucker.nkvoter.console;

import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import net.votefucker.nkvoter.Main;
import net.votefucker.nkvoter.Version;

public class Console implements Runnable
{
    JTextArea displayPane;
    BufferedReader reader;
    private static final Version VERSION = new Version(1, 2, 3);
    public static final Main NKVoter = new Main();

    private Console(JTextArea displayPane, PipedOutputStream pos)
    {
        this.displayPane = displayPane;

        try
        {
            PipedInputStream pis = new PipedInputStream( pos );
            reader = new BufferedReader( new InputStreamReader(pis) );
        }
        catch(IOException e) {}
    }

    public void run()
    {
        String line = null;

        try
        {
            while ((line = reader.readLine()) != null)
            {
//              displayPane.replaceSelection( line + "\n" );
                displayPane.append( line + "\n" );
                displayPane.setCaretPosition( displayPane.getDocument().getLength() );
            }

            System.err.println("im here");
        }
        catch (IOException ioe)
        {   
            JOptionPane.showMessageDialog(null,
                "Error redirecting output : "+ioe.getMessage());
        }
    }

        private static void updateTextArea(final JTextArea displayPane, final String text) {
                 PipedOutputStream pos = new PipedOutputStream();
                Console console = new Console(displayPane, pos);
                new Thread(console).start();
                console.displayPane.append(text);
            }
        
    

    private static void redirectSystemStreams(final JTextArea displayPane) {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateTextArea(displayPane, String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextArea(displayPane, new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

    public static void main(String[] args)
    {
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane( textArea );

        JFrame frame = new JFrame("NKVoter");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( scrollPane );
        frame.setSize(700, 400);
        frame.setVisible(true);

        Console.redirectSystemStreams( textArea );
        final int i = 0;

              try {
      Main.main();
      } catch (Exception e) {}
   
    }
}