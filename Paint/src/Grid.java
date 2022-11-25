import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;
import java.util.ArrayList;

public class Grid implements KeyboardHandler {

    private Rectangle grid;
    private ArrayList<Rectangle> gridArea;
    private int cols;
    private int rows;
    public final static int PADDING = 10;
    public static final int cellSize = 20;
    private Painter painter;
    private boolean isFill = false;

    public Grid(int cols , int rows){
        this.cols = cols;
        this.rows = rows;
        this.gridArea = new ArrayList<>();
        this.grid = new Rectangle(PADDING, PADDING, cols*cellSize, rows*cellSize);
        grid.draw();
        this.painter = new Painter();
    }

    public void makeGrid(){
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                Rectangle cell = new Rectangle(cellSize*i + PADDING, cellSize*j +PADDING, cellSize, cellSize);
                gridArea.add(cell);
                cell.draw();
            }
        }
    }


    public void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveDown.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveUp.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent paint = new KeyboardEvent();
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paint.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent save = new KeyboardEvent();
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKey(KeyboardEvent.KEY_S);

        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clear.setKey(KeyboardEvent.KEY_C);

        keyboard.addEventListener(moveLeft);
        keyboard.addEventListener(moveRight);
        keyboard.addEventListener(moveDown);
        keyboard.addEventListener(moveUp);
        keyboard.addEventListener(paint);
        keyboard.addEventListener(save);
        keyboard.addEventListener(load);
        keyboard.addEventListener(clear);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                paint();
                break;
            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                paint();
                break;
            case KeyboardEvent.KEY_DOWN:
                moveDown();
                paint();
                break;
            case KeyboardEvent.KEY_UP:
                moveUp();
                paint();
                break;
            case KeyboardEvent.KEY_SPACE:
                isFill = !isFill;
                break;
            case KeyboardEvent.KEY_S:
               save();
                break;
            case KeyboardEvent.KEY_L:
                try {
                    load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case KeyboardEvent.KEY_C:
                clear();
                break;
        }
    }

    private void load() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("SavedFile.txt"));
        String[] line = reader.readLine().split("");

        for (int i = 0; i < gridArea.size(); i++) {
            if (line[i].equals("1")) {
                gridArea.get(i).setColor(Color.RED);
                gridArea.get(i).fill();
                continue;
            }
            gridArea.get(i).draw();
        }
    }

    private void save() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("SavedFile.txt"));

            String result = "";

            for (Rectangle rectangle : gridArea) {
                if (rectangle.isFilled()) {
                    result += "1";
                    continue;
                }
                result += "0";
            }
            writer.write(result);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void moveLeft(){
        if(painter.getX() > PADDING){
            painter.moveLeft();
        }
    }
    public void moveRight(){
        if(painter.getX() < grid.getWidth() - PADDING) {
            painter.moveRight();
        }
    }
    public void moveUp(){
        if(painter.getY() > PADDING){
            painter.moveUp();
        }
    }
    public void moveDown(){
        if(painter.getY() < grid.getHeight() - PADDING){
            painter.moveDown();
        }
    }

    public void clear(){
        for(Rectangle rectangle : gridArea){
            rectangle.setColor(Color.BLACK);
            rectangle.draw();
        }
    }

    public void paint(){
        for(Rectangle rectangle: gridArea){
            if(painter.getX() == rectangle.getX()&& painter.getY() == rectangle.getY()) {
                if(isFill) {
                    if (rectangle.isFilled()) {
                        painter.unPaint(rectangle);
                    } else {
                        painter.paint(rectangle);
                    }
                }
            }
        }
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}
