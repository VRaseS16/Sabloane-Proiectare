package align;

public class AlignLeft implements AlignStrategy{

	@Override
	public void print(String text) {
		System.out.println("++++++"+text);
		
	}

}