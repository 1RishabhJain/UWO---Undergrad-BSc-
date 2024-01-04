/**
 * BoardGame.java
 * This class contains methods to read the text file and creates a matrix
 * that can be used by other classes to create the game.
 * @author Rishabh Jain
 *
 */
public class BoardGame {

	private int board_length;
	private int board_width;
	private Snake theSnake;
	private String[][]matrix;
	
	/**
	 * Takes in boardFile as a parameter for the filename, skips the first 2 lines, and assigns the remaining lines to variables respectively
	 * @param boardFile Text file containing the details for the board
	 */
	public BoardGame(String boardFile) {
		MyFileReader reader = new MyFileReader(boardFile);
		reader.readInt();
		reader.readInt();
		board_length = reader.readInt();
		board_width = reader.readInt();
		int rowInitial = reader.readInt();
		int colInitial = reader.readInt();
		
		theSnake = new Snake(rowInitial, colInitial);
		
		matrix = new String[board_width][board_length];
		
		// Nested for loop that will set every spot to "empty"
		for (int i = 0; i < board_width; i++) {
			for (int j = 0; j < board_length; j++) {
				matrix[i][j] = "empty";
			}
		}
		// Will continue to look for apples, rocks and scissors until the end of file is reached
		while (!reader.endOfFile()) {
			
			int row = reader.readInt();
			int column = reader.readInt();
			String type = reader.readString();
			// puts the apple, rock or scissor at the correct row and column
			matrix[row][column] = type;
		}
	}
	
	/**
	 * Returns the object at that part of the matrix
	 * @param row Integer Row
	 * @param col Integer Column
	 * @return Returns the matrix
	 */
	public String getObject(int row, int col) {
		return matrix[row][col];
	}
	/**
	 * Assigns the newObject to the position in the matrix
	 * @param row Integer Row
	 * @param col Integer Column
	 * @param newObject newObject created that equals specific matrix position
	 */
	public void setObject(int row, int col, String newObject) {
		matrix[row][col]= newObject;
	}
	/**
	 * Returns theSnake when getSnake method called
	 * @return Returns theSnake
	 */
	public Snake getSnake() {
		return theSnake;
	}
	/**
	 * Creates a newSnake equal to theSnake
	 * @param newSnake updated theSnake
	 */
	public void setSnake(Snake newSnake) {
		theSnake = newSnake;
	}
	/**
	 * Method used to return the length of the board
	 * @return Returns the board_lengths
	 */
	public int getLength() {
		return board_length;
	}
	/**
	 * Method used to return the width of the board
	 * @return Returns the board_width
	 */
	public int getWidth() {
		return board_width;
	}
	/**
	 * Method that returns the type at specific location of matrix using row and column
	 * @param row Integer Row
	 * @param col Integer Column
	 * @return returns the matrix at the specific location
	 */
	public String getType(int row, int col) {
		return matrix[row][col];
	}
}