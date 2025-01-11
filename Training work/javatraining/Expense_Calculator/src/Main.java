import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn;
        JFrame frame = new JFrame("Expense Calculator");

        JLabel expense_title_label = new JLabel("Expenses:");
        expense_title_label.setForeground(Color.RED);
        expense_title_label.setFont(new Font("ARIAL", Font.PLAIN, 20));
        expense_title_label.setBounds(190, 10, 120, 50);
        frame.add(expense_title_label);

        JLabel expense_type_label = new JLabel("Expense Type:");
        expense_type_label.setBounds(20, 50, 120, 50);
        frame.add(expense_type_label);

        JTextField expense_type_field = new JTextField();
        expense_type_field.setBounds(140, 60, 120, 30);
        frame.add(expense_type_field);

        JLabel expense_amount_label = new JLabel("Expense Amount:");
        expense_amount_label.setBounds(20, 100, 120, 50);
        frame.add(expense_amount_label);

        JTextField expense_amount_field = new JTextField();
        expense_amount_field.setBounds(140, 110, 120, 30);
        frame.add(expense_amount_field);

        JLabel income_title_label = new JLabel("Income");
        income_title_label.setFont(new Font("ARIAL", Font.PLAIN, 20));
        income_title_label.setBounds(190, 140, 120, 50);
        income_title_label.setForeground(Color.GREEN);
        frame.add(income_title_label);

        JLabel income_label = new JLabel("Add Income");
        income_label.setBounds(20, 180, 120, 50);
        frame.add(income_label);

        JTextField income_field = new JTextField();
        income_field.setBounds(140, 190, 120, 30);
        frame.add(income_field);

        JButton add_button = new JButton("Add");
        add_button.setBounds(130, 250, 120, 40);
        frame.add(add_button);

        JButton view_button = new JButton("View");
        view_button.setBounds(250, 250, 120, 40);
        frame.add(view_button);

        // Database connection established
        String url = "jdbc:mysql://localhost:3310/ExpenseCalculator";
        String username = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("DB connected");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expense_type = expense_type_field.getText();
                int expense_amount = expense_amount_field.getText().isEmpty() ? 0 : Integer.parseInt(expense_amount_field.getText());

                if (expense_amount != 0 && !expense_type.isEmpty()) {
                    // Insert the record to mySQL
                    String insert_data = "INSERT INTO expenseTB (expense_type, expense_amount, income_amount) VALUES (?,?,?)";
                    try {
                        PreparedStatement statement = conn.prepareStatement(insert_data);
                        statement.setString(1, expense_type);
                        statement.setInt(2, expense_amount);
                        statement.setInt(3, Integer.parseInt(income_field.getText()));
                        statement.execute();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The values can't be 0 or empty");
                }
            }
        });

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
