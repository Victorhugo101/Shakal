package com.example.easypark.easyparkfinal.beans;

import java.io.Serializable;
import java.util.List;


public class TruckListSerializable implements Serializable {

    public List<Truck> truckList;

    public TruckListSerializable(List<Truck> trucks){
        this.truckList = trucks;
    }
}
