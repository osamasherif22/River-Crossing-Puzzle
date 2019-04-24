package Logic;

import java.util.List;

public class GmeController implements IRiverCrossingController {
	public ICrossingStrategy iStrategy ;
	RiverBanks riverBanks= RiverBanks.getInstance();
	Boat boat = Boat.getInstance();
	Context context;
	
	public ICrossingStrategy getiStrategy() {
	 return iStrategy;
	}

	public void setiStrategy(ICrossingStrategy iStrategy) {
		this.iStrategy = iStrategy;
	}

	public GmeController(ICrossingStrategy iStrategy) {
		super();
		this.iStrategy = iStrategy;
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		this.iStrategy=gameStrategy;
	}

	@Override
	public void resetGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getInstructions() {
		return this.iStrategy.getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return riverBanks.CrossersOnRightBank;	
	}
	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return riverBanks.CrossersOnLeftBank;	

	}

	@Override
	public int getNumberOfSails() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
return this.iStrategy.isValid(riverBanks.CrossersOnRightBank, riverBanks.CrossersOnLeftBank,boat.getCrossersList());
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
				if (fromLeftToRightBank)
				{
				boat.setPosition("Right");	
				for (int i=0;i<2;i++)
				riverBanks.getCrossersOnRightBank().add(crossers.get(i));
				}
			  else {
					boat.setPosition("Left");	
					for (int i=0;i<2;i++)
					riverBanks.getCrossersOnLeftBank().add(crossers.get(i));
					}
				}


	@Override
	public boolean canUndo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canRedo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void undo() {
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		// TODO Auto-generated method stub
		return false;
	}

}
