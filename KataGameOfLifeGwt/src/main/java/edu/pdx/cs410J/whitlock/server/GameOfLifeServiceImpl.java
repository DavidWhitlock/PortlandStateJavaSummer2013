package edu.pdx.cs410J.whitlock.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.pdx.cs410J.whitlock.client.CellState;
import edu.pdx.cs410J.whitlock.client.GameOfLifeService;
import edu.pdx.cs410J.whitlock.client.Generation;

/**
 * The server-side implementation of the division service
 */
public class GameOfLifeServiceImpl extends RemoteServiceServlet implements GameOfLifeService
{

  @Override
  public Generation createGeneration(int rows, int columns) {
    Generation generation = new Generation(rows, columns);
    boolean isAlive = true;
    for (int row = 0; row < generation.getNumberOfRows(); row++) {
      for (int column = 0; column < generation.getNumberOfColumns(); column++) {
        generation.setCellState(row, column, isAlive ? CellState.ALIVE : CellState.DEAD);
        isAlive = !isAlive;
      }
    }
    return generation;
  }

  @Override
  public Generation getNextGeneration(Generation generation) {
    return generation.getNextGeneration();
  }
}
