public class Subject {
    // Basic subject data used in GPA calculation.
    private String subjectName;
    private int creditHours;
    private double grade;

    public Subject(String subjectName, int creditHours, double grade) {
        setSubjectName(subjectName);
        setCreditHours(creditHours);
        setGrade(grade);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        if (subjectName == null || subjectName.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }
        this.subjectName = subjectName.trim();
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        if (creditHours <= 0) {
            throw new IllegalArgumentException("Credit hours must be greater than 0.");
        }
        this.creditHours = creditHours;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        // Keep output compact for console listing inside student info.
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", creditHours=" + creditHours +
                ", grade=" + String.format("%.2f", grade) +
                '}';
    }
}
