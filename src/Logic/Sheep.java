package Logic;

import java.awt.image.BufferedImage;
import java.io.File;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Sheep extends herbivorousAnimal implements ICrosser {

	BufferedImage[] images ;

	

	public Sheep(int weight) {
		super(weight,1);
		  this.setImage();
	
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canSail() {
		return false;
	}
	
	void setImage() {
    	
   	 File file1 = new File("./src/icons/sheep1png.png");
       Image image1 = new Image(file1.toURI().toString());
       File file2 = new File("./src/icons/sheep2.png");
       Image image2 = new Image(file2.toURI().toString());
   	this.images = new BufferedImage[2];
   	this.images[0]=SwingFXUtils.fromFXImage(image1,null);	
   	this.images[1]=SwingFXUtils.fromFXImage(image2,null);	

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
		return images;
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
