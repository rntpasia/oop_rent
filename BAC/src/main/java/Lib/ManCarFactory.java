/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

/**
 *
 * @author anyadanielle
 */
public class ManCarFactory implements ICar{
    @Override
    public Car createCar(String plateNum, String brand, String model, String description, double price) {
        return new Car(plateNum, brand, model, description, price);
    }
    @Override
    public double additionalPrice(){
        return 0.00;
    }
}
