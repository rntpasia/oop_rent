/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ranip
 */
public class RentOps {
    
    private String filename = "rentals.txt";
    private static RentOps instance;

    
    public ArrayList<Rent> rent;
    public RentOps() {
        rent = new ArrayList<>();
    }

   
    public static RentOps getInstance(FleetInventory carInventory) {
        if (instance == null) {
            instance = new RentOps();
            instance.fetchFromDisk(carInventory);
        }
        return instance;
    }

   
    public boolean isCarAvailable(Car car, LocalDate startDate, LocalDate lastDate) {
        if (car == null) {
            return false;
        }
        for (Rent r : rent) {
            if ((r.getCar().getPlateNum() == null ? car.getPlateNum() == null : r.getCar().getPlateNum().equals(car.getPlateNum()))
                    && (startDate.isBefore(r.getLastDate()) && lastDate.isAfter(r.getStartDate()))) {
                return false;
            }
        }
        return true;
    }

    
    public ArrayList<RentRecord> generateRecord() {
        var newList = new ArrayList<RentRecord>(); // create new arraylist so rentals cannot be modified directly
        for (Rent r : rent) {
            newList.add(new RentRecord(r));
        }
        return newList;
    }

    
    public boolean isAvailableNow(Car car) {
        if (car == null) {
            return false;
        }
        for (Rent r : rent) {
            if ((r.getCar().getPlateNum() == null ? car.getPlateNum() == null : r.getCar().getPlateNum().equals(car.getPlateNum()))
                    && ((LocalDate.now().isBefore(r.getLastDate()) || LocalDate.now().isEqual(r.getLastDate()))
                    && (LocalDate.now().isAfter(r.getStartDate()) || LocalDate.now().isEqual(r.getStartDate())))) {
                return false;
            }
        }
        return true;
    }

    
    public boolean RentCar(Car car, LocalDate startDate, LocalDate lastDate) {
        if (isCarAvailable(car, startDate, lastDate)) {
            Rent r = new Rent(car, startDate, lastDate);
            System.out.println("Added rental");
            rent.add(r);
            return true;
        }
        return false;
    }

    
    public boolean RemoveRental(Rent rental) {
        for (Rent r : rent) {
            if (r.getPlateNum() == null ? r.getPlateNum() == null : r.getPlateNum().equals(r.getPlateNum())) {
                rent.remove(r);
                return true;
            }
        }
        return false;
    }

    
    public Rent getRentalByPlateNum(String plateNum) {
        for (Rent r : rent) {
            if (r.getPlateNum() == null ? plateNum == null : r.getPlateNum().equals(plateNum)) {
                return r;
            }
        }
        return null;
    }

    public int getTimesRented(Car car) {
        int times = 0;
        for (Rent r : rent) {
            if (r.getCar().getPlateNum() == null ? car.getPlateNum() == null : r.getCar().getPlateNum().equals(car.getPlateNum())) {
                times++;
            }
        }
        return times;
    }

    
    public void fetchFromDisk(FleetInventory f) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while (reader.ready()) {
                String text = reader.readLine();
                String[] lineComponents = text.split("###");
                try {
                    Car car = f.getCarByPlateNum(lineComponents[2]);
                    if (car == null) {
                        return;
                    }
                    rent.add(new Rent(car, LocalDate
                            .parse(lineComponents[0]),
                            LocalDate.parse(lineComponents[1])
                    )
                    );
                } catch (Exception e) {
                }

            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("An exception has occurred while reading " + filename);
        }
    }

    
    public void saveToDisk() {
        try {
            try (FileWriter fileWriter = new FileWriter(filename)) {
                StringBuilder toWrite = new StringBuilder();
                for (Rent r : rent) {
                    toWrite.append(r.getStartDate().toString())
                            .append("###")
                            .append(r.getLastDate().toString())
                            .append("###")
                            .append(r.getPlateNum()).append("\n");
                }
                fileWriter.write(toWrite.toString());
            }
        } catch (IOException e) {
            System.out.println("An exception has occured while saving to disk.");
        }
    }
}
