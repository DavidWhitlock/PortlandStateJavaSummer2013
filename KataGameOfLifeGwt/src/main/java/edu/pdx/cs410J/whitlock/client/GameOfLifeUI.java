package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;

public class GameOfLifeUI extends Composite {

  public GameOfLifeUI() {
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

    initWidget(grid);
  }
}
