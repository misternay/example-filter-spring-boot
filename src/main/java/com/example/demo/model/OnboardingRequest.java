package com.example.demo.model;

public class OnboardingRequest {
    private String mobileNo;
    private String citizenNo;

    public OnboardingRequest() {
    }

    public OnboardingRequest(String mobileNo, String citizenNo) {
        this.mobileNo = mobileNo;
        this.citizenNo = citizenNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCitizenNo() {
        return citizenNo;
    }

    public void setCitizenNo(String citizenNo) {
        this.citizenNo = citizenNo;
    }
}
