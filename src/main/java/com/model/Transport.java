package com.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Andrei on 12.05.2016.
 */
@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy="transport")
    private Set<Drivers> driverses;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "id:="+id+"name:=" +name;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport= (Transport) o;
        return Objects.equals(id, transport.id) &&
                Objects.equals(name, transport.name);
    }
}
