package model;

import java.util.ArrayList;

public class Company
{
    private String name;
    private int hours; // weekly work hours

    // link to Employee class (--> 0..*)
    private ArrayList<Employee> employees = new ArrayList<>();

    /**
     * Initializes a new company.<br/>
     * Req: hours >= 0;
     */
    public Company(String name, int hours)
    {
        this.name = name;
        this.hours = hours;
    }

    /**
     * Returns the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the hours.
     */
    public int getHours()
    {
        return hours;
    }

    /**
     * Sets the hours.<br/>
     * Req: hours >= 0.
     */
    public void setHours(int hours)
    {
        assert hours >= 0;
        this.hours = hours;
    }

    @Override
    public String toString()
    {
        return name + " (" + hours + " hours)";
    }

    // -----------------------------------------------------------------------------

    /**
     * Returns a list of this company's employees.
     */
    public ArrayList<Employee> getEmployees()
    {
        return new ArrayList<Employee>(employees);
    }

    /**
     * Adds the employee.
     */
    public void addEmployee(Employee employee)
    {
        assert employee != null;
        employees.add(employee);
    }

    /**
     * Removes the employee.
     */
    public void removeEmployee(Employee employee)
    {
        employees.remove(employee);
    }

    // -----------------------------------------------------------------------------

    /**
     * Returns the count of employees in this company.
     */
    public int employeesCount()
    {
        return employees.size();
    }

    /**
     * Returns the total weekly salary of all employees in the company.
     */
    public int totalWeeklySalary()
    {
        int total = 0;
        for (Employee emp : employees) {
            total += emp.weeklySalary();
        }
        return total;
    }

}
