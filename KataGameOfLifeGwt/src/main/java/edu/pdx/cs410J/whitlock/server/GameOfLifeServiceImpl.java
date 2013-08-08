package edu.pdx.cs410J.whitlock.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.pdx.cs410J.whitlock.client.GameOfLifeService;
import edu.pdx.cs410J.whitlock.client.Generation;

/**
 * The server-side implementation of the division service
 */
public class GameOfLifeServiceImpl extends RemoteServiceServlet implements GameOfLifeService
{

  @Override
  public Generation createGeneration(int rows, int columns) {
    return new Generation(rows, columns);
  }
}
