public class BookStatistics implements Visitor{

	protected int images;
	protected int proxys;
	protected int paragraphs;
	protected int tables;
	protected int books;
	
	@Override
	public void visit(Image image) {
		images++;
		
	}

	@Override
	public void visit(ImageProxy imageProxy) {
		// TODO Auto-generated method stub
		proxys++;
	}

	@Override
	public void visit(Paragraph paragraph) {
		// TODO Auto-generated method stub
		paragraphs++;
	}

	@Override
	public void visit(Table table) {
		// TODO Auto-generated method stub
		tables++;
	}

	@Override
	public void visit(Book book) {
		// TODO Auto-generated method stub
		books++;
	}
	
	public void printStatistics() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "BookStatistics [images=" + images + ", proxys=" + proxys + ", paragraphs=" + paragraphs + ", tables="
				+ tables + ", books=" + books + "]";
	}
	

}