package Logic;

import java.awt.image.BufferedImage;

public class Farmer  extends Person implements ICrosser {


	
	public Farmer() {
		super(90);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canSail() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return super.getWight();
	}
	@Override
	public int getEatingRank() {
		// TODO Auto-generated method stub
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