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

    StringReader sr = new StringReader(grid);
    GenerationTextParser parser = new GenerationTextParser();
    Generation generation = parser.parse(sr);
    assertThat(generation.getNumberOfRows(), equalTo(3));
    assertThat(generation.getNumberOfColumns(), equalTo(4));
//    assertThat(generation.getCellState(0,0), equalTo(CellState.DEAD));
  }


}
