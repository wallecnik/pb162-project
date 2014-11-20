package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Implements abstract class polygon by storing the vertices in an array
 *
 * @author Wallecnik
 * @version 20.11.2014
 */
public class CollectionPolygon extends SimplePolygon {

    private List<Vertex2D> vertices;

    /**
     * Constructor of object of type collectionPolygon
     *
     * @param  array                array of vertices of this polygon
     * @throws NullPointerException if any vertex in the array is null
     */
    public CollectionPolygon(Vertex2D[] array) throws NullPointerException {

        if (array == null) throw new NullPointerException("Array cannot be null");

        this.vertices = new ArrayList<Vertex2D>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) throw new NullPointerException("Vertex of polygon cannot be null");
            this.vertices.add(array[i]);
        }

    }

    /**
     * Returns vertex at given index modulo number of indices.
     *
     * @param index vertex index
     * @return vertex at given index modulo number of indices
     * @throws IllegalArgumentException if index is negative
     */
    public Vertex2D getVertex(int index) throws IllegalArgumentException {

        if (index < 0) throw new IllegalArgumentException("Index of vertex cannot be negative.");

        return vertices.get(index % getNumVertices());

    }

    /**
     * Returns number of vertices of the polygon.
     *
     * @return number of vertices
     */
    public int getNumVertices() {
        return this.vertices.size();
    }

    /**
     * Inverts the stored order of the vertices
     * First is now last and vice-versa
     */
    public CollectionPolygon invert() {

        Vertex2D[] retVert = new Vertex2D[this.getNumVertices()];

        for (int i = 0; i < getNumVertices(); i++) {
            retVert[i] = this.getVertex(getNumVertices() - i - 1);
        }

        return new CollectionPolygon(retVert);

    }

    /**
     * Returns Collection of all vertices of this polygon
     *
     * @return unmodifiable collection of all vertices
     */
    public Collection<Vertex2D> getVertices() {

        return Collections.unmodifiableCollection(this.vertices);

    }

    /**
     * Deletes all leftmost vertices in the polygon (it can be more than one)
     *
     * @return Collection of vertices that was deleted
     */
    public Collection<Vertex2D> removeLeftmostVertices() {

        Collection<Vertex2D> retCol = new ArrayList<Vertex2D>();

        double mostLeftX = this.getVertex(0).getX();

        //get leftmost coordinate
        for (Vertex2D vert : this.vertices) {
            if (vert.getX() < mostLeftX)
                mostLeftX = vert.getX();
        }

        for (int i = 0; i < getNumVertices(); i++) {
            if (this.getVertex(i).getX() == mostLeftX) {
                retCol.add(getVertex(i));
                this.vertices.remove(i);
            }
        }

        return retCol;

    }

}














