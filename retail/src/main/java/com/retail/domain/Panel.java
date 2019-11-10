package com.retail.domain;

import javax.persistence.*;

@Entity
@Table(name = "panel")
public class Panel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private int amount;

    private String section;

    private String manufacturer;

    private String technicalCharacteristics;

    private String address;

    public Panel() {
    }

    public Panel(String name, int amount, String section, String manufacturer, String technicalCharacteristics,
                 String address) {
        this.name = name;
        this.amount = amount;
        this.section = section;
        this.manufacturer = manufacturer;
        this.technicalCharacteristics = technicalCharacteristics;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTechnicalCharacteristics() {
        return technicalCharacteristics;
    }

    public void setTechnicalCharacteristics(String technicalCharacteristics) {
        this.technicalCharacteristics = technicalCharacteristics;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
