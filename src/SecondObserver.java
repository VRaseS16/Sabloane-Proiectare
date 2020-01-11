public class SecondObserver implements Observer{

	@Override
	public void update(String oldValue, String newValue) {
		System.out.println("From SecondObserver "+ oldValue + "   "+ newValue);
		
	}
	
}