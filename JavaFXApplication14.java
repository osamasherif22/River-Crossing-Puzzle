/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication14;
import Logic.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ABD-ELRAHMAN
 */
public class JavaFXApplication14 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("EntryViewEx.fxml"));
        stage.setTitle("River Crossing Game");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
// To switch Scenes On same Stage !!! ****//
/* public void changeScreenButtonPushed(ActionEvent event) throws IOException
{
Parent tableViewParent = FXMLLoader.load(getClass().getResource("ExampleOfTableView.fxml"));
Scene tableViewScene = new Scene(tableViewParent);

//This line gets the Stage information
Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

window.setScene(tableViewScene);
window.show();
}*/