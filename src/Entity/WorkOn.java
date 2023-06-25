package Entity;

import Database.MysqlDatabaseManager;
import Utilities.Tools;
import javax.swing.JTable;

/**
 * The WorkOn class represents a relationship between a project and an employee.
 * It contains methods to get and set the project number and employee number.
 */
public class WorkOn implements MainData {

    private int ProjectNumber;
    private int EmployeeNumber;

    /**
     *
     * Retrieves the project number.
     *
     * @return the project number
     */
    public int getProjectNumber() {
        return ProjectNumber;
    }

    /**
     *
     * Sets the project number.
     *
     * @param ProjectNumber the project number to set
     */
    public void setProjectNumber(int ProjectNumber) {
        this.ProjectNumber = ProjectNumber;
    }

    /**
     *
     * Retrieves the employee number.
     *
     * @return the employee number
     */
    public int getEmployeeNumber() {
        return EmployeeNumber;
    }

    /**
     *
     * Sets the employee number.
     *
     * @param EmployeeNumber the employee number to set
     */
    public void setEmployeeNumber(int EmployeeNumber) {
        this.EmployeeNumber = EmployeeNumber;
    }

    /**
     * Adds a new entry to the "WorkOn" table.
     */
    @Override
    public void add() {
        String insertQuery = "INSERT INTO WorkOn VALUES ("
                + ProjectNumber + ","
                + EmployeeNumber + ")";
        boolean isDone = MysqlDatabaseManager.doEdit(insertQuery);
        if (isDone) {
            //Tools.showMessageDialog("Adding is done");
        } else {
            Tools.showMessageDialog("Adding wasn't successful");
        }
    }

    /**
     * Updates an entry in the "WorkOn" table. This method is suspended.
     */
    @Override
    public void update() {
        // Suspended: Implementation not provided
    }

    /**
     * Deletes an entry from the "work_on" table based on the employee and
     * project numbers.
     */
    @Override
    public void delete() {
        String deleteQuery = "DELETE FROM WorkOn WHERE EmployeeNumber = " + EmployeeNumber + " AND ProjectNumber = " + ProjectNumber;
        boolean isDone = MysqlDatabaseManager.doEdit(deleteQuery);
        if (isDone) {
            //Tools.showMessageDialog("Delete is done");
        } else {
            Tools.showMessageDialog("Deletion wasn't successful");
        }
    }

    @Override
    public String getAutoNumber() {
        // Suspended: Implementation not provided
        return "";
    }

    /**
     * Retrieves all rows from the "WorkOnData" table and populates the
     * provided table.
     *
     * @param table the table to populate with data
     */
    @Override
    public void getAllRows(JTable table) {
        MysqlDatabaseManager.fillTable("WorkOnData", table);
    }

    /**
     * Retrieves a specific row from the "WorkOnData" table based on the
     * employee and project numbers and populates the provided table.
     *
     * @param table the table to populate with data
     */
    @Override
    public void getOneRow(JTable table) {
        String query = "SELECT * FROM WorkOnData WHERE EmployeeNumber = " + EmployeeNumber + " AND ProjectNumber = " + ProjectNumber;
        MysqlDatabaseManager.fillTable(query, table);
    }

    /**
     * Filters the "WorkOnData" table based on the provided query and
     * populates the provided table with the results.
     *
     * @param query the SQL query for filtering the data
     * @param table the table to populate with the filtered data
     */
    @Override
    public void filter(String query, JTable table) {
        MysqlDatabaseManager.fillTable(query, table);
    }

    /**
     * Gets the value of a specific column in the "WorkOn" table. This method
     * is suspended.
     *
     * @param name the name of the column
     * @return the value of the column
     */
    @Override
    public String getValue(String name) {
        // Suspended: Implementation not provided
        return "";
    }

    /**
     * Gets the name of a specific value in the "WorkOn" table. This method is
     * suspended.
     *
     * @param value the value in the table
     * @return the name associated with the value
     */
    @Override
    public String getName(String value) {
        // Suspended: Implementation not provided
        return "";
    }

}
