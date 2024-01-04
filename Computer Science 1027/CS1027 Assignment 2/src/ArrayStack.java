/**
 * ArrayStock class implements a stack using an array
 * @author rishabhjain
 *
 * @param <T> generic type
 */
public class ArrayStack<T> implements ArrayStackADT<T> {

	// Array for storing stack data items
	private T[] stack;
	private int top;
	private int initialCapacity;
	private int sizeIncrease;
	private int sizeDecrease;

	
	/**
	 * Empty stack created using array let to initialCapacity
	 * @param initialCap Integer initialCapacity
	 * @param sizeInc Integer sizeIncrease
	 * @param sizeDec Integer sizeDecrease
	 */
	public ArrayStack(int initialCap, int sizeInc, int sizeDec) {
		top = -1;
		stack = (T[]) (new Object[initialCap]);
		initialCapacity = initialCap;
		sizeIncrease = sizeInc;
		sizeDecrease = sizeDec;
	}
	/**
	 * dataItem added to the top of the stack and updates top value
	 */
	public void push(T dataItem) {
		top++;
		if (size() == stack.length)
			expandCapacity();

		stack[top] = dataItem;
		
	}
	/**
	 * Also updates the value of top while removing and returning stack top data item
	 */
	public T pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("The stack is empty.");
		T result = stack[top];
		if ((top < (stack.length*0.25)) && (stack.length > initialCapacity)) {
			T[] newArray = (T[]) (new Object[stack.length - sizeDecrease]);
			for (int i = 0; i < top; ++i)
				newArray[i] = stack[i];
			stack = newArray;
		}
		top--;
		return result;
	}
	/**
	 * Returns the data item at the top of the stack without removing it
	 * EmptyStackException is thrown if the stack is empty
	 */
	public T peek() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("The stack is empty.");

		return stack[top];
	}
	
	/**
	 * Returns true if the stack is empty and it returns false otherwise
	 */
	public boolean isEmpty() {
		return (top == -1);
	}
	/**
	 * Returns the number of data items in the stack
	 */
	public int size() {
		return (top + 1);
	}

	/**
	 * Returns the length of the array stack
	 * @return stack.length
	 */
	public int length() {
		return stack.length;
	}

	/**
	 * Returns a String representation of the stack
	 */
	public String toString() {
		String result = "Stack: ";
		for (int i = 0; i < top; i++)
			result = result + stack[i].toString() + ", ";
		return result + stack[top];
	}
	/**
	 * Method used in push, expandCapacity increases stack's size by sizeIncrease
	 */
	private void expandCapacity() {
		T[] larger = (T[]) (new Object[stack.length + sizeIncrease]);
		for (int index = 0; index < stack.length; index++)
			larger[index] = stack[index];
		stack = larger;
	}
}