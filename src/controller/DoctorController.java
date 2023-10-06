package controller;

import java.util.HashMap;
import model.Doctor;
import repository.DoctorRepository;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class DoctorController extends Menu<Doctor>{
    static String[] mc = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};
    Doctor doctor;
    DoctorRepository repo;
    HashMap<String, Doctor> dMap;
    
    public DoctorController(){
        super("Doctor Management", mc);
        doctor = new Doctor();
        repo = new DoctorRepository();
        dMap = new HashMap<>();
    }

    @Override
    public void execute(int choice) {
        switch (choice){
            case 1:
                System.out.println("--------- Add Doctor ----------");
                repo.addDoctor(dMap, doctor);
                break;
            case 2:
                System.out.println("--------- Update Doctor -------");
                repo.updateDoctor(dMap, doctor);
                break;
            case 3:
                System.out.println("--------- Delete Doctor -------");
                repo.deleteDoctor(dMap, doctor);
                break;
            case 4:
                System.out.println("-------------------- Search Doctor --------------------");
                repo.searchDoctor(dMap);
                break;
            case 5:
                System.out.println("Exit.");
                System.exit(0);
            default:
                System.out.println("Choose again.");
                break;
        }
    }
}
