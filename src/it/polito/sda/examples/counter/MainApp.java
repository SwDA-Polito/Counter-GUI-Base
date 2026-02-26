package it.polito.sda.examples.counter;

/**
 * Main application class that serves as the entry point for the Counter application.
 * Initializes and wires together the MVC components: Model, View, and Controller.
 * 
 * @author Marco Torchiano
 * @version 1.0
 */
public class MainApp {

    /**
     * Application entry point.
     * Creates the Counter model, CounterCtrl controller, and CounterUI view,
     * establishing the MVC architecture.
     */
    static void main(){
        Counter model = new Counter();
        CounterCtrl controller = new CounterCtrl(model);
        CounterUI view = new CounterUI(model, controller);
        view.start();
    }
}
