package uk.ac.hope.mcse.segh.servermanagement.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import oshi.hardware.GlobalMemory;

import java.math.BigInteger;

@Document(collection = "HardwareReadings")
public class HardwareReading {

    @Id

    private BigInteger _id;

    private String dateTime;

    private String cpu;

    private String ram;


    public BigInteger get_id() {
        return _id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }


}