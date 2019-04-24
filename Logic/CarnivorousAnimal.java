package Logic;

public class CarnivorousAnimal extends Animal {
	
	public CarnivorousAnimal(int weight,int eatingRank) {
		super(weight);
		this.eatingRank=eatingRank;
		// TODO Auto-generated constructor stub
	}


	private final int eatingRank ;

	
	public int getEatingRank() {
		return eatingRank;
	}

}
