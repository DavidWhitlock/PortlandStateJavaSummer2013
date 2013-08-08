package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * A GWT remote service that returns a dummy appointment book
 */
@RemoteServiceRelativePath("GameOfLife")
public interface GameOfLifeService extends RemoteService {

  /**
   * Return the current date/time on the server
   */
  Generation createGeneration(int rows, int columns);

  Generation getNextGeneration(Generation generation);
}
