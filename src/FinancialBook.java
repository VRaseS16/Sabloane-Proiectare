public class FinancialBook extends BookStatistics {

	private int imagePrice = 2;
	private int imageProxyPrice = 3;
	private int paragraphPrice = 7;
	private int tablePrice = 5;
	private int bookPrice = 4;
	
	
	public void printPrices() {
		System.out.print("FinancialBook [images=" +(this.images * imagePrice) + 
				", proxys=" + (proxys * this.imageProxyPrice)+ 
				", paragraphs=" + (paragraphs * this.paragraphPrice)+ 
				", tables=" + (tables * this.tablePrice)+
				", books=" + (books * this.bookPrice)+ "]");
	}
	
	
}