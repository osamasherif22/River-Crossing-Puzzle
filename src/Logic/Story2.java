package Logic;

import java.util.ArrayList;
import java.util.List;

public class Story2 implements ICrossingStrategy  {
	Farmer farmer1 ;
	Farmer farmer2;
	Farmer farmer3;
	Farmer farmer4;
	Goat    goat;
	
	public boolean hasFarmer(List<ICrosser>list)
	{
		for (int i =0 ; i<list.size();i++)
		{
			if (list.get(i) instanceof Farmer ) 
				return true;
		}
			return false;
			
	}
	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) 
	{
		if(hasFarmer(boatRiders))
		{
		if (Boat.getInstance().getWight()<=100)
			{
				return true ; 
			}
		}
		return false;
	}

	public Story2() {
		super();
		this.farmer1 = new Farmer(90);
		this.farmer2= new Farmer(80);
		this.farmer3 = new Farmer(60);
		this.farmer4 = new Farmer(40);
		this.goat = new Goat(15);

	}

	@Override
	public List<ICrosser> getInitialCrossers() {
		List<ICrosser> list = new ArrayList<ICrosser>();
		list.add(this.farmer1);
		list.add(this.farmer2);
		list.add(this.farmer3);
		list.add(this.farmer4);
		list.add(this.goat);
		return list;
	}

	@Override
	public String[] getInstructions() {
		String s[] = {"1. The boat cannot bear a load heavier than 100 kg.\n" ,"2. All farmers can raft, while the animal cannot."};
			return s;
	}


}
