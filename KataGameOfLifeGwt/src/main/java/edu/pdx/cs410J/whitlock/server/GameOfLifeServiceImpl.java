package edu.pdx.cs410J.whitlock.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.whitlock.client.AppointmentBook;
import edu.pdx.cs410J.whitlock.client.Appointment;
import edu.pdx.cs410J.whitlock.client.GameOfLifeServer;

/**
 * The server-side implementation of the division service
 */
public class GameOfLifeServiceImpl extends RemoteServiceServlet implements GameOfLifeServer
{
    public AbstractAppointmentBook ping()
    {
        AppointmentBook book = new AppointmentBook();
        book.addAppointment( new Appointment() );
        return book;
    }
}
