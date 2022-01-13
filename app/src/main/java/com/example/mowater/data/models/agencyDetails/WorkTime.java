package com.example.mowater.data.models.agencyDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WorkTime {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("workable_type")
    @Expose
    private String workableType;
    @SerializedName("workable_id")
    @Expose
    private Integer workableId;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("days")
    @Expose
    private List<String> days = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkableType() {
        return workableType;
    }

    public void setWorkableType(String workableType) {
        this.workableType = workableType;
    }

    public Integer getWorkableId() {
        return workableId;
    }

    public void setWorkableId(Integer workableId) {
        this.workableId = workableId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }
}
