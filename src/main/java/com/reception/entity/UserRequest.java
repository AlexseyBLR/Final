package com.reception.entity;

import java.util.Objects;

public class ResultForRequest {

    private String FIO;
    private int mathResult;
    private int physResult;
    private int langResult;
    private int sertResult;
    private String facSpec;
    private String status;

    public ResultForRequest(String FIO, int mathResult, int physResult, int langResult, int sertResult, String facSpec){
        this.FIO = FIO;
        this.mathResult = mathResult;
        this.physResult = physResult;
        this.langResult = langResult;
        this.sertResult = sertResult;
        this.facSpec = facSpec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getMathResult() {
        return mathResult;
    }

    public void setMathResult(int mathResult) {
        this.mathResult = mathResult;
    }

    public int getPhysResult() {
        return physResult;
    }

    public void setPhysResult(int physResult) {
        this.physResult = physResult;
    }

    public int getLangResult() {
        return langResult;
    }

    public void setLangResult(int langResult) {
        this.langResult = langResult;
    }

    public int getSertResult() {
        return sertResult;
    }

    public void setSertResult(int sertResult) {
        this.sertResult = sertResult;
    }

    public String getFacSpec() {
        return facSpec;
    }

    public void setFacSpec(String facSpec) {
        this.facSpec = facSpec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultForRequest)) return false;
        ResultForRequest that = (ResultForRequest) o;
        return getMathResult() == that.getMathResult() &&
                getPhysResult() == that.getPhysResult() &&
                getLangResult() == that.getLangResult() &&
                getSertResult() == that.getSertResult() &&
                Objects.equals(getFIO(), that.getFIO()) &&
                Objects.equals(getFacSpec(), that.getFacSpec()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFIO(), getMathResult(), getPhysResult(), getLangResult(), getSertResult(), getFacSpec(), getStatus());
    }

    @Override
    public String toString() {
        return "ResultForRequest{" +
                "FIO='" + FIO + '\'' +
                ", mathResult=" + mathResult +
                ", physResult=" + physResult +
                ", langResult=" + langResult +
                ", sertResult=" + sertResult +
                ", facSpec='" + facSpec + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
