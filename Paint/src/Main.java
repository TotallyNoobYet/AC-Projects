import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(30,40);
        grid.makeGrid();
        grid.keyboardInit();


        /*FileInputStream inputStream = new FileInputStream("Guga.png");
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);

        FileOutputStream outputStream = new FileOutputStream("EmptyFile4.png");
        outputStream.write(buffer);
        inputStream.close();
        outputStream.close();*/
    }
}
