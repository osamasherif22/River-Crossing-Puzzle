package Logic;
import java.util.List;
public class Boat 
{
      private String position ; ///"R" for right bank and "L" for lift bank 
      private int crossersNum ; 
      final int capacity =2;
      private int wight ;
  	private List<ICrosser> boatCrossers ;

  	private static Boat instance1 = null;
 	 public synchronized static Boat getInstance() 
 	 {
		 
	        if (instance1 == null) {
	            instance1 = new Boat();
	        }
	        return instance1;
	  }

      
      private Boat() {}
 
 	 public List<ICrosser> getCrossersList() {
 		return boatCrossers;
 	}

 	public int getWight() {
		return wight;
	}
 	public void addCrosserToList(ICrosser crosser) 
 	{
 		this.boatCrossers.add(crosser);
		this.wight +=crosser.getWeight();
 	}
 	public void removeCrosserToList(ICrosser crosser) 
 	{
		this.wight-=crosser.getWeight();
 		this.boatCrossers.remove(crosser);
 	}
 	public int getCrossersNum() 
	{
		return crossersNum;
	}

	public void setCrossersNum(int crossersNum) 
	{
		this.crossersNum = crossersNum;
	}
	  
	
	public int getCapacity() 
	{
		return capacity;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;//show edit in git 
	}

	
	public boolean isFull()
	{
		if (this.crossersNum == capacity ) return true ;
		return false;
	}
	
	
	
}
