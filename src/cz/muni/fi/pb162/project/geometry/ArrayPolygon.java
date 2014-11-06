package cz.muni.fi.pb162.project.geometry;

import java.lang.reflect.Array;

/**
 * Created by Wallecnik on 06.11.14.
 */
public class ArrayPolygon extends SimplePolygon {

    private Vertex2D[] vertices;

    /**
     * Constructor of object of type ArrayPolygon
     *
     * @param  array             array of vertices of this polygon
     * @throws NullPointerException if any vertex in the array is null
     */
    public ArrayPolygon (Vertex2D[] array) throws NullPointerException {

        this.vertices = new Vertex2D[array.length];

        for (int i = 0; i < array.length; i++) {
            this.vertices[i] = array[i];
            if (array[i] == null) throw new NullPointerException("Vertex of polygon cannot be null");
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
        return vertices[index % getNumVertices()];
    }

    /**
     * Returns number of vertices of the polygon.
     *
     * @return number of vertices
     */
    public int getNumVertices() {
        return this.vertices.length;
    }
}
