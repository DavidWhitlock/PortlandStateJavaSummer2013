package edu.pdx.cs410J.whitlock;

public class Generation {
  private final int rows;
  private final int columns;

  public Generation(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
  }

  public CellState getCellState(int row, int column) {
    throw new UnsupportedOperationException();
  }

  public int getNumberOfRows() {
    return this.rows;
  }

  public int getNumberOfColumns() {
    return this.columns;
  }
}
