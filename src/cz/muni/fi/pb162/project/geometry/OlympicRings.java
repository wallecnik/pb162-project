package cz.muni.fi.pb162.project.geometry;


/** Class representing olympic rings in 2D plain
 *
 * Object contains only the middle black ring and creates the other rings
 * on demand, but do not contains them.
 *
 * @author Wallecnik
 * @version 23.10.2014
 */
public class OlympicRings {

    private Circle blackRing;
    private Circle blueRing;
    private Circle redRing;
    private Circle yellowRing;
    private Circle greenRing;

    /**
     * Constructor of objects of class OlympicRings
     *
     * @param center
     * @param radius
     */
    public OlympicRings (Vertex2D center, double radius) {

        double centerX = center.getX();
        double centerY = center.getX();

        blackRing = new Circle(center, radius);
        blueRing = new Circle(
                new Vertex2D(centerX - radius * 2 * 1.2, centerY),
                radius);
        redRing = new Circle(
                new Vertex2D(centerX + radius * 2 * 1.2, centerY),
                radius);
        yellowRing = new Circle(
                new Vertex2D(centerX - radius * 2 * 0.6, centerY - radius * 2 * 0.6),
                radius);
        greenRing = new Circle(
                new Vertex2D(centerX + radius * 2 * 0.6, centerY - radius * 2 * 0.6),
                radius);

        blackRing.setColor("black");
        blueRing.setColor("blue");
        redRing.setColor("red");
        yellowRing.setColor("yellow");
        greenRing.setColor("green");

    }

    public Circle getBlackRing() {
        return this.blackRing;
    }

    public Circle getBlueRing() {
        return this.blueRing;
    }

    public Circle getGreenRing() {
        return this.greenRing;
    }

    public Circle getYellowRing() {
        return this.yellowRing;
    }

    public Circle getRedRing() {
        return this.redRing;
    }

}
