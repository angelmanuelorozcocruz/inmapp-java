
/*Imports*/
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Lessons.ConnectionSqlServer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*Class*/
public class App extends Application {
    /* Methods */
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Connect");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /* Variables */
                Integer employeeid = 0;
                String employeename = "";
                try {
                    Statement st = ConnectionSqlServer.getConnectionSqlServer().createStatement();
                    String query = "SELECT * FROM StorInmApp.dbo.employee";
                    ResultSet rt = st.executeQuery(query);
                    while (rt.next()) {
                        employeeid += rt.getInt(1);
                        employeename += rt.getString(2);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Identificador: " + employeeid + "\n" + "Empleado: " + employeename);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Connection To SQL Server");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /* Main Method */
    public static void main(String[] args) {
        launch(args);
    }
}