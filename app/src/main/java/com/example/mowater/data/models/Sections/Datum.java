package com.example.mowater.data.models.Sections;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ref_name")
    @Expose
    private String refName;
    @SerializedName("section_id")
    @Expose
    private Object sectionId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sub_sections")
    @Expose
    private List<SubSection> subSections = null;
    @SerializedName("slider")
    @Expose
    private Slider__1 slider;

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

    public Object getSectionId() {
        return sectionId;
    }

    public void setSectionId(Object sectionId) {
        this.sectionId = sectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubSection> getSubSections() {
        return subSections;
    }

    public void setSubSections(List<SubSection> subSections) {
        this.subSections = subSections;
    }

    public Slider__1 getSlider() {
        return slider;
    }

    public void setSlider(Slider__1 slider) {
        this.slider = slider;
    }
}
