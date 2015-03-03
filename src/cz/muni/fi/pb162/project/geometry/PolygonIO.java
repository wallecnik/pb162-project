package cz.muni.fi.pb162.project.geometry;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Input/output methods
 * 
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public interface PolygonIO {
    
    void write(OutputStream os) throws IOException;
    
    void write(File file) throws IOException;
    
    void read(InputStream is) throws IOException;
    
    void read(File file) throws IOException;
}
