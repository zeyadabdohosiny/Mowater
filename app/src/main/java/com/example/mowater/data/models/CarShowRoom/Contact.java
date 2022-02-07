package com.example.mowater.data.models.CarShowRoom;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("contactable_type")
    @Expose
    private String contactableType;
    @SerializedName("contactable_id")
    @Expose
    private Integer contactableId;
    @SerializedName("facebook_link")
    @Expose
    private String facebookLink;
    @SerializedName("whatsapp_number")
    @Expose
    private String whatsappNumber;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("instagram_link")
    @Expose
    private String instagramLink;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactableType() {
        return contactableType;
    }

    public void setContactableType(String contactableType) {
        this.contactableType = contactableType;
    }

    public Integer getContactableId() {
        return contactableId;
    }

    public void setContactableId(Integer contactableId) {
        this.contactableId = contactableId;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }
}
