/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

/**
 *
 * @author ranip
 */
public class PayRecord {
    private Car car;
    private String name;
    private String phoneNum;
    private String payMethod;
    private Payment p;

    public PayRecord(Payment p) {
        this.car = p.getCar();
        this.name = p.getName();
        this.phoneNum = p.getPhoneNum();
        this.payMethod = p.getPayMethod();
    }

    public Car getCar() {
        return car;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public Payment getP() {
        return p;
    }
    
    
    
    
    
    
    
}
