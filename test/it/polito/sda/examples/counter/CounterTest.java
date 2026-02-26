package it.polito.sda.examples.counter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Counter class.
 */
class CounterTest {

    private Counter counter;

    @BeforeEach
    void setUp() {
        counter = new Counter();
    }

    @Test
    void testInitialValueIsZero() {
        assertEquals(0, counter.getValue());
    }

    @Test
    void testIncrement() {
        counter.increment();
        assertEquals(1, counter.getValue());
    }

    @Test
    void testMultipleIncrements() {
        counter.increment();
        counter.increment();
        counter.increment();
        assertEquals(3, counter.getValue());
    }

    @Test
    void testDecrement() {
        counter.increment();
        counter.increment();
        counter.decrement();
        assertEquals(1, counter.getValue());
    }

    @Test
    void testDecrementAtZeroThrowsException() {
        assertThrows(IllegalStateException.class, () -> counter.decrement());
    }

    @Test
    void testReset() {
        counter.increment();
        counter.increment();
        counter.increment();
        counter.reset();
        assertEquals(0, counter.getValue());
    }

    @Test
    void testResetFromZero() {
        counter.reset();
        assertEquals(0, counter.getValue());
    }
}
