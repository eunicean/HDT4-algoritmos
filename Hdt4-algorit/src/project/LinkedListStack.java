/* Universidad del valle de Guatemala
 * Eunice Anah[i Mata - 21231
 *  
 * La clase funciona como mi LinkedList
 * 
 * */
package project;

public class LinkedListStack <T> implements IStack<T> {

	private int count;
    private SingleLinkedNode<T> first;
    private SingleLinkedNode<T> last;
	
    public LinkedListStack() {
    	this.first = null;
    	this.last = null;
    }
	
	@Override
	public T Pop() {
		SingleLinkedNode<T> temporal = null;
		if(first != null) {
			if(count == 1) {
				temporal = first;
				this.first = null;
				this.last = null;
				count--;
				
			}
			else {
				SingleLinkedNode<T> temporalForFirst = first;
				temporal = first.getNext();
				
				while(temporal != null) {
					temporalForFirst = temporal;
					temporal = temporal.getNext();
				}
				
				last = temporalForFirst;
				last.setNext(null);
				count--;
			}
		}
		return temporal.getValue();
	}

	@Override
	public void Push(T item) { //add Node i suppose
		SingleLinkedNode<T> newNode = new SingleLinkedNode<T>(item);
		if(first == null) {
			this.first = newNode;
			this.last = newNode;
		}
		else {
			this.last.setNext(newNode);
			this.last = newNode;
		}
		count++;
	}

	@Override
	public T Peek() {
		return last.getValue();
	}

	@Override
	public int Size() {   
        return count;
	}

	@Override
	public T GetValue(int i) {
		T answer = null;
		if(first != null) {
			if(i == 0) {
				answer = first.getValue();
			}
			else if(i == (count - 1)) {
				answer = last.getValue();
			}
			else if((i > 0) && (i<(count - 1))) {
				SingleLinkedNode<T> temporal = first;
				int j = 0;
				
				while((temporal != null) && (j != i)) {
					temporal = temporal.getNext();
					j++;
				}
				if (temporal != null)
                {
                    answer = temporal.getValue();
                }
                else
                {
                	answer = null;
                }
			}
			else {
				answer = null;
			}
		}
		return answer;
	}
}
