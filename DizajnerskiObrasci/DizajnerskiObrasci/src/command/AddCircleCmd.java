package command;

import mvc.Circle;
import mvc.DrawingModel;

public class AddCircleCmd implements Command {
    private Circle circle;
    private DrawingModel model;
    
    public AddCircleCmd(Circle circle, DrawingModel model) {
    	this.circle=circle;
    	this.model=model;
    }
	
	@Override
	public void execute() {
		model.add(circle);
		
	}

	@Override
	public void unexecute() {
		model.remove(circle);
		
	}

}
