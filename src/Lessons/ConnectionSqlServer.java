/*Package*/
package Lessons;

/*Imports*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Class*/
public class ConnectionSqlServer {
    public static Connection getConnectionSqlServer() {
        /* Variables */
        Connection con = null;
        try {
            String urlDb = "jdbc:sqlserver://DESKTOP-H755IA0\\SQLEXPRESS2019:1433;databaseName=StorInmApp;user=sa;password=DbAAMOC.1997.#;longinTimeout=30";
            con = DriverManager.getConnection(urlDb);
            if (con != null) {
                System.out.println("Successfull Connection");
            }
        } catch (SQLException ex) {
            System.out.println("Error Of Connection" + ex);
        }
        return con;
    }
}
