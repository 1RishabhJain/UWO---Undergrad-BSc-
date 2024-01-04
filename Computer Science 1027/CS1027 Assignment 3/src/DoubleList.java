/**
 * doubly linked list of nodes of the class DoubleNode
 * 
 * @author rishabhjain
 *
 * @param <T> T
 */
public class DoubleList<T> {
	private DoubleNode<T> head;
	private DoubleNode<T> rear;
	private int numDataItems;

	/**
	 * creates an empty list with zero nodes
	 */
	DoubleList() {
		head = null;
		rear = null;
		numDataItems = 0;
	}

	/**
	 * adds a new node to the list storing newData
	 * 
	 * @param index   index
	 * @param newData newData
	 * @throws InvalidPositionException InvalidPositionException
	 */
	public void addData(int index, T newData) throws InvalidPositionException {
		if (index < 0 || index > numDataItems)
			throw new InvalidPositionException("Invalid Position");
		DoubleNode<T> newNode = new DoubleNode<T>(newData);
		numDataItems++;
		// if there is no node initially
		if (head == null) {
			head = new DoubleNode<T>(newData);
			rear = new DoubleNode<T>(newData);
		}
		if (numDataItems == 1) {
			head.setNext(newNode);
			rear.setPrev(newNode);
			newNode.setNext(null);
			newNode.setPrev(null);
		} else if (index == 0) {
			head.getNext().setPrev(newNode);
			newNode.setNext(head.getNext());
			head.setNext(newNode);
			newNode.setPrev(null);
		} else if (index == numDataItems) {
			rear.getPrev().setNext(newNode);
			newNode.setPrev(rear.getPrev());
			rear.setPrev(newNode);
			newNode.setNext(null);
		} else {
			DoubleNode<T> temp = head.getNext();
			for (int i = 0; i < index; i++) {
				if (temp.getNext() == null) {
					temp.setNext(newNode);
					newNode.setPrev(temp);
					newNode.setNext(null);
					rear.setPrev(newNode);
					return;
				}
				temp = temp.getNext();
			}
			temp.getPrev().setNext(newNode);
			newNode.setPrev(temp.getPrev());
			newNode.setNext(temp);
			temp.setPrev(newNode);
		}
	}

	/**
	 * Returns the node that is at the index position of the list
	 * 
	 * @param index index
	 * @return temp
	 */
	public DoubleNode<T> getNode(int index) {
		if (index < 0 || index >= numDataItems) {
			throw new InvalidPositionException("Invalid position");
		} else if (index == numDataItems) {
			return rear.getPrev();
		}
		DoubleNode<T> temp = head.getNext();
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * Removes the node that is at the index position of the list
	 * 
	 * @param index index
	 * @throws InvalidPositionException InvalidPositionException
	 */
	public void removeData(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems || head == null) {
			throw new InvalidPositionException("Invalid position");
			
		}
		if (numDataItems == 1) {
			head.setNext(null);
			rear.setPrev(null);
		}
		else if (index == 0) {
			head.getNext().getNext().setPrev(null);
			head.setNext(head.getNext().getNext());
			numDataItems--;
		} else if (index == numDataItems) {
			rear.getPrev().getPrev().setPrev(null);
			rear.setPrev(rear.getPrev().getPrev());
			numDataItems--;
		} else {
			DoubleNode<T> temp = head.getNext();
			for (int i = 0; i < (index); i++) {
				temp = temp.getNext();
				if (temp.getNext() == null) {
					temp.getPrev().setNext(temp.getNext());
					rear.setPrev(temp.getPrev());
					numDataItems--;
					return;
				}
			}
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
			numDataItems--;
		}

	}

	/**
	 * Returns the data stored in the node located at the index position of the list
	 * 
	 * @param index index
	 * @return temp.getData()
	 * @throws InvalidPositionException InvalidPositionException
	 */
	public T getData(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems) {
			throw new InvalidPositionException("Invalid position");
		}
		if (index == 0) {
			return head.getNext().getData();
		} else if (index == numDataItems) {
			return rear.getPrev().getData();
		} else {
			DoubleNode<T> temp = head.getNext();
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			return temp.getData();
		}
	}

	/**
	 * Store newData at the node in position index of the list
	 * 
	 * @param index   index
	 * @param newData newData
	 * @throws InvalidPositionException InvalidPositionException
	 */
	public void setData(int index, T newData) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems) {
			throw new InvalidPositionException("Invalid position");
		}
		if (index == 0) {
			head.getNext().setData(newData);
		} else if (index == numDataItems) {
			rear.getPrev().setData(newData);
		} else {
			DoubleNode<T> temp = head.getNext();
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			temp.setData(newData);
		}
	}
}