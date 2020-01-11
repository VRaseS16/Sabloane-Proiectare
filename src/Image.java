import java.util.ArrayList;
import java.util.concurrent.*;
public class Image implements Element, Observable{
	@Override
	public Element copy() {
		Image newImage = new Image(this.value);
		newImage.oldValue = this.oldValue;
		newImage.observers.addAll(this.observers);
		return newImage;
	}

	@Override
	public void SetNewValue(String newValue) {
		oldValue = value;
		value = newValue;
		notifyObservers();
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

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	String value;
	String oldValue = "";

	@Override
	public String toString() {
		return "Image with name: " + value + "\n";
	}

	
	public Image(String name) {
		super();
		this.value = name;
		addObserver(DocumentManager.getInstance().getObserver1());
		addObserver(DocumentManager.getInstance().getObserver2());
	}

	@Override
	public void print() {
		System.out.println("Image with title: "+value);
		
	}
	
	
}