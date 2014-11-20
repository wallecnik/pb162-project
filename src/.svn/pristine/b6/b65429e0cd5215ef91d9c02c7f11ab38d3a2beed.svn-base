package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.BasicRulesTester;
import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.db.CannotStoreException;
import cz.muni.fi.pb162.project.db.Connection;
import cz.muni.fi.pb162.project.db.Connector;
import cz.muni.fi.pb162.project.db.DbException;
import cz.muni.fi.pb162.project.db.DbUnreachableException;
import cz.muni.fi.pb162.project.db.MyStorage;
import cz.muni.fi.pb162.project.db.Storage;
import cz.muni.fi.pb162.project.db.UnrealibleConnector;
import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class ProjectTest {
    
    @Test public void task01() {
        BasicRulesTester.testAncestor(Exception.class, DbException.class);
        BasicRulesTester.testAncestor(DbException.class, DbUnreachableException.class);
        BasicRulesTester.testAncestor(DbException.class, CannotStoreException.class);
        
        try {
            DbException.class.getConstructor(String.class, Throwable.class);
            DbUnreachableException.class.getConstructor(String.class, Throwable.class);
            CannotStoreException.class.getConstructor(String.class, Throwable.class);
        } catch (NoSuchMethodException ex) {
            fail("Vyjimky maji umoznit nastavit chybovou hlasku a zaroven pricinu");
        }
    }

    @Test public void task02() {
        assertTrue("MyStorage neimplementuje rozhrani Storage", 
                new MyStorage(new TestConnector(), 1) instanceof Storage);
        
        // test MyStorage with null Connector
        try {
            Storage st = new MyStorage(null,1);
	    fail("Podarilo se vytvorit instanci tridy MyStorage s parametrem " +
		    "connector = null, aniz by konstruktor vyhodil vyjimku " +
		    "NullPointerException nebo IllegalArgumentException");
	} catch (NullPointerException e) {
	    assertTrue("Vyjimka vyhozena konstruktorem " +
		    "MyStorage by jako popis chyby mela " +
		    "obsahovat nazev chybneho parametru",e.getMessage().contains("connector"));
	} catch (IllegalArgumentException e) {
	    assertTrue("Vyjimka vyhozena konstruktorem " +
		    "MyStorage by jako popis chyby mela " +
		    "obsahovat nazev chybneho parametru",e.getMessage().contains("connector"));
	}
        
        // test MyStorage with wrong retries
        try {
	    Storage st = new MyStorage(new UnrealibleConnector(),-1);
	    fail("Podarilo se vytvorit instanci tridy MyStorage se zapornym" +
		    " poctem opakovani (retries), aniz by konstruktor vyhodil " +
		    "vyjimku IllegalArgumentException");
	} catch (IllegalArgumentException e) {
	    assertTrue("Vyjimka IllegalArgumentException vyhozena konstruktorem " +
		    "MyStorage by jako popis chyby mela " +
		    "obsahovat nazev chybneho parametru",
		    e.getMessage().contains("maxAttempts"));
	}
	try {
            Storage st = new MyStorage(new UnrealibleConnector(),0);
	    fail("Podarilo se vytvorit instanci tridy MyStorage s nulovym" +
		    " poctem opakovani (retries), aniz by konstruktor vyhodil " +
		    "vyjimku IllegalArgumentException");
	} catch (IllegalArgumentException e) {
	    assertTrue("Vyjimka IllegalArgumentException vyhozena konstruktorem " +
		    "MyStorage by jako popis chyby mela " +
		    "obsahovat nazev chybneho parametru",
		    e.getMessage().contains("maxAttempts"));
	}
        
        // test send data
        TestConnector connector = new TestConnector();
        Storage st = new MyStorage(connector,1);
        Circle circle = new Circle();
	try {
	    st.store("address1", circle);
	} catch (Exception ex) {
	    fail("Metoda Storage.store() vyhodila neocekavane vyjimky " + ex);
	}
	assertEquals("Spojeni nebylo navazano se spravnou adresou","" +
		"address1",connector.host);
	assertEquals("Pri posilani gr. objektu na vzdaleny server nebyl objekt predan konektoru",
		circle,connector.sentData);
	assertEquals("Metoda Connector.getConnection() byla zbytecne volana vicekrat",
		1,connector.getConnectionCounter);
	assertEquals("Metoda Connection.sendData() byla zbytecne volana vicekrat",
		1,connector.sendDataCounter);
        
        // multiple invocation of store()
        connector.getConnectionCounter = 0;
        connector.sendDataCounter = 0;
        try {
	    st.store("address1", circle);
	} catch (Exception ex) {
	    fail("Opakovane volani metody Storage.store() vyvolalo neocekavanou vyjimku " + ex);
	}
	assertEquals("Opakovane volani metody Storage.store(): Spojeni nebylo navazano se spravnou adresou","" +
		"address1",connector.host);
	assertEquals("Opakovane volani metody Storage.store(): Pri posilani gr. objektu na vzdaleny server nebyl objekt predan konektoru",
		circle,connector.sentData);
	assertEquals("Opakovane volani metody Storage.store(): Metoda Connector.getConnection() byla zbytecne volana vicekrat",
		1,connector.getConnectionCounter);
	assertEquals("Opakovane volani metody Storage.store(): Metoda Connection.sendData() byla zbytecne volana vicekrat",
		1,connector.sendDataCounter);
        
        // test connection with unknown host
        connector = new TestConnector();
	st = new MyStorage(connector,5);
        connector.connectionException = new UnknownHostException();
	try {
	    st.store("address1", circle);
	    fail("Metoda MyStorage.store() nevyhodi vyjimku, " +
		    "ackoliv se nepodarilo navazat spojeni a metoda " +
		    "Connector.getConnection() vyhodila vyjimku UnknownHostException");
	} catch (DbUnreachableException ex) {
	    assertSame("Vyjimka DbUnreachableException vyvolana jako reakce na " +
		    "vyjimku UnknownHostException nema spravne nastavenou " +
		    "svoji pricinu",connector.connectionException,ex.getCause());
	    assertNotNull("Vyjimka DbUnreachableException vyvolana jako reakce na " +
		    "vyjimku UnknownHostException nema nastavenou smysluplnou zpravu " +
		    "o chybe",ex.getMessage());
	} catch (Exception ex) {
	    fail("Metoda MyStorage.store() misto ocekavane vyjimky " +
		    "DbUnreachableException vyhodila vyjimku " + ex);
	}
	assertEquals("Metoda Connector.getConnection() byla zbytecne volana vicekrat",
		1,connector.getConnectionCounter);
        
        
        // test connection with no route to host
        connector = new TestConnector();
	st = new MyStorage(connector,5);
        connector.connectionException = new NoRouteToHostException();
	try {
            st.store("address1", circle);
	    fail("Metoda MyStorage.store() nevyhodi vyjimku, " +
		    "ackoliv se nepodarilo navazat spojeni a metoda " +
		    "Connector.getConnection() vyhodila vyjimku NoRouteToHostException");
	} catch (DbUnreachableException ex) {
	    assertSame("Vyjimka DbUnreachableException vyvolana jako reakce na " +
		    "vyjimku NoRouteToHostException nema spravne nastavenou " +
		    "svoji pricinu",connector.connectionException,ex.getCause());
	    assertNotNull("Vyjimka DbUnreachableException vyvolana jako reakce na " +
		    "vyjimku NoRouteToHostException nema nastavenou smysluplnou zpravu " +
		    "o chybe",ex.getMessage());
	} catch (Exception ex) {
	    fail("Metoda MyStorage.store() misto ocekavane vyjimky " +
		    "DbUnreachableException vyhodila vyjimku " + ex);
	}
	assertEquals("Metoda Connector.getConnection() byla zbytecne volana vicekrat",
		1,connector.getConnectionCounter);
        
        
        // test sending data with error and no retry
        connector = new TestConnector();
        st = new MyStorage(connector,1);
	connector.dataException = new IOException();
	connector.dataExceptionCounter = 1;
	try {
            st.store("address1", circle);
	    fail("Metoda MyStorage.store() nevyhodi vyjimku, " +
		    "ackoliv se nepodarilo poslat data a metoda " +
		    "Connection.sendData() vyhodila vyjimku IOException");
	} catch (CannotStoreException ex) {
	    assertSame("Vyjimka CannotStoreException vyvolana jako reakce na " +
		    "vyjimku IOException nema spravne nastavenou " +
		    "svoji pricinu",connector.dataException,ex.getCause());
	    assertNotNull("Vyjimka CannotStoreExceptionvyvolana jako reakce na " +
		    "vyjimku IOException nema nastavenou smysluplnou zpravu " +
		    "o chybe",ex.getMessage());
	} catch (Exception ex) {
	    fail("Metoda MyStorage.store() misto ocekavane vyjimky " +
		    "CannotStoreException vyhodila vyjimku " + ex);
	}
	assertEquals("Metoda Connector.getConnection() byla zbytecne volana vicekrat",
		1,connector.getConnectionCounter);
	assertEquals("Metoda Connection.sendData() byla zbytecne volana vicekrat",
		1,connector.sendDataCounter);
        
        
        // test sending data with error and retry is ok
        connector = new TestConnector();
        st = new MyStorage(connector,2);
	connector.dataException = new IOException();
	connector.dataExceptionCounter = 1;
	try {
            st.store("address1", circle);
	} catch (Exception ex) {
	    fail("Metoda MyStorage.store() vyhodila neocekavane vyjimku " 
		    + ex + " (jde o situaci, kdy napoprve metoda " +
		    "Connection.sendData() vyhodi vyjimku a az teprve napodruhe " +
		    "uspeje)");
	}
	assertEquals("Pri posilani gr. objektu na vzdaleny server nebyl objekt predan konektoru",
		circle,connector.sentData);
	assertEquals("Spojeni nebylo navazano se spravnou adresou","" +
		"address1",connector.host);
	assertEquals("Metoda Connector.getConnection() byla zbytecne volana vicekrat",
		1,connector.getConnectionCounter);
	assertEquals("Metoda Connection.sendData() byla zbytecne volana vicekrat",
		2,connector.sendDataCounter);
        
        
        // test sending data with error and retry is not ok
        connector = new TestConnector();
        st = new MyStorage(connector,2);
        connector.dataException = new IOException();
	connector.dataExceptionCounter = 2;

	try {
            st.store("address1", circle);
	    fail("Metoda MyStorage.store() nevyhodi vyjimku, " +
		    "ackoliv se nepodarilo poslat data ani napodruhe a pocet " +
		    "opakovani byl nastaven na dve");
	} catch (CannotStoreException ex) {
	    assertSame("Vyjimka CannotStoreException vyvolana jako reakce na " +
		    "vyjimku IOException nema spravne nastavenou " +
		    "svoji pricinu",connector.dataException,ex.getCause());
	    assertNotNull("Vyjimka CannotStoreExceptionvyvolana jako reakce na " +
		    "vyjimku IOException nema nastavenou smysluplnou zpravu " +
		    "o chybe",ex.getMessage());
	} catch (Exception ex) {
	    fail("Metoda MyStorage.store() misto ocekavane vyjimky " +
		    "CannotStoreException vyhodila vyjimku " + ex);
	}
	assertEquals("Metoda Connector.getConnection() byla zbytecne volana vicekrat",
		1,connector.getConnectionCounter);
	assertEquals("Metoda Connection.sendData() byla zbytecne volana vicekrat",
		2,connector.sendDataCounter);
                
        // test catching Exception instead of UnknownHostException and NoRouteToHostException
        st = new MyStorage(new FailConnector(), 1);
        circle = new Circle();
	try {
	    st.store("address1", circle);
	} catch (IllegalStateException ex) {
	    // ok
	} catch (Exception ex) {
            fail("Metoda Storage.store() zachytava uplne vsechny vyjimky " + ex);
        }
    }
    
    
    
    private static class TestConnector implements Connector {
	
	private IOException dataException;
	private IOException connectionException;
	private int dataExceptionCounter;
	private Object sentData;
	private String host;
	private int getConnectionCounter;
	private int sendDataCounter;
	
        @Override
	public Connection getConnection(String target) throws
		UnknownHostException, NoRouteToHostException 
        {
	    getConnectionCounter++;
	    if (connectionException instanceof NoRouteToHostException) {
		throw (NoRouteToHostException) connectionException;
	    } else if (connectionException instanceof UnknownHostException) {
		throw (UnknownHostException) connectionException;
	    } else {
		host = target;
		return new Connection() {
                    @Override
		    public void sendData(Object data) throws IOException {
			sendDataCounter++;
			if (dataExceptionCounter-- > 0 && dataException != null) {
			    throw dataException;
			}
			sentData = data;
		    }
		};
	    }
	}
    }

    private static class FailConnector implements Connector {
	
        @Override
	public Connection getConnection(String target) throws
		UnknownHostException, NoRouteToHostException 
        {
            throw new IllegalStateException();
	}
    }
}
