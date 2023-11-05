package command;

import mvc.Rectangle;
import mvc.DrawingModel;

public class AddRectangleCmd implements Command{
	    private Rectangle rectangle;
	    private DrawingModel model;
	    
	    
	    
	@Override
	public void execute() {
		model.add(rectangle);
		
	}

	@Override
	public void unexecute() {
		model.remove(rectangle);
		
	}

}
