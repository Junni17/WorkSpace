package model;

public class Employee {
	private String name;
	private int wage; // hourly wage
	private int employmentYear;

	// link to company class (--> 0..1)
	private Company company;

	/**
	 * Initializes a new employee.<br/>
	 * Req: wage >= 0.
	 */
	public Employee(String name, int wage) {
		assert wage >= 0;
		this.name = name;
		this.wage = wage;
	}

	/**
	 * Returns the name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the wage.
	 */
	public int getWage() {
		return this.wage;
	}

	/**
	 * Sets the wage.<br/>
	 * Req: wage >= 0.
	 */
	public void setWage(int wage) {
		assert wage >= 0;
		this.wage = wage;
	}

	public int getEmploymentyear() {
		return this.employmentYear;
	}

	public void setEmploymentYear(int employmentYear) {
		this.employmentYear = employmentYear;
	}

	@Override
	public String toString() {
		return this.name + " (kr " + this.wage + ")";
	}

	// -----------------------------------------------------------------------------

	/**
	 * Returns the company of this emplyee.<br/>
	 * Returns null, if this employee does not have a company.
	 */
	public Company getCompany() {
		return this.company;
	}

	/**
	 * Sets the company of this employee.<br/>
	 * Note: company may be null.
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	// -----------------------------------------------------------------------------

	/**
	 * Returns the weekly salary of this employee.<br/>
	 * Returns 0, if this employee does not have a company.
	 */
	public int weeklySalary() {
		if (this.company != null) {
			return this.wage * this.company.getHours();
		} else {
			return 0;
		}
	}

}
