package Logic;

import java.util.List;

public class Story2 implements ICrossingStrategy  {
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

	@Override
	public List<ICrosser> getInitialCrossers() 
	{
		
		return null;
	}

	@Override
	public String[] getInstructions() {
		String s[] = {"1. The boat cannot bear a load heavier than 100 kg.\n" ,"2. All farmers can raft, while the animal cannot."};
			return s;
	}


}
