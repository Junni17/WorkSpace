package exercise4;

public class Name {
	private String firstName;
	private String middleName;
	private String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.middleName = "";
		this.lastName = lastName;
	}

	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	// firstname

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// middlename

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	// lastname

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// fullname

	public String getFullName() {
		if (this.middleName.equals("")) {
			return this.firstName + " " + this.lastName;
		} else {
			return this.firstName + " " + this.middleName + " " + this.lastName;
		}
	}

	// initials
	// "" fordi jeg laver en string om til en int

	public String getInits() {
		if (this.middleName.equals("")) {
			return "" + this.firstName.charAt(0) + this.lastName.charAt(0);
		} else {
			return "" + this.firstName.charAt(0) + this.middleName.charAt(0) + this.lastName.charAt(0);
		}
	}

	public String getInits(boolean withMiddleInit) {
		if (this.middleName.equals("")) {
			return "" + this.firstName.charAt(0) + this.lastName.charAt(0);
		} else {
			if (withMiddleInit == true) {
				return "" + this.firstName.charAt(0) + this.middleName.charAt(0) + this.lastName.charAt(0);
			} else {
				return "" + this.firstName.charAt(0) + this.lastName.charAt(0);
			}
		}
	}

	// encrypted version of initials

	public String getCryptoInits(int count) {

		char l1 = (char) (this.firstName.charAt(0) + count);
		String result = "" + l1;
		if (!this.middleName.equals("")) {
			char l2 = (char) (this.middleName.charAt(0) + count);
			result = result + l2;
		}
		char l3 = (char) (this.lastName.charAt(0) + count);
		result = result + l3;
		return result;
	}

	// lastName.length er længden på lastname
	public String getUsername() {
		int ll = this.lastName.length();
		return this.firstName.substring(0, 2).toUpperCase() + this.middleName.length()
				+ this.lastName.substring(ll - 2, ll);
	}
}
