package org.academiadecodigo.thisfunctionals.relations.one2many;

import org.academiadecodigo.thisfunctionals.inheritance.TablePerClass.PublicTransport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.print.Doc;

public class PersistenceManager7 {

    public Doctor findById(Integer id, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(Doctor.class, id); // always the primary key
        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    public Doctor saveOrUpdateDoctor(Doctor doctor, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            Doctor savedDoctor = em.merge(doctor);
            em.getTransaction().commit(); // close transaction
            return savedDoctor;

        } catch (RollbackException ex) {
            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public Pacient saveOrUpdatePacient(Pacient pacient, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            Pacient savedPacient = em.merge(pacient);
            em.getTransaction().commit(); // close transaction
            return savedPacient;

        } catch (RollbackException ex) {
            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
