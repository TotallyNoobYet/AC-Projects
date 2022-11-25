package org.academiadecodigo.thisfunctionals.relations.one2one;

import javax.persistence.*;

@Entity
@Table(name = "car_owner")
public class CarOwner {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @OneToOne(
            cascade = {CascadeType.ALL},
            mappedBy = "carOwner"
    )
    private Car car;

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}