package org.academiadecodigo.thisfunctionals.relations.one2many;

import org.academiadecodigo.thisfunctionals.inheritance.TablePerClass.Metro;
import org.academiadecodigo.thisfunctionals.inheritance.TablePerClass.PersistenceManager5;
import org.academiadecodigo.thisfunctionals.inheritance.TablePerClass.Train;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class One2ManyMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");

        PersistenceManager7 persistenceManager7 = new PersistenceManager7();


        Doctor doctor1 = new Doctor();
        Doctor doctor2 = new Doctor();
        Pacient pacient1 = new Pacient();
        Pacient pacient2 = new Pacient();
        Set<Pacient> list1 = new HashSet<>();
        Set<Pacient> list2 = new HashSet<>();



        pacient1.setName("Andre");
        pacient2.setName("Miguel");

        doctor1.setName("Ricardo");
        doctor1.setSpeciality("Cardiology");
        doctor1.setPacients(list1);
        doctor2.setName("Ana Bela");
        doctor2.setSpeciality("Endocrinology");
        doctor2.setPacients(list2);


        doctor1.addPacient(pacient1);
        doctor2.addPacient(pacient2);

        persistenceManager7.saveOrUpdateDoctor(doctor1, emf);
        persistenceManager7.saveOrUpdateDoctor(doctor2, emf);


        emf.close();
    }
}
