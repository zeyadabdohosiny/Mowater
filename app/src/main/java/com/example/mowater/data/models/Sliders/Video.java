package com.example.mowater.data.models.Sliders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Video {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("section_id")
    @Expose
    private Object sectionId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("files")
    @Expose
    private List<File> files = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getSectionId() {
        return sectionId;
    }

    public void setSectionId(Object sectionId) {
        this.sectionId = sectionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
