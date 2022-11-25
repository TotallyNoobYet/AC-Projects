package org.academiadecodigo.thisfunctionals.inheritance.MappedSuperClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="dog")
public class Dog extends Animal {

    public String barkType;

    public String getBarkType() {
        return barkType;
    }

    public void setBarkType(String barkType) {
        this.barkType = barkType;
    }
}
