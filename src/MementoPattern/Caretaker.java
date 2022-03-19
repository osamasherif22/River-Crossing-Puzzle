package MementoPattern;

import java.util.ArrayList;
import java.util.Stack;

import sun.launcher.resources.launcher;
import sun.print.PSPrinterJob.PluginPrinter;

public class Caretaker {

	private Stack<Memento> mementosundo = new Stack<Memento>();
	private Stack<Memento> mementosredo = new Stack<Memento>();
    private ArrayList<Memento> mementos = new ArrayList<Memento>();
	
	public void addMemento (Memento memento)
	{
		System.out.println("ADDDING   >>>> ");
		

		//System.out.println(memento.getRiverBanks().getCrossersOnLeftBank().size());
		mementosundo.push(memento);
		System.out.println("Addded score "+mementosundo.peek().score);
		System.out.println("right size "+mementosundo.peek().CrossersOnRightBank.size());
		System.out.println("left size "+ mementosundo.peek().CrossersOnLeftBank.size());
		System.out.println(mementosundo.size());		
		mementos.add(memento);
	}
	
	public void addCurrent (Memento memento)
	{
		mementosredo.push(memento);
	}

	public Memento undo ()
	{    System.out.println("Inside CAREtAKER"+mementosundo.peek().CrossersOnRightBank.size());
    	 System.out.println(mementosundo.peek().CrossersOnRightBank.size());
    	System.out.println( mementosundo.size());
       return mementosundo.pop();
	}
	public Memento redo ()
	{
		return mementosredo.pop();

	}
	public boolean canUndo()
	{
	   if (mementosundo.isEmpty()==true)  return false;
	   return true;
	}
	
	public boolean canRedo()
	{
	   if (mementosredo.isEmpty()==true)  return false;
	   return true;
	}
	public void Print()
	{			
		System.out.println("*****************************");

   	 System.out.println(mementosundo.peek().CrossersOnRightBank.size());

		System.out.println("*****************************");

		for (int i = 0; i < mementos.size(); i++) {
			System.out.println("left size " +mementos.get(i).CrossersOnLeftBank.size());
			System.out.println("right size " +mementos.get(i).CrossersOnRightBank.size());
			System.out.println("Score "+i+"Is " +mementos.get(i).score);
		}
		System.out.println("*****************************");

	}

	public Caretaker() {
		super();
	}
	
	

}
