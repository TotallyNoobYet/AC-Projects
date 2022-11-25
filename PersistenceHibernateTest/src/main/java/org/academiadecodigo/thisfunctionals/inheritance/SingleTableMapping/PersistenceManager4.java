package org.academiadecodigo.thisfunctionals.inheritance.SingleTableMapping;

import org.academiadecodigo.thisfunctionals.composition.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class PersistenceManager4 {

    public Vehicle findById(Integer id, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(Vehicle.class, id); // always the primary key
        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    public Vehicle saveOrUpdate(Vehicle vehicle, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            Vehicle savedVehicle = em.merge(vehicle);
            em.getTransaction().commit(); // close transaction
            return savedVehicle;

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
