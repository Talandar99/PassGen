package src;

import java.awt.*;
import java.awt.event.*;  
import java.awt.datatransfer.*;

import javax.swing.*; //swing graphical lib 


class PassGen { 
    //pass generation 
    public static String password_gen(){
        //key variables
        int random_password_length= 20;
        String final_password="";
        double random_number= Math.random();
        char[] chars =new char[random_password_length];
        char[] big_letters =new char[random_password_length];
        char[] small_letters =new char[random_password_length];
        char[] fpass= new char[random_password_length];
        //chars
        for(int i=0;i<random_password_length;i++){
            random_number= Math.random();
            random_number=random_number*10;
            long Asciint = Math.round(random_number);
            if(random_number>5&&random_number<8){
                char ch = (char) (30+Asciint);
                chars[i]=ch;
            }     
        }
        //Big letters
        for(int i=0;i<random_password_length;i++){
            random_number= Math.random();
            random_number=random_number*50;
            long Asciint = Math.round(random_number);
            if(random_number<25){
                char ch = (char) (65+Asciint);
                big_letters[i]=ch;
            }
        }
        //small_letters  
        for(int i=0;i<random_password_length;i++){
            random_number= Math.random();
            random_number=random_number*50;
            long Asciint = Math.round(random_number);
            if(random_number<25){
                char ch = (char) (97+Asciint);
                small_letters[i]=ch;
            }     
        }  
        //creating password  
        for(int i=0;i<random_password_length;i++){
            if(chars[i]!=0){
                fpass[i]=chars[i];
            }
            if(big_letters[i]!=0){
                fpass[i]=big_letters[i];
            }
            if(small_letters[i]!=0){
                fpass[i]=small_letters[i];
            }
            if(fpass[i]==0){//null checking
                random_number= Math.random();
                random_number=random_number*10;
                long Asciint= Math.round(random_number);
                final_password=final_password+Asciint;   
            }else{
                final_password=final_password+fpass[i];
            }
        }
        return final_password;
    }
    public static void main(String[] args) {

        JFrame frame = new JFrame("PassGen 1.4"); //Creating new window 
        frame.setLocation(200,200); //lokalizacja okna 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// press [X] to close
        frame.setSize(new Dimension(380, 170)); // window dimnesions

        //label
        JLabel label_password = new JLabel ("Password:");
        label_password.setSize(100,10);
        label_password.setBounds(20, 10, 200, 30);

        //text field
        JTextField textField = new JTextField(" Press [Generate] button to generate password");
        textField.setSize(320,20);
        textField.setBounds(20, 40, 320, 30);

        //button gen    
        JButton button_gen = new JButton("Generate");//add a button
        button_gen.setBounds(20, 80, 100, 30);
        
        //button copy   
        JButton button_copy = new JButton("Copy");//add a button
        button_copy.setBounds(239, 80, 100, 30);

        //pressing button gen
        button_gen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                textField.setText(password_gen()+password_gen());
            }  
        });  
        
        //pressing button copy
        button_copy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
            	StringSelection stringSelection = new StringSelection(textField.getText());
            	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            	clipboard.setContents(stringSelection, null);
            }  
        });  

        //adding things to window
        frame.add(label_password);
        frame.add(textField);
        frame.add(button_gen);
        frame.add(button_copy);

        //color settings
        //frame.getJMenuBar().setBackground(Color.decode("0xb9bffb"));
        frame.getContentPane().setBackground(Color.decode("0xdae0ea"));
        //button_copy.setBackground(Color.decode("0x20d6c7"));
        //button_gen.setBackground(Color.decode("0x20d6c7"));

        //window settings
        frame.setLayout(null);
        //frame.pack(); //autosize
        frame.setVisible(true); // window visibility
        frame.setAlwaysOnTop(true);






    }

}