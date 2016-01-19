package othelloWithGUI;

public class Player {
	
	private final String name;
	private boolean noMove=true;
	public String getName() {
		return name;
	}
	public Player(String name) {
		this.name = name;
	}
	
	public boolean getNoMove() {
		return noMove;
	}
	
	public void setNoMove(boolean input) {
		noMove=input;
	}

}
