package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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
public final class SimpleGUIWithFileChooser {
    
    private final JFrame frame;
    
    public SimpleGUIWithFileChooser(final Controller ctr) {
        this.frame = new JFrame("My second Java Graphical Interface");
        final JPanel canvasSouth = new JPanel(new BorderLayout());
        final JPanel canvasNorth = new JPanel(new BorderLayout());
        this.frame.getContentPane().add(canvasSouth, BorderLayout.SOUTH);
        this.frame.getContentPane().add(canvasNorth, BorderLayout.NORTH);
        final JTextArea textZone = new JTextArea(ctr.getPath());
        textZone.setEnabled(false);
        
        final JButton saveButton = new JButton("SAVE");
        final JButton browseButton = new JButton("Browse");
        canvasSouth.add(saveButton, BorderLayout.SOUTH);
        canvasNorth.add(textZone, BorderLayout.CENTER);
        canvasNorth.add(browseButton, BorderLayout.LINE_END);

        /*
        * saveButton action -> not working...
        * 
        */
        saveButton.addActionListener(e -> {
            try {
                ctr.writeOnFile(textZone.getText());
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        });
        
        /*
         * browseBotton action 
         * 
         */
        browseButton.addActionListener(e -> {
            // TODO Auto-generated method stub
            final JFileChooser fileChooser = new JFileChooser();
            fileChooser.setSelectedFile(ctr.getCurrentFile());
            if (fileChooser.showOpenDialog(browseButton) == JFileChooser.APPROVE_OPTION){
                ctr.setCurrFile(fileChooser.getSelectedFile());
            } 
            if (fileChooser.showOpenDialog(browseButton) == JFileChooser.CANCEL_OPTION){
                fileChooser.cancelSelection();
            }
        });
    }
    
    /*
    * Set the frames's size.
    * 
    */
    private void setSizeFrame() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        this.frame.setSize( sw / 2, sh / 2);
        this.frame.setResizable(true);
    }
    
    /*
     * Method that display the frame and set it closable
     */
    private void Display() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
     * main
     */
    public static void main(String[] args) {
        var window = new SimpleGUIWithFileChooser(new Controller());
        window.Display();
        window.setSizeFrame();
    }
}

