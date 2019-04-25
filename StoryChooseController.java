package javafxapplication14;
import java.io.IOException;

import Logic.GmeController;
import Logic.ICrossingStrategy;
import Logic.IRiverCrossingController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class StoryChooseController {

	 @FXML
	    private ImageView story1;

	    @FXML
	    private ImageView story2;

	    @FXML
	    private ImageView gobtn;

	    @FXML
	    void GotoStory1(ActionEvent event) throws IOException {
	    	System.out.println("HHH");
	    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);    
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

	        window.setScene(tableViewScene);
	        window.show();
	        
	    }
  
}
