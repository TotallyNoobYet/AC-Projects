package org.academiadecodigo.thisfunctionals.relations.many2many;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Many2ManyMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("game_store");

        PersistenceManager6 persistenceManager6 = new PersistenceManager6();

        Player player1 = new Player();
        Player player2 = new Player();
        Game game1 = new Game();
        Game game2 = new Game();
        ArrayList<Game> list1 = new ArrayList<>();
        ArrayList<Game> list2 = new ArrayList<>();


        player1.setUsername("Ascenso");
       // player1.setId(1);
        player2.setUsername("Coutinho");
       // player2.setId(2);
        game1.setName("Last of Us");
        //game1.setId(2);
        game2.setName("Call of Duty");
       // game2.setId(1);

        list1.add(game1);
        list2.add(game2);

        player1.setGames(list1);

        player2.setGames(list2);








        persistenceManager6.saveOrUpdatePlayer(player1, emf);
        persistenceManager6.saveOrUpdatePlayer(player2, emf);


        emf.close();
    }
}
