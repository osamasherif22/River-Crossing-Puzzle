package Logic;

import java.util.ArrayList;
import java.util.List;

public class Story1 implements ICrossingStrategy {
	 Farmer farmer ;
     Snake snake;
     Goat goat ;
     Tomato tomato ;
     
	public Story1() {
		super();
		this.farmer = new Farmer(100);
		this.snake = new Snake(50);
		this.goat = new Goat(30);
	    this.tomato=new Tomato(10);
	}

	@Override
	public List<ICrosser> getInitialCrossers() {
		List<ICrosser> list = new ArrayList<ICrosser>();
		list.add(this.farmer);
		list.add(this.snake);
		list.add(this.goat);
		list.add(this.tomato);
		return list;
	}

	@Override
	public String[] getInstructions() {
String s[] = {"1. The farmer is the only one who can sail the boat. He can only take one passenger in addition to himself.\n" , 
	"2. You can not leave any two crossers on the same bank if they can harm each other"};
		return s;
	}
	public boolean hasFarmer(List<ICrosser>list)
	{
		for (int i =0 ; i<list.size();i++)
		{
			if (list.get(i) instanceof Farmer ) 
				return true;
		}
			return false;
			
	}
	public boolean bankIsSafe(List<ICrosser> bankList)
	{
		if (bankList==null||bankList.isEmpty()) return true;
		if (bankList.size()==1) return true;
		if (hasFarmer(bankList)) return true ; //Farmer prevent any fight
		for (int i =0 ; i<bankList.size();i++)
		{
			for (int j =0 ; j<bankList.size();j++)
			{
				if (Math.abs(bankList.get(i).getEatingRank()-bankList.get(j).getEatingRank())==1 ) 
				return false;
			}
		}
			return true;
	}
	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,List<ICrosser> boatRiders) 
	{
	if (hasFarmer(boatRiders))
		{
			if (bankIsSafe(rightBankCrossers))
			{
				if (bankIsSafe(leftBankCrossers))
				{
					return true ;
				}
			}
		}
		return false;

		}
}
