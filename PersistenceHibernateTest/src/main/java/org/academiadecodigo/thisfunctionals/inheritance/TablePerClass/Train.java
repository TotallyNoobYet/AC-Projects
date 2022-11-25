package org.academiadecodigo.thisfunctionals.inheritance.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "train_table_per_class")
public class Train extends PublicTransport{

    private String trainType;

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }
}
