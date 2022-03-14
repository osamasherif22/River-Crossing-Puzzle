package Logic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sound.midi.Soundbank;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import filesXML.MyDomLoader;
import filesXML.MyDomSaver;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class GmeController implements IRiverCrossingController {
	private int  numberOfSails;
	
	private int  storyNum;
	private  List<ICrosser> gameCrossersList = new ArrayList<ICrosser>();
	
	public  List<ICrosser> getGameCrossersList() {
		return gameCrossersList;
	}
	public int getStoryNum() {
		return this.storyNum;
	}
	public void setStoryNum(int storyNum) {
		this.storyNum = storyNum;
	}
	public void addCrosserToGameCrossersList(ICrosser crosser) 
 	{
 		this.gameCrossersList.add(crosser);
 	}
	
	
	public void setGameCrossersList(List<ICrosser> gameCrossersList) {
		this.gameCrossersList = gameCrossersList;
	}
	public void setNumberOfSails(int numberOfSails) {
		this.numberOfSails = numberOfSails;
	}


	public ICrossingStrategy iStrategy ;
	RiverBanks riverBanks= RiverBanks.getInstance();
	Boat boat = Boat.getInstance();
	Context context;
	
	/** Singletone !! **/
	private static GmeController instance1 = null;
	 public synchronized static GmeController getInstance(ICrossingStrategy iStrategy) 
	 {
		 
	        if (instance1 == null) {
	            instance1 = new GmeController(iStrategy);
	        }
	        return instance1;
	  }
	 public synchronized static GmeController getInstance() 
	 {
		 
	        if (instance1 == null) {
                     return null;	        }
	        return instance1;
	  }
	public ICrossingStrategy getiStrategy() {
	 return iStrategy;
	}

	public void setiStrategy(ICrossingStrategy iStrategy) {
		this.iStrategy = iStrategy;
	}

	public GmeController(ICrossingStrategy iStrategy) {
		super();
		this.iStrategy = iStrategy;
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		this.iStrategy=gameStrategy;
	}

	@Override
	public void resetGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getInstructions() {
		return this.iStrategy.getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return riverBanks.CrossersOnRightBank;	
	}
	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return riverBanks.CrossersOnLeftBank;	

	}

	@Override
	public int getNumberOfSails() {
		// TODO Auto-generated method stub
		return this.numberOfSails;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
return this.iStrategy.isValid(riverBanks.CrossersOnRightBank, riverBanks.CrossersOnLeftBank,boat.getCrossersList());
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank)
	{	List<ICrosser> bankCrossers=new ArrayList<ICrosser>();
			System.out.println("******boatWeight:"+boat.getWight());
				if (fromLeftToRightBank)
				{
					boat.setPosition("right");	
					for ( int i=0 ;i<crossers.size();i++)
					{
					riverBanks.getCrossersOnRightBank().add(crossers.get(i));
					}
					for ( int i=0 ;i<2;i++)
					try{
						boat.removeCrosserToList(crossers.get(0));	
						}catch (Exception e) {
							// TODO: handle exception
						}
				
					System.out.println("boat on "+boat.getPosition());
					System.out.println("right");
					crosserFun.printList(riverBanks.getCrossersOnRightBank());
					System.out.println("left");
					crosserFun.printList(riverBanks.getCrossersOnLeftBank());
					System.out.println("boat");
					crosserFun.printList(boat.getCrossersList());
				}
			  else 
			  {
					boat.setPosition("left");	
					for (int i=0;i<crossers.size();i++) 
					{
						riverBanks.getCrossersOnLeftBank().add(crossers.get(i));
					}
					for ( int i=0 ;i<2;i++)
					{
						try{
							boat.removeCrosserToList(crossers.get(0));	
						}catch (Exception e) {
							// TODO: handle exception
						}
					}
					System.out.println("left boat on "+boat.getPosition());
					System.out.println("right");
					crosserFun.printList(riverBanks.getCrossersOnRightBank());
					System.out.println("left");
					crosserFun.printList(riverBanks.getCrossersOnLeftBank());
					System.out.println("boat");
					crosserFun.printList(boat.getCrossersList());

			  }
				
	}


	@Override
	public boolean canUndo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canRedo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void undo() {
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGame() {
		try {
			if ( iStrategy instanceof Story1)
			{
				MyDomSaver.Save(numberOfSails,1);
			}
			else {
				MyDomSaver.Save(numberOfSails,2);
				
			}
			
			System.out.println("saved");
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadGame() {
		try {
        
        GmeController controller= GmeController.getInstance();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =factory.newDocumentBuilder();
		Document doc =builder.parse("inputFile1.xml");
      ///working in Stroy
		Element stroyElement = (Element) doc.getElementsByTagName("story").item(0);		
		int storyNum = Integer.valueOf(stroyElement.getAttribute("Number"));
		controller.setStoryNum(storyNum);
			try{
				if ( iStrategy instanceof Story1 &&storyNum==1)
			{
				MyDomLoader.Load();
				System.out.println("loaded");


			}
			else if  ( iStrategy instanceof Story2 &&storyNum==2){
				
				MyDomLoader.Load();
				System.out.println("loaded");

			}
				}catch (Exception e) {
				// TODO: handle exception
			}
		
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;}

	@Override
	public boolean isBoatOnTheLeftBank() {
if (this.boat.getPosition().equalsIgnoreCase("left"))
     return true;
return false;
	}

}
