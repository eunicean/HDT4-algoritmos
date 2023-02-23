
package project;

public class DoubleLinkedListStack <T> implements IStack<T> {
	
	
	public static DoubleLinkedListStack instance;
	
	public static DoubleLinkedListStack getInstance() {
		if(instance == null) {
			instance = new DoubleLinkedListStack();
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
