package org.academiadecodigo.thisfunctionals.inheritance.JoinedTable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JoinedTableMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacecrafts");

        PersistenceManager2 persistenceManager2 = new PersistenceManager2();

        Penetrator penetrator = new Penetrator();
        penetrator.setCompanyName("NASA");
        penetrator.setImpactGsMeasure(700);
        penetrator.setManufacturerCountry("USA");

        persistenceManager2.saveOrUpdate(penetrator, emf);

        Orbiter orbiter = new Orbiter();
        orbiter.setCompanyName("Boeing");
        orbiter.setDistantPlanetName("PROXIMA CENTAURI B");
        orbiter.setManufacturerCountry("USA");

        persistenceManager2.saveOrUpdate(orbiter, emf);

        emf.close();

    }
}
