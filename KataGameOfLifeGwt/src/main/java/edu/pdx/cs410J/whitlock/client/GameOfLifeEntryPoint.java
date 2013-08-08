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
    Grid grid = new Grid(5, 5);

    for (int row = 0; row < grid.getRowCount(); row++) {
      for (int column = 0; column < grid.getColumnCount(); column++) {
        Panel cell = new SimplePanel();
        cell.setHeight("10px");
        cell.setWidth("10px");
        if (row * column % 2 == 0) {
          cell.setStyleName("cell-alive");
        } else {
          cell.setStyleName("cell-dead");
        }
        grid.setWidget(row, column, cell);
      }
    }

    RootPanel rootPanel = RootPanel.get();
    rootPanel.add(grid);
  }
}
