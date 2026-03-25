import java.util.ArrayList;

public class StudentManagementSystem {
    // Central storage for all registered students.
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        if (findStudentById(student.getId()) != null) {
            throw new IllegalArgumentException("A student with this ID already exists.");
        }
        students.add(student);
    }

    public void assignSubjectToStudent(int studentId, Subject subject) {
        Student student = findStudentById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student ID not found.");
        }
        student.addSubject(subject);
    }

    public double calculateStudentGPA(int studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student ID not found.");
        }
        return student.calculateGPA();
    }

    public void displayStudentInfo(int studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student ID not found.");
        }
        student.displayStudentInfo();
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }

        for (Student student : students) {
            System.out.println("------------------------");
            student.displayStudentInfo();
        }
        System.out.println("------------------------");
    }

    public void calculateHighestGPA() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        // Track best performer while scanning once through the list.
        Student topStudent = null;
        double highestGPA = -1;

        for (Student student : students) {
            double gpa = student.calculateGPA();
            if (gpa > highestGPA) {
                highestGPA = gpa;
                topStudent = student;
            }
        }

        if (topStudent != null) {
            System.out.printf("Highest GPA Student -> Name: %s, ID: %d, GPA: %.2f%n",
                    topStudent.getName(), topStudent.getId(), highestGPA);
        }
    }

    public String convertToLetterGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }

        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        }
        return "F";
    }

    public Student findStudentById(int id) {
        // Linear lookup is enough for current project size.
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
