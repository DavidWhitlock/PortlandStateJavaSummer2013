package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The client-side interface to the ping service
 */
public interface GameOfLifeServiceAsync {

  /**
   * Return the current date/time on the server
   */
  void createGeneration(int rows, int columns, AsyncCallback<Generation> async);

  void getNextGeneration(Generation generation, AsyncCallback<Generation> asyncCallback);
}
