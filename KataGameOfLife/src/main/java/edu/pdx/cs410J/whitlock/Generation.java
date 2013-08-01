package edu.pdx.cs410J.whitlock;

public class Generation {
  private final int rows;
  private final int columns;
  private CellState[][] cellStates;

  public Generation(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;

    this.cellStates = new CellState[rows][columns];
  }

  public CellState getCellState(int row, int column) {
    return cellStates[row][column];
  }

  public int getNumberOfRows() {
    return this.rows;
  }

  public int getNumberOfColumns() {
    return this.columns;
  }

  public void setCellState(int row, int column, CellState state) {
    this.cellStates[row][column] = state;
  }

  public int getNumberOfLiveNeighborsForCell(int row, int column) {
    int numberOfLiveNeighbors = 0;

    for (int neighborRow = row - 1; neighborRow <= row + 1; neighborRow++) {
      for (int neighborColumn = column - 1; neighborColumn <= column + 1; neighborColumn++) {
        if (neighborRow == row && neighborColumn == column) {
          // Don't count yourself as a neighbors

        } else if (neighborsWithinBoundsOfGrid(neighborRow, neighborColumn)) {

          CellState neighborState = this.cellStates[neighborRow][neighborColumn];
          if (neighborState == CellState.ALIVE) {
            numberOfLiveNeighbors++;
          }
        }
      }
    }

    return numberOfLiveNeighbors;
  }

  private boolean neighborsWithinBoundsOfGrid(int neighborRow, int neighborColumn) {
    return neighborRow >= 0 && neighborRow < this.rows &&
           neighborColumn >= 0 && neighborColumn < this.columns;
  }
}
