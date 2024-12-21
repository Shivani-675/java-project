import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String gender;
    private String illness;

    public Patient(String name, int age, String gender, String illness) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.illness = illness;
    }

    public void displayInfo() {
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Illness: " + illness);
        System.out.println("=====X======X=====X=====X=====");
    }
}

public class HospitalManagementSystem {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Hospital Management System");
            System.out.println("1. Register Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    displayPatients();
                    break;
                case 3:
                    System.out.println("GOOD BYE...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter patient gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter patient illness: ");
        String illness = scanner.nextLine();

        Patient newPatient = new Patient(name, age, gender, illness);
        patients.add(newPatient);
        System.out.println("Patient registered successfully!\n");
    }

    private static void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.\n");
        } else {
            System.out.println("Registered Patients:");
            for (Patient patient : patients) {
                patient.displayInfo();
            }
        }
    }
}
