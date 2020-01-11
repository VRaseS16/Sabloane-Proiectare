public class FirstObserver implements Observer{

//	private static FirstObserver instance;
//	
//	private FirstObserver() {
//		
//	}
//	
//	public static FirstObserver getInstance() {
//		if(instance == null)
//			instance = new FirstObserver();
//		return instance;
//	}

	@Override
	public void update(String oldValue, String newValue) {
		System.out.println("From FirstObserver "+ oldValue + "   "+ newValue);
		
	}
	
}