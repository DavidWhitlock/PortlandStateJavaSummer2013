package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

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
    assertThatAllCellsHaveState(generation, CellState.DEAD);
  }

  private void assertThatAllCellsHaveState(Generation generation, CellState state) {
    for (int row = 0; row < generation.getNumberOfRows(); row++) {
      for (int column = 0; column < generation.getNumberOfColumns(); column++) {
        assertThat(generation.getCellState(row, column), equalTo(state));
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
