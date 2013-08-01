package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static edu.pdx.cs410J.whitlock.CellState.ALIVE;
import static edu.pdx.cs410J.whitlock.CellState.DEAD;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GenerationTextParserTest {

  @Test
  public void parseRowAndColumn() throws IOException {

    Generation generation = parseGenerationText(
      "....",
      "....",
      "....");
    assertThat(generation.getNumberOfRows(), equalTo(3));
    assertThat(generation.getNumberOfColumns(), equalTo(4));
  }

  private String makeGrid(String... lines) {
    StringBuilder sb = new StringBuilder();
    sb.append(lines.length).append(" ").append(lines[0].length()).append("\n");
    for (String line : lines) {
      sb.append(line).append("\n");
    }
    return sb.toString();
  }

  private Generation parseGenerationText(String... lines) throws IOException {
    String grid = makeGrid(lines);
    StringReader sr = new StringReader(grid);
    GenerationTextParser parser = new GenerationTextParser();
    return parser.parse(sr);
  }

  @Test
  public void allDeadCells() throws IOException {
    Generation generation = parseGenerationText(
      "....",
      "....",
      "...."
    );
    assertThatAllCellsHaveState(generation, DEAD);
  }

  @Test
  public void someDeadCellsSomeAliveCells() throws IOException {
    Generation generation = parseGenerationText(
      ".*.",
      "*.*",
      ".*."
    );
    assertThatCellHasState(generation, 0, 0, DEAD);
    assertThatCellHasState(generation, 0, 1, ALIVE);
    assertThatCellHasState(generation, 0, 2, DEAD);
    assertThatCellHasState(generation, 1, 0, ALIVE);
    assertThatCellHasState(generation, 1, 1, DEAD);
    assertThatCellHasState(generation, 1, 2, ALIVE);
    assertThatCellHasState(generation, 2, 0, DEAD);
    assertThatCellHasState(generation, 2, 1, ALIVE);
    assertThatCellHasState(generation, 2, 2, DEAD);
  }

  private void assertThatCellHasState(Generation generation, int row, int column, CellState state) {
    assertThat(generation.getCellState(row, column), equalTo(state));
  }

  private void assertThatAllCellsHaveState(Generation generation, CellState state) {
    for (int row = 0; row < generation.getNumberOfRows(); row++) {
      for (int column = 0; column < generation.getNumberOfColumns(); column++) {
        assertThatCellHasState(generation, row, column, state);
      }
    }
  }

  @Test
  public void allAliveCells() throws IOException {
    Generation generation = parseGenerationText(
      "***",
      "***",
      "***"
    );
    assertThatAllCellsHaveState(generation, CellState.ALIVE);
  }


}
