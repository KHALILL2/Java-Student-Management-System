public class StudentManagementSystem {
    private Student[] students;
    private int studentCount;
    private static final int MAX_STUDENTS = 1000;

    public StudentManagementSystem() {
        this.students = new Student[MAX_STUDENTS];
        this.studentCount = 0;
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        if (findStudentById(student.getId()) != null) {
            throw new IllegalArgumentException("A student with this ID already exists.");
        }
        if (studentCount >= MAX_STUDENTS) {
            throw new IllegalArgumentException("System is full");
        }
        students[studentCount] = student;
        studentCount++;
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
        if (studentCount == 0) {
            System.out.println("No students registered yet.");
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.println("------------------------");
            students[i].displayStudentInfo();
        }
        System.out.println("------------------------");
    }

    public void calculateHighestGPA() {
        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }

        Student topStudent = null;
        double highestGPA = -1;

        for (int i = 0; i < studentCount; i++) {
            double gpa = students[i].calculateGPA();
            if (gpa > highestGPA) {
                highestGPA = gpa;
                topStudent = students[i];
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
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    public boolean removeStudent(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null;
                studentCount--;
                return true;
            }
        }
        return false;
    }

    public Student getTopGPAStudent() {
        if (studentCount == 0) {
            return null;
        }
        Student top = students[0];
        for (int i = 1; i < studentCount; i++) {
            if (students[i].calculateGPA() > top.calculateGPA()) {
                top = students[i];
            }
        }
        return top;
    }

    public Student[] getAllStudents() {
        Student[] result = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            result[i] = students[i];
        }
        return result;
    }
}
