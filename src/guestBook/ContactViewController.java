package guestBook;

/**
 * @author trinemedina
 *
 * This class creates the user interface for ContactBook.
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ContactViewController implements ActionListener {

	Contact contact = new Contact();

	List<Contact> contactList = new ArrayList<Contact>();


	public ContactViewController() {
	}

	public ContactViewController(Contact contact) {
		this.contact = contact;
		new ContactViewController().userInterface();
	}


	JFrame frame = new JFrame("Guest Book");

	JPanel panel_01 = new JPanel();
	JPanel panel_02 = new JPanel();
	JPanel panel_03 = new JPanel();

	JTextField textFN = new JTextField();
	JTextField textLN = new JTextField();
	JTextField textAd = new JTextField();
	JTextField textPN = new JTextField();

	JLabel labelFN = new JLabel("First Name", JLabel.CENTER);
	JLabel labeLN = new JLabel("Last Name", JLabel.CENTER);
	JLabel labeAd = new JLabel("Address", JLabel.CENTER);
	JLabel labelPN = new JLabel("Phone Number", JLabel.CENTER);

	JButton button = new JButton("Submit");

	JTextArea textArea = new JTextArea(10, 30);
	JScrollPane scrollPane = new JScrollPane(textArea);


	private void userInterface() {

		frame.setLayout(new GridLayout(2, 3));
		frame.add(panel_01);
		frame.add(panel_02);
		frame.add(panel_03);


		panel_01.setLayout(new GridLayout(0, 2));
		panel_01.setBackground(Color.CYAN);

		panel_01.add(labelFN);
		panel_01.add(textFN);

		panel_01.add(labeLN);
		panel_01.add(textLN);

		panel_01.add(labeAd);
		panel_01.add(textAd);

		panel_01.add(labelPN);
		panel_01.add(textPN);


		panel_02.add(scrollPane);
		panel_02.setBackground(Color.CYAN);
		textArea.setForeground(Color.DARK_GRAY);

		panel_03.add(button);
		button.setForeground(Color.MAGENTA);
		button.addActionListener(this);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	/**
	 * This method adds first name, last name, address and phone number to the
	 * contactList List. The entries are sorted based on first name and duplicate
	 * objects are removed. For an object to be considered a duplicate, all four
	 * fields must be identical - case is ignored. All fields are Strings.
	 *
	 * @param firstName is the only mandatory field
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (textFN.getText().trim().length() != 0) { // test to ensure First Name has been entered

			textArea.setText("");

			String firstName = textFN.getText();
			String lastName = textLN.getText();
			String address = textAd.getText();
			String phoneNumber = textPN.getText();

			Contact contact = new Contact(firstName, lastName, address, phoneNumber);

			contactList.add(contact);

			Collections.sort(contactList);

			contactList = contact.removeDuplicates(contactList);

			textArea.append(contact.contactOutput(contactList));

			textFN.setText("");
			textLN.setText("");
			textAd.setText("");
			textPN.setText("");

		} else {
			JOptionPane.showMessageDialog(null, "Please enter a first name to continue.");
		}
	}
}
