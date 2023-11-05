package command;

import mvc.Circle;
import mvc.Rectangle;

public class UpdateRectangleCmd implements Command {

	private Rectangle oldState;
	private Rectangle newState;
	private Rectangle original = new Rectangle();
	
	public UpdateRectangleCmd(Rectangle oldState, Rectangle newState) {
		this.oldState = oldState;
		this.newState = newState;
	}
	@Override
	public void execute() {
		original.getUpperLeft().setX(oldState.getUpperLeft().getX());
		original.getUpperLeft().setY(oldState.getUpperLeft().getY());
		original.setWidth(oldState.getWidth());
		original.setHeight(oldState.getHeight());
		original.setColor(oldState.getColor());
		original.setInnerColor(oldState.getInnerColor());
		
		oldState.getUpperLeft().setX(newState.getUpperLeft().getX());
		oldState.getUpperLeft().setX(newState.getUpperLeft().getY());
		oldState.setWidth(newState.getWidth());
		oldState.setHeight(newState.getHeight());
		oldState.setColor(newState.getColor());
		oldState.setInnerColor(newState.getInnerColor());
		
		}

	@Override
	public void unexecute() {
		newState.getUpperLeft().setX(original.getUpperLeft().getX());
		newState.getUpperLeft().setY(original.getUpperLeft().getY());
		newState.setWidth(original.getWidth());
		newState.setHeight(original.getHeight());
		newState.setColor(original.getColor());
		newState.setInnerColor(original.getInnerColor());
		
	}

}
