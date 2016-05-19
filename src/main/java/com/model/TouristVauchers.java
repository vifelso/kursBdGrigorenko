package com.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Andrei on 12.05.2016.
 */
@NamedNativeQueries( {
        @NamedNativeQuery(
                name = "simpleProcedure",
                query = "EXECUTE myProcedure",
                resultClass = TouristVauchers.class
        )

})

@Entity
@Table(name = "touristvouchers")
public class TouristVauchers {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "id_employer")
    private int idEmployer;
    @Column(name = "id_client")
    private int idClient;
    @Column(name = "id_driver")
    private int idDriver;
    @Column(name = "id_hotel")
    private int idHotel;
    @Column(name = "departure_date")
    private Date departureDate;
    @Column(name = "arrival_date")
    private Date arrivalDate;
    @Column(name = "sale_date")
    private Date saleDate;
    @Column(name = "cost")
    private int cost;


    @ManyToOne
    @JoinColumn(name="id_hotel",insertable = false, updatable = false)
    private Hotels hotels;
    @ManyToOne
    @JoinColumn(name="id_employer",insertable = false, updatable = false)
    private Employers employers;
    @ManyToOne
    @JoinColumn(name="id_client",insertable = false, updatable = false)
    private Clients  clients;
    @ManyToOne
    @JoinColumn(name="id_driver",insertable = false, updatable = false)
    private Drivers drivers;

    @OneToMany(mappedBy="touristVauchers")
    private Set<Insurance> insurances;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(int idEmployer) {
        this.idEmployer = idEmployer;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    @Override
    public String toString() {
        return "id:="+id+
                "idEmployer:=" +idEmployer +
                "idClient:=" + idClient +
                "idDriver:="+idDriver+
                "idHotel:="+idHotel+
                "departureDate:="+departureDate+
                "arrivalDate:="+arrivalDate+
                "saleDate:="+saleDate+
                "cost:="+cost;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TouristVauchers touristVauchers = (TouristVauchers) o;
        return  Objects.equals(id, touristVauchers.id) &&
                Objects.equals(idEmployer, touristVauchers.idEmployer) &&
                Objects.equals(idClient, touristVauchers.idClient)&&
                Objects.equals(idDriver, touristVauchers.idDriver)&&
                Objects.equals(idHotel,touristVauchers.idHotel)&&
                Objects.equals(departureDate,touristVauchers.departureDate)&&
                Objects.equals(arrivalDate,touristVauchers.arrivalDate)&&
                Objects.equals(saleDate,touristVauchers.saleDate)&&
                Objects.equals(cost,touristVauchers.cost);
    }
}
