package com.example.mowater.data.models.Sections;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubSection {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ref_name")
    @Expose
    private String refName;
    @SerializedName("section_id")
    @Expose
    private Integer sectionId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slider")
    @Expose
    private Slider slider;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Slider getSlider() {
        return slider;
    }

    public void setSlider(Slider slider) {
        this.slider = slider;
    }
}
