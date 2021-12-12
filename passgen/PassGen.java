package passgen;
import java.awt.*;
import java.awt.event.*;  
import javax.swing.*; //swing graphical lib 

class PassGen { 
    //pass gen 
    public static String password_gen(){
        double random_number= Math.random();
        long random_number_long = Math.round(random_number*random_number*Math.pow(10,24));
        String random_password= String.valueOf(random_number_long);

        while(random_password.length()<13){
            random_number= Math.random();
            random_number_long = Math.round(random_number*random_number*Math.pow(10,24));
            random_password= String.valueOf(random_number_long);   
        }

        char[] chars =new char[random_password.length()];
        char[] big_letters =new char[random_password.length()];
        char[] small_letters =new char[random_password.length()];
        char[] fpass= new char[random_password.length()];
        String final_password="";
        
        for(int i=0;i<random_password.length();i++){
            random_number= Math.random();
            random_number=random_number*20;
            long Asciint = Math.round(random_number);
            if(random_number>5&&random_number<8){
                char ch = (char) (30+Asciint);
                chars[i]=ch;

            }     
        }
        for(int i=0;i<random_password.length();i++){
            random_number= Math.random();
            random_number=random_number*50;
            long Asciint = Math.round(random_number);
            if(random_number<25){
                char ch = (char) (65+Asciint);
                big_letters[i]=ch;


            }     
        }  
        for(int i=0;i<random_password.length();i++){
            random_number= Math.random();
            random_number=random_number*50;
            long Asciint = Math.round(random_number);
            if(random_number<25){
                char ch = (char) (97+Asciint);
                small_letters[i]=ch;

            }     
        }  
        for(int i=0;i<random_password.length();i++){
            if(chars[i]!=0){
                fpass[i]=chars[i];
            }
        } 
        for(int i=0;i<random_password.length();i++){
            if(big_letters[i]!=0){
                fpass[i]=big_letters[i];
            }
        } 
        for(int i=0;i<random_password.length();i++){
            if(small_letters[i]!=0){
                fpass[i]=small_letters[i];
            }
        } 
        for(int i=0;i<random_password.length();i++){
            random_number= Math.random();
            random_number=random_number*100;
            long Asciint = Math.round(random_number);
            if(Asciint%6==0){
                random_number= Math.random();
                random_number=random_number*10;
                Asciint= Math.round(random_number);
                final_password=final_password+Asciint;   
            }else{
                final_password=final_password+fpass[i];
            }

        } 
        return final_password;
    }
    public static void main(String[] args) {

        JFrame frame = new JFrame("PassGen"); //Creating new window 
        frame.setLocation(200,200); //lokalizacja okna 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// press [X] to close
        frame.setSize(new Dimension(380, 170)); // window dimnesions

        //label
        JLabel label_password = new JLabel ("Password:");
        label_password.setSize(100,10);
        label_password.setBounds(20, 10, 200, 30);

        //text field
        JTextField textField = new JTextField("press a button to generate");
        textField.setSize(320,20);
        textField.setBounds(20, 40, 320, 30);

        //button        
        JButton button_gen = new JButton("Generate");//add a button
        button_gen.setBounds(20, 80, 100, 30);

        //pressing button
        button_gen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                textField.setText(password_gen()+password_gen());
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