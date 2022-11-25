package it.unibo.mvc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    public static final String SEP = File.separator;
    public static final String DEFAULT_PATH = 
		System.getProperty("Users") + SEP + "elvisperlika" + SEP + "Desktop" + SEP + "FileTest.txt";

    FileWriter currentFile;
    public Controller() {
        try {
            this.currentFile = new FileWriter(DEFAULT_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final FileWriter getCurrentFile() {
        return currentFile;
    }
    
    final String getPath() {
        return DEFAULT_PATH;
    }

    final void writeOnFile(String inString) {
        try {
            currentFile.write(inString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
