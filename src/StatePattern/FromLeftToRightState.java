package StatePattern;

import Logic.State;

public class FromLeftToRightState extends State {

	@Override
	public void doMove(Context ctx) {
System.out.println("from left to right !!");		
	}

}
