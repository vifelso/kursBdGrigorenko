package com.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Andrei on 12.05.2016.
 */
@Entity
@Table(name = "countries")
public class Countries {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "lvl_security")
    private int lvlSecurity;


    @OneToMany(mappedBy="country")
    private Set<Hotels> hotels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getLvlSecurity() {
        return lvlSecurity;
    }

    public void setLvlSecurity(int lvlSecurity) {
        this.lvlSecurity = lvlSecurity;
    }
    @Override
    public String toString() {
        return "id:="+id+"Country Name:=" + countryName + "Lvl security:=" + lvlSecurity;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Countries countries = (Countries) o;
        return Objects.equals(id, countries.id) &&
                Objects.equals(countryName, countries.countryName) &&
                Objects.equals(lvlSecurity,countries.lvlSecurity);
    }
}
