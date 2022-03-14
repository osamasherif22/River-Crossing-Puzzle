package MementoPattern;
import java.util.ArrayList;
import java.util.List;

import Logic.*;
public class Memento {

	 List<ICrosser> CrossersOnLeftBank =new ArrayList<ICrosser>();
	 List<ICrosser> CrossersOnRightBank =new ArrayList<ICrosser>();
     String boatPosition ;
	 int score ;
	
	
	
	public Memento(List<ICrosser> crossersOnLeftBank, List<ICrosser> crossersOnRightBank, String boatPosition,
			int score) {
		super();
		this.CrossersOnLeftBank = crossersOnLeftBank;
		this.CrossersOnRightBank = crossersOnRightBank;
		this.boatPosition = boatPosition;
		this.score = score;
	}
	
	public Memento getState ()
	{
		Memento memento = new Memento(this.CrossersOnLeftBank,this.CrossersOnRightBank, this.boatPosition, this.score);
	return 	memento;
	}

	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	

}
