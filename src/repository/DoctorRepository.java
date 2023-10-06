package repository;

import dataAccess.DoctorDao;
import java.util.HashMap;
import java.util.Set;
import model.Doctor;

/**
 *
 * @author ASUS
 */
public class DoctorRepository implements IDoctor {

    @Override
    public void addDoctor(HashMap<String, Doctor> dMap, Doctor doctor) {
        if (DoctorDao.Instance().addDoctor(dMap, doctor)) {
            System.out.println("Add success.");
        } else {
            System.out.println("Doctor code already exist");
        }
    }

    @Override
    public void updateDoctor(HashMap<String, Doctor> dMap, Doctor doctor) {
        if (dMap.isEmpty()) {
            System.out.println("No data.");
            return;
        }
        view(dMap);
        if (DoctorDao.Instance().updateDoctor(dMap, doctor)) {
            System.out.println("Update success.");
        } else {
            System.out.println("Doctor code does not exist");
        }
    }

    @Override
    public void deleteDoctor(HashMap<String, Doctor> dMap, Doctor doctor) {
        if (dMap.isEmpty()) {
            System.out.println("No data.");
            return;
        }
        view(dMap);
        if (DoctorDao.Instance().deleteDoctor(dMap, doctor)) {
            System.out.println("Delete success.");
        } else {
            System.out.println("Doctor code does not exist");
        }
    }

    @Override
    public void searchDoctor(HashMap<String, Doctor> dMap) {
        if (dMap.isEmpty()) {
            System.out.println("No data.");
            return;
        }
        HashMap<String, Doctor> search = DoctorDao.Instance().searchDoctor(dMap);
        view(search);
    }
    
    @Override
    public void view(HashMap<String, Doctor> dMap){
        Set<String> code = dMap.keySet();
        System.out.printf("%-10s%-20s%-20s%-20s\n", "Code", "Name", "Specialization", "Availability");
        for (String key : code){
            System.out.printf("%-10s%-20s%-20s%-20d\n", dMap.get(key).getCode(),
                                                            dMap.get(key).getName(),
                                                            dMap.get(key).getSpecialization(),
                                                            dMap.get(key).getAvailability());
        }
    }
}
