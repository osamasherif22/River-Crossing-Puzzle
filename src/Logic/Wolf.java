package Logic;

import java.awt.image.BufferedImage;
import java.io.File;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Wolf extends CarnivorousAnimal implements ICrosser{

	BufferedImage[] images ;
	public Wolf(int weight) {
		super(weight,2);
		  this.setImage();
	}
	

	public Wolf() {
		super(20,2);
		  this.setImage();
	}
	 void setImage() {
	    	
    	 File file1 = new File("./src/icons/wolf.png");
        Image image1 = new Image(file1.toURI().toString());
        File file2 = new File("./src/icons/wolf2.png");
        Image image2 = new Image(file2.toURI().toString());
    	this.images = new BufferedImage[2];
    	this.images[0]=SwingFXUtils.fromFXImage(image1,null);	
    	this.images[1]=SwingFXUtils.fromFXImage(image2,null);	
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
