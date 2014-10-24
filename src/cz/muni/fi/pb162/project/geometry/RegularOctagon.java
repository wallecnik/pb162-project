package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing octagon in 2D plain
 *
 * @author Wallecnik
 * @version 23.10.2014
 */
public class RegularOctagon extends GeneralRegularPolygon {

    /**
     * Constructor for object of class GeneralRegularPolygon
     *
     * @param center     center of this polygon
     * @param edgeLenght length of the edges of polygon
     */
    public RegularOctagon(Vertex2D center, double edgeLenght) {

        super(center, 8, edgeLenght);

    }

}
