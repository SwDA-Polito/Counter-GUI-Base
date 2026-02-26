package it.polito.sda.examples.counter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Counter UI
 */
class CounterUITest {

    private Counter counter;
    private CounterCtrl controller;
    private CounterUI ui;

    @BeforeEach
    void setUp() {
        counter = new Counter();
        controller = new CounterCtrl(counter);
        ui = new CounterUI(counter, controller);
        ui.start();
    }

    @AfterEach
    void tearDown() {
        if (ui != null) {
            ui.dispose();
        }
    }

    @Test
    void testInitialLabelValueIsZero() {
        assertEquals("0", ui.label.getText());
    }

    @Test
    void testPlusButtonClickUpdatesLabel() {
        ui.plus.doClick();
        assertEquals("1", ui.label.getText());
    }

    @Test
    void testMinusButtonClickUpdatesLabel() {
        ui.plus.doClick();
        ui.plus.doClick();
        ui.minus.doClick();
        assertEquals("1", ui.label.getText());
    }

    @Test
    void testResetButtonClickUpdatesLabel() {
        ui.plus.doClick();
        ui.plus.doClick();
        ui.plus.doClick();
        ui.reset.doClick();
        assertEquals("0", ui.label.getText());
    }

    @Test
    void testMultiplePlusClicks() {
        ui.plus.doClick();
        ui.plus.doClick();
        ui.plus.doClick();
        assertEquals("3", ui.label.getText());
    }

    @Test
    void testUIUpdateReflectsModelState() {
        counter.increment();
        counter.increment();
        ui.update();
        assertEquals("2", ui.label.getText());
    }

    @Test
    void testWindowTitle() {
        assertEquals("Counter", ui.getTitle());
    }
}
