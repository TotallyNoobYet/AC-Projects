package org.academiadecodigo.thisfunctionals.inheritance.JoinedTable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "PenetratorJoinedTable")
@Table(name = "penetrator_joined_table")
public class Penetrator extends SpaceCraft {

    private Integer impactGsMeasure;

    public Integer getImpactGsMeasure() {
        return impactGsMeasure;
    }

    public void setImpactGsMeasure(Integer impactGsMeasure) {
        this.impactGsMeasure = impactGsMeasure;
    }
}
