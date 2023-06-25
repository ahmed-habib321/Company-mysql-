package company;

/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 */
import Database.MysqlDatabaseManager;
import Utilities.Tools;

public class Company {

    public static void main(String[] args) {

        MysqlDatabaseManager.initializeDatabase();

        Tools.openForm(new Forms.Login_form());
    }

}
