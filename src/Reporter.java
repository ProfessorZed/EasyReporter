import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
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
	private JTextField textFieldOffense;
	private JTextField textFieldProof;
	private JComboBox<String> comboBoxRank;
	private JComboBox<String> comboBoxPerm;
	private JTextArea textAreaResult;

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
		frame.setBounds(100, 100, 812, 493);
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
				String name, offense, proof, comborank, comboperm;
				name = textFieldName.getText();
				offense = textFieldOffense.getText();
				proof = textFieldProof.getText();
				comborank = comboBoxRank.getSelectedItem().toString();
				comboperm = comboBoxPerm.getSelectedItem().toString();
				System.out.println(name + offense + proof + comborank
						+ comboperm);
				textAreaResult.setText("[" + comborank + "] " + name + "\r\n"
						+ "Offense: " + offense + "\r\n" + "Proof: " + proof
						+ "\r\n" + "Permission to share: " + comboperm);
				String myString = textAreaResult.getText();
				StringSelection stringSelection = new StringSelection(myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				JOptionPane.showMessageDialog(null,
						"Report copied to clipboard!" + "\r\n"
								+ "Use CTRL + V for easy paste ;)");
			}
		});
		btnNewButton.setBounds(10, 386, 322, 58);
		frame.getContentPane().add(btnNewButton);

		textFieldName = new JTextField();
		textFieldName.setToolTipText("Name\r\n");
		textFieldName.setBounds(10, 50, 322, 34);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

		textFieldOffense = new JTextField();
		textFieldOffense.setToolTipText("Offense");
		textFieldOffense.setBounds(10, 188, 322, 34);
		frame.getContentPane().add(textFieldOffense);
		textFieldOffense.setColumns(10);

		textFieldProof = new JTextField();
		textFieldProof.setToolTipText("Proof");
		textFieldProof.setBounds(10, 258, 322, 34);
		frame.getContentPane().add(textFieldProof);
		textFieldProof.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setForeground(SystemColor.desktop);
		lblName.setBounds(147, 25, 46, 14);
		frame.getContentPane().add(lblName);

		JLabel lblNewLabel = new JLabel("Rank");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBounds(147, 95, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(147, 208, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Proof");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setBounds(147, 233, 39, 14);
		frame.getContentPane().add(lblNewLabel_2);

		comboBoxRank = new JComboBox<>();
		comboBoxRank.setModel(new DefaultComboBoxModel<>(new String[] { "VIP",
				"VIP+", "MVP", "MVP+" }));
		comboBoxRank.setToolTipText("Rank");
		comboBoxRank.setBounds(10, 120, 322, 34);
		frame.getContentPane().add(comboBoxRank);

		JLabel lblNewLabel_3 = new JLabel("Offense");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(SystemColor.desktop);
		lblNewLabel_3.setBounds(147, 165, 58, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblDoYouGive = new JLabel(
				"Do you give the staff permission to share your proof?");
		lblDoYouGive.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDoYouGive.setForeground(SystemColor.desktop);
		lblDoYouGive.setBackground(Color.WHITE);
		lblDoYouGive.setBounds(10, 300, 345, 14);
		frame.getContentPane().add(lblDoYouGive);

		comboBoxPerm = new JComboBox<>();
		comboBoxPerm.setModel(new DefaultComboBoxModel<>(new String[] { "Yes.",
				"No." }));
		comboBoxPerm.setToolTipText("");
		comboBoxPerm.setBounds(10, 318, 322, 34);
		frame.getContentPane().add(comboBoxPerm);

		textAreaResult = new JTextArea();
		textAreaResult.setBackground(Color.WHITE);
		textAreaResult.setForeground(Color.BLACK);
		textAreaResult.setEditable(false);
		textAreaResult.setBounds(504, 90, 282, 269);
		textAreaResult.setColumns(10);
		frame.getContentPane().add(textAreaResult);

		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"This button does nothing \r\n at the moment!");
			}
		});
		btnNewButton_2.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		btnNewButton_2.setBounds(335, 386, 159, 58);
		frame.getContentPane().add(btnNewButton_2);

		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(0, 0, 796, 470);
		frame.getContentPane().add(label);
		Image img = new ImageIcon(this.getClass().getResource("/logo2.png"))
				.getImage();
		label.setIcon(new ImageIcon(img));
		
		JLabel lblMadeByProfessorzed = new JLabel("Made by Professor_Zed");
		lblMadeByProfessorzed.setFont(new Font("AR BERKLEY", Font.PLAIN, 15));
		lblMadeByProfessorzed.setBounds(627, 429, 159, 14);
		frame.getContentPane().add(lblMadeByProfessorzed);
		
	}
}