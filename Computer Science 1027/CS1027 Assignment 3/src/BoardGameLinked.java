/**
 * represents the board game where the snake moves around eating apples
 * 
 * @author rishabhjain
 *
 */
public class BoardGameLinked {
	private int boardLength;
	private int boardWidth;
	private SnakeLinked theSnake;

	DoubleList<String>[] board;

	/**
	 * BoardGameLinked
	 * 
	 * @param boardFile boardFile
	 */
	public BoardGameLinked(String boardFile) {
		MyFileReader reader = new MyFileReader(boardFile);
		// ignore first two numbers
		reader.readInt();
		reader.readInt();
		this.boardLength = reader.readInt();
		this.boardWidth = reader.readInt();
		board = new DoubleList[boardWidth];

		// for loop to initiate boardGame to "empty"
		for (int i = 0; i < boardWidth; i++) {
			DoubleList<String> boardColumn = new DoubleList<String>();
			board[i] = boardColumn;
		}

		int rowInitial = reader.readInt();
		int colInitial = reader.readInt();

		theSnake = new SnakeLinked(rowInitial, colInitial);

		for (int i = 0; i < boardWidth; i++) {
			DoubleList<String> row = board[i];
			for (int j = 0; j < boardLength; j++) {
				row.addData(j, "empty");
			}
		}
		// Will continue to look for apples, rocks & scissors until the end of file is
		// reached
		while (!reader.endOfFile()) {
			DoubleList<String> row = board[reader.readInt()];
			row.setData(reader.readInt(), reader.readString());
		}
	}

	/**
	 * returns the string stored in the node with index = col of the doubly linked
	 * list referenced by board[row]
	 * 
	 * @param row row
	 * @param col col
	 * @return rowA rowArray
	 * @throws InvalidPositionException InvalidPositionException
	 */
	public String getObject(int row, int col) throws InvalidPositionException {
		if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength)
			throw new InvalidPositionException("Invalid Position");
		DoubleList<String> rowA = board[row];
		return rowA.getData(col);
	}

	/**
	 * stores newObject in the node with index = col of the doubly linked list
	 * referenced by board[row]
	 * 
	 * @param row row
	 * @param col row
	 * @param newObject newObject
	 * @throws InvalidPositionException InvalidPositionException
	 */
	public void setObject(int row, int col, String newObject) throws InvalidPositionException {
		if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength)
			throw new InvalidPositionException("Invalid Position");
		DoubleList<String> rowA = board[row];
		rowA.setData(col, newObject);
	}

	/**
	 * returns theSnake
	 * 
	 * @return theSnake
	 */
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}

	/**
	 * stores the value of newSnake in instance variable theSnake
	 * 
	 * @param newSnake newSnake
	 */
	public void setSnakeLinked(SnakeLinked newSnake) {
		theSnake = newSnake;
	}

	/**
	 * returns boardLength
	 * 
	 * @return boardLength boardLength
	 */
	public int getLength() {
		return boardLength;
	}

	/**
	 * returns boardWidth
	 * 
	 * @return boardWidth boardWidth
	 */
	public int getWidth() {
		return boardWidth;
	}
}
