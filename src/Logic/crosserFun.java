package Logic;

import java.util.ArrayList;
import java.util.List;

public abstract class crosserFun {
	
	public static void printList(List<ICrosser>list)
	{
		for(int i=0 ; i<list.size();i++)
		{
			System.out.print(list.get(i).getEatingRank()+"  ");
		}
		System.out.println("\n");
	}
	public static ICrosser getCrossser(List<ICrosser> sourceList ,String weight)
	{
		for ( int i=0;i<sourceList.size();i++)
		{

			if(String.valueOf(sourceList.get(i).getWeight()).equals(weight))
			{
				return sourceList.get(i);
			}
			
		}
		return null;
	}
}
		/*switch (weight) {
		/*case 1:
			for(int i =0;i<sourceList.size();i++)
			{
				if(sourceList.get(i).getWeight()==)
					return sourceList.get(i);
			}
			break;

		case "Fox":
			for(int i =0;i<sourceList.size();i++)
			{
				if(sourceList.get(i) instanceof Snake)
					return sourceList.get(i);
			}
			break;
		case "Goat":
			for(int i =0;i<sourceList.size();i++)
			{
				if(sourceList.get(i) instanceof Goat)
					return sourceList.get(i);
			}
		case "Tomato":
			for(int i =0;i<sourceList.size();i++)
			{
				if(sourceList.get(i) instanceof Tomato)
					return sourceList.get(i);
			}
			
			break;
		default:
			break;
		}
		return null;
	}
}*/