package org.academiadecodigo.thisfunctionals.inheritance.MappedSuperClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cat")
public class Cat extends Animal {

    public String purrNoise;

    public String getPurrNoise() {
        return purrNoise;
    }

    public void setPurrNoise(String purrNoise) {
        this.purrNoise = purrNoise;
    }
}
