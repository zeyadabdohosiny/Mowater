package com.example.mowater.data.models.vehicles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainVehicle {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;
    @SerializedName("brand_id")
    @Expose
    private Integer brandId;
    @SerializedName("car_model_id")
    @Expose
    private Integer carModelId;
    @SerializedName("manufacturing_year")
    @Expose
    private String manufacturingYear;
    @SerializedName("car_class_id")
    @Expose
    private Integer carClassId;
    @SerializedName("body_shape")
    @Expose
    private String bodyShape;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(Integer carModelId) {
        this.carModelId = carModelId;
    }

    public String getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(String manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public Integer getCarClassId() {
        return carClassId;
    }

    public void setCarClassId(Integer carClassId) {
        this.carClassId = carClassId;
    }

    public String getBodyShape() {
        return bodyShape;
    }

    public void setBodyShape(String bodyShape) {
        this.bodyShape = bodyShape;
    }

}
