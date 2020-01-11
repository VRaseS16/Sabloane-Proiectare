public class UndoCommand implements Command{

	@Override
	public void execute() {
		DocumentManager.getInstance
		().setBook(((DeleteCommand)DocumentManager.getInstance().getLastCommand()).getMemento().getState());
		
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}