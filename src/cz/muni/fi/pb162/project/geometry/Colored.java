package cz.muni.fi.pb162.project.geometry;

/**
 * Objects with color.
 * 
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public interface Colored {
    
    /**
     * Returns color of the object.
     * 
     * @return Color name.
     */
    String getColor();
    
    /**
     * Sets new color.
     * 
     * @param color Color name
     */
    void setColor(String color);
}
