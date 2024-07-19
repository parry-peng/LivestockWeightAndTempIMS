package com.example.livestockweightandtempims.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LivestockInfo {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private float weight;
    private float temp;
    private String notes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "LivestockInfo{" +
                "id=" + id +
                ", weight=" + weight +
                ", temp=" + temp +
                ", notes='" + notes + '\'' +
                '}';
    }
}
