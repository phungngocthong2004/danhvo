package com.example.lab5_ph40510.model;

public class school {
    private int hinh;
    private String tencs;

    public school() {
    }

    public school(int hinh, String tencs) {
        this.hinh = hinh;
        this.tencs = tencs;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTencs() {
        return tencs;
    }

    public void setTencs(String tencs) {
        this.tencs = tencs;
    }
}
