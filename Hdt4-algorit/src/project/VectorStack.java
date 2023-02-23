package project;

import java.util.Vector;

public class VectorStack <T> implements IStack<T>{

	private Vector<T> myCurrentList = new Vector<T>();
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
