package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.io.IOException;

import static edu.pdx.cs410J.whitlock.CellState.ALIVE;
import static edu.pdx.cs410J.whitlock.CellState.DEAD;
import static edu.pdx.cs410J.whitlock.GenerationTestHelper.parseGenerationText;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple App.
 */
public class GenerationTest
{

  @Test
  public void cellWithNoLiveNeighbors() throws IOException {
    Generation generation = parseGenerationText(
      "...",
      "...",
      "...");
    for (int row = 0; row < generation.getNumberOfRows(); row++) {
      for (int column = 0; column < generation.getNumberOfColumns(); column++) {
        assertThat(generation.getNumberOfLiveNeighborsForCell(row, column), equalTo(0));
      }
    }
  }

  @Test
  public void cellWithAllLiveNeighbors() throws IOException {
    Generation generation = parseGenerationText(
      "***",
      "***",
      "***");
    assertThat(generation.getNumberOfLiveNeighborsForCell(0, 0), equalTo(3));
    assertThat(generation.getNumberOfLiveNeighborsForCell(0, 1), equalTo(5));
    assertThat(generation.getNumberOfLiveNeighborsForCell(0, 2), equalTo(3));
    assertThat(generation.getNumberOfLiveNeighborsForCell(1, 0), equalTo(5));
    assertThat(generation.getNumberOfLiveNeighborsForCell(1, 1), equalTo(8));
    assertThat(generation.getNumberOfLiveNeighborsForCell(1, 2), equalTo(5));
    assertThat(generation.getNumberOfLiveNeighborsForCell(2, 0), equalTo(3));
    assertThat(generation.getNumberOfLiveNeighborsForCell(2, 1), equalTo(5));
    assertThat(generation.getNumberOfLiveNeighborsForCell(2, 2), equalTo(3));
  }

  @Test
  public void generationWithMixOfAliveAndDead() throws IOException {
    Generation generation = parseGenerationText(
      "*.*",
      ".*.",
      "*.*");
    assertThat(generation.getNumberOfLiveNeighborsForCell(0, 0), equalTo(1));
    assertThat(generation.getNumberOfLiveNeighborsForCell(0, 1), equalTo(3));
    assertThat(generation.getNumberOfLiveNeighborsForCell(0, 2), equalTo(1));
    assertThat(generation.getNumberOfLiveNeighborsForCell(1, 0), equalTo(3));
    assertThat(generation.getNumberOfLiveNeighborsForCell(1, 1), equalTo(4));
    assertThat(generation.getNumberOfLiveNeighborsForCell(1, 2), equalTo(3));
    assertThat(generation.getNumberOfLiveNeighborsForCell(2, 0), equalTo(1));
    assertThat(generation.getNumberOfLiveNeighborsForCell(2, 1), equalTo(3));
    assertThat(generation.getNumberOfLiveNeighborsForCell(2, 2), equalTo(1));
  }

  @Test
  public void anyLiveCellWithFewerThanTwoLiveNeighborsDies() throws IOException {
    Generation generation = parseGenerationText(
      "*.*",
      ".*.",
      "*.*");

    assertThat(generation.getCellStateForNextGeneration(0, 0), equalTo(DEAD));
    assertThat(generation.getCellStateForNextGeneration(0, 2), equalTo(DEAD));
    assertThat(generation.getCellStateForNextGeneration(2, 0), equalTo(DEAD));
    assertThat(generation.getCellStateForNextGeneration(2, 2), equalTo(DEAD));
  }

  @Test
  public void anyLiveCellWithMoreThanThreeLiveNeighboursDies() throws IOException {
    Generation generation = parseGenerationText(
      "*.*",
      ".*.",
      "*.*");

    assertThat(generation.getCellStateForNextGeneration(1, 1), equalTo(DEAD));

    generation = parseGenerationText(
      "***",
      "**.",
      "*.*");

    assertThat(generation.getCellStateForNextGeneration(1, 1), equalTo(DEAD));
  }

  @Test
  public void anyLiveCellWithTwoLiveNeighboursLivesOn() throws IOException {
    Generation generation = parseGenerationText(
      "***",
      ".*.",
      "*.*");

    assertThat(generation.getCellStateForNextGeneration(0, 0), equalTo(ALIVE));
  }

  @Test
  public void anyLiveCellWithThreeLiveNeighboursLivesOn() throws IOException {
    Generation generation = parseGenerationText(
      "***",
      ".*.",
      "*.*");

    assertThat(generation.getCellStateForNextGeneration(0, 1), equalTo(ALIVE));
  }

  @Test
  public void anyDeadCellWithExactlyThreeLiveNeighboursBecomesALiveCell() throws IOException {
    Generation generation = parseGenerationText(
      "*.*",
      ".*.",
      "*.*");

    assertThat(generation.getCellStateForNextGeneration(0, 1), equalTo(ALIVE));
    assertThat(generation.getCellStateForNextGeneration(1, 0), equalTo(ALIVE));
    assertThat(generation.getCellStateForNextGeneration(1, 2), equalTo(ALIVE));
    assertThat(generation.getCellStateForNextGeneration(2, 1), equalTo(ALIVE));
  }

}
