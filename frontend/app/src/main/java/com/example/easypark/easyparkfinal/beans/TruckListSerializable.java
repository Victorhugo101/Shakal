package com.example.easypark.easyparkfinal.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Renilson Albuquerque on 22/11/2018.
 */

public class TruckListSerializable implements Serializable {

    public List<Truck> truckList;

    public TruckListSerializable(List<Truck> trucks){
        this.truckList = trucks;
    }
}
