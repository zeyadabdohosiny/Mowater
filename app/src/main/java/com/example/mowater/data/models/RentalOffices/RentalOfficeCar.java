package com.example.mowater.data.models.RentalOffices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RentalOfficeCar implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("rental_office_id")
    @Expose
    private Integer rentalOfficeId;
    @SerializedName("car_model_id")
    @Expose
    private Integer carModelId;
    @SerializedName("car_class_id")
    @Expose
    private Integer carClassId;
    @SerializedName("manufacture_year")
    @Expose
    private String manufactureYear;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("daily_rental_price")
    @Expose
    private Integer dailyRentalPrice;
    @SerializedName("weekly_rental_price")
    @Expose
    private Integer weeklyRentalPrice;
    @SerializedName("monthly_rental_price")
    @Expose
    private Integer monthlyRentalPrice;
    @SerializedName("yearly_rental_price")
    @Expose
    private Integer yearlyRentalPrice;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("car_model")
    @Expose
    private CarModel carModel;
    @SerializedName("car_class")
    @Expose
    private CarClass carClass;

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

    public String getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(String manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(Integer dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }

    public Integer getWeeklyRentalPrice() {
        return weeklyRentalPrice;
    }

    public void setWeeklyRentalPrice(Integer weeklyRentalPrice) {
        this.weeklyRentalPrice = weeklyRentalPrice;
    }

    public Integer getMonthlyRentalPrice() {
        return monthlyRentalPrice;
    }

    public void setMonthlyRentalPrice(Integer monthlyRentalPrice) {
        this.monthlyRentalPrice = monthlyRentalPrice;
    }

    public Integer getYearlyRentalPrice() {
        return yearlyRentalPrice;
    }

    public void setYearlyRentalPrice(Integer yearlyRentalPrice) {
        this.yearlyRentalPrice = yearlyRentalPrice;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }
}
