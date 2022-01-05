package com.example.mowater.data.models.SpecialNumbers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Datum  implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("special_number_category_id")
    @Expose
    private Integer specialNumberCategoryId;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("transfer_type")
    @Expose
    private String transferType;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("Include_insurance")
    @Expose
    private Integer includeInsurance;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("special_number_organization_id")
    @Expose
    private Integer specialNumberOrganizationId;
    @SerializedName("rate")
    @Expose
    private Integer rate;
    @SerializedName("special_number_category")
    @Expose
    private SpecialNumberCategory specialNumberCategory;
    @SerializedName("special_number_organization")
    @Expose
    private SpecialNumberOrganization specialNumberOrganization;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("reviews")
    @Expose
    private List<Object> reviews = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpecialNumberCategoryId() {
        return specialNumberCategoryId;
    }

    public void setSpecialNumberCategoryId(Integer specialNumberCategoryId) {
        this.specialNumberCategoryId = specialNumberCategoryId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIncludeInsurance() {
        return includeInsurance;
    }

    public void setIncludeInsurance(Integer includeInsurance) {
        this.includeInsurance = includeInsurance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSpecialNumberOrganizationId() {
        return specialNumberOrganizationId;
    }

    public void setSpecialNumberOrganizationId(Integer specialNumberOrganizationId) {
        this.specialNumberOrganizationId = specialNumberOrganizationId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public SpecialNumberCategory getSpecialNumberCategory() {
        return specialNumberCategory;
    }

    public void setSpecialNumberCategory(SpecialNumberCategory specialNumberCategory) {
        this.specialNumberCategory = specialNumberCategory;
    }

    public SpecialNumberOrganization getSpecialNumberOrganization() {
        return specialNumberOrganization;
    }

    public void setSpecialNumberOrganization(SpecialNumberOrganization specialNumberOrganization) {
        this.specialNumberOrganization = specialNumberOrganization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Object> getReviews() {
        return reviews;
    }

    public void setReviews(List<Object> reviews) {
        this.reviews = reviews;
    }
}
