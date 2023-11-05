package singleton;

public class DatabaseConnectionLazy {
	
	private static DatabaseConnectionLazy instance;

	private DatabaseConnectionLazy() {
		
	}
	public static DatabaseConnectionLazy getInstance() {
		if(instance==null)
			synchronized(DatabaseConnectionLazy.class) {
				//objekti oba pozivaju metodu
				if(instance==null)
		instance=new DatabaseConnectionLazy();
			}
		return instance;
	}
}
