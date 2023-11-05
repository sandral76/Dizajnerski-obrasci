package command;

import mvc.Donut;
public class UpdateDonutCmd implements Command {

	private Donut oldState;
	private Donut newState;
	
	private Donut original=new Donut();
	public UpdateDonutCmd(Donut oldState, Donut newState) {
		this.oldState = oldState;
		this.newState = newState;
	}
	
	@Override
	public void execute() {
		original.setCenter(oldState.getCenter());
		original.setRadius(oldState.getRadius());
		original.setInnerRadius(oldState.getInnerRadius());
		original.setColor(oldState.getColor());
		original.setInnerColor(oldState.getInnerColor());
		
		
		oldState.setCenter(newState.getCenter());	
		oldState.setRadius(newState.getRadius());
		oldState.setInnerRadius(newState.getInnerRadius());
		oldState.setColor(newState.getColor());
		oldState.setInnerColor(newState.getInnerColor());
		
		
		
	}

	@Override
	public void unexecute() {
		oldState.setCenter(original.getCenter());
		oldState.setRadius(original.getRadius());
		oldState.setInnerRadius(original.getInnerRadius());
		oldState.setColor(original.getColor());
		oldState.setInnerColor(original.getInnerColor());
		
	}

}
