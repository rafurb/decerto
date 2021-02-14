package com.decerto.repo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "somenumber")
public class SomeNumbers {
    @Id
    @GeneratedValue
    private Long id;

    private String valuee;

    public SomeNumbers() {}
    public SomeNumbers(String valuee){
        this.valuee = valuee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValuee() {
        return valuee;
    }

    public void setValuee(String valuee) {
        this.valuee = valuee;
    }

    @Override
    public String toString() {
        return "SomeNumbers{" +
                "id=" + id +
                ", valuee='" + valuee + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeNumbers that = (SomeNumbers) o;
        return Objects.equals(id, that.id) && Objects.equals(valuee, that.valuee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valuee);
    }
}
