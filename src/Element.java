  
import java.util.ArrayList;

public interface Element {
	void print();
	void accept(Visitor visitor);
	void SetNewValue(String newValue);
	Element copy();
}