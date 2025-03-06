import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumCalculator extends JFrame {
    private JTextField num1Field;
    private JTextField num2Field;
    private JTextField resultField;
    private JButton addButton;

    public SumCalculator() {
        // Set up the frame
        setTitle("Sum Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Use absolute positioning

        // Create components
        JLabel num1Label = new JLabel("Number 1:");
        num1Label.setBounds(20, 20, 100, 25);
        add(num1Label);

        num1Field = new JTextField();
        num1Field.setBounds(120, 20, 150, 25);
        add(num1Field);

        JLabel num2Label = new JLabel("Number 2:");
        num2Label.setBounds(20, 60, 100, 25);
        add(num2Label);

        num2Field = new JTextField();
        num2Field.setBounds(120, 60, 150, 25);
        add(num2Field);

        addButton = new JButton("Add");
        addButton.setBounds(20, 100, 100, 25);
        add(addButton);

        JLabel resultLabel = new JLabel("Sum:");
        resultLabel.setBounds(20, 140, 100, 25);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(120, 140, 150, 25);
        resultField.setEditable(false); // Make the result field non-editable
        add(resultField);

        // Add action listener for the button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSum();
            }
        });
    }

    private void calculateSum() {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double sum = num1 + num2;
            resultField.setText(String.valueOf(sum));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SumCalculator calculator = new SumCalculator();
            calculator.setVisible(true);
        });
    }
}
