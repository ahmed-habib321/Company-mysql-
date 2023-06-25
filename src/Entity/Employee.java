package Entity;

import Database.MysqlDatabaseManager;
import Utilities.Tools;
import javax.swing.JTable;

/**
 * The Employee class represents an employee in the system. It provides methods
 * to perform CRUD operations on employee data.
 */
public class Employee implements MainData {

    private int EmployeeNumber;
    private String EmployeeName;
    private String Address;
    private double Salary;
    private String BirthDate; //"2009-08-20"\\
    private String HiringDate;
    private int DepartmentNumber;

    /**
     * Retrieves the employee number.
     *
     * @return The employee number.
     */
    public int getEmployeeNumber() {
        return EmployeeNumber;
    }

    /**
     * Sets the employee number.
     *
     * @param EmployeeNumber The employee number to set.
     */
    public void setEmployeeNumber(int EmployeeNumber) {
        this.EmployeeNumber = EmployeeNumber;
    }

    /**
     * Retrieves the employee name.
     *
     * @return The employee name.
     */
    public String getEmployeeName() {
        return EmployeeName;
    }

    /**
     * Sets the employee name.
     *
     * @param EmployeeName The employee name to set.
     */
    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    /**
     * Retrieves the employee address.
     *
     * @return The employee address.
     */
    public String getEmployeeAddress() {
        return Address;
    }

    /**
     * Sets the employee address.
     *
     * @param Address The employee address to set.
     */
    public void setEmployeeAddress(String Address) {
        this.Address = Address;
    }

    /**
     * Retrieves the employee salary.
     *
     * @return The employee salary.
     */
    public double getSalary() {
        return Salary;
    }

    /**
     * Sets the employee salary.
     *
     * @param Salary The employee salary to set.
     */
    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    /**
     * Retrieves the employee birth Date.
     *
     * @return The employee birth Date.
     */
    public String getBirthDate() {
        return BirthDate;
    }

    /**
     * Sets the employee birth Date.
     *
     * @param BirthDate The employee birth Date to set.
     */
    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    /**
     * Retrieves the employee hire Date.
     *
     * @return The employee hire Date.
     */
    public String getHireDate() {
        return HiringDate;
    }

    /**
     * Sets the employee hire Date.
     *
     * @param HiringDate The employee hire Date to set.
     */
    public void setHireDate(String HiringDate) {
        this.HiringDate = HiringDate;
    }

    /**
     * Retrieves the employee department Number.
     *
     * @return The employee department Number.
     */
    public int getDepartmentNumber() {
        return DepartmentNumber;
    }

    /**
     * Sets the employee department Number.
     *
     * @param DepartmentNumber The employee department Number to set.
     */
    public void setDepartmentNumber(int DepartmentNumber) {
        this.DepartmentNumber = DepartmentNumber;
    }

    /**
     * Adds a new employee to the database.
     */
    @Override
    public void add() {
        String insertQuery = "INSERT INTO Employee VALUES ("
                + EmployeeNumber + ","
                + "'" + EmployeeName + "' ,"
                + "'" + Address + "' ,"
                + Salary + ","
                + " TO_DATE('" + HiringDate + "' ,'YYYY/MM/DD') ,"
                + " TO_DATE('" + BirthDate + "' ,'YYYY/MM/DD') ,"
                + DepartmentNumber + ")";

        boolean isDone = MysqlDatabaseManager.doEdit(insertQuery);
        if (isDone) {
            //Tools.showMessageDialog("Adding is done");
        } else {
            Tools.showMessageDialog("Adding isn't done");
        }
    }

    /**
     * Updates the information of an existing employee in the database.
     */
    @Override
    public void update() {
        String updateQuery = "UPDATE EmployeeData SET "
                + " Name = '" + EmployeeName + "' ,"
                + " Address = '" + Address + "' ,"
                + " Salary = " + Salary + ","
                + " HiringDate = " + " TO_DATE('" + HiringDate + "' ,'YYYY/MM/DD')" + " ,"
                + " BirthDate = " + " TO_DATE('" + BirthDate + "' ,'YYYY/MM/DD')" + " ,"
                + " DepartmentNumber = " + DepartmentNumber
                + " WHERE Number = " + EmployeeNumber;

        boolean isDone = MysqlDatabaseManager.doEdit(updateQuery);
        if (isDone) {
            //Tools.showMessageDialog("Update is done");
        } else {
            Tools.showMessageDialog("Update isn't done");
        }
    }

    /**
     * Deletes an existing employee from the database.
     */
    @Override
    public void delete() {
        String deleteQuery = "DELETE FROM EmployeeData WHERE Number = " + EmployeeNumber;
        boolean isDone = MysqlDatabaseManager.doEdit(deleteQuery);
        if (isDone) {
            //Tools.showMessageDialog("Delete is done");
        } else {
            Tools.showMessageDialog("Delete isn't done");
        }
    }

    /**
     * Retrieves an auto-generated employee number from the database.
     *
     * @return The auto-generated employee number.
     */
    @Override
    public String getAutoNumber() {
        return MysqlDatabaseManager.getAutoNumber("EmployeeData", "EmployeeNumber");
    }

    /**
     * Retrieves all rows of employee data from the database and populates them
     * into a JTable.
     *
     * @param table The JTable to populate with employee data.
     */
    @Override
    public void getAllRows(JTable table) {
        MysqlDatabaseManager.fillTable("EmployeeData", table);
    }

    /**
     * Retrieves a single row of employee data from the database based on the
     * employee number and populates it into a JTable.
     *
     * @param table The JTable to populate with employee data.
     */
    @Override
    public void getOneRow(JTable table) {
        String query = "SELECT * FROM EmployeeData WHERE Number = " + EmployeeNumber;
        MysqlDatabaseManager.fillTable(query, table);
    }

    /**
     * Filters employee data from the database based on a custom query and
     * populates the filtered data into a JTable.
     *
     * @param query The custom query to filter the employee data.
     * @param table The JTable to populate with the filtered employee data.
     */
    @Override
    public void filter(String query, JTable table) {
        MysqlDatabaseManager.fillTable(query, table);
    }

    /**
     * Retrieves the value (employee number) associated with a given employee
     * name from the database.
     *
     * @param name The employee name.
     * @return The employee number associated with the given name.
     */
    @Override
    public String getValue(String name) {
        try {
            String query = "SELECT Number FROM EmployeeData WHERE Name = '" + name + "'";
            return (String) MysqlDatabaseManager.getTableData(query).items[0][0];
        } catch (Exception ex) {
            Tools.showMessageDialog("Error: " + ex);
            return "0";
        }
    }

    /**
     * Retrieves the name (employee name) associated with a given employee
     * number from the database.
     *
     * @param value The employee number.
     * @return The employee name associated with the given number.
     */
    @Override
    public String getName(String value) {
        try {
            String query = "SELECT Name FROM EmployeeData WHERE Number = " + value;
            return (String) MysqlDatabaseManager.getTableData(query).items[0][0];
        } catch (Exception ex) {
            Tools.showMessageDialog("Error: " + ex);
            return null;
        }
    }

}
