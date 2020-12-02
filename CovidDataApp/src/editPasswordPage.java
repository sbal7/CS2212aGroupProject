import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class editPasswordPage implements ActionListener {

        private static JLabel newPassLabel;
        private static JPasswordField newPassTxt;
        private static JLabel oldPassLabel;
        private static JPasswordField oldPassTxt;
        private static JButton submitButton;
        private static JLabel msg;
        private static JButton resetButton;
        HashMap<String,String> loginInfo = new HashMap<String,String>();
        JFrame frame = new JFrame("Create New Password");
        JPanel panel = new JPanel();
        String user;

    editPasswordPage(String username,HashMap<String,String>loginInfoNew){

        user = username;
        loginInfo = loginInfoNew;

        frame.setSize(450,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        //  New user-name Label
        newPassLabel = new JLabel("New Password:");
        newPassLabel.setBounds(10, 20, 100, 25);
        panel.add(newPassLabel);

        // New user-name text field
        newPassTxt = new JPasswordField(20);
        newPassTxt.setBounds(110, 20, 300, 25);
        panel.add(newPassTxt);

        // New password Label
        oldPassLabel = new JLabel("Old Password:");
        oldPassLabel.setBounds(10, 50, 100, 25);
        panel.add(oldPassLabel);

        // new password text field (with privacy dots)
        oldPassTxt = new JPasswordField(20);
        oldPassTxt.setBounds(110, 50, 300, 25);
        panel.add(oldPassTxt);

        // Create new user button
        submitButton = new JButton("Submit");
        submitButton.setBounds(110, 80, 130, 25);
        submitButton.addActionListener(this);
        panel.add(submitButton);

        // Reset button
        resetButton = new JButton("Reset");
        resetButton.setBounds(278, 80, 130, 25);
        resetButton.addActionListener(this);
        panel.add(resetButton);

        // Display message
        msg = new JLabel("");
        msg.setBounds(10, 110, 300, 25);
        panel.add(msg);

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent act) {
        if(act.getSource() == resetButton){
            resetButtonAction();
        }
        if(act.getSource() == submitButton){
            submitButtonAction();
        }

    }
    private void resetButtonAction(){
        oldPassTxt.setText(""); // empty text field
        newPassTxt.setText(""); // empty text field
    }
    private void submitButtonAction(){

        String filepath = "users//"+user+".txt";
        String pass = String.valueOf(oldPassTxt.getPassword());
        String newPass = String.valueOf(newPassTxt.getPassword());

        try {
            // Read old Password
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);
            String last = scanner.nextLine();
            // If correct write new password
            if(last.equals(pass)){
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(newPass);
                fileWriter.close();
                msg.setText("");
                //find input in hashtable
                loginInfo.remove(user);
                loginInfo.put(user, newPass);
            }
            else {
                msg.setForeground(Color.red);
                msg.setText("Incorrect Password"); // User-name exists display message
            }
        }
        catch (Exception e){
            System.out.println("Change Password Error");
        }

    }

}
