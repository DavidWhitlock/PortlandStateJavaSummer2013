package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class GameOfLifeUI extends Composite {

  private final TextBox rows;
  private final TextBox columns;
  private final Grid grid;

  public GameOfLifeUI() {
    grid = new Grid(5, 5);

    redrawGrid();

    DockPanel dock = new DockPanel();
    dock.add(grid, DockPanel.CENTER);

    HorizontalPanel buttons = new HorizontalPanel();
    buttons.add(new Label("Rows:"));

    rows = new TextBox();
    rows.setVisibleLength(3);
    buttons.add(rows);
    buttons.add(new Label("Columns:"));

    columns = new TextBox();
    columns.setVisibleLength(3);
    buttons.add(columns);

    Button start = new Button("Start");
    start.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        updateSizeOfGrid();
      }
    });
    buttons.add(start);

    dock.add(buttons, DockPanel.NORTH);

    initWidget(dock);
  }

  private void redrawGrid() {
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
  }

  private void updateSizeOfGrid() {
    int rows = Integer.parseInt(this.rows.getText());
    int columns = Integer.parseInt(this.columns.getText());

    this.grid.resizeRows(rows);
    this.grid.resizeColumns(columns);

    redrawGrid();
  }
}