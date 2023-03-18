import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {



    private JTextField textField;



    private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonDot, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEqual, buttonClear;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;


    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        textField = new JTextField(20);
        textField.setEditable(false);
        Font font = new Font("Arial", Font.PLAIN, 24);
        textField.setFont(font); // Set font size to 24
        textField.setPreferredSize(new Dimension(0, 60)); // Set height to 60
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        button7 = new JButton("7");
        button7.addActionListener(this);
        buttonPanel.add(button7);

        button8 = new JButton("8");
        button8.addActionListener(this);
        buttonPanel.add(button8);

        button9 = new JButton("9");
        button9.addActionListener(this);
        buttonPanel.add(button9);

        buttonDivide = new JButton("/");
        buttonDivide.addActionListener(this);
        buttonPanel.add(buttonDivide);

        button4 = new JButton("4");
        button4.addActionListener(this);
        buttonPanel.add(button4);

        button5 = new JButton("5");
        button5.addActionListener(this);
        buttonPanel.add(button5);

        button6 = new JButton("6");
        button6.addActionListener(this);
        buttonPanel.add(button6);

        buttonMultiply = new JButton("*");
        buttonMultiply.addActionListener(this);
        buttonPanel.add(buttonMultiply);

        button1 = new JButton("1");
        button1.addActionListener(this);
        buttonPanel.add(button1);

        button2 = new JButton("2");
        button2.addActionListener(this);
        buttonPanel.add(button2);

        button3 = new JButton("3");
        button3.addActionListener(this);
        buttonPanel.add(button3);

        buttonMinus = new JButton("-");
        buttonMinus.addActionListener(this);
        buttonPanel.add(buttonMinus);

        button0 = new JButton("0");
        button0.addActionListener(this);
        buttonPanel.add(button0);

        buttonDot = new JButton(".");
        buttonDot.addActionListener(this);
        buttonPanel.add(buttonDot);

        buttonEqual = new JButton("=");
        buttonEqual.addActionListener(this);
        buttonPanel.add(buttonEqual);

        buttonPlus = new JButton("+");
        buttonPlus.addActionListener(this);
        buttonPanel.add(buttonPlus);

        buttonClear = new JButton("C");
        buttonClear.addActionListener(this);
        buttonPanel.add(buttonClear);

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button0) {
            textField.setText(textField.getText() + "0");
        } else if (e.getSource() == button1) {
            textField.setText(textField.getText() + "1");
        } else if (e.getSource() == button2) {
            textField.setText(textField.getText() + "2");
        } else if (e.getSource() == button3) {
            textField.setText(textField.getText() + "3");
        } else if (e.getSource() == button4) {
            textField.setText(textField.getText() + "4");
        } else if (e.getSource() == button5) {
            textField.setText(textField.getText() + "5");
        } else if (e.getSource() == button6) {
            textField.setText(textField.getText() + "6");
        } else if (e.getSource() == button7) {
            textField.setText(textField.getText() + "7");
        } else if (e.getSource() == button8) {
            textField.setText(textField.getText() + "8");
        } else if (e.getSource() == button9) {
            textField.setText(textField.getText() + "9");
        } else if (e.getSource() == buttonDot) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        } else if (e.getSource() == buttonPlus) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        } else if (e.getSource() == buttonMinus) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        } else if (e.getSource() == buttonMultiply) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        } else if (e.getSource() == buttonDivide) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        } else if (e.getSource() == buttonClear) {
            textField.setText("");
        } else if (e.getSource() == buttonEqual) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(null, "Division by zero not allowed!");
                    }
                    break;
            }
            textField.setText(String.format("%.3f", result)); // round to 3 decimal place

        num1 = result;
        }
    }
}

