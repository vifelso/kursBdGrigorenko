package com.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "clients")
public class Clients implements Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "full_name")
	private String name;

	@Column(name = "passport_data")
	private String passport;




	@OneToMany(mappedBy="clients")
	private Set<TouristVauchers> touristVaucherses;







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

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}
	@Override
	public String toString() {
		return "id:="+id+"Name:=" + name + "passport:=" + passport;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Clients clients = (Clients) o;
		return Objects.equals(id, clients.id) &&
				Objects.equals(name, clients.name) &&
				Objects.equals(passport,clients.passport);
	}

}
