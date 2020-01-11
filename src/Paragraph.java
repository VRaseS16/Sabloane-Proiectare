import java.util.ArrayList;

import align.AlignStrategy;

public class Paragraph implements Element, Observable{
	
	@Override
	public Element copy() {
		Paragraph newImage = new Paragraph(this.value);
		newImage.oldValue = this.oldValue;
		newImage.observers.addAll(this.observers);
		return newImage;
	}
	
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
	

	
	
	public Paragraph(String name) {
		super();
		this.value = name;
		addObserver(DocumentManager.getInstance().getObserver1());
		addObserver(DocumentManager.getInstance().getObserver2());
	}
	
	private AlignStrategy align;


	@Override
	public String toString() {
		return "Paragraph : " + value + "\n";
	}

	@Override
	public void print() {
		if(value != null && align != null)
			align.print(value);
		else
			System.out.println("Paragraph: "+ value);
		
	}
	
	public void setAlignStrategy( AlignStrategy alignStrategy) {
		this.align = alignStrategy;
	}
	

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}