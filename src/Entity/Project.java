package Entity;

import Database.MysqlDatabaseManager;
import Utilities.Tools;
import javax.swing.JTable;

/**
 * Represents a Project entity that implements the MainData interface.
 */
public class Project implements MainData {

    private int ProjectNumber;
    private String ProjectName;
    private String Location;
    private int DepartmentNumber;

    /**
     * Gets the project number.
     *
     * @return the project number
     */
    public int getProjectNumber() {
        return ProjectNumber;
    }

    /**
     * Sets the project number.
     *
     * @param ProjectNumber the project number to set
     */
    public void setProjectNumber(int ProjectNumber) {
        this.ProjectNumber = ProjectNumber;
    }

    /**
     * Gets the project name.
     *
     * @return the project name
     */
    public String getProjectName() {
        return ProjectName;
    }

    /**
     * Sets the project name.
     *
     * @param ProjectName the project name to set
     */
    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    /**
     * Gets the project location.
     *
     * @return the project location
     */
    public String getLocation() {
        return Location;
    }

    /**
     * Sets the project location.
     *
     * @param Location the project location to set
     */
    public void setLocation(String Location) {
        this.Location = Location;
    }

    /**
     * Gets the department number.
     *
     * @return the department number
     */
    public int getDepartmentNumber() {
        return DepartmentNumber;
    }

    /**
     * Sets the department number.
     *
     * @param DepartmentNumber the department number to set
     */
    public void setDepartmentNumber(int DepartmentNumber) {
        this.DepartmentNumber = DepartmentNumber;
    }

    /**
     * Adds a new project to the database.
     */
    @Override
    public void add() {
        String insertQuery = "INSERT INTO Project VALUES ("
                + ProjectNumber + ","
                + "'" + ProjectName + "'" + ","
                + "'" + Location + "',"
                + DepartmentNumber + ")";
        boolean isDone = MysqlDatabaseManager.doEdit(insertQuery);
        if (isDone) {
            //Tools.showMessageDialog("Adding is done");
        } else {
            Tools.showMessageDialog("Adding isn't done");
        }
    }

    /**
     * Updates an existing project in the database.
     */
    @Override
    public void update() {
        String updateQuery = "UPDATE project_data SET "
                + "DepartmentNumber = " + DepartmentNumber
                + ", Location = '" + Location + "'"
                + ", Project = '" + ProjectName + "'"
                + " WHERE ProjectNumber = " + String.valueOf(ProjectNumber);
        boolean isDone = MysqlDatabaseManager.doEdit(updateQuery);
        if (isDone) {
            //Tools.showMessageDialog("Update is done");
        } else {
            Tools.showMessageDialog("Update isn't done");
        }
    }

    /**
     * Deletes the current project from the database.
     */
    @Override
    public void delete() {
        String deleteQuery = "DELETE FROM Project WHERE ProjectNumber = " + ProjectNumber;
        boolean isDone = MysqlDatabaseManager.doEdit(deleteQuery);
        if (isDone) {
            //Tools.showMessageDialog("Delete is done");
        } else {
            Tools.showMessageDialog("Delete isn't done");
        }
    }

    /**
     * Generates the auto-number for a new project.
     *
     * @return the generated auto-number
     */
    @Override
    public String getAutoNumber() {
        return MysqlDatabaseManager.getAutoNumber("Project", "ProjectNumber");
    }

    /**
     * Retrieves all rows of projects and populates the given table.
     *
     * @param table the table to fill with project data
     */
    @Override
    public void getAllRows(JTable table) {
        MysqlDatabaseManager.fillTable("ProjectData", table);
    }

    /**
     * Retrieves a single row of project data based on the project number and
     * populates the given table.
     *
     * @param table the table to fill with project data
     */
    @Override
    public void getOneRow(JTable table) {
        String query = "SELECT * FROM ProjectData WHERE ProjectNumber = " + String.valueOf(ProjectNumber);
        MysqlDatabaseManager.fillTable(query, table);
    }

    /**
     * Filters the project data based on the given query and populates the given
     * table.
     *
     * @param query the query to filter the project data
     * @param table the table to fill with filtered project data
     */
    @Override
    public void filter(String query, JTable table) {
        MysqlDatabaseManager.fillTable(query, table);
    }

    /**
     * Retrieves the value of the project number based on the project name.
     *
     * @param name the project name
     * @return the corresponding project number
     */
    @Override
    public String getValue(String name) {
        try {
            String query = "SELECT ProjectNumber FROM ProjectData WHERE Project = '" + name + "'";
            return (String) MysqlDatabaseManager.getTableData(query).items[0][0];
        } catch (Exception ex) {
            Tools.showMessageDialog("Error: " + ex);
            return "0";
        }
    }

    /**
     * Retrieves the name of the project based on the project number.
     *
     * @param value the project number
     * @return the corresponding project name
     */
    @Override
    public String getName(String value) {
        try {
            String query = "SELECT Project FROM ProjectData WHERE ProjectNumber = " + value;
            return (String) MysqlDatabaseManager.getTableData(query).items[0][0];
        } catch (Exception ex) {
            Tools.showMessageDialog("Error: " + ex);
            return null;
        }
    }
}
