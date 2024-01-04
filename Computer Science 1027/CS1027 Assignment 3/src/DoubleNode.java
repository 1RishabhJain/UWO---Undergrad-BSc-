/**
 * Nodes in doubly linked list
 * 
 * @author rishabhjain
 *
 * @param <T> T
 */
public class DoubleNode<T> {
	// references to the next and previous nodes in the list along with data
	DoubleNode<T> next;
	DoubleNode<T> prev;
	private T data;

	/**
	 * Creates empty node with instance variables set to null
	 */
	public DoubleNode() {
		next = null;
		prev = null;
		data = null;
	}

	/**
	 * Creates a node storing the given data in which next and prev are null.
	 * 
	 * @param newData newData
	 */
	public DoubleNode(T newData) {
		next = null;
		prev = null;
		data = newData;
	}

	/**
	 * Returns the value of next
	 * 
	 * @return Next
	 */
	public DoubleNode<T> getNext() {
		return next;
	}

	/**
	 * Returns the value of prev
	 * 
	 * @return prev
	 */
	public DoubleNode<T> getPrev() {
		return prev;
	}

	/**
	 * Returns the value of data
	 * 
	 * @return data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Stores nextNode in next
	 * 
	 * @param nextNode nextNode
	 */
	public void setNext(DoubleNode<T> nextNode) {
		next = nextNode;
	}

	/**
	 * Stores prevNode in prev
	 * 
	 * @param prevNode prevNode
	 */
	public void setPrev(DoubleNode<T> prevNode) {
		prev = prevNode;
	}

	/**
	 * Stores newData in data
	 * 
	 * @param newData newData
	 */
	public void setData(T newData) {
		data = newData;
	}
}
