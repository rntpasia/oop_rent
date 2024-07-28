/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

/**
 *
 * @author anyadanielle
 */
public class AutoCarFactory implements ICar{
    @Override
    public Car createCar(String plateNum, String brand, String model, String description, double price) {
        double newPrice = additionalPrice() + price;
        return new Car(plateNum, brand, model, description, newPrice);
    }
    @Override
    public double additionalPrice(){
        return 500.00;
    }
}
