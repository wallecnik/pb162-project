package cz.muni.fi.pb162.project.geometry;

/**
 * Class SimplePolygon implements some basic methods of every general polygon
 * It stands on other methods that are supposed to be implemented by non-abstract subclasses
 *
 * @author Wallecnik
 * @version 6.11.2014
 */
public abstract class SimplePolygon implements Polygon{

    /**
     * Returns the height of the object,
     * i.e. the height of the smallest bounding rectangle.
     *
     * @return object's height
     */
    public double getHeight() {

        Vertex2D mostTop = getVertex(0);
        Vertex2D mostBottom = getVertex(0);

        // get most top and most bottom vertex
        for (int i = 1; i < getNumVertices(); i++) {
            Vertex2D vert = getVertex(i);
            if (mostTop.getY() < vert.getY())
                mostTop = vert;
            if (mostBottom.getY() > vert.getY())
                mostBottom = vert;
        }

        return mostTop.getY() - mostBottom.getY();
        
    }

    /**
     * Returns the width of the object,
     * i.e. the width of the smallest bounding rectangle.
     *
     * @return object's width
     */
    public double getWidth() {

        Vertex2D mostRight = getVertex(0);
        Vertex2D mostLeft = getVertex(0);

        // get most left and most right vertex
        for (int i = 1; i < getNumVertices(); i++) {
            Vertex2D vert = getVertex(i);
            if (mostRight.getX() < vert.getX())
                mostRight = vert;
            if (mostLeft.getX() > vert.getX())
                mostLeft = vert;
        }

        return mostRight.getX() - mostLeft.getX();

    }

    /**
     * Returns either the length of open 2D geometry (e.g. the length of a polyline)
     * or the perimeter of enclosed 2D object (e.g. the perimeter of a polygon).
     *
     * @return length or perimeter
     */
    public double getLength() {

        double length = 0.0;

        for (int i = 0; i < getNumVertices(); i++) {
            length += getVertex(i).distance(getVertex(i + 1));
        }

        return length;

    }

    /**
     * Return area of a solid object.
     *
     * @return Area
     */
    public double getArea() {

        double area = 0.0;

        for (int i = 0; i < getNumVertices(); i++) {
            area += 0.5 * (getVertex(i).getX() * getVertex(i+1).getY() - getVertex(i+1).getX() * getVertex(i).getY());
        }

        return area;

    }

    /**
     * Nicely formatted string of all vertices of this object
     *
     * @return String with all vertices
     */
    @Override
    public String toString() {

        String retString = "Polygon: vertices =";

        for (int i = 0; i < getNumVertices(); i++) {
            retString += " " + getVertex(i).toString();
        }

        return retString;

    }
}
