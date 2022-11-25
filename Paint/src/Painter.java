import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Painter {

private Rectangle painter;
private Color colorToPaint;

public Painter(){
    this.painter = new Rectangle(Grid.PADDING, Grid.PADDING, Grid.cellSize, Grid.cellSize);
    this.colorToPaint = Color.RED;
    painter.setColor(Color.BLACK);
    painter.fill();
}

public int getX() {
    return painter.getX();
}
public int getY(){
    return painter.getY();
}

    public void moveLeft(){
        painter.translate(-Grid.cellSize, 0);
    }
    public void moveRight(){
        painter.translate(Grid.cellSize, 0);
    }
    public void moveUp(){
       painter.translate(0, -Grid.cellSize);
    }
    public void moveDown(){
        painter.translate(0, Grid.cellSize);
    }

    public void paint(Rectangle r){
        r.setColor(colorToPaint);
        r.fill();
    }

    public void unPaint(Rectangle r){
        r.setColor(Color.BLACK);
        r.draw();
    }



}
