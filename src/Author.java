public class Author{
	
	@Override
	public String toString() {
		return "Author : " + name + "\n";
	}

	String name;

	public Author(String name) {
		this.name = name;
	}
}