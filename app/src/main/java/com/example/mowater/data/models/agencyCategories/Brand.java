package com.example.mowater.data.models.agencyCategories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Brand {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("manufacture_country_id")
    @Expose
    private Integer manufactureCountryId;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManufactureCountryId() {
        return manufactureCountryId;
    }

    public void setManufactureCountryId(Integer manufactureCountryId) {
        this.manufactureCountryId = manufactureCountryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
