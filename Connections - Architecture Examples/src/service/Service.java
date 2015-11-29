package service;

import model.Company;
import model.Employee;
import storage.Storage;

public class Service {
	/**
	 * Creates a new Company.<br />
	 * Requires: hours >= 0.
	 */
	public static Company createCompany(String name, int hours) {
		assert hours >= 0;
		Company company = new Company(name, hours);
		Storage.storeCompany(company);
		return company;
	}

	/**
	 * Deletes the company.<br />
	 * Requires: The company has no employees.
	 */
	public static void deleteCompany(Company company) {
		assert company.employeesCount() == 0;
		Storage.deleteCompany(company);
	}

	/**
	 * Updates the company.<br />
	 * Requires: hours >= 0.
	 */
	public static void updateCompany(Company company, String name, int hours) {
		assert hours >= 0;
		company.setName(name);
		company.setHours(hours);
	}

	// -------------------------------------------------------------------------

	/**
	 * Creates a new employee.<br />
	 * Requires: wage >= 0.
	 */
	public static Employee createEmployee(String name, int wage) {
		assert wage >= 0;
		Employee employee = new Employee(name, wage);
		Storage.storeEmployee(employee);
		return employee;
	}

	/**
	 * Deletes the employee.
	 */
	public static void deleteEmployee(Employee employee) {
		Company company = employee.getCompany();
		if (company != null) {
			company.removeEmployee(employee);
			employee.setCompany(null);
		}
		Storage.deleteEmployee(employee);
	}

	/**
	 * Updates the employee.<br />
	 * Requires: wage >= 0.
	 */
	public static void updateEmployee(Employee employee, String name, int wage) {
		assert wage >= 0;
		employee.setName(name);
		employee.setWage(wage);
	}

	// -------------------------------------------------------------------------

	/**
	 * Sets the employee's company.<br/>
	 * Note: company may be null.
	 */
	public static void setCompanyOfEmployee(Employee employee, Company company, int employmentYear) {
		Company oldCompany = employee.getCompany();
		if (oldCompany != null) {
			oldCompany.removeEmployee(employee);
			employee.setCompany(null);
		}
		if (company != null) {
			employee.setCompany(company);
			employee.setEmploymentYear(employmentYear);
			company.addEmployee(employee);

		}
	}

	// -------------------------------------------------------------------------

	/**
	 * Initializes the storage with some objects.
	 */
	public static void initStorage() {
		Company c1 = Service.createCompany("IBM", 37);
		Company c2 = Service.createCompany("AMD", 40);
		Service.createCompany("SLED", 45);
		Service.createCompany("Vector", 32);

		Employee e1 = Service.createEmployee("Bob Dole", 210);
		Service.setCompanyOfEmployee(e1, c2, 2010);
		Employee e2 = Service.createEmployee("Alice Schmidt", 250);
		Service.setCompanyOfEmployee(e2, c1, 1993);
		Employee e3 = Service.createEmployee("George Down", 150);
		Service.setCompanyOfEmployee(e3, c2, 2001);
		Service.createEmployee("Rita Uphill", 300);
	}

}
