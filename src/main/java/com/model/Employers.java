package com.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Andrei on 12.05.2016.
 */
@Entity
@Table(name = "employers")
public class Employers {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "position")
    private String position;
    @Column(name="phone")
    private String phone;

    @OneToMany(mappedBy="employers")
    private Set<TouristVauchers> touristVaucherses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "id:="+id+"fullName:=" + fullName + "position:=" + position + "phone:"+ phone;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employers employers = (Employers) o;
        return Objects.equals(id, employers.id) &&
                Objects.equals(fullName, employers.fullName) &&
                Objects.equals(position, employers.position)&&
                Objects.equals(phone,employers.phone);
    }
}
