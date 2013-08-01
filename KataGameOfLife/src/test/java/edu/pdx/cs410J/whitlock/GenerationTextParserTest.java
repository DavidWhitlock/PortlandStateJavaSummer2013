package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GenerationTextParserTest {

  @Test
  public void parseRowAndColumn() throws IOException {
    String grid =
      "3 4\n" +
      "....\n" +
      "....\n" +
      "....";

    Generation generation = parseGenerationText(grid);
    assertThat(generation.getNumberOfRows(), equalTo(3));
    assertThat(generation.getNumberOfColumns(), equalTo(4));
  }

  private Generation parseGenerationText(String grid) throws IOException {
    StringReader sr = new StringReader(grid);
    GenerationTextParser parser = new GenerationTextParser();
    return parser.parse(sr);
  }

  @Test
  public void allDeadCells() throws IOException {
    String grid =
      "3 4\n" +
      "....\n" +
      "....\n" +
      "....";

    Generation generation = parseGenerationText(grid);
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
    String grid =
      "3 3\n" +
      "***\n" +
      "***\n" +
      "***";

    Generation generation = parseGenerationText(grid);
    assertThatAllCellsHaveState(generation, CellState.ALIVE);
  }


}
