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
     * Constructor of objects of class Olympicrings
     *
     * @param center
     * @param radius
     */
    public OlympicRings (Vertex2D center, double radius) {

        this.blackRing = new Circle(center, radius);
        setBlueRing();
        setGreenRing();
        setRedRing();
        setYellowRing();

    }

    public Circle getBlackRing() { return this.blackRing; }

    public Circle getBlueRing() { return this.blueRing; }

    public Circle getGreenRing() { return this.greenRing; }

    public Circle getYellowRing() { return this.yellowRing; }

    public Circle getRedRing() { return this.redRing; }

    private void setBlueRing() {

        blueRing =  new Circle(
                new Vertex2D(
                        blackRing.getCenter().getX() - blackRing.getRadius() * 2 * 1.2,
                        blackRing.getCenter().getY()
                ),
                blackRing.getRadius()
        );
        blueRing.setColor("blue");

    }

    private void setRedRing() {

        redRing = new Circle(
                new Vertex2D(
                        blackRing.getCenter().getX() + blackRing.getRadius() * 2 * 1.2,
                        blackRing.getCenter().getY()
                ),
                blackRing.getRadius()
        );
        redRing.setColor("red");

    }

    private void setYellowRing() {

        yellowRing = new Circle(
                new Vertex2D(
                        blackRing.getCenter().getX() - blackRing.getRadius() * 2 * 0.6,
                        blackRing.getCenter().getY() - blackRing.getRadius() * 2 * 0.6
                ),
                blackRing.getRadius()
        );
        yellowRing.setColor("yellow");

    }

    private void setGreenRing() {

        greenRing = new Circle(
                new Vertex2D(
                        blackRing.getCenter().getX() + blackRing.getRadius() * 2 * 0.6,
                        blackRing.getCenter().getY() - blackRing.getRadius() * 2 * 0.6
                ),
                blackRing.getRadius()
        );
        greenRing.setColor("green");

    }

}
