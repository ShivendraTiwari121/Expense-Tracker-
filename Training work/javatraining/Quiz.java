import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Quiz {
     static int score = 0;
     static int timeLeft = 30;
     static Timer timer;
     static int num1;
     static int num2;
     static char operator;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Quiz App");
        jFrame.setSize(400, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        JLabel num1Label = new JLabel();
        num1Label.setBounds(50, 50, 50, 30);
        jFrame.add(num1Label);

        JLabel operatorLabel = new JLabel();
        operatorLabel.setBounds(110, 50, 50, 30);
        jFrame.add(operatorLabel);

        JLabel num2Label = new JLabel();
        num2Label.setBounds(170, 50, 50, 30);
        jFrame.add(num2Label);

        JTextField answerField = new JTextField();
        answerField.setBounds(230, 50, 50, 30);
        jFrame.add(answerField);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(290, 50, 80, 30);
        jFrame.add(nextButton);

        JLabel timerLabel = new JLabel("Time left: 30");
        timerLabel.setBounds(50, 100, 100, 30);
        jFrame.add(timerLabel);

        JLabel scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(160, 100, 100, 30);
        scoreLabel.setForeground(Color.GREEN); 
        jFrame.add(scoreLabel);


        Random random = new Random();


        generateQuestion(random, num1Label, operatorLabel, num2Label);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time left: " + timeLeft);
        
   
                if (timeLeft <= 10) {
                    timerLabel.setForeground(Color.RED);
                } else {
                    timerLabel.setForeground(Color.BLACK);
                }
        
                if (timeLeft <= 0) {
                    timer.stop();
                    nextButton.setEnabled(false);
                    JOptionPane.showMessageDialog(jFrame, "Time's up! Final Score: " + score);
                }
            }
        });
        timer.start();

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Check if the answer field is empty
                    if (answerField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(jFrame, "Please enter a number.");
                        return;
                    }

                    int userAnswer = Integer.parseInt(answerField.getText());
                    int correctAnswer = 0;
                    boolean validAnswer = true;

                    switch (operator) {
                        case '+':
                            correctAnswer = num1 + num2;
                            break;
                        case '-':
                            correctAnswer = num1 - num2;
                            break;
                        case '*':
                            correctAnswer = num1 * num2;
                            break;
                        case '/':
                            if (num2 != 0) {
                                correctAnswer = num1 / num2; 
                            } else {
                                validAnswer = false;
                            }
                            break;
                    }

                    if (validAnswer && userAnswer == correctAnswer) {
                        score++;
                        scoreLabel.setText("Score: " + score);
                    }

              
                    generateQuestion(random, num1Label, operatorLabel, num2Label);
                    answerField.setText("");


                    timeLeft = 30;
                    timerLabel.setText("Time left: " + timeLeft);
                    timerLabel.setForeground(Color.BLACK); 
                    timer.restart();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(jFrame, "Please enter a valid number.");
                }
            }
        });

        jFrame.setVisible(true);
    }

    private static void generateQuestion(Random random, JLabel num1Label, JLabel operatorLabel, JLabel num2Label) {
        num1 = random.nextInt(10) + 1;
        num2 = random.nextInt(10) + 1;
        char[] operators = {'+', '-', '*', '/'};
        operator = operators[random.nextInt(operators.length)];

        num1Label.setText(String.valueOf(num1));

        operatorLabel.setText(String.valueOf(operator));
        num2Label.setText(String.valueOf(num2));
    }
}