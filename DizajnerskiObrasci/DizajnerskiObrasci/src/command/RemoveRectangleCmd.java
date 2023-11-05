package command;

import mvc.DrawingModel;
import mvc.Rectangle;

public class RemoveRectangleCmd implements Command {
	private Rectangle rectangle;
	private DrawingModel model;

	@Override
	public void execute() {
		model.remove(rectangle);

	}

	@Override
	public void unexecute() {
		model.add(rectangle);
	}

}
