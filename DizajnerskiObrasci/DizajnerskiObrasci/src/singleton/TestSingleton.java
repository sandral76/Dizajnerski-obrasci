package singleton;

public class TestSingleton {

	public static void main(String[] args) {
		DatabaseConnection obj1 =DatabaseConnection.getInstance();
		DatabaseConnection obj2=DatabaseConnection.getInstance();
		System.out.println(DatabaseConnection.getInstance());
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(Integer.toHexString(obj1.hashCode()));
		
		DatabaseConnectionLazy obj3=DatabaseConnectionLazy.getInstance();
		System.out.println(obj3);
		DatabaseConnectionLazy obj4=DatabaseConnectionLazy.getInstance();
		System.out.println(obj4);
		
	}
}
