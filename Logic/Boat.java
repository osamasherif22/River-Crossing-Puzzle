package Logic;

import java.util.List;
public class Boat 
{
      private String position ; ///"R" for right bank and "L" for lift bank 
      private int crossersNum ; 
      final int capacity =2;
   	private List<ICrosser> crossersList ;

 


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
 		return crossersList;
 	}


 	public void addCrosserToList(ICrosser crossers) {
 		this.crossersList.add(crossers);
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
		this.position = position;
	}

	
	public boolean isFull()
	{
		if (this.crossersNum == capacity ) return true ;
		return false;
	}
	
	
	
}
