package javafxapplication14;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Logic.*;

public class EntryViewExController2 {

    @FXML
    private ImageView StartButton;

    @FXML
    void GotoStorySelectView(ActionEvent event) throws IOException {
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("StoryChooseView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
    
  
}
