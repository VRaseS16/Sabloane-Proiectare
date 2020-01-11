public class DeleteCommand implements Command{

	private Memento state = new Memento();
	@Override
	public void execute() {
		state.setState(DocumentManager.getInstance().getBook());
		((Section)DocumentManager.getInstance().getBook()).removeLast();
		DocumentManager.getInstance().addCommand(this);
	}

	@Override
	public void unexecute() {
		DocumentManager.getInstance().setBook(state.getState());
		
	}

	public Memento getMemento() {
		return state;
	}

}