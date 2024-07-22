package com.example.livestockweightandtempims.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LivestockFullInfo {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private float weight;
    private float temp;
    private float temp_avg_7;
    private float temp_avg_14;
    private String note;

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

    public float getTemp_avg_7() {
        return temp_avg_7;
    }

    public void setTemp_avg_7(float temp_avg_7) {
        this.temp_avg_7 = temp_avg_7;
    }

    public float getTemp_avg_14() {
        return temp_avg_14;
    }

    public void setTemp_avg_14(float temp_avg_14) {
        this.temp_avg_14 = temp_avg_14;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "LivestockFullInfo{" +
                "id=" + id +
                ", weight=" + weight +
                ", temp=" + temp +
                ", temp_avg_7=" + temp_avg_7 +
                ", temp_avg_14=" + temp_avg_14 +
                ", note='" + note + '\'' +
                '}';
    }
}
