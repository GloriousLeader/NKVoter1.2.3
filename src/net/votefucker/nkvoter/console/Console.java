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

    public static void redirectOutput(JTextArea displayPane)
    {
        Console.redirectOut(displayPane);
        Console.redirectErr(displayPane);
    }

    public static void redirectOut(JTextArea displayPane)
    {
        PipedOutputStream pos = new PipedOutputStream();
        System.setOut( new PrintStream(pos, true) );

        Console console = new Console(displayPane, pos);
        new Thread(console).start();
    }

    public static void redirectErr(JTextArea displayPane)
    {
        PipedOutputStream pos = new PipedOutputStream();
        System.setErr( new PrintStream(pos, true) );

        Console console = new Console(displayPane, pos);
        new Thread(console).start();
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

        Console.redirectOutput( textArea );
        final int i = 0;

              try {
      Main.main();
      } catch (Exception e) {}
   
    }
}