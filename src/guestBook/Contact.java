package guestBook;

/**
 * @author trinemedina
 *
 * This class consists of methods for creating and sorting contacts. Getter and Setter
 * methods have been created for all member fields; however,
 * the passed arguments are not being validated.
 */

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Contact implements Comparable<Contact> {

	// on personal PC

	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;


	public Contact() {
		this(null, null, null, null);
	}

	public Contact(String firstName) {
		this(firstName, null, null, null);
	}

	public Contact(String firstName, String lastName) {
		this(firstName, lastName, null, null);

	}

	public Contact(String firstName, String lastName, String address) {
		this(firstName, lastName, address, null);

	}

	public Contact(String firstName, String lastName, String address, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}


	/**
	 * This method is used to sort contacts alphabetically by first name
	 *
	 * @param compareContact, which is an object of Class Contact
	 * @return 0 if strings are equal. If not, then a value lesser or greater than 0
	 *         depending on which string is lexicographically greater
	 */
	@Override
	public int compareTo(Contact compareContact) {

		String compareName = compareContact.getFirstName();

		return this.firstName.compareTo(compareName);
	}

	/**
	 * This method is used to remove duplicates from the list of contacts before
	 * they're displayed
	 *
	 * @param contactList as a List<Contact>
	 * @return list with duplicates removed
	 */
	public List<Contact> removeDuplicates(List<Contact> contactList) {

		List<Contact> listWithoutDupes = contactList.stream().distinct().collect(Collectors.toList());

		return listWithoutDupes;
	}


	/**
	 * This method is required to use distinct() to remove duplicate contacts.
	 */
	// I found three different options for this method. (1) use Objects.hash(...) -
	// simple and less prone to coding errors.
	// (2) use two prime numbers to calculate the hash codes for each argument -
	// this version is commented out. (3) Use Eclipse to generate the hashCode().
	@Override
	public int hashCode() {

		return Objects.hash(getFirstName(), getLastName(), getAddress(), getPhoneNumber());

		// int hash = 7;
		// hash = 61 * hash + Objects.hashCode(this.getFirstName());
		// hash = 61 * hash + Objects.hashCode(this.getLastName());
		// hash = 61 * hash + Objects.hashCode(this.getAddress());
		// hash = 61 * hash + Objects.hashCode(this.getPhoneNumber());
		// return hash;
	}

	/**
	 * This method is required to use distinct() to remove duplicates. It compares
	 * each field of two Contact objects and returns true if they're equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		final Contact c1 = (Contact) obj;

		return this.getFirstName().equalsIgnoreCase(c1.getFirstName())
				&& this.getLastName().equalsIgnoreCase(c1.getLastName())
				&& this.getAddress().equalsIgnoreCase(c1.getAddress())
				&& this.getPhoneNumber().equalsIgnoreCase(c1.getPhoneNumber());
	}


	/**
	 * This method creates the output of the contact list. I used it to avoid the
	 * brackets and commas from the toString method.
	 *
	 * @param contactList as a list of Contact
	 * @return string representation of the contact list
	 */
	public String contactOutput(List<Contact> contactList) {

		StringBuilder sb = new StringBuilder();

		String str = null;

		for (Contact contact : contactList) {
			sb.append(contact);
		}

		str = sb.toString();

		return str;
	}

	@Override
	public String toString() {

		return String.format(
				"Contact:	  \nFirst Name:	  %s\nLast Name:	  %s\nAddress:	  %s\nPhone Number:  %s\n\n",
				getFirstName(), getLastName(), getAddress(), getPhoneNumber());
	}

	// All getter and setter methods are below

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


}
