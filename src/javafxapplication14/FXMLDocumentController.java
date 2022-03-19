 package javafxapplication14;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import Logic.crosserFun;
import Logic.Boat;
import Logic.Farmer;
import Logic.GmeController;
import Logic.ICrosser;
import Logic.ICrossingStrategy;
import Logic.IRiverCrossingController;
import Logic.RiverBanks;
import Logic.Story1;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.annotations.Ignore;
import icons.*;

public class FXMLDocumentController {
  /* static boolean flagFarmerInboat ;
    static boolean flagFoxInboat ;*/
    static boolean boat11fill;
   
	static boolean boat12fill;
    static boolean boat21fill;
    static boolean boat22fill;
    
    static String crosser1Wight;
    static String crosser2Wight;
    static String crosser3Wight;
    static String crosser4Wight;
    static String crosser5Wight;
    static int loadLeftCounter=0;
    static int loadRightCounter=0;


    
   RiverBanks riverBanks= RiverBanks.getInstance();
   GmeController controller= GmeController.getInstance();
   Boat boat =Boat.getInstance();
   @FXML
   private ImageView GOimage;
   @FXML
   private Button Stbtn;
   @FXML
   private Button saveButton;
   @FXML
   private Button laodButton;
   @FXML
   private Label scoreLabel;
   
   @FXML
   private ImageView backImg;
	@FXML
    private GridPane grid;

    @FXML
    private ImageView boat1;

    @FXML
    private ImageView scor;
    
    
    @FXML
    private ImageView crosser1;
    @FXML
    private ImageView crosser5;

    @FXML
    private ImageView OnBoat11;

    @FXML
    private ImageView OnBoat12;

    @FXML
    private Button button1;
    
    @FXML
    private ImageView crosser3ViewRight;

    @FXML
    private ImageView crosser4ViewRight;

    @FXML
    private ImageView crosser5ViewRight;
    @FXML
    private ImageView boat2;

    @FXML
    private ImageView OnBoat21;

    @FXML
    private ImageView OnBoat22;
    
    @FXML
    private ImageView crosser2;
    
    @FXML
    private ImageView crosser3;
    
    @FXML
    private ImageView crosser4;
    
    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Button button;
    
    @FXML
    private ImageView crosser1ViewRight;

    @FXML
    private ImageView crosser2ViewRight;

    @FXML
    private ImageView rightView3;
    
    static int getCrosserNum(String weight)
    {
    	if (weight.equalsIgnoreCase(crosser1Wight))
    	{
    		return 1;
    	}
    	else if(weight.equalsIgnoreCase(crosser2Wight))
    		{
    		return 2;
    		}
    	else if (weight.equalsIgnoreCase(crosser3Wight))
    	{
    		return 3;
    	}
    	else if (weight.equalsIgnoreCase(crosser4Wight))
    	{
    		return 4;
    	}
    	else if (weight.equalsIgnoreCase(crosser5Wight))
    	{
    		return 5;
    	}
    	return -1;
    }
    	
