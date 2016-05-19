package com.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "drivers")
public class Drivers {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "id_transport")
    private int idOfTransport;
    @Column(name="full_name")
    private String fullName;
    @Column(name="adress")
    private String address;
    @Column(name="phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name="id_transport",insertable = false, updatable = false)
    private Transport transport;

    @OneToMany(mappedBy="drivers")
    private Set<TouristVauchers> touristVaucherses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOfTransport() {
        return idOfTransport;
    }

    public void setIdOfTransport(int idOfTransport) {
        this.idOfTransport = idOfTransport;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "id:="+id+"id_of_transport:=" + idOfTransport + "fullName:=" + fullName + "address:"+ address +"phone:" + phone;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drivers drivers = (Drivers) o;
        return Objects.equals(id, drivers.id) &&
                Objects.equals(idOfTransport, drivers.idOfTransport) &&
                Objects.equals(fullName,drivers.fullName)&&
                Objects.equals(address,drivers.address)&&
                Objects.equals(phone,drivers.phone);
    }
}
