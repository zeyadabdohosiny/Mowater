package com.example.mowater.data.models.agencyDetails;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
@Keep
public class Data implements Serializable  {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("brand_id")
    @Expose
    private Integer brandId;
    @SerializedName("tax_number")
    @Expose
    private String taxNumber;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("reservation_availability")
    @Expose
    private Integer reservationAvailability;
    @SerializedName("delivery_availability")
    @Expose
    private Integer deliveryAvailability;
    @SerializedName("reservation_active")
    @Expose
    private Integer reservationActive;
    @SerializedName("delivery_active")
    @Expose
    private Integer deliveryActive;
    @SerializedName("country_id")
    @Expose
    private Integer countryId;
    @SerializedName("city_id")
    @Expose
    private Integer cityId;
    @SerializedName("area_id")
    @Expose
    private Integer areaId;
    @SerializedName("year_founded")
    @Expose
    private String yearFounded;
    @SerializedName("car_models")
    @Expose
    private List<CarModel> carModels = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("rating_count")
    @Expose
    private Integer ratingCount;
    @SerializedName("is_reviewed")
    @Expose
    private Boolean isReviewed;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("area")
    @Expose
    private Area area;
    @SerializedName("work_time")
    @Expose
    private WorkTime workTime;
    @SerializedName("services")
    @Expose
    private List<Object> services = null;
    @SerializedName("contact")
    @Expose
    private Object contact;
    @SerializedName("products")
    @Expose
    private List<Object> products = null;
    @SerializedName("reviews")
    @Expose
    private List<Object> reviews = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getReservationAvailability() {
        return reservationAvailability;
    }

    public void setReservationAvailability(Integer reservationAvailability) {
        this.reservationAvailability = reservationAvailability;
    }

    public Integer getDeliveryAvailability() {
        return deliveryAvailability;
    }

    public void setDeliveryAvailability(Integer deliveryAvailability) {
        this.deliveryAvailability = deliveryAvailability;
    }

    public Integer getReservationActive() {
        return reservationActive;
    }

    public void setReservationActive(Integer reservationActive) {
        this.reservationActive = reservationActive;
    }

    public Integer getDeliveryActive() {
        return deliveryActive;
    }

    public void setDeliveryActive(Integer deliveryActive) {
        this.deliveryActive = deliveryActive;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(String yearFounded) {
        this.yearFounded = yearFounded;
    }

    public List<CarModel> getCarModels() {
        return carModels;
    }

    public void setCarModels(List<CarModel> carModels) {
        this.carModels = carModels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Boolean getIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(Boolean isReviewed) {
        this.isReviewed = isReviewed;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public WorkTime getWorkTime() {
        return workTime;
    }

    public void setWorkTime(WorkTime workTime) {
        this.workTime = workTime;
    }

    public List<Object> getServices() {
        return services;
    }

    public void setServices(List<Object> services) {
        this.services = services;
    }

    public Object getContact() {
        return contact;
    }

    public void setContact(Object contact) {
        this.contact = contact;
    }

    public List<Object> getProducts() {
        return products;
    }

    public void setProducts(List<Object> products) {
        this.products = products;
    }

    public List<Object> getReviews() {
        return reviews;
    }

    public void setReviews(List<Object> reviews) {
        this.reviews = reviews;
    }
}
