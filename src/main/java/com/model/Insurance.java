package com.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Andrei on 12.05.2016.
 */
@NamedNativeQueries( {

        @NamedNativeQuery(
                name = "withParameters",
                query = "EXECUTE myProcedureWithParameters :Summa1,:Summa2",
                resultClass = Insurance.class
        )

})
@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "id_touristvoucher")
    private int idTouristVoucher;
    @Column(name = "insurance_date")
    private Date insuranceDate;
    @Column(name = "cost")
    private int cost;

    @ManyToOne
    @JoinColumn(name="id_touristvoucher",insertable = false, updatable = false)
    private TouristVauchers touristVauchers;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTouristVoucher() {
        return idTouristVoucher;
    }

    public void setIdTouristVoucher(int idTouristVoucher) {
        this.idTouristVoucher = idTouristVoucher;
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    @Override
    public String toString() {
        return "id:="+id+"idTouristVoucher:=" +idTouristVoucher + "InsuranceDate:=" + insuranceDate + "cost:"+cost;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insurance insurance= (Insurance) o;
        return Objects.equals(id, insurance.id) &&
                Objects.equals(idTouristVoucher, insurance.idTouristVoucher) &&
                Objects.equals(insuranceDate, insurance.insuranceDate)&&
                Objects.equals(cost, insurance.cost);
    }
}
