package edu.pdx.cs410J.whitlock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class GenerationTextParser {
  public Generation parse(Reader reader) throws IOException {
    BufferedReader br = new BufferedReader(reader);

    String firstLine = br.readLine();
    String[] rowAndColumn = firstLine.split(" ");
    int rows = Integer.parseInt(rowAndColumn[0]);
    int columns = Integer.parseInt(rowAndColumn[1]);

    Generation generation = new Generation(rows, columns);

    for (int row = 0; row < rows; row++) {
      String line = br.readLine();
      for (int column = 0; column < line.length(); column++) {
        char c = line.charAt(column);
        CellState state;
        if (c == '.') {
          state = CellState.DEAD;

        } else if (c == '*') {
          state = CellState.ALIVE;

        } else {
          throw new IllegalStateException("Unknown character: " + c);
        }

        generation.setCellState(row, column, state);
      }
    }

    return generation;
  }
}
