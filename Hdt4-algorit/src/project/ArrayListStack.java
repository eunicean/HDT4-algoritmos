/* Universidad del valle de Guatemala
 * Eunice Anah[i Mata - 21231
 *  
 * La clase funciona como mi arraylist
 * 
 * */

package project;

import java.util.ArrayList;

public class ArrayListStack <T> implements IStack<T> {

	
	private ArrayList<T> myCurrentList = new ArrayList<T>();
	
	public static ArrayListStack instance;
	
	public static ArrayListStack getInstance() {
		if(instance == null) {
			instance = new ArrayListStack();
		}
		return instance;
	}
	
	@Override
	public T Pop() {
		return myCurrentList.remove(myCurrentList.size()-1);
	}

	@Override
	public void Push(T item) {
		myCurrentList.add(item);
	}

	@Override
	public T Peek() {
		return myCurrentList.get(myCurrentList.size()-1);
	}

	@Override
	public int Size() {
		return myCurrentList.size();
	}
	
	public T GetValue(int pos) {
		return myCurrentList.get(pos);
	}

}
