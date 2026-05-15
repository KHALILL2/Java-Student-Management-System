/*
 * Subject class represents a university subject
 * with a subject name and grade.
 */

public class Subject {

    // Subject name
    private String subjectName;

    // Subject grade
    private double grade;


    /*
     * Constructor
     * Used to create a new Subject object
     */
    public Subject(String subjectName, double grade) {
        setSubjectName(subjectName);
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

        this.subjectName = subjectName;
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
                "Subject: %-15s Grade: %.2f",
                subjectName,
                grade
        );
    }
}
