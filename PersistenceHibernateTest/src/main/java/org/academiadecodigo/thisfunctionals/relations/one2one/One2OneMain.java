package org.academiadecodigo.thisfunctionals.relations.one2one;

import org.academiadecodigo.thisfunctionals.inheritance.TablePerClass.Metro;
import org.academiadecodigo.thisfunctionals.inheritance.TablePerClass.PersistenceManager5;
import org.academiadecodigo.thisfunctionals.inheritance.TablePerClass.Train;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class One2OneMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mechanic");

        PersistenceManager8 persistenceManager8 = new PersistenceManager8();

        Car car1 = new Car();
        Car car2 = new Car();
        CarOwner carOwner1 = new CarOwner();
        CarOwner carOwner2 = new CarOwner();

        car1.setModel(2000);
        car2.setModel(3000);
        car1.setOwner(carOwner1);
        car2.setOwner(carOwner2);
        carOwner2.setName("Joana");
        carOwner1.setName("Miguel");
        carOwner1.setCar(car1);
        carOwner2.setCar(car2);

        persistenceManager8.saveOrUpdateCarOwner(carOwner1, emf);
        persistenceManager8.saveOrUpdateCarOwner(carOwner2, emf);
        persistenceManager8.saveOrUpdateCar(car1, emf);
        persistenceManager8.saveOrUpdateCar(car2, emf);

        emf.close();
    }

}
