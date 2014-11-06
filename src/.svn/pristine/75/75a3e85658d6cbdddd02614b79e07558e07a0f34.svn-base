package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Solid;

/**
 * Interface for convex regular polygons, e.g. equilateral triangle, suqare, regular octagon, etc..
 * 
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public interface RegularPolygon  extends Solid {

    /**
     * Returns number of edges of the regular polygon.
     * 
     * @return number of edges
     */
    int getNumEdges();
    
    /**
     * Returns length of single edge.
     * 
     * @return edge length
     */
    double getEdgeLength();

    /**
     * Returns center of the minimum bounding circle.
     * 
     * @return center of the minimum bounding circle
     */
    Vertex2D getCenter();
    
    /**
     * Returns radius of the minimum bounding circle.
     * 
     * @return radius of the minimum bounding circle
     */
    double getRadius();
    
}
