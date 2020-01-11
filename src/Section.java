import java.util.*;

public class Section implements Element, Observable{
	String value;
	public String oldValue;
	
	
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
	
	 ArrayList<Element> content;
	
	Section(String sectionTitle){
		this.value = sectionTitle;
		content = new ArrayList<>();
		addObserver(DocumentManager.getInstance().getObserver1());
		addObserver(DocumentManager.getInstance().getObserver2());
	}
	
	void add(Element element) {
		content.add(element);
	}
	
	void remove(Element element) {
		content.remove(element);
	}
	
	Element getElement(int index) {
		return content.get(index%content.size());
	}
	
	
	@Override
	public void accept(Visitor visitor) {
		for(Element visited: content) {
			visited.accept(visitor);
		}
	}
	
	public void removeLast() {
		content.remove(content.size()-1);
	}
	
	public void deleteLastElement() {
		content.remove(content.size()-1);
	}
	
	@Override
	public void print() {
		System.out.println(value);
		for(Element element: content)
			element.print();
	}

	@Override
	public Element copy() {
		Section newObject = new Section(this.value);
		newObject.oldValue = this.oldValue;
		newObject.observers.addAll(this.observers);
		for(Element element : this.content) {
			newObject.content.add(element.copy());
		}
		return newObject;
	}
	
	

}