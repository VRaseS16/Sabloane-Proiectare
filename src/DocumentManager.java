import java.util.*;
public class DocumentManager {
	private static DocumentManager instance;
	private Element book;
	private FirstObserver observer1;
	private SecondObserver observer2;
	private Stack<Command> undoCommands;
	private Stack<Command> redoCommands;
	
	private DocumentManager() {
		observer1 = new FirstObserver();
		observer2 = new SecondObserver();
		undoCommands = new Stack<>();
		redoCommands = new Stack<>();
	};
	
	public static DocumentManager getInstance() {
		if(instance == null) {
			instance = new DocumentManager();
		}
		return instance;
	}

	public Element getBook() {
		return this.book;
	}

	public void setBook(Element book) {
		this.book = book;
	}

	public FirstObserver getObserver1() {
		return observer1;
	}

	public void setObserver1(FirstObserver observer1) {
		this.observer1 = observer1;
	}

	public SecondObserver getObserver2() {
		return observer2;
	}

	public void setObserver2(SecondObserver observer2) {
		this.observer2 = observer2;
	}

	public void addCommand(Command newCommand) {
		undoCommands.push(newCommand);
	}
	
	public Command getLastCommand() {
		return undoCommands.pop();
	}

	public void addRCommand(Command newCommand) {
		redoCommands.push(newCommand);
	}
	
	public Command getLastRCommand() {
		return redoCommands.pop();
	}
	
}