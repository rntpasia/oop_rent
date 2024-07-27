/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author ranip
 */
public class Rent {
    private String plateNum;
    private LocalDate startDate;
    private LocalDate lastDate;
    private Car car;
    private long count;
    

    public Rent(Car car, LocalDate start, LocalDate end) {
        this.plateNum = "1" + start.format(DateTimeFormatter.ofPattern("MMddyy")) + car.getPlateNum();
        this.car = car;
        this.startDate = start;
        this.lastDate = end;
    }
    
    public long getDayCount(LocalDate startDate,LocalDate lastDate){
        return ChronoUnit.DAYS.between(startDate, lastDate);}

    public boolean isAvailable() {
        return startDate == null;
    }
  
    public Period getRentalPeriod() {
        return isAvailable() ? null : Period.between(startDate, lastDate);
    }
    
    public Car getCar() {
        return car;
    }
    
    public String getPlateNum() {
        return plateNum;
    }

    
    public LocalDate getStartDate() {
        return startDate;
    }
   
    public LocalDate getLastDate() {
        return lastDate;
    }
}
