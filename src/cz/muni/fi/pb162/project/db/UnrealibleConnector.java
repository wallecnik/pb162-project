package cz.muni.fi.pb162.project.db;

import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * This class represents a simple fake Connector simulating unreliable connection 
 * to remote host (the connection is unsuccessful until several attempts).
 *
 * @author Radek Oslejsek &lt;oslejsek&amp;fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 * @author Tomas Pitner
 * @author Petr Adamek
 */
public class UnrealibleConnector implements Connector {

    Random random = new Random();
    int retries = random.nextInt(10);
    boolean nrthFailure = false;

    @Override
    public Connection getConnection(String target)
            throws UnknownHostException, NoRouteToHostException {

        retries--;
        if (retries <= 0) {
            retries = random.nextInt(10);
            if (nrthFailure = !nrthFailure) {
                throw new NoRouteToHostException("No route to " + target
                        + " (counter: " + retries + ").");
            } else {
                throw new UnknownHostException("No host: " + target
                        + " (counter: " + retries + ").");
            }
        } else {
            return new SimpleConnection(target);
        }
    }

    private class SimpleConnection implements Connection {

        private int retries = random.nextInt(8);
        private String host;

        private SimpleConnection(String host) {
            this.host = host;
        }

        @Override
        public void sendData(Object data) throws IOException {
            retries--;
            if (retries > 0) {
                throw new IOException("Cannot send data (counter: " + retries + ")");
            } else {
                retries = random.nextInt(8);
                System.out.println("Data '" + data + "' sent to '" + host + "'.");
            }
        }
    }
}
