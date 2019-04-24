package Logic;

import java.awt.image.BufferedImage;

public class Wolf extends CarnivorousAnimal implements ICrosser{


	

	public Wolf() {
		super(20,2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canSail() {
		return false;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
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
