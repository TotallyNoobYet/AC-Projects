package org.academiadecodigo.thisfunctionals.inheritance.JoinedTable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "OrbiterJoinedTable")
@Table(name = "orbiter_joined_table")
public class Orbiter extends SpaceCraft {

    private String distantPlanetName;


    public void setDistantPlanetName(String distantPlanetName) {
        this.distantPlanetName = distantPlanetName;
    }

    public String getDistantPlanetName() {
        return distantPlanetName;
    }
}
