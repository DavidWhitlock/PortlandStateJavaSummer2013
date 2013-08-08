package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * A basic GWT class that makes sure that we can send an appointment book back from the server
 */
public class GameOfLifeEntryPoint implements EntryPoint {
  @Override
  public void onModuleLoad() {
    GameOfLifeUI ui = new GameOfLifeUI();

    RootPanel rootPanel = RootPanel.get();
    rootPanel.add(ui);
  }
}
