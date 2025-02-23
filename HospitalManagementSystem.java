import java.util.*;

public class HospitalManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Patient> patients = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();
    private static List<Billing> bills = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View Electronic Health Records");
            System.out.println("4. Manage Billing");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    scheduleAppointment();
                    break;
                case 3:
                    viewEHR();
                    break;
                case 4:
                    manageBilling();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contact = scanner.nextLine();

        Patient patient = new Patient(name, age, contact);
        patients.add(patient);
        System.out.println("Patient registered successfully.");
    }

    private static void scheduleAppointment() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter doctor name: ");
        String doctor = scanner.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Appointment appointment = new Appointment(name, doctor, date);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully.");
    }

    private static void viewEHR() {
        System.out.println("Displaying all patient records:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void manageBilling() {
        System.out.println("1. Add Bill");
        System.out.println("2. View Bills");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter patient name: ");
                String name = scanner.nextLine();
                System.out.print("Enter total bill amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                Billing bill = new Billing(name, amount);
                bills.add(bill);
                System.out.println("Bill added successfully.");
                break;
            case 2:
                System.out.println("Billing Records:");
                for (Billing b : bills) {
                    System.out.println(b);
                }
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}

class Patient {
    private String name;
    private int age;
    private String contact;

    public Patient(String name, int age, String contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', age=" + age + ", contact='" + contact + "'}";
    }
}

class Appointment {
    private String patientName;
    private String doctorName;
    private String date;

    public Appointment(String patientName, String doctorName, String date) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{patient='" + patientName + "', doctor='" + doctorName + "', date='" + date + "'}";
    }
}

class Billing {
    private String patientName;
    private double totalAmount;

    public Billing(String patientName, double totalAmount) {
        this.patientName = patientName;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Billing{patient='" + patientName + "', totalAmount=" + totalAmount + "}";
    }
}