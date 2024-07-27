/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author ranip
 */
public class Car {
    private String plateNum;
    private String description;
    private String brand;
    private String model;
    private double price;
    

    public Car(String plateNum, String brand, String model, String description, double price) {
        this.plateNum = generateRandomPlateNumber();
        this.description = description;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    
     private static String generateRandomPlateNumber() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 3; i++) {
            char randomChar = (char) (r.nextInt(26) + 'A');
            sb.append(randomChar);
        }
        
        for (int i = 0; i < 3; i++) {
            sb.append(r.nextInt(10));
        }
        return sb.toString();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }


   
    
}
