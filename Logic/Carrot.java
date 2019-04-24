package Logic;

import java.awt.image.BufferedImage;

public class Carrot extends Planet implements ICrosser {

	public Carrot(int wight ) {
		super(wight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canSail() {
		// TODO Auto-generated method stub
		return false;
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
		return null;}
}
