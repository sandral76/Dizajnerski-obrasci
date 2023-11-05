package command;

import mvc.Donut;
import mvc.DrawingModel;

public class RemoveDonutCmd implements Command{
	  private Donut donut;
	    private DrawingModel model;
	@Override
	public void execute() {
		model.remove(donut);
		
	}

	@Override
	public void unexecute() {
		model.add(donut);
		
	}

}
