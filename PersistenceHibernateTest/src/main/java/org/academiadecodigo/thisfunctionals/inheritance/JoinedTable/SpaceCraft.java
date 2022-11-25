package org.academiadecodigo.thisfunctionals.inheritance.JoinedTable;

import javax.persistence.*;

@Entity(name = "VehicleJoinedTable")
@Table(name = "vehicle_joined_table")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SpaceCraft {

    @Id
    private Integer id;

    private String ManufacturerCountry;

    private String companyName;

    public void setManufacturerCountry(String manufacturerCountry) {
        ManufacturerCountry = manufacturerCountry;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    public String getManufacturerCountry() {
        return ManufacturerCountry;
    }

    public String getCompanyName() {
        return companyName;
    }
}
