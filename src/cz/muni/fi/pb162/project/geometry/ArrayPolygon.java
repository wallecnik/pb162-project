package cz.muni.fi.pb162.project.geometry;

import java.lang.reflect.Array;

/**
 * Implements abstract class polygon by storing the vertices in an array
 *
 * @author Wallecnik
 * @version 7.11.2014
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

    /**
     * Inverts the stored order of the vertices
     * First is now last adn vice-versa
     */
    public void invert() {

        int numVertices = getNumVertices();

        //swap every vertex (no need of the middle one)
        for (int i = 0; i < (numVertices / 2); i++) {
            Vertex2D vert = vertices[i];
            vertices[i] = vertices[numVertices - 1 - i];
            vertices[numVertices - 1 - i] = vert;
        }

    }

    /**
     * Compares if this and given polygon are the same if they are drawn
     * vertices in the array can be moved or even inverted
     *
     * @param pol ArrayPolygon to compare with
     * @return    true if yes false if not
     */
    public boolean compare(ArrayPolygon pol) {

        if (this.getNumVertices() != pol.getNumVertices()) return false;

        if (compareAll(pol)) return true;

        //not the same try invert order
        boolean kontr = false;

        this.invert();
        if (compareAll(pol)) kontr = true;
        this.invert();

        if (kontr) return true;

        return false;

    }

    /**
     * Compares if this and given polygon has the same vertexes in the same order
     * vertexes can be "moved" but not inverted
     *
     * @param pol ArrayPolygon to compare with
     * @return    true if zes false if not
     */
    private boolean compareAll (ArrayPolygon pol) {

        int numVertices = getNumVertices();
        boolean kontr;

        //find the index of the vertex in @param pol that is the same as first vertex in this polygon
        int vertexIndex = 0;
        kontr = false;
        for (int i = 0; i < numVertices; i++) {

            if (vertices[0].equals(pol.getVertex(i))) {
                vertexIndex = i;
                kontr = true;
                break;
            }

        }

        //same vertex was not found
        if (!kontr) return false;

        //start comparing in one order
        kontr = true;
        for (int i = 0; i < numVertices; i++) {

            if (vertices[i].equals(pol.getVertex(vertexIndex + i))) {
                //do nothing - this is ok
            }
            else {
                kontr = false;
                break;
            }

        }

        //the for cycle reached its end and every vertex is moved good
        if (kontr) return true;

        return false;

    }

}














