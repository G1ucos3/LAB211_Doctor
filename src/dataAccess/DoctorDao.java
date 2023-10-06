package dataAccess;

import common.Validate;
import java.util.HashMap;
import java.util.Set;
import model.Doctor;

/**
 *
 * @author ASUS
 */
public class DoctorDao {

    private static DoctorDao instance = null;
    private Validate validate = new Validate();

    public static DoctorDao Instance() {
        if (instance == null) {
            synchronized (DoctorDao.class) {
                if (instance == null) {
                    instance = new DoctorDao();
                }
            }
        }
        return instance;
    }

    public boolean addDoctor(HashMap<String, Doctor> dMap, Doctor doctor) {
        String code = validate.checkStringAdd("Enter Code");
        if (!validate.checkCode(dMap, code)) {
            return false;
        }
        String name = validate.checkStringAdd("Enter Name");
        String specialization = validate.checkStringAdd("Enter Specialiaztion");
        int availability = validate.checkInt("Enter Availability");
        doctor = new Doctor(code, name, specialization, availability);
        dMap.put(code, doctor);
        return true;
    }

    public boolean updateDoctor(HashMap<String, Doctor> dMap, Doctor doctor) {
        String code = validate.checkStringAdd("Enter Code");
        if (validate.checkCode(dMap, code)) {
            return false;
        }
        String name = validate.checkStringUpdate("Enter Name (leave blank to not change)");
        if (!validate.checkBlank(name)) {
            dMap.get(code).setName(name);
        }
        String specialization = validate.checkStringUpdate("Enter Specialization (leave blank to not change)");
        if (!validate.checkBlank(specialization)) {
            dMap.get(code).setSpecialization(specialization);
        }
        int availability = validate.checkInt("Enter Availability");
        dMap.get(code).setAvailability(availability);
        return true;
    }

    public boolean deleteDoctor(HashMap<String, Doctor> dMap, Doctor doctor) {
        String code = validate.checkStringAdd("Enter Code");
        if (validate.checkCode(dMap, code)) {
            return false;
        }
        dMap.remove(code);
        return true;
    }

    public HashMap<String, Doctor> searchDoctor(HashMap<String, Doctor> dMap) {
        HashMap<String, Doctor> search = new HashMap<>();
        Set<String> code = dMap.keySet();
        String name = validate.checkStringAdd("Enter Name");
        for (String key : code) {
            if (dMap.get(key).getName().toLowerCase().contains(name.toLowerCase())) {
                search.put(dMap.get(key).getCode(), dMap.get(key));
            }
        }
        return search;
    }

}
