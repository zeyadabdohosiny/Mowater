package com.example.mowater.data.models.agencyDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CarModel  implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("brand_id")
    @Expose
    private Integer brandId;
    @SerializedName("car_classes")
    @Expose
    private List<CarClass> carClasses = null;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public List<CarClass> getCarClasses() {
        return carClasses;
    }

    public void setCarClasses(List<CarClass> carClasses) {
        this.carClasses = carClasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
