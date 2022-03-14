package Logic;

import java.util.ArrayList;
import java.util.List;

public class RiverBanks {
	
  List<ICrosser> CrossersOnLeftBank =new ArrayList<ICrosser>();
  List<ICrosser> CrossersOnRightBank =new ArrayList<ICrosser>();
  
  private RiverBanks() {
	super();
}

private static RiverBanks instance1 = null;
	 public synchronized static RiverBanks getInstance() 
	 {
		 
	        if (instance1 == null) {
	            instance1 = new RiverBanks();
	        }
	        return instance1;
	  }
	 public void addCrosserToRightList(ICrosser crosser) 
	 	{
	 		this.CrossersOnRightBank.add(crosser);
	 	}
	 public void addCrosserToLeftList(ICrosser crosser) 
	 	{
	 		this.CrossersOnLeftBank.add(crosser);
	 	}
	public List<ICrosser> getCrossersOnLeftBank() {
		return this.CrossersOnLeftBank;
	}
	public void setCrossersOnLeftBank(List<ICrosser> crossersOnLeftBank) {
		this.CrossersOnLeftBank = crossersOnLeftBank;
	}
	public List<ICrosser> getCrossersOnRightBank() {
		return this.CrossersOnRightBank;
	}
	public void setCrossersOnRightBank(List<ICrosser> crossersOnRightBank) {
		this.CrossersOnRightBank = crossersOnRightBank;
	}

	

}
