import javax.swing.JFrame;
import javax.swing.JLabel;

public class WorldPage {
	
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	
	WorldPage(String userID){
		
		welcomeLabel.setBounds(0,0,200,35);
		welcomeLabel.setText("Hello "+ userID);
		
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

}
