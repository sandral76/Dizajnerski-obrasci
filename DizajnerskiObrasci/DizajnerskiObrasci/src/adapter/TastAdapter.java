package adapter;

public class TastAdapter {

	public static void main(String[] args) {
		Car car=new Car();
		Plane plane=new Plane();
		Train train=new Train();
		Boat boat=new Boat();
		Vehicle boatAdapter=new BoatAdapter(boat);
		
		car.goFaster();
		plane.goFaster();
		train.goFaster();
		boat.rowFaster();
		boatAdapter.goFaster();
		
		

	}

}
