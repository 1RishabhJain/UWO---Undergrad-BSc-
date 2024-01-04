/**
 * stores the information about the snake as it moves around the board
 * 
 * @author rishabhjain
 *
 */
public class SnakeLinked {

	private int snakeLength;
	private DoubleList<Position> snakeBody;

	/**
	 * SnakeLinked
	 * 
	 * @param row row
	 * @param col col
	 */
	public SnakeLinked(int row, int col) {
		snakeBody = new DoubleList<Position>();
		snakeLength = 1;
		Position obj = new Position(row, col);
		snakeBody.addData(0, obj);
	}

	/**
	 * Returns the length of the snake
	 * 
	 * @return snakeLength
	 */
	public int getLength() {
		return snakeLength;
	}

	/**
	 * Returns the position of the snake
	 * 
	 * @param index index
	 * @return snakePos
	 */
	public Position getPosition(int index) {
		Position snakePos = new Position(0, 0);

		if (index < 0 || index >= snakeLength) {
			snakePos = null;
		} else {
			snakePos = snakeBody.getData(index);
		}
		return snakePos;
	}

	/**
	 * returns true if pos is in the doubly linked list of snakeBody
	 * 
	 * @param pos pos
	 * @return boolean true or false
	 */
	public boolean snakePosition(Position pos) {
		for (int i = 0; i < snakeLength; i++) {
			if (snakeBody.getData(i).getRow() == pos.getRow() && snakeBody.getData(i).getCol() == pos.getCol()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * returns the new position that the head of the snake
	 * 
	 * @param direction direction
	 * @return the new Position
	 */
	public Position newHeadPosition(String direction) {
		Position snakePos = snakeBody.getData(0);
		int row = snakePos.getRow();
		int col = snakePos.getCol();
		if (direction.equals("right"))
			++col;
		else if (direction.equals("left"))
			--col;
		else if (direction.equals("up"))
			--row;
		else if (direction.equals("down"))
			++row;
		return new Position(row, col);
	}

	/**
	 * moves the snake in the specified direction
	 * 
	 * @param direction direction
	 */
	public void moveSnakeLinked(String direction) {
		Position pos = newHeadPosition(direction);
		snakeBody.addData(0, pos);
		snakeBody.removeData(snakeLength);
	}

	/**
	 * decreases the value of snakeLength
	 */
	public void shrink() {
		snakeLength = snakeLength - 1;
		snakeBody.removeData(snakeLength);
	}

	/**
	 * increases the length of the snake by 1
	 * 
	 * @param direction direction
	 */
	void grow(String direction) {
		Position pos = newHeadPosition(direction);
		snakeBody.addData(0, pos);
		snakeLength++;
	}
}
