import java.util.ArrayList;

public class Table implements Element, Observable{
	
	@Override
	public Element copy() {
		Table newImage = new Table(this.value);
		newImage.oldValue = this.oldValue;
		newImage.observers.addAll(this.observers);
		return newImage;
	}

	ArrayList<Observer> observers = new ArrayList<>();
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		for(Observer ob: observers)
			ob.update(oldValue, value);
	}
	
	String value;
	public String oldValue;
	@Override
	public void SetNewValue(String newValue) {
		oldValue = value;
		value = newValue;
		notifyObservers();
	}

	public Table(String name) {
		super();
		this.value = name;
	}
	
	@Override
	public void print() {
		System.out.println("Table: "+value);
		
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}