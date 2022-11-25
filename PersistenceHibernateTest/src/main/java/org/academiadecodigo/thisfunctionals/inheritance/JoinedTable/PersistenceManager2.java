package org.academiadecodigo.thisfunctionals.inheritance.JoinedTable;

import org.academiadecodigo.thisfunctionals.composition.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class PersistenceManager2 {

    public SpaceCraft findById(Integer id, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(SpaceCraft.class, id); // always the primary key
        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    public SpaceCraft saveOrUpdate(SpaceCraft spaceCraft, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            SpaceCraft savedSpacecraft = em.merge(spaceCraft);
            em.getTransaction().commit(); // close transaction
            return savedSpacecraft;

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
