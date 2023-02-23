/* Universidad del valle de Guatemala
 * Eunice Anah[i Mata - 21231
 *  
 * La clase funciona como mi factory
 * 
 * */
package project;

public class Factory<T> {

	public static Factory instance;
	
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}
	
	private IStack<T> myStack;
	
	public IStack<T> getStack(int option){
		switch (option) {
		case 1: // AraylistStack
			myStack = new ArrayListStack<T>();
			break;
		case 2: // vectorStack
			myStack = new VectorStack<T>();
			break;
		case 3: // LinkedListStack
			myStack = new LinkedListStack<T>();
			break;
		case 4: // DoubleLinkedListStack
			myStack = new DoubleLinkedListStack<T>();
			break;
		default:
			break;
		}
		return myStack;
	}
	
}
