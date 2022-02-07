package com.example.mowater.data.models.RentalOffices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pivot implements Serializable {

    @SerializedName("model_id")
    @Expose
    private Integer modelId;
    @SerializedName("payment_method_id")
    @Expose
    private Integer paymentMethodId;
    @SerializedName("model_type")
    @Expose
    private String modelType;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }
}
