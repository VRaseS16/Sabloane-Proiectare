import java.util.*;
public class Book implements Element{
	@Override
	public Element copy() {
		Book newBook = new Book(this.value);
		newBook.authors.addAll(this.authors);
		newBook.elementList.addAll(this.elementList);
		newBook.oldValue = this.oldValue;
		return newBook;
	}
	String value;
	public String oldValue;
	@Override
	public void SetNewValue(String newValue) {
		oldValue = value;
		value = newValue;
		
	}
	ArrayList<Author> authors;
	ArrayList<Element> elementList;
	
	Book(String name){
		this.value = name;
		authors = new ArrayList<>();
		elementList = new ArrayList<>();
	}

	public void addAuthor(Author author) {
		authors.add(author);
	}
	

	public void addContent(Element element) {
		elementList.add(element);
		//return chapterList.size()-1;
	}

	@Override
	public void print() {
		System.out.println("Book: " + value);
		System.out.println("Authors: ");
		System.out.println(Printing.fancyPrinting(authors));
		for(Element element: elementList)
			element.print();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	/*
	public int addChapter(String chapterName) {
		chapterList.add(new Chapter(chapterName));
		return chapterList.size()-1;
	}
	
	public Chapter getChapter(int index) {
		return chapterList.get(index);
	}
	
	@Override
	public String toString() {
		return "Book [name=" + name + ", authors=" + authors + ", chapterList=" + chapterList + "]";
	}
	*/
	
	
	
}