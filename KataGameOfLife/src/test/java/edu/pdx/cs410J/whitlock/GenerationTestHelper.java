package edu.pdx.cs410J.whitlock;

import java.io.IOException;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GenerationTestHelper {
  private static String makeGrid(String... lines) {
    StringBuilder sb = new StringBuilder();
    sb.append(lines.length).append(" ").append(lines[0].length()).append("\n");
    for (String line : lines) {
      sb.append(line).append("\n");
    }
    return sb.toString();
  }

  static Generation parseGenerationText(String... lines) throws IOException {
    String grid = makeGrid(lines);
    StringReader sr = new StringReader(grid);
    GenerationTextParser parser = new GenerationTextParser();
    return parser.parse(sr);
  }

  static void assertThatCellHasState(Generation generation, int row, int column, CellState state) {
    assertThat(generation.getCellState(row, column), equalTo(state));
  }

  static void assertThatAllCellsHaveState(Generation generation, CellState state) {
    for (int row = 0; row < generation.getNumberOfRows(); row++) {
      for (int column = 0; column < generation.getNumberOfColumns(); column++) {
        assertThatCellHasState(generation, row, column, state);
      }
    }
  }
}
