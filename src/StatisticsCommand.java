public class StatisticsCommand implements Command{

	@Override
	public void execute() {
		BookStatistics stats = new BookStatistics();
		DocumentManager.getInstance().getBook().accept(stats);
		stats.printStatistics();
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}