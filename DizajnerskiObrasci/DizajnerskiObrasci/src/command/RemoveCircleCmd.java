package command;

import mvc.Circle;
import mvc.DrawingModel;

public class RemoveCircleCmd implements Command {
	private Circle circle;
    private DrawingModel model;
    
    public RemoveCircleCmd(Circle circle, DrawingModel model) {
    	this.circle=circle;
    	this.model=model;
    }
	@Override
	public void execute() {
		model.remove(circle);

	}

	@Override
	public void unexecute() {
		model.add(circle);
	}

}
