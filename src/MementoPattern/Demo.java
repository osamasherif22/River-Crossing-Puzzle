package MementoPattern;

import java.util.ArrayList;
import java.util.List;

import Logic.Boat;
import Logic.Farmer;
import Logic.Goat;
import Logic.ICrosser;
import Logic.RiverBanks;
import icons.*;
public class Demo {

	public Demo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<ICrosser> crossersOnLeftBank =new ArrayList<ICrosser>() ;
		List<ICrosser> crossers =new ArrayList<ICrosser>() ;
		boat.addCrosserToList(new Farmer(51));
		crossersOnLeftBank.add(new Farmer(100));
		crossers.add(new Farmer(50));
		
		RiverBanks riverBanks = RiverBanks.getInstance();
		riverBanks.setCrossersOnLeftBank(crossersOnLeftBank);
		riverBanks.setCrossersOnRightBank(crossers);
Caretaker caretaker =new Caretaker ();
Originator originator = new Originator() ;
originator.setState(riverBanks, boat, 15);
System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());
caretaker.addMemento(originator.saveMemento());

List<ICrosser> crossersOnLeftBank1 =new ArrayList<ICrosser>() ;
List<ICrosser> crossers1 =new ArrayList<ICrosser>() ;
boat1.addCrosserToList(new Farmer(20));
crossersOnLeftBank1.add(new Farmer(30));
crossers1.add(new Farmer(50));
riverBanks.setCrossersOnLeftBank(crossersOnLeftBank1);
riverBanks.setCrossersOnRightBank(crossers1);
originator.setState(riverBanks, boat1, 150);
System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());


caretaker.addCurrent(originator.saveMemento());
originator.restore(caretaker.undo());
System.out.println("after Undo1");
System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());

caretaker.addMemento(originator.saveMemento());
originator.restore(caretaker.redo());

System.out.println("after redo1");

System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());


caretaker.addCurrent(originator.saveMemento());
originator.restore(caretaker.undo());
System.out.println("after Undo1");
System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());

caretaker.addMemento(originator.saveMemento());
originator.restore(caretaker.redo());

System.out.println("after redo1");

System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());

caretaker.addCurrent(originator.saveMemento());
originator.restore(caretaker.undo());
System.out.println("after Undo1");
System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());

caretaker.addMemento(originator.saveMemento());
originator.restore(caretaker.redo());

System.out.println("after redo1");

System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());

caretaker.addCurrent(originator.saveMemento());
originator.restore(caretaker.undo());
System.out.println("after Undo1");
System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());

caretaker.addMemento(originator.saveMemento());
originator.restore(caretaker.redo());

System.out.println("after redo1");

System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());

caretaker.addCurrent(originator.saveMemento());
originator.restore(caretaker.undo());
System.out.println("after Undo1");
System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());

caretaker.addMemento(originator.saveMemento());
originator.restore(caretaker.redo());

System.out.println("after redo1");

System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());


caretaker.addMemento(originator.saveMemento());
originator.restore(caretaker.redo());

System.out.println("after redo1");

System.out.println(originator.getScore());
System.out.println(originator.getBoat().getCrossersList().get(0).getWeight());

	}

}
