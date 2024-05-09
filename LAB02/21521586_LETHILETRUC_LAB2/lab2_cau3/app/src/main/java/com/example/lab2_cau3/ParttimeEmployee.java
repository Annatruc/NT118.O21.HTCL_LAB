package com.example.lab2_cau3;

public class ParttimeEmployee extends Employee{

    public ParttimeEmployee(){};

    @Override
    public double TinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + " - PartTime=" + TinhLuong();
    }
}
