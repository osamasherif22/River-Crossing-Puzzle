package MementoPattern;

import java.util.ArrayList;
import java.util.List;

import Logic.Boat;
import Logic.ICrosser;
import Logic.RiverBanks;
import Logic.crosserFun;

public class Originator {
	
	 List<ICrosser> CrossersOnLeftBank =new ArrayList<ICrosser>();
	  List<ICrosser> CrossersOnRightBank =new ArrayList<ICrosser>();
    private String boatPosition ; ///"R" for right bank and "L" for lift bank 

	private int score ;
	
public void setState(List<ICrosser> CrossersOnLeftBank ,List<ICrosser> CrossersOnRightBank, String boatPosition, int score)
{
this.boatPosition=boatPosition; this.CrossersOnLeftBank=CrossersOnLeftBank; this.CrossersOnRightBank=CrossersOnRightBank; 
this.score =score ;
}
public Memento saveMemento () 
{
	System.out.println("Size rught in memento " +CrossersOnRightBank.size());
	return new Memento(CrossersOnLeftBank,CrossersOnRightBank, boatPosition,score);
}
public void restore(Memento memento)
{
	System.out.println("SIze restore"+memento.CrossersOnLeftBank.size());
	System.out.println("SIze restore right "+memento.CrossersOnRightBank.size());

	this.boatPosition=memento.boatPosition; this.CrossersOnLeftBank=memento.CrossersOnLeftBank; this.CrossersOnRightBank=memento.CrossersOnRightBank; 
	this.score =memento.score ;
}
public int getScore() {
	return score;
}

public Originator() {
	
	super();
}
public List<ICrosser> getCrossersOnLeftBank() {
	return CrossersOnLeftBank;
}
public void setCrossersOnLeftBank(List<ICrosser> crossersOnLeftBank) {
	CrossersOnLeftBank = crossersOnLeftBank;
}
public List<ICrosser> getCrossersOnRightBank() {
	return CrossersOnRightBank;
}
public void setCrossersOnRightBank(List<ICrosser> crossersOnRightBank) {
	CrossersOnRightBank = crossersOnRightBank;
}
public String getBoatPosition() {
	return boatPosition;
}
public void setBoatPosition(String boatPosition) {
	this.boatPosition = boatPosition;
}
public void setScore(int score) {
	this.score = score;
}

}

