package Logic;

import java.awt.image.BufferedImage;
import java.io.File;

import com.sun.xml.internal.bind.v2.runtime.Name;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Farmer  extends Person implements ICrosser {

	BufferedImage[] images ;
	private String name; 
	public Farmer(int wight) {
		super(wight);
	  this.setImage();
	  this.name="Farmer"+String.valueOf(wight);
	}

	public String getName() 
	{
		return this.name;
	}

	public Farmer() {
		super(90);
		  this.name="Farmer"+String.valueOf(90);

	  this.setImage();
	}
    void setImage() {
    	Image image1;
    	Image image2;
    	if ( getWight()==90)
    	{
       	 File file1 = new File("./src/icons/90kgfarmer.png");
          image1 = new Image(file1.toURI().toString());
         File file2 = new File("./src/icons/90flip.png");
          image2 = new Image(file2.toURI().toString());
    	}
    	else if (getWight()==80)
    	{
    		 File file1 = new File("./src/icons/80kgfarmer.png");
             image1 = new Image(file1.toURI().toString());
            File file2 = new File("./src/icons/80flip.png");
             image2 = new Image(file2.toURI().toString());
    	}
    	else if (getWight()==60)
    	{
    		 File file1 = new File("./src/icons/60kgfarmer.png");
             image1 = new Image(file1.toURI().toString());
            File file2 = new File("./src/icons/60flip.png");
             image2 = new Image(file2.toURI().toString());
    	}
    	else if (getWight()==40)
    	{
    		 File file1 = new File("./src/icons/40kgfarmer.png");
             image1 = new Image(file1.toURI().toString());
            File file2 = new File("./src/icons/40flip.png");
             image2 = new Image(file2.toURI().toString());
    	}
    	else {
    	 File file1 = new File("./src/icons/man.png");
         image1 = new Image(file1.toURI().toString());
        File file2 = new File("./src/icons/man2.png");
         image2 = new Image(file2.toURI().toString());}
    	this.images = new BufferedImage[2];
    	this.images[0]=SwingFXUtils.fromFXImage(image1,null);	
    	this.images[1]=SwingFXUtils.fromFXImage(image2,null);	
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
