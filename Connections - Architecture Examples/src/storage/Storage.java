package storage;

import java.util.ArrayList;

import model.Company;
import model.Employee;

public class Storage
{
    private static ArrayList<Company> companies = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static ArrayList<Company> getAllCompanies()
    {
        return new ArrayList<Company>(companies);
    }

    public static void storeCompany(Company company)
    {
        assert company != null;
        companies.add(company);
    }

    public static void deleteCompany(Company company)
    {
        companies.remove(company);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Employee> getAllEmployees()
    {
        return new ArrayList<Employee>(employees);
    }

    public static void storeEmployee(Employee employee)
    {
        assert employee != null;
        employees.add(employee);
    }

    public static void deleteEmployee(Employee employee)
    {
        employees.remove(employee);
    }

}
