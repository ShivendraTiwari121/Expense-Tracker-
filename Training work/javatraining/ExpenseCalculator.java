import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ExpenseCalculator {
   public static void main(String[] args){
    //Expense calculator
    JFrame frame = new JFrame("Expense Calculator");
    

    JLabel todayExpensLabel = new JLabel("Expenses : ");
    todayExpensLabel.setBounds(190,20,120,50);
    todayExpensLabel.setForeground(Color.RED);
    todayExpensLabel.setFont(new Font ("ARIAL",Font.PLAIN,20));
    frame.add(todayExpensLabel);


    JLabel expenseTypeLabel = new JLabel("Expense Type : ");
    expenseTypeLabel.setBounds(20,50,120,50);
    frame.add(expenseTypeLabel);

    JTextField expenseTypeField = new JTextField();
    expenseTypeField.setBounds(140,60,120,30);
    frame.add(expenseTypeField);

    JLabel expenseAmountLabel = new JLabel("Expense Amount:");
    expenseAmountLabel.setBounds(20,100,120,50);
    frame.add(expenseAmountLabel);

    JTextField expenseAmountField = new JTextField();
    expenseAmountField.setBounds(140,110,120,30);
    frame.add(expenseAmountField);

    JLabel incomeTitleLabel = new JLabel("Income");
    incomeTitleLabel.setBounds(190,140,120,50);
    incomeTitleLabel.setForeground(Color.GREEN);
    incomeTitleLabel.setFont(new Font ("ARIAL",Font.PLAIN,20));
    frame.add(incomeTitleLabel);


    JLabel incomLabel = new JLabel("Add Income : ");
    incomLabel.setBounds(20,170,120,50);
    frame.add(incomLabel);

    JTextField incomeField = new JTextField();
    incomeField.setBounds(140,180,120,20);
    frame.add(incomeField);


    JButton addButton = new JButton("Add");
    addButton.setBounds(160,250,120,40);
    addButton.setBackground(Color.BLUE);
    frame.add(addButton);


    JButton viewButton = new JButton("View");
    viewButton.setBounds(300,250,120,40);
    frame.add(viewButton);


    addButton.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
            //Add the validation of empty form
          String expense_type = expenseTypeField.getText();
          int expense_amount= expenseAmountField.getText().isEmpty()? 0: Integer.parseInt(expenseAmountField.getText());
          if (expense_amount!=0 && !expense_type.isEmpty()) {
            //insert the record to my sql
          }
          else{
            JOptionPane.showMessageDialog(null,"The values can't be zero");
          }
        }


    });



    frame.setSize(500,400);
    frame.setLayout(null);
    frame.setVisible(true);

   } 
}
