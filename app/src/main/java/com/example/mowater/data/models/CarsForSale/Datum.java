package com.example.mowater.data.models.CarsForSale;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("availability")
    @Expose
    private Integer availability;
    @SerializedName("one_image")
    @Expose
    private String oneImage;
    @SerializedName("is_favorite")
    @Expose
    private Boolean isFavorite;
    @SerializedName("main_vehicle")
    @Expose
    private MainVehicle mainVehicle;
    @SerializedName("files")
    @Expose
    private List<File> files = null;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public MainVehicle getMainVehicle() {
        return mainVehicle;
    }

    public void setMainVehicle(MainVehicle mainVehicle) {
        this.mainVehicle = mainVehicle;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
