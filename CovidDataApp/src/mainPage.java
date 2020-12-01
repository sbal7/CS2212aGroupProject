import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class mainPage {

	private JFrame frame;
	private JLabel lblAddACountry;
	private JLabel lblRemoveACountry;
	private JButton button;
	private JButton button_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage window = new mainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(1350, 1000, 1300, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel map = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/map1.jpg")).getImage();
		map.setIcon(new ImageIcon(img));
		map.setBounds(17, 89, 1034, 587);
		frame.getContentPane().add(map);
		
		JButton addCountryButton = new JButton("+");
		addCountryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addCountryButton.setBounds(467, 61, 58, 29);
		frame.getContentPane().add(addCountryButton);
		
		lblAddACountry = new JLabel("Add a Country");
		lblAddACountry.setBounds(74, 66, 103, 16);
		frame.getContentPane().add(lblAddACountry);
		
		lblRemoveACountry = new JLabel("Remove a Country");
		lblRemoveACountry.setBounds(537, 66, 122, 16);
		frame.getContentPane().add(lblRemoveACountry);
		
		JButton removeCountryButton = new JButton("-");
		removeCountryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		removeCountryButton.setBounds(952, 61, 58, 29);
		frame.getContentPane().add(removeCountryButton);
		
		JComboBox addCountryBox = new JComboBox();
		addCountryBox.setEditable(true);
		addCountryBox.setBounds(170, 62, 300, 27);
		frame.getContentPane().add(addCountryBox);
		
		JComboBox removeCountryBox = new JComboBox();
		removeCountryBox.setEditable(true);
		removeCountryBox.setBounds(654, 62, 300, 27);
		frame.getContentPane().add(removeCountryBox);
		
		JComboBox analysisBox = new JComboBox();
		analysisBox.setBounds(482, 665, 103, 27);
		frame.getContentPane().add(analysisBox);
		
		JLabel listOfSelectedCountriesBox = new JLabel("List Of Selected Countries");
		listOfSelectedCountriesBox.setBounds(1091, 104, 163, 16);
		frame.getContentPane().add(listOfSelectedCountriesBox);
		
		JButton recalculateButton = new JButton("Recalculate");
		recalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		recalculateButton.setBounds(1116, 437, 117, 29);
		frame.getContentPane().add(recalculateButton);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(1149, 466, 61, 16);
		frame.getContentPane().add(lblOutput);
		
		JLabel lblAnalysisMethod = new JLabel("Choose Analysis Method");
		lblAnalysisMethod.setBounds(307, 669, 163, 16);
		frame.getContentPane().add(lblAnalysisMethod);
		
		JTextArea listOfSelectedCountriesPanel = new JTextArea();
		listOfSelectedCountriesPanel.setBounds(1063, 132, 219, 292);
		frame.getContentPane().add(listOfSelectedCountriesPanel);
		
		JTextArea outputPanel = new JTextArea();
		outputPanel.setBounds(1063, 494, 219, 150);
		frame.getContentPane().add(outputPanel);
		
	
	
	}
}
