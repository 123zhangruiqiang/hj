package com.zhangruiqiang.madeCsv.entity;

public class Bd {
    private String platformNo;
    private String projectNo;
    private String ProjectName;
    private String projectType;
    private String amount;
    private String repaymentWay;
    private String projectPeriod;
    private String expectedYield;
    private String totalLoanMoney;
    private String totalInvestment;
    private String LoanTime;
    private String subjectNo;
    //private String repaymentTimes;

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
    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }
    @FieldSort("4")
    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
    @FieldSort("5")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    @FieldSort("6")
    public String getRepaymentWay() {
        return repaymentWay;
    }

    public void setRepaymentWay(String repaymentWay) {
        this.repaymentWay = repaymentWay;
    }
    @FieldSort("7")
    public String getProjectPeriod() {
        return projectPeriod;
    }

    public void setProjectPeriod(String projectPeriod) {
        this.projectPeriod = projectPeriod;
    }
    @FieldSort("8")
    public String getExpectedYield() {
        return expectedYield;
    }

    public void setExpectedYield(String expectedYield) {
        this.expectedYield = expectedYield;
    }
    @FieldSort("9")
    public String getTotalLoanMoney() {
        return totalLoanMoney;
    }

    public void setTotalLoanMoney(String totalLoanMoney) {
        this.totalLoanMoney = totalLoanMoney;
    }
    @FieldSort("10")
    public String getTotalInvestment() {
        return totalInvestment;
    }

    public void setTotalInvestment(String totalInvestment) {
        this.totalInvestment = totalInvestment;
    }
    @FieldSort("11")
    public String getLoanTime() {
        return LoanTime;
    }



    public void setLoanTime(String loanTime) {
        LoanTime = loanTime;
    }
    @FieldSort("12")
    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }
    /*@FieldSort("12")
    public String getRepaymentTimes() {
        return repaymentTimes;
    }

    public void setRepaymentTimes(String repaymentTimes) {
        this.repaymentTimes = repaymentTimes;
    }*/

    @Override
    public String toString() {
        return "Bd{" +
                "platformNo='" + platformNo + '\'' +
                ", projectNo='" + projectNo + '\'' +
                ", ProjectName='" + ProjectName + '\'' +
                ", projectType='" + projectType + '\'' +
                ", amount='" + amount + '\'' +
                ", repaymentWay='" + repaymentWay + '\'' +
                ", projectPeriod='" + projectPeriod + '\'' +
                ", expectedYield='" + expectedYield + '\'' +
                ", totalLoanMoney='" + totalLoanMoney + '\'' +
                ", totalInvestment='" + totalInvestment + '\'' +
                ", LoanTime='" + LoanTime + '\'' +
                ", subjectNo='" + subjectNo + '\'' +
                '}';
    }
}
