package geometry;

import java.util.Arrays;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		Point p1 = new Point();
		Point p = new Point();
		p.setX(15);
		p.setY(27);
		p.setSelected(true);
		p1.setX(10);
		p1.setY(20);
		p1.setSelected(true);

		System.out.println("X koordinata tacke p1 je" + p1.getX() + '\n' + "Y koordinata tacke p1 je " + p1.getY()
				+ '\n' + "Tacka selektovana:" + p1.isSelected());
		double result = p1.distance(50, 60);
		System.out.println("Distance beetwen two point is " + result);

		// 1. Inicijalizovati x koordinatu tacke p
		// na vrednost y koordinate tacke p1
		p.setX(p1.getY());
		System.out.println(p.getX());

		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a
		// za krajnju tacku linije l1 tacku p1
		Line l1 = new Line();
		l1.setStartPoint(p);
		l1.setEndPoint(p1);
		System.out.println(l1.getStartPoint().getY());

		// 3. Postaviti y koordinatu krajnje tacke l1 na 23
		l1.getEndPoint().setY(23);

		System.out.println(l1.getEndPoint().getY());

		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		System.out.println(l1.getStartPoint().getX());

		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y
		// koordinate pocetne tacke linije l1
		l1.getEndPoint().setX((int) (l1.length() - l1.getStartPoint().getX() - l1.getStartPoint().getY()));
		System.out.println(l1.getEndPoint().getX());

		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15
		Rectangle r1 = new Rectangle();
		r1.setUpperLeft(p);// ne postoji kreiramo bilo sta
		r1.getUpperLeft().setX(10); // getUpper-tako dolazimo do tacke
		r1.getUpperLeft().setY(15);
		System.out.println(r1.getUpperLeft().getX());
		System.out.println(r1.getUpperLeft().getY());

		// 7. Postaviti centar kruga c1 na koordinate tacke
		// gore levo od r1
		Circle c1 = new Circle();
		c1.setCenter(r1.getUpperLeft());
		System.out.println(c1.getCenter().getX());

		// 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
		// povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		System.out.println(c1.getCenter().getX());

		// testiranje konstruktora
		Point p2 = new Point(20, 20);
		Point p3 = new Point(15, 18, true);
		Point p4 = new Point(20, 30);
		System.out.println(p2.toString());
		System.out.println(p4.toString());

		Rectangle r2 = new Rectangle(p3, 20, 40);
		System.out.println(r2);
		System.out.println(p2);// moze i bez poziva metode

		// == i equals()
		String s1 = new String("Hello world!");
		System.out.println(s1);
		String s2 = new String("Hello world!");

		s1 = s2; // sada pokazuju na isti objekat u memoriji
		System.out.println();
		System.out.println(s1 == s2);// proveravamo da li i jedna i druga ref gadjaju isiti obj u mem
		System.out.println(s1.equals(s2));// oba objekta imaju istu vrednost

		Rectangle r3 = new Rectangle(p3, 20, 40);
		System.out.println(r3.equals(r2));

		Circle c2 = new Circle(p2, 20);
		Circle c3 = new Circle(p2, 20);
		System.out.println(c2.toString());
		System.out.println(c3);
		System.out.println(c2.equals(c3));

		Donut d = new Donut();
		d.setCenter(p2);
		//d.setRadius(50);
		d.setInnerRadius(10);
		d.moveBy(40, 120);
		System.out.println(d);
		
		
		Point p5= new Point(5,5);
		Point p6= new Point(10,10);
		Point p7= new Point(2,2);
		Point p8= new Point(20,20);
		
		Point[] points= {p5,p6,p7,p8};
		System.out.println("Nesortirani niz tacaka:");
		for(int i=0; i<points.length;i++) {
			System.out.println(points[i]);
		}
		
		//sortiranje niza-moramo imati comapreTo metodu- iz util paketa 
		Arrays.sort(points);
		System.out.println("Sortiran niz:");
		for(int i=0; i<points.length;i++) {
			System.out.println(points[i]);
		}
		
		//kolekcija gde odjeredjene obj vezujemo sa kljuc
		HashMap<String, Shape> map = new HashMap<String, Shape>();
		map.put("point", p1);
		map.put("rectangle", r1);
		map.put("Point", p3);
		
		System.out.println("point from map is:" + map.get("point"));
		System.out.println("Point from map is:" + map.get("Point"));

		
		Point p9= new Point(100,100);
		map.put("point", p9);//pregazice vrednost na p8-nije vise p1
		System.out.println("point from map is:" + map.get("point"));


		// dinamicko povezivanje-u run time se odredjuje tip objekta, c2 nece biti
		// circle vec donut
		Circle c4 = new Donut(new Point(100, 200), 100, 50);
		System.out.println(d.area());
		System.out.println(c2.equals(c3));
		System.out.println(c4.contains(p3));

		// polimorfizam ispit
		System.out.println(c4 instanceof Circle);
		
		Circle c6= new Circle(p9, 40);
		//zbog toga sto se moze javiti greska moramo postaviti try catch blok
		//try-udji u ovaj blok i probaj da ga izvrsis
		try {
			c6.setRadius(-50);
		}
		//ako naidjes na gresku u try uhvati je 
		catch(Exception e) {
			e.printStackTrace();
		}
		//finally ce se uvek izvrsiti
		finally {
			System.out.println("Uvek se izvrsava!");
		}
	}

}
