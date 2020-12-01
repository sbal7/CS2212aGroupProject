import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {
	
	private static JLabel userLabel;
	private static JTextField userTxt;
	private static JLabel passLabel;
	private static JPasswordField passTxt;
	private static JButton loginButton;
	private static JButton resetButton;
	private static JButton newUserButton;
	private static JLabel success;
	HashMap<String,String> loginInfo = new HashMap<String,String>();
	JFrame frame = new JFrame("Login Covid-19 App");
	JPanel panel = new JPanel();

	Login(HashMap<String,String>loginInfoOg) {
		 
		loginInfo = loginInfoOg;
		
		frame.setSize(350,160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		panel.setLayout(null);
		
		userLabel = new JLabel("Username:");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		userTxt = new JTextField(20);
		userTxt.setBounds(100, 20, 200, 25);
		panel.add(userTxt);
		
		passLabel = new JLabel("Password:");
		passLabel.setBounds(10, 50, 80, 25);
		panel.add(passLabel);
		
		passTxt = new JPasswordField(20);
		passTxt.setBounds(100, 50, 200, 25);
		panel.add(passTxt);
		
		loginButton = new JButton("Submit!");
		loginButton.setBounds(97, 80, 80, 25);
		loginButton.addActionListener(this);
		panel.add(loginButton);
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(223, 80, 80, 25);
		resetButton.addActionListener(this);
		panel.add(resetButton);
		
		newUserButton = new JButton("New User");
		newUserButton.setBounds(0, 80, 85, 25);
		newUserButton.addActionListener(this);
		panel.add(newUserButton);
		
		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);
		
		
		frame.setVisible(true);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==resetButton) {
			userTxt.setText("");
			passTxt.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			success.setText("");
			String userID = userTxt.getText();
			String password = String.valueOf(passTxt.getPassword());
			
			
			if(loginInfo.containsKey(userID)) {
				if(loginInfo.get(userID).equals(password)) {
					success.setForeground(Color.green);
					success.setText("Login Successful!");
					frame.dispose();
					//WorldPage worldPage = new WorldPage(userID);
					mainPage mainPage = new mainPage();
				}
				else {
					success.setForeground(Color.red);
					success.setText("Wrong Password");
				}
			}else if(userID.isEmpty() && password.isEmpty()) {
				success.setForeground(Color.red);
				success.setText("Fill All Fields");
			}
			else {
				success.setForeground(Color.red);
				success.setText("Username Not Found");
			}
		}
		
		if (e.getSource() == newUserButton) {
			success.setText("");
			userTxt.setText("");
			passTxt.setText("");
			NewUserPage newuserpage = new NewUserPage(loginInfo);
			
		}
	}	


}
