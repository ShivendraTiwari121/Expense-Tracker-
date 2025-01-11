import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JframeDemo {
    public static void main(String[] args){
        System.out.println("Jframe is used to build GUI Java Application");
        JFrame jFrame = new JFrame("BMI Calculator");


        JLabel userWeightLabel = new JLabel("Enter your weight in Kg :");
        userWeightLabel.setBounds(10,40,60,40);
        JTextField userWeighTextField = new JTextField("");
        userWeightLabel.setBounds(250,40,60,40);

        JLabel userHeightLabel = new JLabel("Enter your height in Kg :");
        userHeightLabel.setBounds(10,100,60,40);
        JTextField userHeighTextField = new JTextField("");
        userHeightLabel.setBounds(250,100,60,40);


        JButton calculatebmi = new JButton("calculate bmi");
        calculatebmi.setBounds(200,250,150,50);
        jFrame.add(calculatebmi);
        //to click on the button 
        calculatebmi.addActionListener(ActionEvent e);



        jFrame.add(userWeightLabel);
        jFrame.add(userWeighTextField);
        jFrame.add(userHeightLabel);
        jFrame.add(userHeighTextField);

        //to use the default layout
        jFrame.setLayout(null);
        //to add the size in frame
        jFrame.setSize(300,400);
        // to set the visible in frame 
        jFrame.setVisible(true);
    }
}
