package org.academiadecodigo.thisfunctionals.inheritance.SingleTableMapping;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingleTableMappingMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vehicles");


        PersistenceManager4 persistenceManager4 = new PersistenceManager4();

        Car car = new Car();
        car.setGears(6);
        car.setMaxSpeed(240);


        persistenceManager4.saveOrUpdate(car, emf);

       Boat boat = new Boat();
       boat.setEngines(4);
       boat.setMaxSpeed(100);


        persistenceManager4.saveOrUpdate(boat, emf);

        emf.close();

    }
}
