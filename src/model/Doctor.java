package model;

import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class Doctor {

    private String code;
    private String name;
    private String specialization;
    private int Availability;
    
    private HashMap<String, Doctor> dMap = new HashMap<>();

    public Doctor() {
    }

    public Doctor(String code, String name, String specialization, int Availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.Availability = Availability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int Availability) {
        this.Availability = Availability;
    }

    public HashMap<String, Doctor> getdMap() {
        return dMap;
    }

    public void setdMap(HashMap<String, Doctor> dMap) {
        this.dMap = dMap;
    }
    
}
