package command;

import mvc.Circle;
import mvc.Donut;
import mvc.DrawingModel;
import mvc.Line;
import mvc.Point;

import java.awt.Color;

public class TestCommand {

	public static void main(String[] args) {
		
		Point p1 = new Point(10, 10,false, Color.RED);
		Point p2 = new Point(20, 20,false, Color.BLUE);
		DrawingModel model = new DrawingModel();
		AddPointCmd addPointCmd = new AddPointCmd(p1, model);
		addPointCmd.execute();
		System.out.println(model.getShapes().size());  //1
		
		UpdatePointCmd updatePointCmd = new UpdatePointCmd(p1, p2);
		updatePointCmd.execute();
		System.out.println(p1);  //20.20
		updatePointCmd.unexecute();
		System.out.println(p1);//10.10
		
		
		
		Point p3 = new Point(30, 30 ,false, Color.YELLOW);
		Point p4 = new Point(20, 20,false, Color.GREEN);
		
		Line line1=new Line(p1,p2,false,Color.RED);
		Line line2=new Line(p3,p4,false,Color.BLACK);
		System.out.println("Line");
		System.out.println(line1);
		System.out.println(line2);
	    UpdateLineCmd addlinecmd=new UpdateLineCmd(line1,line2);
	    addlinecmd.execute();
	    System.out.println(line1);
	    addlinecmd.unexecute();
	    System.out.println(line1);
	    System.out.println("Circle");
	    Circle circle1=new Circle(p1,80,false,Color.YELLOW);
	    Circle circle2=new Circle(p1,150,false,Color.YELLOW);
	    System.out.println(circle1);
	    UpdateCircleCmd addcirclecmd=new UpdateCircleCmd(circle1,circle2);
	    addcirclecmd.execute();
	    System.out.println(circle1);
		Donut d11=new Donut(p1,50,30,false, Color.RED,Color.BLUE);
		Donut d12=new Donut(p2,60,40,false, Color.RED,Color.BLUE);
		AddDonutCmd addDonutCmd = new AddDonutCmd(d11, model);
		addDonutCmd.execute();
		System.out.println(d11);
		
		UpdateDonutCmd updateDonutCmd=new UpdateDonutCmd(d11,d12);
		updateDonutCmd.execute();
		System.out.println(d11);
		updateDonutCmd.unexecute();
		System.out.println(d11);
		
		
		
	}
}
		




