import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private String major;
    // Each student can have multiple subjects.
    private ArrayList<Subject> subjects;

    public Student(int id, String name, String major) {
        setId(id);
        setName(name);
        setMajor(major);
        this.subjects = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Student ID must be greater than 0.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.name = name.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (major == null || major.trim().isEmpty()) {
            throw new IllegalArgumentException("Major cannot be empty.");
        }
        this.major = major.trim();
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject s) {
        if (s == null) {
            throw new IllegalArgumentException("Subject cannot be null.");
        }
        subjects.add(s);
    }

    public double calculateGPA() {
        if (subjects.isEmpty()) {
            return 0.0;
        }

        // Weighted average by credit hours.
        double weightedSum = 0.0;
        int totalCredits = 0;

        for (Subject subject : subjects) {
            weightedSum += subject.getGrade() * subject.getCreditHours();
            totalCredits += subject.getCreditHours();
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        return weightedSum / totalCredits;
    }

    public void displayStudentInfo() {
        // Console-friendly layout so details stay readable in menu mode.
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Major: " + major);

        if (subjects.isEmpty()) {
            System.out.println("Subjects: None");
        } else {
            System.out.println("Subjects:");
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + subjects.get(i));
            }
        }

        System.out.printf("Current GPA: %.2f%n", calculateGPA());
    }
}
