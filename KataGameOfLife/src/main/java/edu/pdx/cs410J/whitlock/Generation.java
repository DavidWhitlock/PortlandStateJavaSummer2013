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
}
