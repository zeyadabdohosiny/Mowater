package com.example.mowater.data.models.RentalOffices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RentalLaw implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("rental_office_id")
    @Expose
    private Integer rentalOfficeId;
    @SerializedName("title")
    @Expose
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRentalOfficeId() {
        return rentalOfficeId;
    }

    public void setRentalOfficeId(Integer rentalOfficeId) {
        this.rentalOfficeId = rentalOfficeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
