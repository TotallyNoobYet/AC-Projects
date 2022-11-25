public class Engine {

    private Player player1;
    private Player player2;
    private int maxRounds = 5;
    private int rounds = 0;
    private Gestures player1Play;
    private Gestures player2Play;
    private Player winner;

    private int player1Wins = 0;
    private int player2Wins = 0;

    private void checkWinner(){
        if(player1Play == player2Play){
            System.out.println(player1 + ": " + player1Play + "\n" + player2 + ": " + player2Play);
            System.out.println("it's a draw!");
        } else if (player1Play == Gestures.ROCK && player2Play != Gestures.PAPER){
            System.out.println(player1 + ": " + player1Play + "\n" + player2 + ": " + player2Play);
            System.out.println(player1 + " won this play");
            player1Wins++;
        }else if (player1Play == Gestures.PAPER && player2Play != Gestures.SCISSORS) {
            System.out.println(player1 + ": " + player1Play + "\n" + player2 + ": " + player2Play);
            System.out.println(player1 + " won this play");
            player1Wins++;
        } else if(player1Play == Gestures.SCISSORS && player2Play != Gestures.ROCK) {
            System.out.println(player1 + ": " + player1Play + "\n" + player2 + ": " + player2Play);
            System.out.println(player1 + " won this play");
            player1Wins++;
        } else {
            System.out.println(player1 + ": " + player1Play + "\n" + player2 + ": " + player2Play);
            System.out.println(player2 + " won this play");
            player2Wins++;
        }
    }


    public void startGame(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;

        while(rounds < maxRounds){
            player1Play = player1.makeMove();
            player2Play = player2.makeMove();
            checkWinner();
            System.out.println();
            rounds++;
        }

        winner = (player1Wins > player2Wins) ? player1 : player2;

        System.out.println(winner + " is the winner of the game!");
    }

}
