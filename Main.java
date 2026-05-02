import java.util.Scanner;

public class Main {
    // One shared scanner for the full app lifecycle.
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        boolean running = true;

        // Main loop: keep running until user chooses Exit.
        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            try {
                switch (choice) {
                    case 1:
                        addStudentFlow(system);
                        break;
                    case 2:
                        addSubjectFlow(system);
                        break;
                    case 3:
                        displayStudentFlow(system);
                        break;
                    case 4:
                        calculateGPAFlow(system);
                        break;
                    case 5:
                        system.displayAllStudents();
                        break;
                    case 8:
                        system.calculateHighestGPA();
                        break;
                    case 9:
                        convertGradeFlow(system);
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting Student Management System...");
                        break;
                    default:
                        System.out.println("Invalid option. Please select a valid menu choice.");
                }
            } catch (IllegalArgumentException ex) {
                // Validation and business-rule errors end up here.
                System.out.println("Error: " + ex.getMessage());
            } catch (Exception ex) {
                // Safety net to keep menu alive on unexpected cases.
                System.out.println("Unexpected error occurred: " + ex.getMessage());
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. Add Subject");
        System.out.println("3. Display Info");
        System.out.println("4. Calculate GPA");
        System.out.println("5. Display All");
        System.out.println("8. Calculate Highest GPA");
        System.out.println("9. Convert Grade");
        System.out.println("0. Exit");
    }

    private static void addStudentFlow(StudentManagementSystem system) {
        int id = readInt("Enter student ID (positive integer): ");
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }

        String name = readNonEmptyString("Enter student name: ");
        String major = readNonEmptyString("Enter student major: ");

        Student student = new Student(id, name, major);
        system.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void addSubjectFlow(StudentManagementSystem system) {
        int studentId = readInt("Enter student ID to assign subject: ");
        if (studentId <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }

        if (system.findStudentById(studentId) == null) {
            throw new IllegalArgumentException("Student ID does not exist.");
        }

        String subjectName = readNonEmptyString("Enter subject name: ");
        int creditHours = readInt("Enter credit hours (>0): ");
        if (creditHours <= 0) {
            throw new IllegalArgumentException("Credit hours must be greater than 0.");
        }

        double grade = readDouble("Enter grade (0-100): ");
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }

        Subject subject = new Subject(subjectName, creditHours, grade);
        system.assignSubjectToStudent(studentId, subject);
        System.out.println("Subject assigned successfully.");
    }

    private static void displayStudentFlow(StudentManagementSystem system) {
        int studentId = readInt("Enter student ID to display: ");
        if (studentId <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }

        if (system.findStudentById(studentId) == null) {
            throw new IllegalArgumentException("Student ID does not exist.");
        }

        system.displayStudentInfo(studentId);
    }

    private static void calculateGPAFlow(StudentManagementSystem system) {
        int studentId = readInt("Enter student ID to calculate GPA: ");
        if (studentId <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }

        if (system.findStudentById(studentId) == null) {
            throw new IllegalArgumentException("Student ID does not exist.");
        }

        double gpa = system.calculateStudentGPA(studentId);
        System.out.printf("Student GPA: %.2f%n", gpa);
    }

    private static void convertGradeFlow(StudentManagementSystem system) {
        double grade = readDouble("Enter numeric grade (0-100): ");
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }

        String letter = system.convertToLetterGrade(grade);
        System.out.println("Letter Grade: " + letter);
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // Keep asking until valid integer is entered.
                System.out.println("Invalid integer. Please try again.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                // Keep asking until valid decimal is entered.
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }
}
