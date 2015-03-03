package cz.muni.fi.pb162.project.geometry;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implements abstract class polygon by storing the vertices in map
 *
 * @author Wallecnik
 * @version 4.12.2014
 */
public class LabeledPolygon extends SimplePolygon implements PolygonIO{

    private SortedMap<String,Vertex2D> vertices = new TreeMap<String, Vertex2D>();

    /**
     * Adds new vertex to polygon
     *
     * @param label name of the vertex (usually literal)
     * @param vert  vertex to be added
     */
    public void addVertex(String label, Vertex2D vert) {
        if (label == null) throw new NullPointerException("label of vertex cannot be null");
        if (vert == null) throw new NullPointerException("vertex cannot be null");
        vertices.put(label, vert);
    }

    /**
     * Returns vertex at given index modulo number of indices.
     *
     * @param index vertex index
     * @return vertex at given index modulo number of indices
     * @throws IllegalArgumentException if index is negative
     */
    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if (index < 0) throw new IllegalArgumentException("index cannot be negative");
        int i=0;
        for (String label : getLabels()) {
            if (i == index % getNumVertices()) return vertices.get(label);
            i++;
        }
        return null;
    }

    /**
     * Returns vertex named by the label parameter
     *
     * @param label vertex index
     * @return vertex at given label
     * @throws IllegalArgumentException if label does not exist
     */
    public Vertex2D getVertex(String label) throws IllegalArgumentException {
        if (!vertices.containsKey(label)) throw new IllegalArgumentException("Vertex is not present");
        return vertices.get(label);
    }

    /**
     * Returns number of vertices of the polygon.
     *
     * @return number of vertices
     */
    @Override
    public int getNumVertices() {
        return vertices.size();
    }

    /**
     * Returns a sorted set of keys of this polygon in ascending order
     *
     * @return set of keys
     */
    public Collection<String> getLabels() {
        return Collections.unmodifiableSet(vertices.keySet());
    }

    /**
     * Returns all labels of given vertex
     *
     * @param vert vertex to find labels for
     * @return set of keys
     */
    public Collection<String> getLabels(Vertex2D vert) {
        Collection<String> labels = new HashSet<String>();
        for (String label : vertices.keySet()){
            if (vertices.get(label).equals(vert)) labels.add(label);
        }
        return labels;
    }

    /**
     * Returns vertexes on duplicite positions, but each position only once
     *
     * @return set of vertexes that are duplicite in the polygon
     */
    public Collection<Vertex2D> duplicateVertices() {
        SortedMap<String, Vertex2D> duplicates = new TreeMap<String, Vertex2D>(vertices);
        for (String label : vertices.keySet()) {
            Vertex2D vert = duplicates.remove(label);
            if (duplicates.containsValue(vert))
                duplicates.put(label, vert);
        }
        return new HashSet<Vertex2D>(duplicates.values());
    }

    /**
     * Returns a sorted collection of vertices in ascending order
     *
     * @return set of vertices
     */
    public Collection<Vertex2D> getSortedVertices() {
        return new TreeSet<Vertex2D>(vertices.values());
    }

    /**
     * Returns a sorted collection of vertices sorted with given comparator
     *
     * @return set of vertices
     */
    public Collection<Vertex2D> getSortedVertices(Comparator comparator) {
        Collection retCol = new TreeSet<Vertex2D>(comparator);
        retCol.addAll(vertices.values());
        return retCol;
    }

    /**
     * Takes an opened stream and writes into it
     *
     * @param os already opened stream to write into
     * @throws IOException if some IO error occurs
     */
    public void write(OutputStream os) throws IOException {
        if (os == null) throw new NullPointerException();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(os));

            for (String label : getLabels()) {
                Vertex2D vert = getVertex(label);
                bw.write(vert.getX() + " " + vert.getY() + " " + label);
                bw.newLine();
            }
        } finally {
            bw.flush();
        }
    }

    /**
     * Takes an opened file and writes into it
     *
     * @param file already opened file to write into
     * @throws IOException if some IO error occurs
     */
    public void write(File file) throws IOException {
        if (file == null) throw new NullPointerException();
        OutputStream os = new FileOutputStream(file);
        try {
            write(os);
        }
        finally {
            os.close();
        }
    }

    /**
     * Takes an opened stream and reads from it
     *
     * @param is already opened stream to read from
     * @throws IOException if some IO error occurs
     */
    public void read(InputStream is) throws IOException {
        if (is == null) throw new NullPointerException();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            Pattern pattern = Pattern.compile("^(-?\\d+.\\d+) (-?\\d+.\\d+) (.+)$");
            Map<String, Vertex2D> vertices = new HashMap<String, Vertex2D>();

            String line = br.readLine();
            while (line != null) {


                Matcher matcher = pattern.matcher(line);
                if (! matcher.find()) throw new IOException("input format");

                double x = Double.parseDouble(matcher.group(1));
                double y = Double.parseDouble(matcher.group(2));
                String name = matcher.group(3);

                vertices.put(name, new Vertex2D(x, y));

                line = br.readLine();

            }

            this.vertices.putAll(vertices);

        }
        finally {
            br.close();
        }
    }

    /**
     * Takes an opened file and reads from it
     *
     * @param file already opened file to read from
     * @throws IOException if some IO error occurs
     */
    public void read(File file) throws IOException {
        if (file == null) throw new NullPointerException();
        InputStream is = new FileInputStream(file);
        try {
            read(is);
        }
        finally {
            is.close();
        }
    }

    /**
     * Takes an opened stream and writes into it
     * Does not use writer, but writes binary data
     *
     * @param os already opened stream to write into
     * @throws IOException if some IO error occurs
     */
    public void binaryWrite(OutputStream os) throws IOException {
        if (os == null) throw new NullPointerException();

        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(os);

            for (String label : getLabels()) {
                Vertex2D vert = getVertex(label);
                String line = vert.getX() + " " + vert.getY() + " " + label;
                bos.write(line.getBytes());
                bos.write(System.getProperty("line.separator").getBytes());
            }
        } finally {
            bos.flush();
        }
    }
}
