package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_FILE = "Output.txt";

    private File dest = new File(HOME + File.separator + DEFAULT_FILE);

    final File getCurrentFile() {
        return dest;
    }

    final File setCurrFile(final File file) {
        return dest = file;
    }
    
    final String getPath() {
        return dest.getPath();
    }

    final void writeOnFile(String inString) throws IOException {
        try (PrintStream out = new PrintStream(dest, StandardCharsets.UTF_8)) {
            out.println(inString);
        }
    }


}
