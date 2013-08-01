package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.io.IOException;

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

}
