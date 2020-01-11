import java.util.*;
public class  Printing<T> {
	
	public static <T> String fancyPrinting(ArrayList<T> array) {
		//System.out.println(array.size());
		StringBuilder str = new StringBuilder();
		for(T t : array) {
			str.append(t.toString());
		}
		return str.toString();
	}
}