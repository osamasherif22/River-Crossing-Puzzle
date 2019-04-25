package javafxapplication14;

import Logic.GmeController;
import Logic.ICrossingStrategy;
import Logic.IRiverCrossingController;
import Logic.Story1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.GridPane;

public class FXMLDocumentController {
   static  boolean flagFarmerInboat ;
   static  boolean flagFoxInboat ;
   static  boolean boat1fill;
   static  boolean boat2fill;
   ICrossingStrategy iStrategy =new Story1();
   IRiverCrossingController controller = new GmeController(iStrategy);
   
	@FXML
    private GridPane grid;

    @FXML
    private ImageView boat1;

    @FXML
    private ImageView farmerview;

    @FXML
    private ImageView OnBoat1;

    @FXML
    private ImageView OnBoat11;

    @FXML
    private Button button1;

    @FXML
    private ImageView boat2;

    @FXML
    private ImageView OnBoat21;

    @FXML
    private ImageView OnBoat22;
    
    @FXML
    private ImageView Fox;
    
    @FXML
    private ImageView Goat;
    
    @FXML
    private ImageView Tomato;
    
    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Button button;
    
    @FXML
    void Onboat1(MouseEvent event) {
    	if( OnBoat1.getImage()==null)
    		return;
    	OnBoat1.setImage(null);
    	//System.out.println(OnBoat1.getId());
    	switch(OnBoat1.getAccessibleText()) {
    	  case "farmer":
    			farmerview.setVisible(true);
    		  break;
    	  case "Fox":
    			Fox.setVisible(true);
             break;
    	  default:
    	       return ; 
    	}
    	boat1fill=false;
    }

    @FXML
    void Onboat2(MouseEvent event) {
    	if( OnBoat11.getImage()==null)
    		return;
    OnBoat11.setImage(null);
    switch(OnBoat11.getAccessibleText()) {
  	  case "farmer":
		farmerview.setVisible(true);
		break;
  	  case "Fox":
		Fox.setVisible(true);
		break;
  	  default:
       return ; 
    }
    boat2fill=false;
     }

    
    @FXML
    void GoatMove(MouseEvent event) {
     System.out.println("Moving G !!!");
    }

    @FXML
    void FoxMove(MouseEvent event) {
    		if (boat1fill&&boat2fill==false)  
	{
		// case that boat have crosser on it 
	Fox.setVisible(false);
	OnBoat11.setImage(Fox.getImage());
	OnBoat11.setAccessibleText("Fox");
	OnBoat11.setVisible(true);
	boat2fill=true;
	}
	// case that boat haven't crosser on it 
   else if (boat1fill==false)
   {
	   boat1fill=true;
	Fox.setVisible(false);
	OnBoat1.setImage(Fox.getImage());
	OnBoat1.setAccessibleText("Fox");
	OnBoat1.setVisible(true);
	}
        }
    
    @FXML
    void TomatoMove(MouseEvent event) {
     System.out.println("Moving G !!!");
    }
    @FXML
    void GoPress(ActionEvent event) {
    	boat1.setVisible(false);
    	OnBoat1.setVisible(false);
    	OnBoat11.setVisible(false);
    	boat2.setVisible(true);
    	OnBoat21.setImage(OnBoat1.getImage());
    	OnBoat22.setImage(OnBoat11.getImage());
    	boat2.setImage(boat1.getImage());
    }

    @FXML
    void FarmerMove(MouseEvent event) {
    	
    	if (boat1fill&&boat2fill==false)  
    	{
    		// case that boat have crosser on it 
    	farmerview.setVisible(false);
    	OnBoat11.setImage(farmerview.getImage());
    	OnBoat11.setAccessibleText("farmer");
    	OnBoat11.setVisible(true);
    	boat2fill=true;
    	}
		// case that boat haven't crosser on it 

    	else if (boat1fill==false)
    	{ 
    	   boat1fill=true;
    	farmerview.setVisible(false);
    	OnBoat1.setImage(farmerview.getImage());
    	OnBoat1.setAccessibleText("farmer");
    	OnBoat1.setVisible(true);
    	}
    	
    }
  
}
