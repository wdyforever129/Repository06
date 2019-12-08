package com.evan.entity;

import java.util.List;

public class DataBase {
    private List format;
    private String opr;
    private List result;
    private String triple;

    public List getFormat() {
        return format;
    }

    public void setFormat(List format) {
        this.format = format;
    }

    public String getOpr() {
        return opr;
    }

    public void setOpr(String opr) {
        this.opr = opr;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public String getTriple() {
        return triple;
    }

    public void setTriple(String triple) {
        this.triple = triple;
    }

    @Override
    public String toString() {
        return "OprData{" +
                "format=" + format +
                ", opr='" + opr + '\'' +
                ", result=" + result +
                ", triple='" + triple + '\'' +
                '}';
    }
}
