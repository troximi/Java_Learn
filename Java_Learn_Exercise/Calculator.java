import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    private static JFrame frame;
    private static JTextField display;
    private static double operand1;
    private static String operator;

    public static void main(String[] args) {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        display = new JTextField(20);
        JButton[] numberButtons = new JButton[10];
        JButton[] operatorButtons = new JButton[] {
                new JButton("+"),
                new JButton("-"),
                new JButton("*"),
                new JButton("/")
        };

        JPanel displayPanel = new JPanel();
        displayPanel.add(display);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new NumberButtonListener(i));
            numberButtons[i] = button;
            buttonPanel.add(button);
        }

        for (JButton button : operatorButtons) {
            button.addActionListener(new OperatorButtonListener(button.getText()));
            buttonPanel.add(button);
        }

        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(new EqualsButtonListener());
        buttonPanel.add(equalsButton);

        // Add a clear button
        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ClearButtonListener());
        buttonPanel.add(clearButton);

        frame.add(displayPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static class NumberButtonListener implements ActionListener {

        private int number;

        public NumberButtonListener(int number) {
            this.number = number;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = display.getText();
            display.setText(currentText + String.valueOf(number));
        }
    }

    private static class OperatorButtonListener implements ActionListener {

        private String selectedOperator;

        public OperatorButtonListener(String operator) {
            this.selectedOperator = operator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().isEmpty()) {
                return;
            }

            operand1 = Double.parseDouble(display.getText());
            display.setText("");
            operator = selectedOperator;
        }
    }

    private static class EqualsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().isEmpty() || operator == null) {
                return;
            }

            double operand2 = Double.parseDouble(display.getText());
            double result = calculate(operand1, operator, operand2);
            display.setText(String.valueOf(result));
            operator = null;
        }
    }

    private static class ClearButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            display.setText("");
            operand1 = 0;
            operator = null;
        }
    }

    private static double calculate(double operand1, String operator, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    JOptionPane.showMessageDialog(frame, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
