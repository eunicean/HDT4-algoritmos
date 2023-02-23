package project;

public class LinkedListStack <T> implements IStack<T> {

	public static LinkedListStack instance;
	
	public static LinkedListStack getInstance() {
		if(instance == null) {
			instance = new LinkedListStack();
		}
		return instance;
	}
	
	@Override
	public T Pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Push(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T Peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
