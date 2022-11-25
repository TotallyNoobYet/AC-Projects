package org.academiadecodigo.thisfunctionals.inheritance.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "metro_table_per_class")
public class Metro extends PublicTransport{

    private String circulationApp;

    public String getCirculationApp() {
        return circulationApp;
    }

    public void setCirculationApp(String circulationApp) {
        this.circulationApp = circulationApp;
    }
}
