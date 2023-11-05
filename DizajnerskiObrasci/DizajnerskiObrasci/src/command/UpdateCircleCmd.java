package command;

import mvc.Circle;

public class UpdateCircleCmd implements Command {
	private Circle oldState;
	private Circle newState;
	private Circle original = new Circle();

	public UpdateCircleCmd(Circle oldState, Circle newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
     original.setCenter(oldState.getCenter());
     original.setRadius(oldState.getRadius());
     original.setColor(oldState.getColor());
     
     oldState.setCenter(newState.getCenter());
     oldState.setRadius(newState.getRadius());
     oldState.setColor(newState.getColor());
		  
	}

	@Override
	public void unexecute() {
		oldState.setCenter(original.getCenter());
		oldState.setRadius(original.getRadius());
		oldState.setColor(original.getColor());

	}

}
