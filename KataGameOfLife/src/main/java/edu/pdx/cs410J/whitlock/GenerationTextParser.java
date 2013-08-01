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



    return generation;
  }
}
