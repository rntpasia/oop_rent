/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Lib;

/**
 *
 * @author anyadanielle
 */
public interface ICar {
     Car createCar(String plateNum, String brand, String model, String description, String transmission, double price);
     double additionalPrice();
}
