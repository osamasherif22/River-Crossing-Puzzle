package Logic;

import java.awt.image.BufferedImage;
import java.io.File;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Tomato extends Planet implements ICrosser {

	BufferedImage[] images ;
	private String name;
	public Tomato() {
		super(5);
		this.name = "Tomato"+String.valueOf(5);
		  this.setImage();

		// TODO Auto-generated constructor stub
	}
	public Tomato(int weight) {
		super(weight);
		this.name = "Tomato"+String.valueOf(weight);
		  this.setImage();

		// TODO Auto-generated constructor stub
	}
	
	 public String getName() {
		return this.name;
	}
	void setImage() {
	    	
    	 File file1 = new File("./src/icons/tomato.png");
        Image image1 = new Image(file1.toURI().toString());
        File file2 = new File("./src/icons/tomato.png");
        Image image2 = new Image(file2.toURI().toString());
    	this.images = new BufferedImage[2];
    	this.images[0]=SwingFXUtils.fromFXImage(image1,null);	
    	this.images[1]=SwingFXUtils.fromFXImage(image2,null);	
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
		return null;}
}
