package cz.muni.fi.pb162.project.test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class OutputTester {

    private OutputStream os;
    private PrintStream  tempOutput;
    private PrintStream  origOutput;
    
    public OutputTester() {
        os = new ByteArrayOutputStream();
        tempOutput = new PrintStream(os);
    }
    
    public void captureOutput() {
        origOutput = System.out;
        System.setOut(tempOutput);
    }
    
    public void releaseOutput() {
        System.setOut(origOutput);
    }

    public boolean outputEquals(String exp) {
        return exp.trim().equals(os.toString().trim());
    }
    
    public boolean outputEqualsIgnoreCase(String exp) {
        return exp.trim().equalsIgnoreCase(os.toString().trim());
    }
}
