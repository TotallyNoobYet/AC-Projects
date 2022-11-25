package org.academiadecodigo.thisfunctionals.inheritance.MappedSuperClass;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MappedSuperClassMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("animals");


        PersistenceManager3 persistenceManager3 = new PersistenceManager3();

        Cat cat = new Cat();
        cat.setPurrNoise("Puuurrrr");
        cat.setAnimalType("Mamal");


        persistenceManager3.saveOrUpdate(cat, emf);

        Dog dog = new Dog();
        dog.setBarkType("Loud");
        dog.setAnimalType("Mamal");


        persistenceManager3.saveOrUpdate(dog, emf);

        emf.close();

    }
}
