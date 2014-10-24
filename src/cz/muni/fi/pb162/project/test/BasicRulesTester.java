package cz.muni.fi.pb162.project.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 * @author Petr Adamek
 */
public class BasicRulesTester extends junit.framework.Assert {

    private static void validateIdentifier(String identifier) {
	assertTrue("Indentifikator " + identifier, 
                identifier.charAt(0) == identifier.toLowerCase().charAt(0));
	assertFalse("Indentifikator " + identifier, identifier.contains("_"));
        assertFalse("Indentifikator " + identifier, identifier.contains("-"));
    }
    
    private static void validateConstIdentifier(String identifier) {
	assertTrue("Konstanta " + identifier, identifier.equals(identifier.toUpperCase()));
    }
    
    public static void testAttributes(Class clazz) {
	
	for (Field field : clazz.getDeclaredFields()) {
	    int mod = field.getModifiers();
	    if (Modifier.isStatic(mod) && Modifier.isFinal(mod)) {
		// constant
		validateConstIdentifier(field.getName());
	    } else {
		// regular attribute
		assertTrue("Viditelnost atributu", Modifier.isPrivate(mod));
		validateIdentifier(field.getName());
	    }
	}
    }
    
    public static void testMethods(Class clazz) {
	
	for (Method method : clazz.getDeclaredMethods()) {
	    validateIdentifier(method.getName());
	}
    }
    
    public static void testMethodsAndAttributes(Class clazz) {
	testAttributes(clazz);
	testMethods(clazz);
    }
    
    @SuppressWarnings("unchecked")
    public static void testAbstractMethod(Class clazz, String name, Class<?>... paramTypes) {
        Method method = null;
        try {
            method = clazz.getMethod(name, paramTypes);
        } catch (NoSuchMethodException ex) {
            fail("Trida " + clazz.getSimpleName() + " nema pozadovanou metodu " + 
                    getMethodSignature(name, paramTypes));
        }
        assertTrue("Metoda " + name + " ma byt abstraktni",
                Modifier.isAbstract(method.getModifiers()) || 
                !method.getDeclaringClass().equals(clazz));
    }
    
    /**
     * Tests presence of the implementation of non-abstract method in a class
     * @param clazz
     * @param name
     * @param paramTypes 
     */
    @SuppressWarnings("unchecked")
    public static void testNonAbstractMethod(Class clazz, String name, Class<?>... paramTypes) {
        Method method = null;
        try {
            method = clazz.getMethod(name, paramTypes);
        } catch (NoSuchMethodException ex) {
            fail("Trida " + clazz.getSimpleName() + " nema pozadovanou metodu " + 
                    getMethodSignature(name, paramTypes));
        }
        assertFalse("Metoda " + name + " nema byt abstraktni", Modifier.isAbstract(method.getModifiers()));
    }
    
    @SuppressWarnings("unchecked")
    public static void testStaticMethod(Class clazz, String name, Class<?>... paramTypes) {
        Method method = null;
        try {
            method = clazz.getMethod(name, paramTypes);
        } catch (NoSuchMethodException ex) {
            fail("Trida " + clazz.getSimpleName() + " nema pozadovanou metodu " + 
                    getMethodSignature(name, paramTypes));
        }
        assertTrue("Metoda " + name + " ma byt staticka", Modifier.isStatic(method.getModifiers()));
    }
    
    /**
     * Fails if the given class declares some of the given methods.
     * 
     * @param clazz
     * @param name
     * @param paramTypes 
     */
    @SuppressWarnings("unchecked")
    public static void testRedundantMethod(Class clazz, String name, Class<?>... paramTypes) {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(name, paramTypes);
            fail("Trida " + clazz.getSimpleName() + " nema mit metodu " + 
                    getMethodSignature(name, paramTypes));
        } catch (NoSuchMethodException ex) {
            // ok
        }
    }
    
    public static void testRunnableClass(Class clazz) {
        for (Method method: clazz.getMethods()) {
            if (!method.getName().equals("main")) continue;
            assertTrue("Spustitelna trida", Modifier.isStatic(method.getModifiers()));
            assertTrue("Spustitelna trida", Modifier.isPublic(method.getModifiers()));
            assertTrue("Spustitelna trida", method.getReturnType().equals(void.class));
            Class<?>[] params = method.getParameterTypes();
            assertNotNull("Spustitelna trida", params);
            assertTrue("Spustitelna trida", params.length == 1);
            assertTrue("Spustitelna trida", params[0].isArray());
            //assertTrue("Spustitelna trida", params[0].equals(String.class)); to do
            return; // ok
        }
        fail("Spustitelna trida");
    }
    
    @SuppressWarnings("unchecked")
    protected static String getMethodSignature(String name, Class<?>... paramTypes) {
        String m = "";
        if (paramTypes != null) {
            for (int i = 0; i < paramTypes.length; i++) {
                Class<?> p = paramTypes[i];
                m += p.getSimpleName();
                if (i < paramTypes.length - 1) m += ", ";
            }
            m += ")";
        }
        return name + "(" + m + ")";
    }
    
    public static void testAncestor(Class ancestor, Class clazz) {
        assertEquals("Trida " + clazz + " neni primym potomkem tridy " + ancestor,
		ancestor,clazz.getSuperclass());
    }
}
