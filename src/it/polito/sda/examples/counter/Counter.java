package it.polito.sda.examples.counter;

/**
 * Represents a simple counter model that maintains an integer value.
 * The counter supports increment, decrement, and reset operations.
 * The value cannot be decremented below zero.
 * 
 * @author SDA Examples
 * @version 1.0
 */
public class Counter {

    private int value;

    /**
     * Increments the counter value by one.
     */
    public void increment(){ 
        value++;  // increments value
    }

    /**
     * Decrements the counter value by one.
     * 
     * @throws IllegalStateException if the current value is zero
     */
    public void decrement(){ 
        if(value==0) // if already zero signal error
            throw new IllegalStateException("Connot decrement at zero"); 
        value--; // otherwise decrements
    }

    /**
     * Resets the counter value to zero.
     */
    public void reset(){
        value=0;  // increments value
    }

    /**
     * Returns the current value of the counter.
     * 
     * @return the current counter value
     */
    public int getValue(){ return value; }
}
