package com.example.livestockweightandtempims.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "livestockHealthInfo", primaryKeys = {"id", "timestamp"})
public class LivestockHealthInfo {
    @ColumnInfo(name = "id")
    private long id;
    private float weight;
    private float temp;

    @ColumnInfo(name = "timestamp")
    private int timestamp;

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

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "livestockHealthInfo{" +
                "id=" + id +
                ", weight=" + weight +
                ", temp=" + temp +
                ", timestamp=" + timestamp +
                '}';
    }
}
