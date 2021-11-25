package guestBook;
//package GuestBook;

import javax.swing.SwingUtilities;

public class ContactBook {



	public static void main(String[] args) {

		Contact contact = new Contact();

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ContactViewController(contact);
			}
		});
	}



}

