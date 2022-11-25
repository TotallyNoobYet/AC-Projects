package org.academiadecodigo.thisfunctionals.relations.one2one;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer model;

    @OneToOne
    private CarOwner carOwner;


    public Integer getId() {
        return id;
    }


    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public CarOwner getOwner() {
        return carOwner;
    }

    public void setOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }
}
