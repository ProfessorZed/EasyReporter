import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Reporter {

	private JFrame frame;
	private JTextField textFieldName;
	private JComboBox<String> comboBoxPerm;
	private JTextArea textAreaResult;
	private TextArea textAreaProof;
	private TextArea textAreaOffense;
	private JComboBox<String> comboBoxColor;
	private JLabel lblName;
	private JLabel lblProof;
	private JLabel lblOffense;
	private JLabel lblDoYouGive;
	private JComboBox<String> comboBoxRank;
	private JLabel lblRank;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		links linksob = new links();
		linksob.setVisible(true);
		linksob.setSize(400, 150);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporter window = new Reporter();
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
	public Reporter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.setBounds(100, 100, 812, 482);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		java.net.URL url = this.getClass().getResource("/logo2.png");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img2 = kit.createImage(url);
		frame.setIconImage(img2);
		

		JButton btnNewButton = new JButton("Click when ready!");
		btnNewButton.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name, offense, proof,comboperm, comborank;
				name = textFieldName.getText();
				offense = textAreaOffense.getText();
				proof = textAreaProof.getText();
				comboperm = comboBoxPerm.getSelectedItem().toString();
				comborank = comboBoxRank.getSelectedItem().toString();
				System.out.println(name + offense + proof + comboperm);
				textAreaResult.setText("[" + comborank + "]" + name + "\r\n"
						+ "Offense: " + offense + "\r\n" + "Proof: " + proof
						+ "\r\n" + "Permission to share: " + comboperm + "\r\n" + "\r\n" + "Skin: http://www.minecraft-skin-viewer.net/?username=" + name);
				String myString = textAreaResult.getText();
				StringSelection stringSelection = new StringSelection(myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				JOptionPane.showMessageDialog(null,
						"Report copied to clipboard!" + "\r\n"
								+ "Use CTRL + V for easy paste ;)");
				Reporter.this.textFieldName.setText("");
		        Reporter.this.textAreaOffense.setText("");
		        Reporter.this.textAreaProof.setText("");
		        Reporter.this.comboBoxRank.setSelectedItem("Default");
		        Reporter.this.comboBoxPerm.setSelectedItem("Yes.");
		        Reporter.this.textAreaResult.setText("");
			}
		});
		btnNewButton.setBounds(10, 374, 322, 58);
		frame.getContentPane().add(btnNewButton);

		textFieldName = new JTextField();
		textFieldName.setToolTipText("Name\r\n");
		textFieldName.setBounds(10, 50, 322, 34);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		
		
		textAreaOffense = new TextArea();
		textAreaOffense.setBounds(10, 256, 322, 42);
		frame.getContentPane().add(textAreaOffense);
		
		textAreaProof = new TextArea();
		textAreaProof.setBounds(10, 188, 322, 42);
		frame.getContentPane().add(textAreaProof);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setForeground(SystemColor.desktop);
		lblName.setBounds(147, 25, 46, 14);
		frame.getContentPane().add(lblName);

		lblProof = new JLabel("Proof");
		lblProof.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProof.setForeground(SystemColor.desktop);
		lblProof.setBounds(147, 161, 39, 14);
		frame.getContentPane().add(lblProof);


		lblOffense = new JLabel("Offense");
		lblOffense.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOffense.setForeground(SystemColor.desktop);
		lblOffense.setBounds(147, 236, 58, 14);
		frame.getContentPane().add(lblOffense);

		lblDoYouGive = new JLabel(
				"Do you give the staff permission to share your proof?");
		lblDoYouGive.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDoYouGive.setForeground(new Color(0, 0, 0));
		lblDoYouGive.setBackground(Color.WHITE);
		lblDoYouGive.setBounds(10, 304, 345, 14);
		frame.getContentPane().add(lblDoYouGive);

		lblRank = new JLabel("Rank");
		lblRank.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRank.setForeground(SystemColor.desktop);
		lblRank.setBounds(147, 95, 46, 14);
		frame.getContentPane().add(lblRank);
		
		comboBoxPerm = new JComboBox<>();
		comboBoxPerm.setModel(new DefaultComboBoxModel<>(new String[] { "Yes.",
				"No." }));
		comboBoxPerm.setToolTipText("");
		comboBoxPerm.setBounds(10, 329, 322, 34);
		frame.getContentPane().add(comboBoxPerm);

		textAreaResult = new JTextArea();
		textAreaResult.setBackground(Color.WHITE);
		textAreaResult.setForeground(Color.BLACK);
		textAreaResult.setEditable(false);
		textAreaResult.setBounds(504, 90, 282, 269);
		textAreaResult.setColumns(10);
		frame.getContentPane().add(textAreaResult);
		
		
		comboBoxRank = new JComboBox<>();
		comboBoxRank.setModel(new DefaultComboBoxModel<>(new String[] {
				"Default", "VIP", "VIP+", "MVP", "MVP+" }));
		comboBoxRank.setToolTipText("Rank");
		comboBoxRank.setBounds(10, 120, 322, 34);
		frame.getContentPane().add(comboBoxRank);
		
		JLabel label = new JLabel("");
		label.setBackground(SystemColor.menu);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(0, 0, 796, 443);
		frame.getContentPane().add(label);
		Image img = new ImageIcon(this.getClass().getResource("/logo2.png"))
				.getImage();
		label.setIcon(new ImageIcon(img));
		
		comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"Original (Black)", "Red", "Blue", "Green"}));
		comboBoxColor.setBounds(565, 10, 122, 20);
		frame.getContentPane().add(comboBoxColor);
		
		
		JLabel lblColors = new JLabel("Colors:");
		lblColors.setBounds(523, 13, 46, 14);
		frame.getContentPane().add(lblColors);
		
		
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxColor.getSelectedItem().toString() == "Original (Black)") {
					lblName.setForeground(Color.BLACK);
					lblProof.setForeground(Color.BLACK);
					lblOffense.setForeground(Color.BLACK);
					lblDoYouGive.setForeground(Color.BLACK);
					lblRank.setForeground(Color.BLACK);
					JOptionPane.showMessageDialog(null, "Changed colors to the original " + "\r\n" + "Color (Black)");
				}
				if(comboBoxColor.getSelectedItem().toString() == "Red") {
					lblName.setForeground(Color.RED);
					lblProof.setForeground(Color.RED);
					lblOffense.setForeground(Color.RED);
					lblDoYouGive.setForeground(Color.RED);
					lblRank.setForeground(Color.RED);
					JOptionPane.showMessageDialog(null, "Changed colors to Red.");
				}
				if(comboBoxColor.getSelectedItem().toString() == "Blue") {
					lblName.setForeground(Color.BLUE);
					lblProof.setForeground(Color.BLUE);
					lblOffense.setForeground(Color.BLUE);
					lblDoYouGive.setForeground(Color.BLUE);
					lblRank.setForeground(Color.BLUE);
					JOptionPane.showMessageDialog(null, "Changed colors to Blue.");
				}
				if(comboBoxColor.getSelectedItem().toString() == "Green") {
					lblName.setForeground(Color.GREEN);
					lblProof.setForeground(Color.GREEN);
					lblOffense.setForeground(Color.GREEN);
					lblDoYouGive.setForeground(Color.GREEN);
					lblRank.setForeground(Color.GREEN);
					
					JOptionPane.showMessageDialog(null, "Changed colors to Green.");
				}
			}
		});
		btnConfirm.setBounds(697, 9, 89, 23);
		frame.getContentPane().add(btnConfirm);
		
	}
}