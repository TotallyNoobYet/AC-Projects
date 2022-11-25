public class Playground {

    public static void main(String[] args) {
        Player player1 = new Player("Anne");
        Player player2 = new Player("Richie");

        Engine engine = new Engine();

        engine.startGame(new Player("Anne"), new Player("Jose"));
    }
}
