package cz.muni.fi.pb162.project.demo;

import java.util.Collection;
import cz.muni.fi.pb162.project.demo.Draw;
import cz.muni.fi.pb162.project.geometry.CollectionPolygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * !!! ODKOMENTOVAT RADEK V MAIN() !!!
 * 
 * Trida umoznujici vykresleni grafickych objektu pozadovanych v ramci nepovinnych ukolu.
 * 
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;
 * @version 2013-09-05
 *
 */

public class DrawExtra07 extends Draw {

    public static void main(String[] args) {
        CollectionPolygon pol = new CollectionPolygon(new Vertex2D[]{
            new Vertex2D(-900,  100),
            new Vertex2D(-100,  100),
            new Vertex2D( 100,  100),
            new Vertex2D( 100, -100),
            new Vertex2D(-100, -100),
            new Vertex2D(-900, -100),
        });
        
        Collection<Vertex2D> col = pol.removeLeftmostVertices();
        
        Draw canvas = new DrawExtra07();
        
        // ODKOMENTOVAT !!!!   canvas.paintSimplePolygon(pol);
        
    }
}
