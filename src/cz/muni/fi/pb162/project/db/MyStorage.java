package cz.muni.fi.pb162.project.db;

import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;

/**
 * Storage class for connecting, checking and sending data
 *
 * @author Wallecnik
 * @version 13.11.2014
 */
public class MyStorage implements Storage {

    private Connector connector;
    private int maxAttempts;

    /**
     * Constructor for objects of class MyStorage
     *
     * @param connector   connector to be used when establishing a connection
     * @param maxAttempts maximum amount of attempts to try when storing data
     */
    public MyStorage (Connector connector, int maxAttempts) throws IllegalArgumentException {

        if (connector == null) throw new IllegalArgumentException("connector cannot be null.");
        if (maxAttempts < 1) throw new IllegalArgumentException("maxAttempts must be positive");

        this.connector = connector;
        this.maxAttempts = maxAttempts;

    }

    /**
     * Stores data in remote Db server.
     *
     * @param host Address of remote DB server
     * @param data Data to store
     * @throws DbUnreachableException if DB is unreachable
     * @throws CannotStoreException if the method failed during the storing data into DB
     */
    public void store(String host, Object data) throws DbUnreachableException, CannotStoreException {

        Connection connection;

        try {
            connection = connector.getConnection(host);
        } catch (UnknownHostException uhe) {
            throw new DbUnreachableException("", uhe);
        } catch (NoRouteToHostException nrthe) {
            throw new DbUnreachableException("", nrthe);
        }

        int counter = 0;

        do {
            try {
                counter++;
                connection.sendData(data);
                return;
            } catch (IOException ioe) {
                if (counter >= maxAttempts)
                    throw new CannotStoreException("Data cannot be stored", ioe);
            }
        } while (true);

    }

}
