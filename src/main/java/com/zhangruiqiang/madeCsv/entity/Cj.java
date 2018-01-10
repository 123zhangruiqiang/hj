package com.zhangruiqiang.madeCsv.entity;

public class Cj {
    private String platformNo;
    private String projectNo;
    private String idCardType;
    private String idCardNo;
    private String investmentTime;
    private String amount;
    private String subjectNo;
    private String provience;
    private String city;
    private String district;

    @FieldSort("1")
    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String plaformNo) {
        this.platformNo = plaformNo;
    }
    @FieldSort("2")
    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }
    @FieldSort("3")
    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }
    @FieldSort("4")
    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }
    @FieldSort("5")
    public String getInvestmentTime() {
        return investmentTime;
    }

    public void setInvestmentTime(String investmentTime) {
        this.investmentTime = investmentTime;
    }
    @FieldSort("6")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    @FieldSort("7")
    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }
    @FieldSort("8")
    public String getProvience() {
        return provience;
    }

    public void setProvience(String provience) {
        this.provience = provience;
    }
    @FieldSort("9")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @FieldSort("10")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
