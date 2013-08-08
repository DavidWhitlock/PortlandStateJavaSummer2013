package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.pdx.cs410J.AbstractAppointmentBook;

/**
 * The client-side interface to the ping service
 */
public interface GameOfLifeServerAsync {

  /**
   * Return the current date/time on the server
   */
  void ping(AsyncCallback<AbstractAppointmentBook> async);
}