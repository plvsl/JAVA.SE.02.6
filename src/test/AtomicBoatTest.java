package test;

import main.AtomicBoat;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class AtomicBoatTest {
    AtomicBoat atomicBoat;

    @Test
    public void checkIsEngineStartedMethodAndStartEngineMethodAndStopEngineMethod() {
        atomicBoat = new AtomicBoat(100);
        assertFalse(atomicBoat.isEngineStarted());
        atomicBoat.startEngine();
        assertTrue(atomicBoat.isEngineStarted());
        atomicBoat.stopEngine();
        assertFalse(atomicBoat.isEngineStarted());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void checkUnsupportedOperationExceptionThrowingForNotStartedAtomicEngine()
            throws UnsupportedOperationException {
        atomicBoat = new AtomicBoat(100);
        assertFalse(atomicBoat.isEngineStarted());
        atomicBoat.go(20);
    }

    @Test
    public void checkGoMethodPositiveTest() {
        atomicBoat = new AtomicBoat(100);
        atomicBoat.startEngine();
        assertEquals("we are going, we are going, ", atomicBoat.go(2));
    }

    @Test
    public void checkGoMethodNegativeTest() {
        atomicBoat = new AtomicBoat(2);
        atomicBoat.startEngine();
        assertEquals("we are going, we are going, oil is over", atomicBoat.go(3));
    }

}
