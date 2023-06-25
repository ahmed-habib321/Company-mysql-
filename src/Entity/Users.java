package Entity;

import Database.MysqlDatabaseManager;
import Forms.Login_form;
import Utilities.Tools;
import javax.swing.JTable;

/**
 * The Users class represents a user in the system.
 */
public class Users implements MainData {

    private String Username;
    private String Password;
    private String IsBanned;

    /**
     * Gets the Username of the user.
     *
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * Sets the Username of the user.
     *
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Sets the Password of the user.
     *
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * Checks if the user is banned.
     *
     * @return true if the user is banned, false otherwise
     */
    public boolean isBanned() {
        return "Yes".equals(IsBanned);
    }

    /**
     * Sets the ban status of the user.
     *
     * @param IsBanned the ban status to set
     */
    public void setBanned(String IsBanned) {
        this.IsBanned = IsBanned;
    }

    /**
     * Adds a new user to the database.
     */
    @Override
    public void add() {
        String insertQuery = "INSERT INTO Users VALUES ("
                + "'" + Username + "',"
                + "'" + Password + "',"
                + "'No')";
        boolean isDone = MysqlDatabaseManager.doEdit(insertQuery);
        if (isDone) {
            //Tools.showMessageDialog("Account is created");
        } else {
            Tools.showMessageDialog("Failed to create account");
        }
    }

    /**
     * Updates the information of an existing user in the database.
     */
    @Override
    public void update() {
        String updateQuery = "UPDATE Users SET "
                + "Password = '" + Password + "',"
                + "isBanned = '" + IsBanned + "' "
                + "WHERE Username = '" + Username + "'";
        boolean isDone = MysqlDatabaseManager.doEdit(updateQuery);
        if (isDone) {
            //Tools.showMessageDialog("Update is done");
        } else {
            Tools.showMessageDialog("Update failed");
        }
    }

    /**
     * Deletes an existing user from the database.
     */
    @Override
    public void delete() {
        String deleteQuery = "DELETE FROM Users WHERE Username = '" + Username + "'";
        boolean isDone = MysqlDatabaseManager.doEdit(deleteQuery);
        if (isDone) {
            //Tools.showMessageDialog("Delete is done");
        } else {
            Tools.showMessageDialog("Delete failed");
        }
    }

    @Override
    public String getAutoNumber() {
        // Suspended - Implementation not provided
        return "";
    }

    /**
     * Retrieves all rows of user data from the database and populates them into
     * a JTable.
     *
     * @param table The JTable to populate with users data.
     */
    @Override
    public void getAllRows(JTable table) {
        MysqlDatabaseManager.fillTable("Users", table);
    }

    /**
     * Retrieves a single row of user data from the database based on the
     * Username and populates it into a JTable.
     *
     * @param table The JTable to populate with users data.
     */
    @Override
    public void getOneRow(JTable table) {
        String query = "SELECT * FROM Users WHERE Username = '" + Username + "'";
        MysqlDatabaseManager.fillTable(query, table);
    }

    /**
     * Filters user data from the database based on a custom query and populates
     * the filtered data into a JTable.
     *
     * @param query The custom query to filter the user data.
     * @param table The JTable to populate with the filtered user data.
     */
    @Override
    public void filter(String query, JTable table) {
        MysqlDatabaseManager.fillTable(query, table);
    }

    @Override
    public String getValue(String name) {
        // Suspended - Implementation not provided
        return "";
    }

    @Override
    public String getName(String value) {
        // Suspended - Implementation not provided
        return "";
    }

}
