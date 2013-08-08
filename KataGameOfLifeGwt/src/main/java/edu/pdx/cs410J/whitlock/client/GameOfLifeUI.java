package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.ui.*;

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

    DockPanel dock = new DockPanel();
    dock.add(grid, DockPanel.CENTER);

    HorizontalPanel buttons = new HorizontalPanel();
    buttons.add(new Label("Rows:"));

    TextBox rows = new TextBox();
    rows.setVisibleLength(3);
    buttons.add(rows);
    buttons.add(new Label("Columns:"));

    TextBox columns = new TextBox();
    columns.setVisibleLength(3);
    buttons.add(columns);
    buttons.add(new Button("Start"));

    dock.add(buttons, DockPanel.NORTH);

    initWidget(dock);
  }
}
