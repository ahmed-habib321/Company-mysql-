package Entity;

import Database.MysqlDatabaseManager;
import Utilities.Tools;
import javax.swing.JTable;

/**
 * Represents the entity class for managing employee phones.
 */
public class EmployeePhones implements MainData {

    private int EmployeeNumber;
    private String Phone;

    /**
     * Gets the employee number.
     *
     * @return the employee number
     */
    public int getEmployeeNumber() {
        return EmployeeNumber;
    }

    /**
     * Sets the employee number.
     *
     * @param EmployeeNumber the employee number to set
     */
    public void setEmployeeNumber(int EmployeeNumber) {
        this.EmployeeNumber = EmployeeNumber;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * Sets the phone number.
     *
     * @param Phone the Phone number to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * Adds a new phone entry for an employee to the database.
     */
    @Override
    public void add() {
        String insertQuery = "INSERT INTO EMPLOYEE_PHONES VALUES ("
                + "'" + Phone + "', "
                + EmployeeNumber + ")";
        boolean isDone = MysqlDatabaseManager.doEdit(insertQuery);
        if (isDone) {
            //Tools.showMessageDialog("Adding is done");
        } else {
            Tools.showMessageDialog("Adding isn't done");
        }
    }

    /**
     * Updates a phone entry for an employee in the database.
     */
    @Override
    public void update() {
        // Suspended
    }

    /**
     * Deletes the current phone entry for an employee from the database.
     */
    @Override
    public void delete() {
        String deleteQuery = "DELETE FROM EmployeePhones WHERE EmployeeNumber = " + EmployeeNumber
                + " AND Phone = '" + Phone + "'";
        boolean isDone = MysqlDatabaseManager.doEdit(deleteQuery);
        if (isDone) {
            //Tools.showMessageDialog("Delete is done");
        } else {
            Tools.showMessageDialog("Delete isn't done");
        }
    }

    /**
     * Deletes all phone entries for an employee from the database.
     */
    public void deleteAllPhones() {
        String deleteQuery = "DELETE FROM EmployeePhones WHERE EmployeeNumber = " + EmployeeNumber;
        boolean isDone = MysqlDatabaseManager.doEdit(deleteQuery);
        if (isDone) {
            //Tools.showMessageDialog("Delete is done");
        } else {
            Tools.showMessageDialog("Delete isn't done");
        }
    }

    /**
     * Retrieves the employee number associated with a given phone number.
     *
     * @param phone the phone number to search for
     * @return the employee number associated with the phone number, or "0" if
     * not found
     */
    public String getEmployeeNumberByPhone(String phone) {
        try {
            String query = "SELECT EmployeeNumber FROM EmployeePhones WHERE Phone = '" + phone + "'";
            return (String) MysqlDatabaseManager.getTableData(query).items[0][0];
        } catch (Exception ex) {
            Tools.showMessageDialog("Error: " + ex);
            return "0";
        }
    }

    /**
     * Retrieves the auto-generated number (not used in this implementation).
     *
     * @return an empty string
     */
    @Override
    public String getAutoNumber() {
        return ""; // Suspended
    }

    /**
     * Retrieves all phone entries for the current employee and populates the
     * specified table.
     *
     * @param table the table to populate with the phone entries
     */
    @Override
    public void getAllRows(JTable table) {
        String query = "SELECT Phone FROM EmployeePhones WHERE EmployeeNumber = " + EmployeeNumber;
        MysqlDatabaseManager.fillTable(query, table);
    }

    /**
     * Retrieves a single phone entry for the current employee (not used in this
     * implementation).
     *
     * @param table the table to populate with the phone entry
     */
    @Override
    public void getOneRow(JTable table) {
        // Suspended
    }

    /**
     * Filters the phone entries based on the specified query and populates the
     * specified table (not used in this implementation).
     *
     * @param query the filter query
     * @param table the table to populate with the filtered phone entries
     */
    @Override
    public void filter(String query, JTable table) {
        // Suspended
    }

    /**
     * Retrieves the value for the specified attribute (not used in this
     * implementation).
     *
     * @param name the name of the attribute
     * @return an empty string
     */
    @Override
    public String getValue(String name) {
        return ""; // Suspended
    }

    /**
     * Retrieves the name for the specified value (not used in this
     * implementation).
     *
     * @param value the value of the attribute
     * @return an empty string
     */
    @Override
    public String getName(String value) {
        return ""; // Suspended
    }

}
