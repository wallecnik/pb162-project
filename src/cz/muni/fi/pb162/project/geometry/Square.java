package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing square in 2D plain
 *
 * @author Wallecnik
 * @version 23.10.2014
 */
public class Square extends GeneralRegularPolygon{

    /**
     * Constructor for object of class Square
     *
     * @param center     center of this square
     * @param edgeLenght length of the edges of this square
     */
    public Square (Vertex2D center, double edgeLenght) {

        super(center, 4, edgeLenght);

    }

    /**
     * Constructor for object of class Square
     *
     * @param radius radius of the minimum bounding circle
     * @param center center of this square
     */
    public Square (double radius, Vertex2D center) {

        super(center, 4, Math.sqrt(radius*radius) / 2.0);

    }

}
