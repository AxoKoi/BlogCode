
package misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class RutTest {

    @Test
    public void isValidRut() {
        assertTrue(Rut.isValidRut(11111111,1));
        assertTrue(Rut.isValidRut(12345678,5));
    }

    @Test
    public void rut() {
        Rut rut = new Rut(12345678,5);
        assertEquals(12345678, rut.getValue());
        assertEquals(Rut.VerificationDigit.FIVE, rut.getVerificationDigit());
    }
}
