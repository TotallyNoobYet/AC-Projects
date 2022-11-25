package org.academiadecodigo.thisfunctionals.composition;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompositionMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dog_owners");

        PersistenceManager persistenceManager = new PersistenceManager();

        Owner owner1 = new Owner();
        owner1.setName("Gustavo");
        owner1.setDog(new Dog());
        owner1.getDog().setDog_breed("Pitt-bull");
        owner1.getDog().setDog_name("Benedito");

        persistenceManager.saveOrUpdate(owner1, emf);

        Owner owner2= new Owner();
        owner2.setName("Sara");
        owner2.setDog(new Dog());
        owner2.getDog().setDog_breed("Pitt-bull");
        owner2.getDog().setDog_name("Quim");

        persistenceManager.saveOrUpdate(owner2, emf);

        emf.close();

    }

}
