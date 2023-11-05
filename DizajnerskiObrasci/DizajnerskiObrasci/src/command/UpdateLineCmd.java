package command;

import mvc.Line;
import mvc.Shape;

public class UpdateLineCmd implements Command{
	private Line oldState;
	private Line newState;
	private Line original=new Line();

 public UpdateLineCmd(Line oldState,Line newState) {
	 this.oldState=oldState;
	 this.newState=newState;
 }
	@Override
	public void execute() {
		original.setStartPoint(oldState.getStartPoint());
		original.setEndPoint(oldState.getEndPoint());
		original.setColor(oldState.getColor());
		//kod ostalih oblika i za boje treba
		oldState.setStartPoint(newState.getStartPoint());
		oldState.setEndPoint(newState.getEndPoint());
		oldState.setColor(newState.getColor());		
		
	}

	@Override
	public void unexecute() {
		oldState.setStartPoint(original.getStartPoint());
		oldState.setEndPoint(original.getEndPoint());
		oldState.setColor(original.getColor());

	}

}
