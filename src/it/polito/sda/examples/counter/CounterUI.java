package it.polito.sda.examples.counter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;

/**
 * Provides a graphical user interface with increment, decrement, and reset buttons.
 * Displays the current counter value in a centered label.
 * 
 * @author SDA Examples
 * @version 1.0
 */
public class CounterUI extends JFrame {
    JLabel label = new JLabel("0");
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton reset = new JButton("Reset");
    Counter counter;

    /**
     * Constructs a new CounterUI with the specified counter model and controller.
     * Initializes the GUI components and sets up event listeners.
     * 
     * @param counter the Counter model to display
     * @param controller the CounterCtrl that handles user interactions
     */
    public CounterUI(Counter counter, CounterCtrl controller) {
        super("Counter");
        this.counter = counter;

        // layout
        JPanel rootContainer = new JPanel();
        rootContainer.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        rootContainer.add(topPanel, BorderLayout.NORTH);
        topPanel.add(plus);
        topPanel.add(minus);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Helvetica", Font.BOLD, 20));
        rootContainer.add(label, BorderLayout.CENTER);
        rootContainer.add(reset, BorderLayout.SOUTH);

        // events
        controller.setUI(this);
        plus.addActionListener(e -> controller.plus());
        minus.addActionListener(e -> controller.minus());
        reset.addActionListener(e -> controller.reset());


        this.add(rootContainer);
    }

    public void start() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Updates the display label with the current counter value.
     * Called by the controller after the model state changes.
     */
    public void update(){
        label.setText(String.valueOf(counter.getValue()));
    }

}