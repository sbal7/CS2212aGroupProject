import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewUserPage implements ActionListener {
	
	private static JLabel newUserLabel;
	private static JTextField newUserTxt;
	private static JLabel newPassLabel;
	private static JPasswordField newPassTxt;
	private static JButton okButton;
	private static JButton resetButton;
	private static JLabel msg;
	HashMap<String,String> loginInfo = new HashMap<String,String>();
	JFrame frame = new JFrame("Create New User Covid-19 App");
	JPanel panel = new JPanel();
	
	NewUserPage(HashMap<String,String>loginInfoNew) {
		
		loginInfo = loginInfoNew;
		
		frame.setSize(350,160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		panel.setLayout(null);
		
		newUserLabel = new JLabel("New Username:");
		newUserLabel.setBounds(10, 20, 100, 25);
		panel.add(newUserLabel);
		
		newUserTxt = new JTextField(20);
		newUserTxt.setBounds(120, 20, 200, 25);
		panel.add(newUserTxt);
		
		newPassLabel = new JLabel("New Password:");
		newPassLabel.setBounds(10, 50, 100, 25);
		panel.add(newPassLabel);
		
		newPassTxt = new JPasswordField(20);
		newPassTxt.setBounds(120, 50, 200, 25);
		panel.add(newPassTxt);
		
		okButton = new JButton("Create!");
		okButton.setBounds(118, 80, 80, 25);
		okButton.addActionListener(this);
		panel.add(okButton); 
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(242, 80, 80, 25);
		resetButton.addActionListener(this);
		panel.add(resetButton);
		
		msg = new JLabel("");
		msg.setBounds(10, 110, 300, 25);
		panel.add(msg);
		
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent act) {
		
		if(act.getSource()==resetButton) {
			newUserTxt.setText("");
			newPassTxt.setText("");
		}
		
		if(act.getSource()== okButton) {
			
			String user = newUserTxt.getText();
			String pass = String.valueOf(newPassTxt.getPassword());
			
			if(user.isEmpty() || pass.isEmpty()) {
				msg.setForeground(Color.red);
				msg.setText("Fill All Fields");
			}
			else if(loginInfo.containsKey(user)) {
				msg.setForeground(Color.red);
				msg.setText("Username Already Exists");
			}
			else {
				loginInfo.put(user,pass);
				msg.setForeground(Color.green);
				msg.setText("User Created!");
				frame.dispose();
			}
		}
		
	}
	

}
