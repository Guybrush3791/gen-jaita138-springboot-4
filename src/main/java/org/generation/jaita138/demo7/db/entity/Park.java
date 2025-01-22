package org.generation.jaita138.demo7.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String name;
    @Column(length = 128)
    private String address;
    @Column(length = 64)
    private String city;
    @Column(length = 2)
    private String country;

    private int area;
    private int shop;
    private int toilet;

    private boolean sport;

    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getShop() {
        return shop;
    }

    public void setShop(int shop) {
        this.shop = shop;
    }

    public int getToilet() {
        return toilet;
    }

    public void setToilet(int toilet) {
        this.toilet = toilet;
    }

    public boolean isSport() {
        return sport;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void softDelete() {

        this.deleted = true;
    }

    @Override
    public String toString() {

        return "Park [\n"
                + "  id=" + id + ",\n"
                + "  name=" + name + ",\n"
                + "  address=" + address + ",\n"
                + "  city=" + city + ",\n"
                + "  country=" + country + ",\n"
                + "  area=" + area + ",\n"
                + "  shop=" + shop + ",\n"
                + "  toilet=" + toilet + ",\n"
                + "  sport=" + sport + ",\n"
                + "  deleted=" + deleted + "\n"
                + "]";
    }

}
