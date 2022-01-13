package com.example.mowater.data.models.vehicles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("vehicable_id")
    @Expose
    private Integer vehicableId;
    @SerializedName("vehicable_type")
    @Expose
    private String vehicableType;
    @SerializedName("main_vehicle_id")
    @Expose
    private Integer mainVehicleId;
    @SerializedName("is_new")
    @Expose
    private Integer isNew;
    @SerializedName("availability")
    @Expose
    private Integer availability;
    @SerializedName("one_image")
    @Expose
    private String oneImage;
    @SerializedName("main_vehicle")
    @Expose
    private MainVehicle mainVehicle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVehicableId() {
        return vehicableId;
    }

    public void setVehicableId(Integer vehicableId) {
        this.vehicableId = vehicableId;
    }

    public String getVehicableType() {
        return vehicableType;
    }

    public void setVehicableType(String vehicableType) {
        this.vehicableType = vehicableType;
    }

    public Integer getMainVehicleId() {
        return mainVehicleId;
    }

    public void setMainVehicleId(Integer mainVehicleId) {
        this.mainVehicleId = mainVehicleId;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public String getOneImage() {
        return oneImage;
    }

    public void setOneImage(String oneImage) {
        this.oneImage = oneImage;
    }

    public MainVehicle getMainVehicle() {
        return mainVehicle;
    }

    public void setMainVehicle(MainVehicle mainVehicle) {
        this.mainVehicle = mainVehicle;
    }
}
