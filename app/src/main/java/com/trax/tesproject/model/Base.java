package com.trax.tesproject.model;

import com.google.gson.annotations.SerializedName;

public class Base {

//    @SerializedName("statusCode")
//    private int statuscode;
//
//    @SerializedName("message")
//    private String message;
//
//    @SerializedName("errorMessage")
//    private String error;
//
//    @SerializedName("data")
//    private data data;
private float statusCode;
    private String message;
    private String errorMessage = null;
    Data DataObject;


    // Getter Methods

    public float getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Data getData() {
        return DataObject;
    }

    // Setter Methods

    public void setStatusCode(float statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setData(Data dataObject) {
        this.DataObject = dataObject;
    }

}
