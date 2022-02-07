package com.example.mowater.data.models.CarShowRoomDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Model implements Serializable {

    @SerializedName("car_model_id")
    @Expose
    private Integer carModelId;
    @SerializedName("car_class_id")
    @Expose
    private Integer carClassId;
    @SerializedName("car_model")
    @Expose
    private CarModel__1 carModel;
    @SerializedName("car_class")
    @Expose
    private CarClass__1 carClass;

    public Integer getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(Integer carModelId) {
        this.carModelId = carModelId;
    }

    public Integer getCarClassId() {
        return carClassId;
    }

    public void setCarClassId(Integer carClassId) {
        this.carClassId = carClassId;
    }

    public CarModel__1 getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel__1 carModel) {
        this.carModel = carModel;
    }

    public CarClass__1 getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass__1 carClass) {
        this.carClass = carClass;
    }
}
