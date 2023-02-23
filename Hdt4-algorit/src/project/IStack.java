//Interface for the stack
/* Universidad del valle de Guatemala
 * Eunice Anah[i Mata - 21231
 *  
 * La clase funciona como mi interfaz para los stacks
 * 
 * */

package project;

public interface IStack <T>{
	public T Pop();
	public void Push(T item);
	public T Peek();
	public int Size();
	public T GetValue(int i);
}
