package org.academiadecodigo.thisfunctionals.relations.one2one;

import org.academiadecodigo.thisfunctionals.inheritance.TablePerClass.PublicTransport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class PersistenceManager8 {

    public CarOwner findById(Integer id, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(CarOwner.class, id); // always the primary key
        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    public CarOwner saveOrUpdateCarOwner(CarOwner carOwner, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            CarOwner savedCarOwner = em.merge(carOwner);
            em.getTransaction().commit(); // close transaction
            return savedCarOwner;

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

    public Car saveOrUpdateCar(Car car, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            Car savedCar = em.merge(car);
            em.getTransaction().commit(); // close transaction
            return savedCar;

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
