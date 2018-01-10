package com.zhangruiqiang.madeCsv.entity;

public class Hk {
    private String platformNo;
    private String projectNo;
    private String idCardType;
    private String idCardNo;
    private String repaymentTime;
    private String amount;
    private String interestAmount;
    private String subjectNo;
    @FieldSort("1")
    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
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
    public String getRepaymentTime() {
        return repaymentTime;
    }

    public void setRepaymentTime(String repaymentTime) {
        this.repaymentTime = repaymentTime;
    }
    @FieldSort("6")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    @FieldSort("7")
    public String getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(String interestAmount) {
        this.interestAmount = interestAmount;
    }
    @FieldSort("8")
    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    @Override
    public String toString() {
        return "Hk{" +
                "platformNo='" + platformNo + '\'' +
                ", projectNo='" + projectNo + '\'' +
                ", idCardType='" + idCardType + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", repaymentTime='" + repaymentTime + '\'' +
                ", amount='" + amount + '\'' +
                ", interestAmount='" + interestAmount + '\'' +
                ", subjectNo='" + subjectNo + '\'' +
                '}';
    }
}
