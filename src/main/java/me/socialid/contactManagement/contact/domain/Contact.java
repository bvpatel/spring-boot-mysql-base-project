package me.socialid.contactManagement.contact.domain;

import java.util.List;

public class Contact {
	private Name name;
	private Phonetic phonetic;
	private List<ContactNumber> contactNumbers;
	private Photo profilePic;
	private List<Email> emails;
	private List<Address> addresses;
}
