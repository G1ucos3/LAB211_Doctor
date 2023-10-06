package repository;

import java.util.HashMap;
import model.Doctor;

/**
 *
 * @author ASUS
 */
public interface IDoctor {

    public void addDoctor(HashMap<String, Doctor> dMap, Doctor doctor);

    public void updateDoctor(HashMap<String, Doctor> dMap, Doctor doctor);

    public void deleteDoctor(HashMap<String, Doctor> dMap, Doctor doctor);

    public void searchDoctor(HashMap<String, Doctor> dMap);
    
    public void view(HashMap<String, Doctor> dMap);
}
