/*
 * Subject class represents a university subject
 * with a subject name, credit hours, and grade.
 */

public class Subject {

    // Subject name
    private String subjectName;
    // Credit hours for GPA calculation
    private int creditHours;

    // Subject grade
    private double grade;


    /*
     * Constructor
     * Used to create a new Subject object
     */
    public Subject(String subjectName, int creditHours, double grade) {
        setSubjectName(subjectName);
        setCreditHours(creditHours);
        setGrade(grade);
    }


    // Getter for subject name
    public String getSubjectName() {
        return subjectName;
    }


    /*
     * Setter for subject name
     * Validation:
     * - Name cannot be null
     * - Name cannot be empty
     */
    public void setSubjectName(String subjectName) {

        if (subjectName == null || subjectName.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }

        this.subjectName = subjectName.trim();
    }


    // Getter for credit hours
    public int getCreditHours() {
        return creditHours;
    }


    /*
     * Setter for credit hours
     * Validation:
     * - Credit hours must be > 0
     */
    public void setCreditHours(int creditHours) {
        if (creditHours <= 0) {
            throw new IllegalArgumentException("Credit hours must be greater than 0.");
        }
        this.creditHours = creditHours;
    }


    // Getter for grade
    public double getGrade() {
        return grade;
    }


    /*
     * Setter for grade
     * Validation:
     * - Grade must be between 0 and 100
     */
    public void setGrade(double grade) {

        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }

        this.grade = grade;
    }


    /*
     * toString method
     * Returns object data in readable format
     */
    @Override
    public String toString() {

        return String.format(
                "Subject: %-15s Credits: %-2d Grade: %.2f",
                subjectName,
                creditHours,
                grade
        );
    }
}
