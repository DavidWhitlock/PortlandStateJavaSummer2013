package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import edu.pdx.cs410J.AbstractAppointmentBook;

/**
 * A GWT remote service that returns a dummy appointment book
 */
@RemoteServiceRelativePath("GameOfLife")
public interface GameOfLifeServer extends RemoteService {

  /**
   * Returns the current date and time on the server
   */
  public AbstractAppointmentBook ping();

}
