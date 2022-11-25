package org.academiadecodigo.thisfunctionals.relations.one2many;

import javax.persistence.*;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String speciality;


    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "doctor"
    )
    private Set<Pacient> pacients;

    public void addPacient(Pacient pacient) {
        pacients.add(pacient);
        pacient.setDoctor(this);
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Pacient> getPacients() {
        return pacients;
    }

    public void setPacients(Set<Pacient> pacients) {
        this.pacients = pacients;
    }
}
