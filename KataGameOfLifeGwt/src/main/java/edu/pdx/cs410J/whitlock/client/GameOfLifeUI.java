package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class GameOfLifeUI extends Composite {

  private final TextBox rows;
  private final TextBox columns;
  private final Grid grid;
  private final GameOfLifeServiceAsync service;

  public Generation generation;

  public GameOfLifeUI() {
    grid = new Grid();

    DockPanel dock = new DockPanel();
    dock.add(grid, DockPanel.CENTER);

    HorizontalPanel buttons = new HorizontalPanel();
    buttons.add(new Label("Rows:"));

    rows = new TextBox();
    rows.setText("5");
    rows.setVisibleLength(3);
    buttons.add(rows);
    buttons.add(new Label("Columns:"));

    columns = new TextBox();
    columns.setText("5");
    columns.setVisibleLength(3);
    buttons.add(columns);

    Button start = new Button("Start");
    start.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        startGameOfLife();
      }
    });
    buttons.add(start);

    dock.add(buttons, DockPanel.NORTH);

    initWidget(dock);

    service = GWT.create(GameOfLifeService.class);

    startGameOfLife();
  }

  private void startGameOfLife() {
    int rows = Integer.parseInt(this.rows.getText());
    int columns = Integer.parseInt(this.columns.getText());

    service.createGeneration(rows, columns, new AsyncCallback<Generation>() {
      @Override
      public void onFailure(Throwable caught) {
        reportFailure(caught);
      }

      @Override
      public void onSuccess(Generation generation) {
        GameOfLifeUI.this.generation = generation;
        drawGeneration();
      }
    });

    Timer timer = new Timer() {
      @Override
      public void run() {
        drawNextGeneration();
      }
    };
    timer.scheduleRepeating(1000);

  }

  private void reportFailure(Throwable caught) {
    Window.alert(caught.getMessage());
  }

  private void drawNextGeneration() {
    service.getNextGeneration(this.generation, new AsyncCallback<Generation>() {
      @Override
      public void onFailure(Throwable caught) {
        reportFailure(caught);
      }

      @Override
      public void onSuccess(Generation result) {
        GameOfLifeUI.this.generation = result;
        drawGeneration();
      }
    });

  }

  private void drawGeneration() {
    int rows = generation.getNumberOfRows();
    int columns = generation.getNumberOfColumns();

    this.grid.resizeRows(rows);
    this.grid.resizeColumns(columns);

    for (int row = 0; row < grid.getRowCount(); row++) {
      for (int column = 0; column < grid.getColumnCount(); column++) {
        Panel cell = new SimplePanel();
        cell.setHeight("10px");
        cell.setWidth("10px");
        if (generation.getCellState(row, column) == CellState.ALIVE) {
          cell.setStyleName("cell-alive");
        } else {
          cell.setStyleName("cell-dead");
        }
        grid.setWidget(row, column, cell);
      }
    }

  }
}
