package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.io.IOException;

import static edu.pdx.cs410J.whitlock.CellState.ALIVE;
import static edu.pdx.cs410J.whitlock.CellState.DEAD;
import static edu.pdx.cs410J.whitlock.GenerationTestHelper.assertThatAllCellsHaveState;
import static edu.pdx.cs410J.whitlock.GenerationTestHelper.assertThatCellHasState;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GenerationTextParserTest {

  @Test
  public void parseRowAndColumn() throws IOException {

    Generation generation = GenerationTestHelper.parseGenerationText(
      "....",
      "....",
      "....");
    assertThat(generation.getNumberOfRows(), equalTo(3));
    assertThat(generation.getNumberOfColumns(), equalTo(4));
  }

  @Test
  public void allDeadCells() throws IOException {
    Generation generation = GenerationTestHelper.parseGenerationText(
      "....",
      "....",
      "...."
    );
    assertThatAllCellsHaveState(generation, DEAD);
  }

  @Test
  public void someDeadCellsSomeAliveCells() throws IOException {
    Generation generation = GenerationTestHelper.parseGenerationText(
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

  @Test
  public void allAliveCells() throws IOException {
    Generation generation = GenerationTestHelper.parseGenerationText(
      "***",
      "***",
      "***"
    );
    assertThatAllCellsHaveState(generation, CellState.ALIVE);
  }


}
