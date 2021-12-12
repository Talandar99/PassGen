package src;
import java.awt.*;
import java.awt.event.*;  
import javax.swing.*; //swing graphical lib 

class PassGen { 
    public static String password_gen(){
        double random_number= Math.random();
        long random_number_long = Math.round(random_number*random_number*Math.pow(10,12));
        String random_password= String.valueOf(random_number_long);
        return random_password;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("PassGen"); //Creating new window 
        frame.setLocation(200,200); //lokalizacja okna 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// press [X] to close
        frame.setSize(new Dimension(260, 170)); // window dimnesions

        //label
        JLabel label_password = new JLabel ("Password:");
        label_password.setSize(100,10);
        label_password.setBounds(20, 10, 200, 30);

        //text field
        JTextField textField = new JTextField("press a button to generate");
        textField.setSize(100,20);
        textField.setBounds(20, 40, 200, 30);

        //button        
        JButton button_gen = new JButton("Generate");//add a button
        button_gen.setBounds(20, 80, 100, 30);

        //pressing button
        button_gen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                textField.setText(password_gen());
            }  
        });  
        


        //adding things to window
        frame.add(label_password);
        frame.add(textField);
        frame.add(button_gen);


        frame.setLayout(null);
        //frame.pack(); //autosize
        frame.setVisible(true); // window visibility
        frame.setAlwaysOnTop(true);





    }
}