package Logic;

public class Context {
	
	private State currentState ;
	
	 public State getCurrentState() {
		return currentState;
	}
	 
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public void doMove()  
	    { 
	        currentState.doMove(this); 
	    }

	public Context() {
		this.currentState=new FromLeftToRightState();
	}

}
  