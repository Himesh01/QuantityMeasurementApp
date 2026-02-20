package quantitymeasurementapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import quantitymeasurementapp.QuantityMeasurement.FeetEquality;

public class TestFeetEquality {

    FeetEquality feet1;
    FeetEquality feet2;

    @Test
    public void testEquals() {
        feet1 = new FeetEquality(1);
        feet2 = new FeetEquality(1);
        assertEquals(feet1, feet2);
    }

    @Test
    public void testDifferent() {
        feet1 = new FeetEquality(1);
        feet2 = new FeetEquality(2);
        assertNotEquals(feet1, feet2);
    }

    @Test
    public void testNull() {
        feet1 = new FeetEquality(1);
        feet2 = null;
        assertNotEquals(feet1, feet2);
    }

    @Test
    public void testSameReference() {
        feet1 = new FeetEquality(1);
        assertEquals(feet1, feet1);
    }

    @Test
    public void testEmptyVariable() {
        feet1 = new FeetEquality(1);
        feet2 = new FeetEquality(); // default value = 0.0
        assertNotEquals(feet1, feet2);
    }
}