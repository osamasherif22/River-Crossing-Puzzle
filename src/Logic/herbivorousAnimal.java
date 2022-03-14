package Logic;

public class herbivorousAnimal extends Animal {
	
	public herbivorousAnimal(int weight,int eatingRank) {
		super(weight);
		this.eatingRank=1;
		// TODO Auto-generated constructor stub
	}


	private final int eatingRank ;

	
	public int getEatingRank() {
		return eatingRank;
	}

}
