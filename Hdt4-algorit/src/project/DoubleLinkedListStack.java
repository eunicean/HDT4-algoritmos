/* Universidad del valle de Guatemala
 * Eunice Anah[i Mata - 21231
 *  
 * La clase funciona como mi double linked list
 * 
 * */

package project;

public class DoubleLinkedListStack <T> implements IStack<T> {
	
	private int count = 0;
    private DoubleLinkedNode<T> first = null;
    private DoubleLinkedNode<T> last = null;

	@Override
	public T Pop() {
		DoubleLinkedNode<T> answer = last;
		last = last.getPrevious();
		last.setNext(null);
		return answer.getValue();
	}

	@Override
	public void Push(T item) {
		DoubleLinkedNode<T> newNode = new DoubleLinkedNode<T>(item);
		if(first == null) {
			first = newNode;
			last = newNode;
			first.setNext(first);
			first.setPrevious(first);
		}
		else {
			newNode.setPrevious(last);
			last = newNode;
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
				DoubleLinkedNode<T> temporal = first;
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
