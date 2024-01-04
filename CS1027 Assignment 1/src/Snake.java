/**
 * Snake.java
 * This class contains methods that are used for the creation and updates of the snake
 * @author Rishabh Jain
 *
 */
public class Snake {

	private int snakeLength;
	private Position[] snakeBody;
	/**
	 * Creates the snake using the row and column
	 * @param row Integer Row
	 * @param col Integer Column
	 */
	public Snake(int row, int col) {
		snakeLength = 1;
		snakeBody = new Position[5];
		snakeBody[0] = new Position(row, col);
	}
	/**
	 * Method to return the length of the snake
	 * @return Returns the length of the snake
	 */
	public int getLength() {
		return snakeLength;
	}
	/**
	 * getPosition method returns null or snakeBody depending on index value, specifically; returns null when the index is out of range, this would be an index less than 0 or greater than or equal to the snakeLength, If the index is valid it returns the snakeBody[index] 
	 * @param index Index Value
	 * @return Returns either null or snakeBody depending on the index value
	 */
	public Position getPosition(int index) {
		if (index < 0) {
			return null;
		}
		if (index >= snakeLength) {
			return null;
		}
		else {
			return snakeBody[index];
		}
	}
	/**
	 * Method called when snake comes in contact with scissors, reduces the length of the snake by 1
	 * 
	 */
	public void shrink() {
		snakeLength = snakeLength - 1;
	}
	/**
	 * Compares the two objects of the class position
	 * @param pos Position
	 * @return Returns true or false depending on equality
	 */
	public boolean snakePosition(Position pos) {
		// iterates through every element of the snake array
		for (int i = 0; i < snakeLength; i++) {
			if (pos.equals(snakeBody[i])) {
				return true;
			}
		}
		return false;
	}
	/**
	 * This method sets a new position for the head of the snake based on the string keyboard input.
	 * @param direction Keyboard directional string
	 * @return Returns the updated headPosition
	 */
	public Position newHeadPosition(String direction) {
		int currentRow = snakeBody[0].getRow();
		int currentCol = snakeBody[0].getCol();
		// Adjusts the row/column by +1 or -1
		if (direction.equals("up")) {
			currentRow = currentRow - 1;
		}
		else if (direction.equals("down")) {
			currentRow = currentRow + 1;
		}
		if (direction.equals("right")) {
			currentCol = currentCol + 1;
		}
		else if (direction.equals("left")) {
			currentCol = currentCol - 1;
		}
		return new Position(currentRow, currentCol);
	}
	/**
	 * Moves the entire snake and adjust each position of the array, and calls the newHeadPosition method to adjust the head as well
	 * @param direction Keyboard directional string
	 */
	public void moveSnake(String direction) {
		for (int i = snakeLength-1; i > 0; i--) {
			// new position is equal to the one previous position
			snakeBody[i] = snakeBody[i-1];
		}
		snakeBody[0] = newHeadPosition(direction);
	}
	/**
	 * Grow method used to increase the size of the array by 1, called when snake eats apple
	 * @param direction Keyboard directional string
	 */
	public void grow(String direction) {
		if (snakeLength == snakeBody.length) {
			increaseArraySize();
		}
		snakeLength += 1;
		moveSnake(direction);
	}
	/**
	 * Doubles the size of the array snakeBody, creating a largerList
	 */
	public void increaseArraySize() {
		Position[] largerList = new Position[snakeBody.length * 2];
		// iterates through the entire snakeBody
		for (int i = 0; i < snakeBody.length; i++)
			largerList[i] = snakeBody[i];
		
		snakeBody = largerList;
	}
}