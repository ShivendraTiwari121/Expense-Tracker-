import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConvertorJFRAME {
    public static void main(String[] args){
        System.out.println("Currency Convertor");
        //Create a new jframe
        JFrame jframe = new JFrame("Currency Convertor");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400,200);
        jframe.setLayout(new GridLayout(3,2));

        //Create components
        JLabel label1 = new JLabel("Amount in USD :");
        JTextField textField1 = new JTextField();
        JLabel label2 = new JLabel("Amount in EUR:");
        JTextField textField2 = new JTextField();
        JButton convertButton = new JButton("Convert");

        //Add components to frame
        jframe.add(label1);
        jframe.add(label2);
        jframe.add(textField1);
        jframe.add(textField2);
        jframe.add(convertButton);

        //Add action listener to button
        convertButton.addActionListener(new ActionListener(){
             
            public void actionPerformed(ActionEvent e){
                try{
                    double usd = Double.parseDouble(textField1.getText());
                    double eur = usd* 0.85; 
                    textField2.setText(String.format("%.2f",eur));}
                    catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(jframe, "Please enter a valid number");
                    }
                }
            });
        jframe.setVisible(true);
    }
   
}
