package org.academiadecodigo.thisfunctionals.inheritance.TablePerClass;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TablePerClassMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("public_transport");

        PersistenceManager5 persistenceManager5 = new PersistenceManager5();


        Metro metro = new Metro();
        metro.setCirculationApp("MetroPorto");
        metro.setMaxSpeed(70);

        persistenceManager5.saveOrUpdate(metro, emf);

        Train train = new Train();
        train.setTrainType("AlphaPendular");
        train.setMaxSpeed(200);

        persistenceManager5.saveOrUpdate(train, emf);

        emf.close();


        emf.close();
    }
}
