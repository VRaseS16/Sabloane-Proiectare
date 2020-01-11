import java.util.*;

public class OpenCommand implements Command{
	
	private String title;
	
	public OpenCommand(String title) {
		this.title = title;
	}
	
	

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void execute() {
		Builder jsonBuilder = new JSONBuilder("C:\\Users\\Adrian\\git\\repository\\SP\\lib\\"+title);
		jsonBuilder.build();
		Element myBook = jsonBuilder.getResult();
		//myBook.print();
		DocumentManager.getInstance().setBook(myBook);
	}

}