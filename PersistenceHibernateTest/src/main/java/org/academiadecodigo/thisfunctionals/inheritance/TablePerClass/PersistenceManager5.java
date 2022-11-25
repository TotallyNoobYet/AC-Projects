package org.academiadecodigo.thisfunctionals.inheritance.TablePerClass;

import org.academiadecodigo.thisfunctionals.composition.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class PersistenceManager5 {

    public PublicTransport findById(Integer id, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(PublicTransport.class, id); // always the primary key
        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    public PublicTransport saveOrUpdate(PublicTransport trnasport, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            PublicTransport savedTransport = em.merge(trnasport);
            em.getTransaction().commit(); // close transaction
            return savedTransport;

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
