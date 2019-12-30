package asupekar_hw4.person;

import asupekar_hw4.enums.PersonStatus;

public class Person {

	protected String firstName;
	protected String lastName;
	protected int suid;
	protected PersonStatus status;
	protected String email;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getSuid() {
		return suid;
	}

	public PersonStatus getStatus() {
		return status;
	}

	public String getEmail() {
		return email;
	}

	public Person(String firstName, String lastName, int suid, PersonStatus status, String email) {
		this(firstName, lastName);
		this.suid = suid;
		this.status = status;
		this.email = email;
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
