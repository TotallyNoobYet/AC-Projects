package org.academiadecodigo.thisfunctionals.composition;

import javax.persistence.*;

@Embeddable
public class Dog {

    private String dog_name;
    private String dog_breed;


    @Transient
    private String age;

    private String getDog_name() {
        return dog_name;
    }

    public void setDog_name(String dog_name) {
        this.dog_name = dog_name;
    }

    public String getDog_breed() {
        return dog_breed;
    }

    public void setDog_breed(String dog_breed) {
        this.dog_breed = dog_breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
