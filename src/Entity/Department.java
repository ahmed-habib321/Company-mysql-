package Entity;

import Database.MysqlDatabaseManager;
import javax.swing.JTable;
import Utilities.Tools;

/**
 * The Department class represents a Department entity with its associated
 * properties and database operations.
 */
public class Department implements MainData {

    private int DepartmentNumber;
    private String DepartmentName;
    private String Location;

    /**
     * Default constructor for the Department class.
     */
    public Department() {
    }

    /**
     * Constructor for the Department class.
     *
     * @param DepartmentNumber The Department Number.
     * @param DepartmentName The department name.
     * @param Location The department location.
     */
    public Department(int DepartmentNumber, String DepartmentName, String Location) {
        this.DepartmentNumber = DepartmentNumber;
        this.DepartmentName = DepartmentName;
        this.Location = Location;
    }

    /**
     * Retrieves the Department Number.
     *
     * @return the Department Number
     */
    public int getDepartmentNumber() {
        return DepartmentNumber;
    }

    /**
     * Sets the Department Number.
     *
     * @param DepartmentNumber the Department Number to set
     */
    public void setDepartmentNumber(int DepartmentNumber) {
        this.DepartmentNumber = DepartmentNumber;
    }

    /**
     * Retrieves the department name.
     *
     * @return the department name
     */
    public String getDepartmentName() {
        return DepartmentName;
    }

    /**
     * Sets the department name.
     *
     * @param DepartmentName the department name to set
     */
    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    /**
     * Retrieves the Location.
     *
     * @return the Location
     */
    public String getLocation() {
        return Location;
    }

    /**
     * Sets the location.
     *
     * @param Location the Location to set
     */
    public void setLocation(String Location) {
        this.Location = Location;
    }

    /**
     * Adds a new Department to the database.
     */
    @Override
    public void add() {
        String insertQuery = "INSERT INTO DepartmentData VALUES ("
                + DepartmentNumber + ","
                + "'" + DepartmentName + "'" + "," + "'" + Location + "')";
        boolean isDone = MysqlDatabaseManager.doEdit(insertQuery);
        if (isDone) {
            //Tools.showMessageDialog("Adding is done.");
        } else {
            Tools.showMessageDialog("Adding isn't done.");
        }
    }

    /**
     * Updates the department information in the database.
     */
    @Override
    public void update() {
        String updateQuery = "UPDATE DepartmentData SET Department = '"
                + DepartmentName + "'" + ", Location='" + Location
                + "' WHERE DepartmentNumber = " + DepartmentNumber;
        boolean isDone = MysqlDatabaseManager.doEdit(updateQuery);
        if (isDone) {
            //Tools.showMessageDialog("Update is done.");
        } else {
            Tools.showMessageDialog("Update isn't done.");
        }
    }

    /**
     * Deletes the department from the database.
     */
    @Override
    public void delete() {
        String deleteQuery = "DELETE FROM DepartmentData WHERE "
                + "DepartmentNumber = " + DepartmentNumber;
        boolean isDone = MysqlDatabaseManager.doEdit(deleteQuery);
        if (isDone) {
            //Tools.showMessageDialog("Delete is done.");
        } else {
            Tools.showMessageDialog("Delete isn't done.");
        }
    }

    /**
     * Generates an auto-incremented number for the department.
     *
     * @return The auto-incremented number.
     */
    @Override
    public String getAutoNumber() {
        return MysqlDatabaseManager.getAutoNumber("DepartmentData", "DepartmentNumber");
    }

    /**
     * Retrieves all the departments from the database and populates the
     * provided table.
     *
     * @param table The table to populate with department data.
     */
    @Override
    public void getAllRows(JTable table) {
        MysqlDatabaseManager.fillTable("DepartmentData", table);
    }

    /**
     * Retrieves a specific department from the database and populates the
     * provided table.
     *
     * @param table The table to populate with department data.
     */
    @Override
    public void getOneRow(JTable table) {
        String query = "SELECT * FROM DepartmentData WHERE DepartmentNumber = " + DepartmentNumber;
        MysqlDatabaseManager.fillTable(query, table);
    }

    /**
     * Filters the department data based on the provided query and populates the
     * table.
     *
     * @param query The query to filter the department data.
     * @param table The table to populate with filtered department data.
     */
    @Override
    public void filter(String query, JTable table) {
        MysqlDatabaseManager.fillTable(query, table);
    }

    /**
     * Retrieves the Department Number based on the department name from the
     * database.
     *
     * @param Name The department name.
     * @return The Department Number associated with the given name.
     */
    @Override
    public String getValue(String Name) {
        try {
            String query = "SELECT DepartmentNumber FROM DepartmentData WHERE "
                    + "Department = '" + Name + "'";
            return (String) MysqlDatabaseManager.getTableData(query).items[0][0];
        } catch (Exception ex) {
            Tools.showMessageDialog("Error: " + ex);
            return "0";
        }
    }

    /**
     * Retrieves the department name based on the Department Number from the
     * database.
     *
     * @param Value The Department Number.
     * @return The department name associated with the given number.
     */
    @Override
    public String getName(String Value) {
        try {
            String query = "SELECT Department FROM DepartmentData WHERE DepartmentNumber = " + Value;
            return (String) MysqlDatabaseManager.getTableData(query).items[0][0];
        } catch (Exception ex) {
            Tools.showMessageDialog("Error: " + ex);
            return null;
        }
    }

}
