package edu.pdx.cs410J.whitlock.client;

import java.io.Serializable;

import static edu.pdx.cs410J.whitlock.client.CellState.ALIVE;
import static edu.pdx.cs410J.whitlock.client.CellState.DEAD;

public class Generation implements Serializable {
  private int rows;
  private int columns;
  private CellState[][] cellStates;

  public Generation() {

  }

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
          if (neighborState == ALIVE) {
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

  public CellState getCellStateForNextGeneration(int row, int column) {
    CellState cellState = this.getCellState(row, column);
    int numberOfLiveNeighbors = getNumberOfLiveNeighborsForCell(row, column);

    if (cellState == ALIVE) {
      if (numberOfLiveNeighbors < 2) {
        return DEAD;

      } else if (numberOfLiveNeighbors > 3) {
        return DEAD;

      } else if (numberOfLiveNeighbors == 2 || numberOfLiveNeighbors == 3) {
        return ALIVE;
      }

    } else {
      assert cellState == DEAD;
      if (numberOfLiveNeighbors == 3) {
        return ALIVE;
      }
    }

    return DEAD;
  }

  public Generation getNextGeneration() {
    Generation nextGeneration = new Generation(this.rows, this.columns);
    for (int row = 0; row < this.rows; row++) {
      for (int column = 0; column < this.columns; column++) {
        CellState nextState = this.getCellStateForNextGeneration(row, column);
        nextGeneration.setCellState(row, column, nextState);
      }
    }

    return nextGeneration;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Generation)) {
      return false;
    }

    Generation other = (Generation) o;
    if (this.rows != other.rows) {
      return false;

    } else if (this.columns != other.columns) {
      return false;

    } else {
      for (int row = 0; row < rows; row++) {
        for (int column = 0; column < columns; column++) {
          if (this.cellStates[row][column] != other.cellStates[row][column]) {
            return false;
          }
        }
      }

      return true;
    }
  }
}
