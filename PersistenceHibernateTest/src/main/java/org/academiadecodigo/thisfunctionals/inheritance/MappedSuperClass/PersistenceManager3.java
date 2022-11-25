package org.academiadecodigo.thisfunctionals.inheritance.MappedSuperClass;

import org.academiadecodigo.thisfunctionals.composition.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class PersistenceManager3 {

    public Cat findCatById(Integer id, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(Cat.class, id); // always the primary key
        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    public Dog findDogById(Integer id, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(Dog.class, id); // always the primary key
        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    public Animal saveOrUpdate(Animal animal, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            Animal savedAnimal = em.merge(animal);
            em.getTransaction().commit(); // close transaction
            return savedAnimal;

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
