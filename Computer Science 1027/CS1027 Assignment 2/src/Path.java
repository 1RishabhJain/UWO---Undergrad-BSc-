/**
 * Path class finds best route from starting cell to destination cell
 * 
 * @author rishabhjain
 *
 */

public class Path {
	Map cityMap;

	/**
	 * City map instance variable
	 * 
	 * @param theMap City map instance variable
	 */
	public Path(Map theMap) {
		super();
		this.cityMap = theMap;
	}

	/**
	 * Parameters are initial, increasing and decreasing Gets the starting cell
	 */
	public void findPath() {
		ArrayStack<MapCell> path = new ArrayStack<MapCell>(10, 5, 5);
		MapCell theCell = cityMap.getStart();
		path.push(theCell);
		theCell.markInStack();
		try {

			while (!path.isEmpty() && !path.peek().isDestination()) {

				MapCell currentCell = (MapCell) path.peek();

				if (currentCell.isDestination()) {
					break;
				}

				if (this.nextCell(currentCell) != null) {
					path.push(this.nextCell(currentCell));
					this.nextCell(currentCell).markInStack();
				}

				else {
					path.pop().markOutStack();
				}

				theCell = currentCell;
			}
			// Output Message when destination found and final path created
			if (path.size() > 0) {
				System.out.println("Path was found containing " + path.size() + " cells.");
			} else {
				System.out.println("No path found");
			}

		}
		// Empty stack and invalid map exceptions
		catch (EmptyStackException e) {
			System.out.println("No path found");
		}
		catch (Exception e) {
			System.out.println("No path found");
		}
	}
	/**
	 * Next Cell method
	 * @param cell Cell
	 * @return cell or nextCell
	 */
	private MapCell nextCell(MapCell cell) {

		MapCell myCell;
		MapCell nextCell;
		// checks the cells around
		if (cell.isDestination()) {
			return cell;
		}

		if (cell.isStart() || cell.isIntersection()) {

			for (int i = 0; i <= 3; i++) {
				if (cell.getNeighbour(i) != null && !cell.getNeighbour(i).isMarked()) {
					nextCell = cell.getNeighbour(i);
					if (nextCell.isDestination()) {
						return nextCell;
					}
					if (nextCell.isIntersection()) {
						return nextCell;
					}
				}
			}
			
			// Checks the 4 directional paths for marked cells and blocks
			nextCell = cell.getNeighbour(0);
			if (nextCell != null && !nextCell.isMarked() && nextCell.isNorthRoad()) {
				return nextCell;
			}

			nextCell = cell.getNeighbour(1);
			if (nextCell != null && !nextCell.isMarked() && nextCell.isEastRoad()) {
				return nextCell;
			}

			nextCell = cell.getNeighbour(2);
			if (nextCell != null && !nextCell.isMarked() && nextCell.isSouthRoad()) {
				return nextCell;
			}

			nextCell = cell.getNeighbour(3);
			if (nextCell != null && !nextCell.isMarked() && nextCell.isWestRoad()) {
				return nextCell;
			}
		}
		// Checks the 4 directional paths for marked cells and blocks
		if (cell.isNorthRoad()) {
			nextCell = cell.getNeighbour(0);
			if (nextCell != null && !nextCell.isMarked() || nextCell.isBlock()) {
				return nextCell;
			}

		}
		if (cell.isEastRoad()) {
			nextCell = cell.getNeighbour(1);
			if (nextCell != null && !nextCell.isMarked() || nextCell.isBlock()) {
				return nextCell;
			}

		}
		if (cell.isSouthRoad()) {
			nextCell = cell.getNeighbour(2);
			if (nextCell != null && !nextCell.isMarked() || nextCell.isBlock()) {
				return nextCell;
			}

		}
		if (cell.isWestRoad()) {
			nextCell = cell.getNeighbour(3);
			if (nextCell != null && !nextCell.isMarked() || nextCell.isBlock()) {
				return nextCell;
			}

		}
		return null;

	}

}