package inheritence;

public class Person {
	private String name; //The private modifier on this field means that the field is only visible in the Person class. 
						 //Even the subclasses of the class does not have access to this field.
	
	protected String address; //The protected modifier makes the field visible to subclasses of the class Person, but
							  // it also becomes visible to other classes in the same package. A better solution is to make
							  // the field private, with appropriate getters and setters. 
	protected String qualification;

	public Person(String name, String address, String qualification) {
		this.name = name;
		this.address = address;
		this.qualification = qualification;
	}

	public String getName() { //Necessary, if other classes including subclasses shall have access to the name field. 
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() { //Subclasses and classes in the same package can access the address field directly.
		return address;			
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void printPerson() {
		System.out.println();
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Qualification: " + qualification);
	}


}
