package com.example.mowater.data.models.CarsForSale;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Color {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("color_code")
    @Expose
    private String colorCode;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
