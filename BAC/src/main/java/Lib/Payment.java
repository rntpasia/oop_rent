/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import java.time.LocalDate;

/**
 *
 * @author ranip
 */
public class Payment {
    private Car car;
    private Rent rent;
    private String name;
    private String phoneNum;
    private String payMethod;
    

    public Payment(String name, String phoneNum, String payMethod) {
        
        this.name = name;
        this.phoneNum = phoneNum;
        this.payMethod = payMethod;
    }
    
    public double computePrice(){
        long day = rent.getDayCount(LocalDate.MAX, LocalDate.MAX);
        double total = day * 600;
        return total;
    }

    public Car getCar() {
        return car;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
}
