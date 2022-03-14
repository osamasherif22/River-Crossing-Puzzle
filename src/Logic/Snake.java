package Logic;

import java.awt.image.BufferedImage;
import java.io.File;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Snake extends CarnivorousAnimal implements ICrosser {
   

	BufferedImage[] images ;
	private String name;


	public Snake(int wight ) {
		super(wight,2);
		  this.name="Snake"+String.valueOf(wight);
		this.setImage();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return this.name;
	}
	public Snake() {
		super(15,2);
		this.setImage();
		// TODO Auto-generated constructor stub
	}
	void setImage() {
    	try {
		
   	 File file1 = new File("./src/icons/snacke1.png");
     Image image1 = new Image(file1.toURI().toString());
       File file2 = new File("./src/icons/flipsnake.png");
       Image image2 = new Image(file2.toURI().toString());
   	this.images = new BufferedImage[2];
   	this.images[0]=SwingFXUtils.fromFXImage(image1,null);
   	this.images[1]=SwingFXUtils.fromFXImage(image2,null);

	
		} catch (Exception e) {
System.out.println("here");		}
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
