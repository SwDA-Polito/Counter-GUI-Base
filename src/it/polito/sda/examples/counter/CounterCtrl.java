package it.polito.sda.examples.counter;

import javax.swing.JOptionPane;

/**
 * Controller class handles user interactions and coordinates between the Counter model and CounterUI view.
 * 
 * @author Marco Torchiano
 * @version 1.0
 */
public class CounterCtrl {
    Counter counter;
    CounterUI ui;

    /**
     * Constructs a new CounterCtrl with the specified counter model.
     * 
     * @param counter the Counter model to control
     */
    public CounterCtrl(Counter counter){
        this.counter = counter;
    }

    /**
     * Sets the UI view associated with this controller.
     * 
     * @param ui the CounterUI view to be updated by this controller
     */
    public void setUI(CounterUI ui){
        this.ui = ui;
    }

    /**
     * Handles the plus button action.
     * Increments the counter and updates the UI.
     */
    public void plus(){
        counter.increment();
        ui.update();
    }

    /**
     * Handles the minus button action.
     * Decrements the counter and updates the UI.
     * Displays an error dialog if decrementing below zero is attempted.
     */
    public void minus(){
        try{
            counter.decrement();
        }catch(IllegalStateException ise){
            JOptionPane.showMessageDialog(ui, ise, "Error", JOptionPane.ERROR_MESSAGE);
        }
        ui.update();
    }

    /**
     * Handles the reset button action.
     * Resets the counter to zero and updates the UI.
     */
    public void reset(){
        counter.reset();
        ui.update();
    }
}
