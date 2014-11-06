package cz.muni.fi.pb162.project.geometry;

/**
 * Measurable objects, i.e. 2D objects with meaninful length or perimeter,
 * width and height.
 * 
 * @author Radek Oslejsek, oslejsek@fi.muni.cz
 */
public interface Measurable {

    /**
     * Returns the width of the object, 
     * i.e. the width of the smallest bounding rectangle.
     * 
     * @return object's width
     */
    double getWidth();
    
    /**
     * Returns the height of the object, 
     * i.e. the height of the smallest bounding rectangle.
     * 
     * @return object's height
     */
    double getHeight();

    /**
     * Returns either the length of open 2D geometry (e.g. the length of a polyline) 
     * or the perimeter of enclosed 2D object (e.g. the perimeter of a polygon).
     * 
     * @return length or perimeter
     */
    double getLength();    
}
