package com.example.livestockweightandtempims.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ArchiveInfo {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private int purchase_date;
    private float purchase_price;
    private float purchase_weight;
    private String color;
    private String purchase_unit;
    private String contact;
    private int telephone;
    private int vaccination_status;
    private int vaccination_date;
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(int purchase_date) {
        this.purchase_date = purchase_date;
    }

    public float getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(float purchase_price) {
        this.purchase_price = purchase_price;
    }

    public float getPurchase_weight() {
        return purchase_weight;
    }

    public void setPurchase_weight(float purchase_weight) {
        this.purchase_weight = purchase_weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPurchase_unit() {
        return purchase_unit;
    }

    public void setPurchase_unit(String purchase_unit) {
        this.purchase_unit = purchase_unit;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getVaccination_status() {
        return vaccination_status;
    }

    public void setVaccination_status(int vaccination_status) {
        this.vaccination_status = vaccination_status;
    }

    public int getVaccination_date() {
        return vaccination_date;
    }

    public void setVaccination_date(int vaccination_date) {
        this.vaccination_date = vaccination_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "archiveInfo{" +
                "id=" + id +
                ", purchase_date='" + purchase_date + '\'' +
                ", purchase_price=" + purchase_price +
                ", purchase_weight=" + purchase_weight +
                ", color=" + color +
                ", purchase_unit=" + purchase_unit +
                ", contact='" + contact + '\'' +
                ", telephone=" + telephone +
                ", vaccination_status=" + vaccination_status +
                ", vaccination_date='" + vaccination_date + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public ArchiveInfo(long id, int purchase_date, float purchase_price, float purchase_weight, String color, String purchase_unit, String contact, int telephone, int vaccination_status, int vaccination_date, String note) {
        this.id = id;
        this.purchase_date = purchase_date;
        this.purchase_price = purchase_price;
        this.purchase_weight = purchase_weight;
        this.color = color;
        this.purchase_unit = purchase_unit;
        this.contact = contact;
        this.telephone = telephone;
        this.vaccination_status = vaccination_status;
        this.vaccination_date = vaccination_date;
        this.note = note;
    }

    public boolean checkArchive() {
        // 检查 id 是否不为空且长度等于 15
        boolean idValid = (this.id != 0) && (String.valueOf(this.id).length() == 15);

        // 检查 vaccination_status 是否在 1 到 30 的范围内
        boolean vaccinationStatusValid = (this.vaccination_status >= 1) && (this.vaccination_status <= 30);

        // 如果两个条件都满足，则返回 true，否则返回 false
        return idValid && vaccinationStatusValid;
    }

}
