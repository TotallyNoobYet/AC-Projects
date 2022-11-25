package org.academiadecodigo.thisfunctionals.relations.many2many;

import org.academiadecodigo.thisfunctionals.inheritance.TablePerClass.PublicTransport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class PersistenceManager6 {

    public Game findGameById(Integer id, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(Game.class, id); // always the primary key
        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    public Player findPlayerById(Integer id, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(Player.class, id); // always the primary key
        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    public Game saveOrUpdateGame(Game game, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            Game savedGame = em.merge(game);
            em.getTransaction().commit(); // close transaction
            return savedGame;

        } catch (RollbackException ex) {
            // something went wrong, make sure db is consistent
            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public Player saveOrUpdatePlayer(Player player, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            Player savedPlayer = em.merge(player);
            em.getTransaction().commit(); // close transaction
            return savedPlayer;

        } catch (RollbackException ex) {
            // something went wrong, make sure db is consistent
            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
