package Logic;

import java.util.List;

public class RiverBanks {
	
  List<ICrosser> CrossersOnLeftBank ;
  List<ICrosser> CrossersOnRightBank ;
  
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
	public List<ICrosser> getCrossersOnLeftBank() {
		return CrossersOnLeftBank;
	}
	public void setCrossersOnLeftBank(List<ICrosser> crossersOnLeftBank) {
		CrossersOnLeftBank = crossersOnLeftBank;
	}
	public List<ICrosser> getCrossersOnRightBank() {
		return CrossersOnRightBank;
	}
	public void setCrossersOnRightBank(List<ICrosser> crossersOnRightBank) {
		CrossersOnRightBank = crossersOnRightBank;
	}

	

}
