package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    
    private final JFrame frame;
    
    public SimpleGUI(final Controller ctr) {
        this.frame = new JFrame("My first Java Graphical Interface");
        final JPanel canvas = new JPanel(new BorderLayout());
        this.frame.getContentPane().add(canvas);
        final JTextArea textZone = new JTextArea();
        
        final JButton saveButton = new JButton("SAVE");
        canvas.add(saveButton, BorderLayout.SOUTH);
        canvas.add(textZone, BorderLayout.CENTER);

        saveButton.addActionListener(e -> {
            try {
                ctr.writeOnFile(textZone.getText());
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
    }
    
    private void setSizeFrame() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        this.frame.setSize( sw / 2, sh / 2);
        this.frame.setResizable(true);
    }
    
    private void display() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        var window = new SimpleGUI(new Controller());
        window.display();
        window.setSizeFrame();
    }
}
