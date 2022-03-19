package Logic;
import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.tree.Tree;
public class Boat 
{
      private String position ; ///"R" for right bank and "L" for lift bank 
      private int crossersNum ; 
      private int wight ; 
      private final int capacity =2;
   //   private final int maxWight =120 ;
       List<ICrosser> boatCrossers =new ArrayList<ICrosser>();
       public Boat() {
    		super();
    		 this.position="left";
   		
   		// TODO Auto-generated constructor stub
   	}


       private static Boat instance1 = null;
  	 public synchronized static Boat getInstance() 
	 {
		 
	        if (instance1 == null) {
	            instance1 = new Boat();
	        }
	        return instance1;
	  }
  	 
 	 	public List<ICrosser> getCrossersList() {
 		return this.boatCrossers;
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
		try {
			if (this.boatCrossers.size()==2 ) return true ;
			return false;
		} catch (Exception e) {
			return true; 
		}
		
	}
	
	
	
}