    @FXML
    void Save(ActionEvent  event) 
    {	System.out.println("OnsaveFun");
    	saveButton.setVisible(false);
    try {
    		System.out.println("on save try");
    		controller.saveGame();
    		
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
    }
    
						/**WHEN Back button pressed**/
    @FXML
    void BackPr(MouseEvent event) 
    {

    	if (OnBoat21.getImage()==null&&OnBoat22.getImage()==null) 
    	{
    		// set alert type       
			 Alert a = new Alert(AlertType.ERROR);
			// set alert type       
           // set content text 
           a.setContentText("\n The Boat Is Empty  !!"); 
           // show the dialog 
           a.show(); 
           return;
    	}
    	
    	if (controller.canMove(boat.getCrossersList(), false))
    	{
    		
    			controller.doMove(boat.getCrossersList(), false);
    			saveButton.setVisible(true);
    			controller.setNumberOfSails(controller.getNumberOfSails()+1);
    	    	scoreLabel.setVisible(true);
    			scoreLabel.setText(String.valueOf(controller.getNumberOfSails()));
    			boat1.setImage(boat2.getImage());
		    	boat1.setVisible(true);
		    	boat2.setImage(null);
		    	if (OnBoat21.getImage()!=null) 
		    		{
		    		switch(getCrosserNum(OnBoat21.getAccessibleText())) 
		    		{
				      	case 1:
				    		crosser1.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(0).getImages()[0], null));;
				    		crosser1.setVisible(true);
				    		break;
				      	case 2:
				    		crosser2.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(1).getImages()[0], null));
				    		crosser2.setVisible(true);
				    		break;
				      	case 3:
				      	   crosser3.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(2).getImages()[0], null));
				    	   crosser3.setVisible(true);
				    	   break;
				    	case 4:
				           crosser4.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(3).getImages()[0], null));
				           crosser4.setVisible(true);
				           break;
				    	case 5:
					           crosser5.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(4).getImages()[0], null));
					           crosser5.setVisible(true);
					           break;
				    		
				      	  default:
				           return ; 
		    		}
		    		
		    	}
		    	if(OnBoat22.getImage()!=null)
				{
		    		switch(getCrosserNum(OnBoat22.getAccessibleText())) {
					  case 1:
						crosser1.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(0).getImages()[0], null));;
						crosser1.setVisible(true);
						break;
					  case 2:
						crosser2.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(1).getImages()[0], null));
						crosser2.setVisible(true);
						break;
					case 3:
						crosser3.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(2).getImages()[0], null));
					    crosser3.setVisible(true);
						break;
					   case 4:
				        crosser4.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(3).getImages()[0], null));
				    	crosser4.setVisible(true);
				        break;
					   case 5:
					        crosser5.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(4).getImages()[0], null));
					    	crosser5.setVisible(true);
					        break;
					  default:
			  }
			}
		    GOimage.setVisible(true);
		    backImg.setVisible(false);
		    OnBoat21.setImage(null);
			OnBoat22.setImage(null);
			OnBoat11.setImage(null);
			OnBoat12.setImage(null);
			OnBoat11.setAccessibleText(null);
		    OnBoat12.setAccessibleText(null);
			OnBoat21.setAccessibleText(null);
			OnBoat22.setAccessibleText(null);
			boat11fill=false;
			boat12fill=false;
			/***enf of game ****/
			System.out.println("size"+controller.getCrossersOnLeftBank().size());
			System.out.println("list"+controller.getCrossersOnLeftBank());
			
		  }
    	
    	else { // set alert type   
    		controller.canMove(boat.getCrossersList(), false);
    		//System.out.println(riverBanks.getCrossersOnLeftBank().get(0).getEatingRank());
    		//System.out.println(riverBanks.getCrossersOnLeftBank().get(1).getEatingRank());

   		 Alert a = new Alert(AlertType.ERROR);
   		// set alert type       
         // set content text 
         a.setContentText("\n Invalid Move  !!"); 
         // show the dialog 
         a.show(); 
         return;
       	}
    	
    }
   
    void  drawImageViews()
    {ICrosser crosser;
    	try {
    		crosser1.setImage(SwingFXUtils.toFXImage(controller.getiStrategy().getInitialCrossers().get(0).getImages()[0], null));
    		crosser1Wight=String.valueOf(controller.getiStrategy().getInitialCrossers().get(0).getWeight());
        	crosser1.setAccessibleText(crosser1Wight);
        	crosser1ViewRight.setAccessibleText(crosser1Wight);
    		crosser=controller.getiStrategy().getInitialCrossers().get(0);
    		controller.addCrosserToGameCrossersList(crosser);
        	
		} catch (Exception e) {
			// TODO: handle exception
		}
    	try {
		crosser2.setImage(SwingFXUtils.toFXImage(controller.getiStrategy().getInitialCrossers().get(1).getImages()[0], null));
		crosser2Wight=String.valueOf(controller.getiStrategy().getInitialCrossers().get(1).getWeight());
    	crosser2.setAccessibleText(crosser2Wight);
    	crosser2ViewRight.setAccessibleText(crosser2Wight);
    	crosser=controller.getiStrategy().getInitialCrossers().get(1);
		controller.addCrosserToGameCrossersList(crosser);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	try {
        	crosser3.setImage(SwingFXUtils.toFXImage(controller.getiStrategy().getInitialCrossers().get(2).getImages()[0], null));
        	crosser3Wight=String.valueOf(controller.getiStrategy().getInitialCrossers().get(2).getWeight());
        	crosser3.setAccessibleText(crosser3Wight);
        	crosser3ViewRight.setAccessibleText(crosser3Wight);
        	crosser=controller.getiStrategy().getInitialCrossers().get(2);
    		controller.addCrosserToGameCrossersList(crosser);
		} catch (Exception e2) {
			// TODO: handle exception
		}
    	
    	try {
        	crosser4.setImage(SwingFXUtils.toFXImage(controller.getiStrategy().getInitialCrossers().get(3).getImages()[0], null));
        	crosser4Wight=String.valueOf(controller.getiStrategy().getInitialCrossers().get(3).getWeight());
        	crosser4.setAccessibleText(crosser4Wight);
        	crosser4ViewRight.setAccessibleText(crosser4Wight);
        	crosser=controller.getiStrategy().getInitialCrossers().get(3);
    		controller.addCrosserToGameCrossersList(crosser);
		} catch (Exception e2) {
			// TODO: handle exception
		}
    	try {
        	crosser5.setImage(SwingFXUtils.toFXImage(controller.getiStrategy().getInitialCrossers().get(4).getImages()[0], null));
        	crosser5Wight=String.valueOf(controller.getiStrategy().getInitialCrossers().get(4).getWeight());
        	crosser5.setAccessibleText(crosser5Wight);
        	crosser5ViewRight.setAccessibleText(crosser5Wight);
        	crosser=controller.getiStrategy().getInitialCrossers().get(4);
    		controller.addCrosserToGameCrossersList(crosser);
		} catch (Exception e2) {
			// TODO: handle exception
		}
    }
    
    void  loadImageViews()
    {ICrosser crosser = null;
    
    	try {
    		crosser1.setImage(SwingFXUtils.toFXImage(controller.getCrossersOnLeftBank().get(loadLeftCounter).getImages()[0], null));
    		crosser1Wight=String.valueOf(controller.getCrossersOnLeftBank().get(loadLeftCounter).getWeight());
        	crosser1.setAccessibleText(crosser1Wight);
        	crosser1ViewRight.setAccessibleText(crosser1Wight);
        	
        	crosser=controller.getCrossersOnLeftBank().get(loadLeftCounter);
    		controller.addCrosserToGameCrossersList(crosser);
    		
    		
    		loadLeftCounter++;

		}
    	catch (Exception e) 
    	{
			try {
				crosser1ViewRight.setImage(SwingFXUtils.toFXImage(controller.getCrossersOnRightBank().get(loadRightCounter).getImages()[1], null));
	    		crosser1Wight=String.valueOf(controller.getCrossersOnRightBank().get(loadRightCounter).getWeight());
	        	crosser1ViewRight.setAccessibleText(crosser1Wight);
	        	crosser1.setAccessibleText(crosser1Wight);
	        	crosser=controller.getCrossersOnRightBank().get(loadRightCounter);
	    		controller.addCrosserToGameCrossersList(crosser);
	        	loadRightCounter++;	        	
			}
				
			 catch (Exception e2) {
				// TODO: handle exception
			}
		}
    	
    	try 
    	{
    		crosser2.setImage(SwingFXUtils.toFXImage(controller.getCrossersOnLeftBank().get(loadLeftCounter).getImages()[0], null));
    		crosser2Wight=String.valueOf(controller.getCrossersOnLeftBank().get(loadLeftCounter).getWeight());
        	crosser2.setAccessibleText(crosser2Wight);
        	crosser2ViewRight.setAccessibleText(crosser2Wight);
        	crosser=controller.getCrossersOnLeftBank().get(loadLeftCounter);
    		controller.addCrosserToGameCrossersList(crosser);
        	loadLeftCounter++;
		}
    	catch (Exception e) 
    	{
			try {
				crosser2ViewRight.setImage(SwingFXUtils.toFXImage(controller.getCrossersOnRightBank().get(loadRightCounter).getImages()[1], null));
	    		crosser2Wight=String.valueOf(controller.getCrossersOnRightBank().get(loadRightCounter).getWeight());
	        	crosser2ViewRight.setAccessibleText(crosser2Wight);
	        	crosser2.setAccessibleText(crosser2Wight);
	        	crosser=controller.getCrossersOnRightBank().get(loadRightCounter);
	    		controller.addCrosserToGameCrossersList(crosser);
	        	loadRightCounter++;
			}
				
			 catch (Exception e2) {
				// TODO: handle exception
			}
		}
    	
    	try 
    	{
    		crosser3.setImage(SwingFXUtils.toFXImage(controller.getCrossersOnLeftBank().get(loadLeftCounter).getImages()[0], null));
    		crosser3Wight=String.valueOf(controller.getCrossersOnLeftBank().get(loadLeftCounter).getWeight());
        	crosser3.setAccessibleText(crosser3Wight);
        	crosser3ViewRight.setAccessibleText(crosser3Wight);
        	crosser=controller.getCrossersOnLeftBank().get(loadLeftCounter);
    		controller.addCrosserToGameCrossersList(crosser);
        	loadLeftCounter++;
		}
    	catch (Exception e) 
    	{
			try {
				crosser3ViewRight.setImage(SwingFXUtils.toFXImage(controller.getCrossersOnRightBank().get(loadRightCounter).getImages()[1], null));
	    		crosser3Wight=String.valueOf(controller.getCrossersOnRightBank().get(loadRightCounter).getWeight());
	        	crosser3ViewRight.setAccessibleText(crosser3Wight);
	        	crosser3.setAccessibleText(crosser3Wight);
	        	crosser=controller.getCrossersOnRightBank().get(loadRightCounter);
	    		controller.addCrosserToGameCrossersList(crosser);
	    		loadRightCounter++;
			}
				
			 catch (Exception e2) {
				// TODO: handle exception
			}
    	}
			try 
			{
	    		crosser4.setImage(SwingFXUtils.toFXImage(controller.getCrossersOnLeftBank().get(loadLeftCounter).getImages()[0], null));
	    		crosser4Wight=String.valueOf(controller.getCrossersOnLeftBank().get(loadLeftCounter).getWeight());
	        	crosser4.setAccessibleText(crosser4Wight);
	        	crosser4ViewRight.setAccessibleText(crosser4Wight);
	        	crosser=controller.getCrossersOnLeftBank().get(loadLeftCounter);
	    		controller.addCrosserToGameCrossersList(crosser);
	        	loadLeftCounter++;
			}
	    	catch (Exception e) 
	    	{
				try {
					crosser4ViewRight.setImage(SwingFXUtils.toFXImage(controller.getCrossersOnRightBank().get(loadRightCounter).getImages()[1], null));
		    		crosser4Wight=String.valueOf(controller.getCrossersOnRightBank().get(loadRightCounter).getWeight());
		        	crosser4ViewRight.setAccessibleText(crosser4Wight);
		        	crosser4.setAccessibleText(crosser4Wight);
		        	crosser=controller.getCrossersOnRightBank().get(loadRightCounter);
		    		controller.addCrosserToGameCrossersList(crosser);
		        	loadRightCounter++;
				}
					
				 catch (Exception e2) {
					// TODO: handle exception
				}
	    	}
			
				try 
				{
		    		crosser5.setImage(SwingFXUtils.toFXImage(controller.getCrossersOnLeftBank().get(loadLeftCounter).getImages()[0], null));
		    		crosser5Wight=String.valueOf(controller.getCrossersOnLeftBank().get(loadLeftCounter).getWeight());
		        	crosser5.setAccessibleText(crosser5Wight);
		        	crosser5ViewRight.setAccessibleText(crosser5Wight);
		        	crosser=controller.getCrossersOnLeftBank().get(loadLeftCounter);
		    		controller.addCrosserToGameCrossersList(crosser);
		        	loadLeftCounter++;
				}
		    	catch (Exception e) 
		    	{
					try {
						crosser5ViewRight.setImage(SwingFXUtils.toFXImage(controller.getCrossersOnRightBank().get(loadRightCounter).getImages()[1], null));
			    		crosser5Wight=String.valueOf(controller.getCrossersOnRightBank().get(loadRightCounter).getWeight());
			        	crosser5ViewRight.setAccessibleText(crosser5Wight);
			        	crosser5.setAccessibleText(crosser5Wight);
			        	crosser=controller.getCrossersOnRightBank().get(loadRightCounter);
			    		controller.addCrosserToGameCrossersList(crosser);
			    		loadRightCounter++;
					}
						
					 catch (Exception e2) {
						// TODO: handle exception
					}
		    	}
    }
    
    @FXML
    void Start(ActionEvent  event) {

    	try {
    	riverBanks.setCrossersOnLeftBank(controller.getiStrategy().getInitialCrossers());
    	crosserFun.printList(controller.getiStrategy().getInitialCrossers());
    	drawImageViews();

    	Stbtn.setVisible(false);
    	saveButton.setVisible(false);
    	laodButton.setVisible(false);
    	scoreLabel.setVisible(false);
    	GOimage.setVisible(true);
    	boat1.setVisible(true);
    	scor.setVisible(true);
    	boat22fill=false;
        OnBoat22.setAccessibleText(null);
        OnBoat21.setAccessibleText(null);
    	}
    	catch (Exception e) {
        System.out.println("OHH Error loading Images !!");		}
    }
    @FXML
    void Load(ActionEvent  event) {

    	try {
    	controller.loadGame();
    	loadImageViews();
    	System.out.println("gmaeList");
    	crosserFun.printList(controller.getGameCrossersList());
    	
    	/*System.out.println("leftload");
    	crosserFun.printList(riverBanks.getCrossersOnLeftBank());*/
    	
    	laodButton.setVisible(false);
    	scoreLabel.setVisible(true);
		scoreLabel.setText(String.valueOf(controller.getNumberOfSails()));
    	Stbtn.setVisible(false);
    	saveButton.setVisible(false);
    	scor.setVisible(true);
    	boat22fill=false;
        OnBoat22.setAccessibleText(null);
        OnBoat21.setAccessibleText(null);

    	if ( boat.getPosition().equals("left"))
    	{
    	GOimage.setVisible(true);
    	boat1.setVisible(true);
    	}
    	else 
    	{
    		backImg.setVisible(true);
    		boat2.setImage(boat1.getImage());
        	boat2.setVisible(true);	
        	}
		
    	
    	}
    	catch (Exception e) {
        System.out.println("OHH Error loading Images !!");		}
    }
   

    @FXML
    void Onboat11(MouseEvent event) {
    	if( OnBoat11.getImage()==null)
    		return;
		ICrosser crosser;

    	//System.out.println(OnBoat11.getId());
    	switch(getCrosserNum(OnBoat11.getAccessibleText())) {
    	  case 1:
    		  crosser1.setVisible(true);
    		crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat11.getAccessibleText());
    		  break;
    	  case 2:
    			crosser2.setVisible(true);
    		  	crosser=crosserFun.getCrossser(boat.getCrossersList(),OnBoat11.getAccessibleText());
    			             break;
    	  case 3:
  			crosser3.setVisible(true);
		  	crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat11.getAccessibleText());
	        break;
           case 4:
   			crosser4.setVisible(true);
   			crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat11.getAccessibleText());
			   			break;
           case 5:
      			crosser5.setVisible(true);
      			crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat11.getAccessibleText());
   			   			break;
    	  default:
    	       return ; 
    	}
	boat.removeCrosserToList(crosser);//get the crosser from left bank list and add it to boat list
   riverBanks.getCrossersOnLeftBank().add(crosser); 	
	boat11fill=false;
   	OnBoat11.setImage(null);
    	OnBoat11.setAccessibleText(null);
		saveButton.setVisible(true);
    }

    @FXML
    void Onboat12(MouseEvent event) {
    	if( OnBoat12.getImage()==null)
    		return;
    	ICrosser crosser;
    	switch(getCrosserNum(OnBoat12.getAccessibleText())) {
  	  case 1:
		crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat12.getAccessibleText());
  		  crosser1.setVisible(true);
		break;
  	  case 2:
		crosser2.setVisible(true);
	crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat12.getAccessibleText());
		break;
  	case 3:
			crosser3.setVisible(true);
	crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat12.getAccessibleText());

			break;
       case 4:
			crosser4.setVisible(true);
			crosser=crosserFun.getCrossser(boat.getCrossersList(),OnBoat12.getAccessibleText());
        break;
       case 5:
			crosser5.setVisible(true);
			crosser=crosserFun.getCrossser(boat.getCrossersList(),OnBoat12.getAccessibleText());
       break;
  	  default:
       return ; 
    }
	boat.removeCrosserToList(crosser);//get the crosser from left bank list and add it to boat list
	 riverBanks.getCrossersOnLeftBank().add(crosser); 	
	boat12fill=false;
	OnBoat12.setImage(null);
	OnBoat12.setAccessibleText(null);
	saveButton.setVisible(true);
 
    }

    @FXML
    void Onboat21(MouseEvent event) {
    	if( OnBoat21.getImage()==null)
    		return;
    	ICrosser crosser;
		//System.out.println(OnBoat11.getId());
    	switch(getCrosserNum(OnBoat21.getAccessibleText())) {
    	  case 1:
    			crosser1ViewRight.setVisible(true);
    			crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat21.getAccessibleText());
    			break;
    	  case 2:
    			crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat21.getAccessibleText());
    			crosser2ViewRight.setVisible(true);
             break;
    	  case 3:
    			crosser=crosserFun.getCrossser(boat.getCrossersList(),OnBoat21.getAccessibleText());
    			boat.removeCrosserToList(crosser);//get the crosser from left bank list and add it to boat list
  			crosser3ViewRight.setVisible(true);
           break;
           case 4:
        		crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat21.getAccessibleText());
   			crosser4ViewRight.setVisible(true);
            break;
           case 5:
       		crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat21.getAccessibleText());
  			crosser5ViewRight.setVisible(true);
           break;
    	  default:
    	       return ; 
    	}
		boat.removeCrosserToList(crosser);//get the crosser from left bank list and add it to boat list
		   riverBanks.getCrossersOnRightBank().add(crosser); 	
			saveButton.setVisible(true);

		boat21fill=false;
    	OnBoat21.setImage(null);
    	OnBoat21.setAccessibleText(null);
    }

    @FXML
    void Onboat22(MouseEvent event) {
    	if( OnBoat22.getImage()==null)
    		return;
    ICrosser crosser;
    switch(getCrosserNum(OnBoat22.getAccessibleText())) {
  	  case 1:
  		crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat22.getAccessibleText());

  		  crosser1ViewRight.setVisible(true);
		break;
  	  case 2:
  		crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat22.getAccessibleText());

  		  crosser2ViewRight.setVisible(true);
		break;
  	case 3:
  		crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat22.getAccessibleText());

		crosser3ViewRight.setVisible(true);
       break;
       case 4:
    	   crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat22.getAccessibleText());

			crosser4ViewRight.setVisible(true);
        break;
       case 5:
    	   crosser=crosserFun.getCrossser(boat.getCrossersList(), OnBoat22.getAccessibleText());

			crosser5ViewRight.setVisible(true);
        break;
        
  	  default:
       return ; 
    }
	boat.removeCrosserToList(crosser);//get the crosser from left bank list and add it to boat list
	   riverBanks.getCrossersOnRightBank().add(crosser); 	

    OnBoat22.setImage(null);
	OnBoat22.setAccessibleText(null);
    boat22fill=false;
	saveButton.setVisible(true);
 
    }
    
    static boolean crosserMoveToLeft(ImageView OnBoat21,ImageView OnBoat22,ImageView crosserView,String name)
    {
    	
    	Boat boat = Boat.getInstance();
    	if (boat.getPosition().equalsIgnoreCase("left")) return false;
    	if (crosserView.getImage()==null) return false;
 
		//System.out.println("Fox Moving Right !!! ");
		System.out.println(boat21fill);
		System.out.println(boat22fill);
		System.out.println(OnBoat22.getAccessibleText());
		
		if (boat22fill==false)  
		{
		System.out.println("In"+boat21fill);	
		// case that boat have crosser on it 
		crosserView.setVisible(false);
		OnBoat22.setImage(crosserView.getImage());
		OnBoat22.setAccessibleText(name);
		OnBoat22.setVisible(true);
		boat22fill=true;
		}
		// case that boat haven't crosser on it 
		else if (boat21fill==false)
		{
		   boat21fill=true;
		   crosserView.setVisible(false);
		OnBoat21.setImage(crosserView.getImage());
		OnBoat21.setAccessibleText(name);
		OnBoat21.setVisible(true);
		
		}
	System.out.println("After "+name+" Moving Right !!! ");
	System.out.println(boat21fill);
	System.out.println(boat22fill);
	return true;
	}
    
    static boolean crosserMoveToRight(ImageView OnBoat11,ImageView OnBoat12,ImageView crosserView,String name)
    {
    	Boat boat = Boat.getInstance();
	if (boat.getPosition().equalsIgnoreCase("right")) return false;
	    if (crosserView.getImage()==null) return false;
		// case that boat have crosser on it 
			if (boat11fill&&boat12fill==false)  
			{

			
			crosserView.setVisible(false);
				OnBoat12.setImage(crosserView.getImage());
				OnBoat12.setAccessibleText(name);
				OnBoat12.setVisible(true);
				boat12fill=true;
				
			}
		// case that boat haven't crosser on it 
			else if (boat11fill==false)
			{
				boat11fill=true;
				crosserView.setVisible(false);
				OnBoat11.setImage(crosserView.getImage());
				OnBoat11.setAccessibleText(name);
				OnBoat11.setVisible(true);
			}
			return true;
    }
    @FXML
    void MovingCrosser3ToRight(MouseEvent event) {
    		try {
    			if (boat.isFull()) return;
    			if (crosserMoveToRight(OnBoat11, OnBoat12, crosser3, crosser3.getAccessibleText()))
        		{	
        			ICrosser crosser =crosserFun.getCrossser(riverBanks.getCrossersOnLeftBank(),crosser3.getAccessibleText());//get the crosser from left bank list and add it to boat list
        			boat.addCrosserToList(crosser);	
         			riverBanks.getCrossersOnLeftBank().remove(crosser);
         			saveButton.setVisible(false);

        			System.out.println("goat "+boat.getCrossersList().indexOf((crosser)));
        		}
			} catch (Exception e) {
				// TODO: handle exception
			}
    			
    }
    @FXML
    void MovingCrosser1ToRight(MouseEvent event) 
    {
    try {
		if (boat.isFull()) return;
		if (crosserMoveToRight(OnBoat11, OnBoat12, crosser1, crosser1.getAccessibleText())==true)
     	{	
			ICrosser crosser =crosserFun.getCrossser(riverBanks.getCrossersOnLeftBank(),crosser1.getAccessibleText());//get the crosser from left bank list and add it to boat list
			boat.addCrosserToList(crosser);	
 			riverBanks.getCrossersOnLeftBank().remove(crosser);
 			saveButton.setVisible(false);

			System.out.println("farmer"+boat.getCrossersList().indexOf((crosser)));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}	
    	
    }
        @FXML
    void MovingCrosser2ToRight(MouseEvent event) 
    {try {
		if (boat.isFull()) return;
		if (crosserMoveToRight(OnBoat11, OnBoat12, crosser2, crosser2.getAccessibleText()))
    	{	
			ICrosser crosser =crosserFun.getCrossser(riverBanks.getCrossersOnLeftBank(),crosser2.getAccessibleText());//get the crosser from left bank list and add it to boat list
			boat.addCrosserToList(crosser);		
 			riverBanks.getCrossersOnLeftBank().remove(crosser);
 			saveButton.setVisible(false);

			System.out.println("fox"+boat.getCrossersList().indexOf((crosser)));  	
        }
	} catch (Exception e) {
		// TODO: handle exception
	}
    	
    }
    @FXML
    void MovingCrosser4ToRight(MouseEvent event) 
    {
    	try {
			if ( boat.isFull()) return ; 
			if(crosserMoveToRight(OnBoat11, OnBoat12, crosser4, crosser4.getAccessibleText()))
	    	{	
				ICrosser crosser =crosserFun.getCrossser(riverBanks.getCrossersOnLeftBank(),crosser4.getAccessibleText());//get the crosser from left bank list and add it to boat list
				boat.addCrosserToList(crosser);		
	 			riverBanks.getCrossersOnLeftBank().remove(crosser);
	 			saveButton.setVisible(false);

				System.out.println("tomato"+boat.getCrossersList().indexOf((crosser)));
			}
		} catch (Exception e) {
			System.out.println("nooo ");
			crosserFun.printList(boat.getCrossersList());
		}
    	
    }
    @FXML
    void MovingCrosser5ToRight(MouseEvent event) 
    {
    	try {
			if ( boat.isFull()) return ; 
			if(crosserMoveToRight(OnBoat11, OnBoat12, crosser5, crosser5.getAccessibleText()))
	    	{	
				ICrosser crosser =crosserFun.getCrossser(riverBanks.getCrossersOnLeftBank(),crosser5.getAccessibleText());//get the crosser from left bank list and add it to boat list
				boat.addCrosserToList(crosser);		
	 			riverBanks.getCrossersOnLeftBank().remove(crosser);
	 			saveButton.setVisible(false);

				System.out.println("tomato"+boat.getCrossersList().indexOf((crosser)));
			}
		} catch (Exception e) {
		}
    	
    }
              /** When press Go Button 
             * @throws IOException **/
    
    @FXML
    void GoPress(MouseEvent event) {
       

    	if (OnBoat11.getImage()==null&&OnBoat12.getImage()==null) 
    	{
    		// set alert type       
			 Alert a = new Alert(AlertType.ERROR);
			// set alert type       
           // set content text 
           a.setContentText("\n The Boat Is Empty  !!"); 
           // show the dialog 
           a.show(); 
           return;
    	}
    if (controller.canMove(boat.getCrossersList(), true))
    { 
    	controller.doMove(boat.getCrossersList(), true);
    	saveButton.setVisible(true);
		controller.setNumberOfSails(controller.getNumberOfSails()+1);
    	scoreLabel.setVisible(true);
		scoreLabel.setText(String.valueOf(controller.getNumberOfSails()));
		boat2.setImage(boat1.getImage());
    	boat2.setVisible(true);
    	boat1.setImage(null);
    	System.out.println(OnBoat11.getAccessibleText());
    	System.out.println(OnBoat12.getAccessibleText());

    	if (OnBoat11.getAccessibleText()!=null)
    	{
    switch(getCrosserNum(OnBoat11.getAccessibleText())) {
      	  case 1:
    		crosser1ViewRight.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(0).getImages()[1], null));;
    		crosser1ViewRight.setVisible(true);
    		break;
      	  case 2:
    		crosser2ViewRight.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(1).getImages()[1], null));
    		crosser2ViewRight.setVisible(true);
    		break;
      	case 3:
      		crosser3ViewRight.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(2).getImages()[1], null));
    	    crosser3ViewRight.setVisible(true);
      		break;
    	case 4:
           crosser4ViewRight.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(3).getImages()[1], null));
        	crosser4ViewRight.setVisible(true);
           break;
    	case 5:
            crosser5ViewRight.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(4).getImages()[1], null));
         	crosser5ViewRight.setVisible(true);
            break;
      	  default:
           return ; 
        }
    	}
    	if (OnBoat12.getAccessibleText()!=null)
    	{
    switch(getCrosserNum(OnBoat12.getAccessibleText())){
	  case 1:
		crosser1ViewRight.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(0).getImages()[1], null));;
		crosser1ViewRight.setVisible(true);
		break;
	  case 2:
		crosser2ViewRight.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(1).getImages()[1], null));
		crosser2ViewRight.setVisible(true);

		break;
	case 3:
		crosser3ViewRight.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(2).getImages()[1], null));
	    crosser3ViewRight.setVisible(true);

		break;
	case 4:
     crosser4ViewRight.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(3).getImages()[1], null));
 	crosser4ViewRight.setVisible(true);

     break;
	case 5:
	     crosser5ViewRight.setImage(SwingFXUtils.toFXImage(controller.getGameCrossersList().get(4).getImages()[1], null));
	 	crosser5ViewRight.setVisible(true);

	     break;
			
	  default:
     return ; 
  }
    	}
    	
    backImg.setVisible(true);
    GOimage.setVisible(false);
        OnBoat11.setImage(null);
	    OnBoat12.setImage(null);
    	OnBoat21.setImage(null);
    	OnBoat22.setImage(null);
    	OnBoat11.setAccessibleText(null);
	    OnBoat12.setAccessibleText(null);
    	OnBoat21.setAccessibleText(null);
    	OnBoat22.setAccessibleText(null);
    	boat21fill=false;
    	boat22fill=false;
    	System.out.println(boat21fill);
    	System.out.println(boat22fill);
    	if (controller.getCrossersOnLeftBank().size()==0)
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		// set alert type       
          // set content text 
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(" Congratulation !!");
    		alert.setContentText("End Of Story \n Your score is : "+controller.getNumberOfSails());
    		alert.show();
    		
    		

          // show the dialog 
          crosser1.setVisible(false);
          crosser1ViewRight.setVisible(false);
          crosser2.setVisible(false);
          crosser2ViewRight.setVisible(false);
          crosser3.setVisible(false);
          crosser3ViewRight.setVisible(false);
          crosser4.setVisible(false);
          crosser4ViewRight.setVisible(false);
          crosser5.setVisible(false);
          crosser5ViewRight.setVisible(false);
          boat2.setVisible(false);
          backImg.setVisible(false);
          saveButton.setVisible(false);
          
				

  	        //This line gets the Stage information
  	        
  		
    	
    }}else { // set alert type       
		 Alert a = new Alert(AlertType.ERROR);
		// set alert type       
      // set content text 
      a.setContentText("\n Invalid Move  !!"); 
      // show the dialog 
      a.show(); 
    	}
    	}

     
     @FXML
     void MovingCrosser2ToLeft(MouseEvent event)
     {
    	 try {
			if(boat.isFull()) return ;
			if(crosserMoveToLeft(OnBoat21, OnBoat22, crosser2ViewRight, crosser2ViewRight.getAccessibleText()))
	    	 {	
	 			ICrosser crosser =crosserFun.getCrossser(riverBanks.getCrossersOnRightBank(),crosser2ViewRight.getAccessibleText());//get the crosser from left bank list and add it to boat list
	 			boat.addCrosserToList(crosser);		
	 			riverBanks.getCrossersOnRightBank().remove(crosser);
	 			saveButton.setVisible(false);

	 			System.out.println("dsds"+boat.getCrossersList().indexOf((crosser)));
	 		}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	 
     }

     @FXML
     void MovingCrosser1ToLeft(MouseEvent event)
     {
    	 try {
 			if(boat.isFull()) return ;
 			if(crosserMoveToLeft(OnBoat21, OnBoat22, crosser1ViewRight, crosser1ViewRight.getAccessibleText()))
 	    	 {	
 	 			ICrosser crosser =crosserFun.getCrossser(riverBanks.getCrossersOnRightBank(),crosser1ViewRight.getAccessibleText());//get the crosser from left bank list and add it to boat list
 	 			boat.addCrosserToList(crosser);			
 	 			riverBanks.getCrossersOnRightBank().remove(crosser);
 	 			saveButton.setVisible(false);

 	 			System.out.println("dsds"+boat.getCrossersList().indexOf((crosser)));
 	 		}

		} catch (Exception e) {
			// TODO: handle exception
		}
    	 
     }
     @FXML
     void MovingCrosser4ToLeft(MouseEvent event)
     {try { 			if(boat.isFull()) return ;

     if(crosserMoveToLeft(OnBoat21, OnBoat22, crosser4ViewRight, crosser4ViewRight.getAccessibleText()))
	 {	
			ICrosser crosser =crosserFun.getCrossser(riverBanks.getCrossersOnRightBank(),crosser4ViewRight.getAccessibleText());//get the crosser from left bank list and add it to boat list
			boat.addCrosserToList(crosser);
			riverBanks.getCrossersOnRightBank().remove(crosser);
			saveButton.setVisible(false);

			System.out.println("dsds"+boat.getCrossersList().indexOf((crosser)));
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
    	 
     }
     
     @FXML
     void MovingCrosser3ToLeft(MouseEvent event)
      {
    	try {
    		if(boat.isFull()) return ;
    		if(crosserMoveToLeft(OnBoat21, OnBoat22, crosser3ViewRight, crosser3ViewRight.getAccessibleText()))
       	 {	
    			ICrosser crosser =crosserFun.getCrossser(riverBanks.getCrossersOnRightBank(),crosser3ViewRight.getAccessibleText());//get the crosser from left bank list and add it to boat list
    			boat.addCrosserToList(crosser);			
    			saveButton.setVisible(false);

    			riverBanks.getCrossersOnRightBank().remove(crosser);
    			System.out.println("dsds"+boat.getCrossersList().indexOf((crosser)));
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	 
     }
     @FXML
     void MovingCrosser5ToLeft(MouseEvent event)
      {System.out.println("inGoat");
    	try {
    		if(boat.isFull()) return ;
    		System.out.println("inGoattry");
    		if(crosserMoveToLeft(OnBoat21, OnBoat22, crosser5ViewRight, crosser5ViewRight.getAccessibleText()))
       	 {	
    			ICrosser crosser =crosserFun.getCrossser(riverBanks.getCrossersOnRightBank(),crosser5ViewRight.getAccessibleText());//get the crosser from left bank list and add it to boat list
    			boat.addCrosserToList(crosser);			
    			saveButton.setVisible(false);

    			riverBanks.getCrossersOnRightBank().remove(crosser);
    			System.out.println("dsds"+boat.getCrossersList().indexOf((crosser)));
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	 
     }

  }
