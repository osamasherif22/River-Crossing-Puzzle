package Logic;

import java.awt.image.BufferedImage;

public class Goat extends herbivorousAnimal implements ICrosser {


	

	public Goat(int wight) {
		super(wight,1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canSail() {
		return false;
	}

	@Override
	public int getWeight() {
		return super.getWeight();
	}

	@Override
	public int getEatingRank() {
		return super.getEatingRank();

	}

	@Override
	public BufferedImage[] getImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICrosser makeCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLabelToBeShown(String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLabelToBeShown() {
		// TODO Auto-generated method stub
		return null;
	}

}
