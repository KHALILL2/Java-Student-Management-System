// استدعااء كلاس جاهزه  Array list 
// لتخزين البيانات مكتبه جاهزه 
import java.util.ArrayList;


/**
 * Represents a student in the system.
 */
public class Student {

    private int id;
    private String name;
    private String major;
       // قائمة المواد المسجل بها الطالب
    private ArrayList<Subject> subjects;

    // Constructorلإنشاء طالب جديد
  
    public Student(int id, String name, String major) {
        setId(id);
        setName(name);
        setMajor(major);
        // إنشاء قائمة فارغة للمواد
        this.subjects = new ArrayList<>();
    }

    // Getters
    // لإرجاع بيانات الطالب
    public int getId()    { return id; }
    public String getName()  { return name; }
    public String getMajor() { return major; }
      
    public ArrayList<Subject> getSubjects() { return subjects; }

    // Setters مع شروط التحقق (Validation) للحفاظ على متانة الكود
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Student ID must be greater than 0.");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.name = name.trim();
    }

    public void setMajor(String major) {
        if (major == null || major.trim().isEmpty()) {
            throw new IllegalArgumentException("Major cannot be empty.");
        }
        this.major = major.trim();
    }

    
     
     // إضافة مادة جديدة للطالب
    public void addSubject(Subject subject) {       
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null.");
        }
        subjects.add(subject);
    }
/*
حساب المعدل التراكمي GPA
باستخدام المتوسط المرجح حسب عدد الساعات
ولو مفيش مواد بيرجع 0
*/
    public double calculateGPA() {
        if (subjects.isEmpty()) return 0.0;

        double totalPoints = 0;
        int    totalCredits = 0;

        // المرور على كل المواد لحساب المجموع
        for (Subject s : subjects) {
            totalPoints  += s.getGrade() * s.getCreditHours();
            totalCredits += s.getCreditHours();
        }

        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

     // عرض بيانات الطالب والمواد المسجل بها
    public void displayStudentInfo() {
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Major      : " + major);

        if (subjects.isEmpty()) {
            System.out.println("Subjects   : No subjects enrolled yet.");
        } else {
              // طباعة جميع المواد
            System.out.println("Subjects   :");
            for (Subject s : subjects) {
                System.out.println("  - " + s);
            }
        }
        System.out.printf("Current GPA: %.2f%n", calculateGPA());
    }
}
