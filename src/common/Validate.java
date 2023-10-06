package common;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Doctor;

/**
 *
 * @author ASUS
 */
public class Validate {

    public String checkStringAdd(String s) {
        String str = "";
        while (checkBlank(str)) {
            Scanner sc = new Scanner(System.in);
            System.out.print(s + ": ");
            str = sc.nextLine();
        }
        return str.trim();
    }
    
    public String checkStringUpdate(String s){
        Scanner sc = new Scanner(System.in);
        System.out.print(s + ": ");
        String str = sc.nextLine();
        return str.trim();
    }
    
    public boolean checkBlank(String s){
        if(s.isBlank() || s.isEmpty()) return true;
        return false;
    }

    public boolean checkCode(HashMap<String, Doctor> dMap, String code) {
        if (dMap.containsKey(code)) {
            return false;
        }
        return true;
    }

    public int checkInt(String s) {
        int num;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(s + ": ");
                num = sc.nextInt();
                return num;
            } catch (InputMismatchException E) {
                System.err.print("Please input a number.");
            }
        }
    }
}
