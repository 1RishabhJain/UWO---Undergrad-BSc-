/**
 * Position.java
 * This class contains methods that return the position for the value required
 * @author Rishabh Jain
 *
 */
public class Position {

	private int positionRow;
	private int positionColumn;
	
	/**
	 * 
	 * @param row integer variable for the row
	 * @param col integer variable for the column
	 * 
	 */
	public Position(int row, int col) {
		positionRow = row;
		positionColumn = col;
	}
	/**
	 * Returns the position of the row
	 * @return positionRow returned
	 */
	public int getRow() {
		return positionRow;
	}
	/**
	 * Returns the position of the column
	 * @return positionColumn returned
	 */
	public int getCol() {
		return positionColumn;
	}
	/**
	 * Creates a newRow set to positionRow
	 * @param newRow Set equal to the positionRow
	 */
	public void setRow(int newRow) {
		positionRow = newRow;
	}
	/**
	 * Creates a newCol set to positionColumn
	 * @param newCol positionColumn set equal to newCol
	 */
	public void setCol(int newCol) {
		positionColumn = newCol;
	}
	
	/**
	 * This compares the row and column 
	 * @param otherPosition otherPosition that is compared to the positionRow and positionColumn
	 * @return true or false depending of the equality of the position values
	 */
	public boolean equals(Position otherPosition) {
		if (positionRow == otherPosition.getRow() && positionColumn == otherPosition.getCol()){
			return true;
		}
		else {
			return false;
		}
	}
}