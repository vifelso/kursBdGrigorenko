package com.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Andrei on 12.05.2016.
 */
@Entity
@Table(name = "hotels")
public class Hotels {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "id_country")
    private int idCountry;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "adress")
    private String address;
    @Column(name = "phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name="id_country",insertable = false, updatable = false)
    private Countries country;
    @OneToMany(mappedBy="hotels")
    private Set<TouristVauchers> touristVaucherses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "id:="+id+"idCountry:=" + idCountry + "hotelName:=" + hotelName + "address:"+address+"phone:"+ phone;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotels hotels = (Hotels) o;
        return Objects.equals(id, hotels.id) &&
                Objects.equals(idCountry, hotels.idCountry) &&
                Objects.equals(hotelName, hotels.hotelName)&&
                Objects.equals(address, hotels.address)&&
                Objects.equals(phone,hotels.phone);
    }
}
