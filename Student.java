// استدعااء كلاس جاهزه  Array list 
// لتخزين البيانات مكتبه جاهزه 
import java.util.ArrayList;


/**
 * Represents a student in the system.
 */
public class Student {

    private String id;
    private String name;
    private String major;
       // قائمة المواد المسجل بها الطالب
    private ArrayList<Subject> subjects;

    // Constructorلإنشاء طالب جديد
  
    public Student(String id, String name, String major) {
       
        this.id       = id;
        this.name     = name;
        this.major    = major;
          // إنشاء قائمة فارغة للمواد
        this.subjects = new ArrayList<>();         
    }

    // Getters
    // لإرجاع بيانات الطالب
    public String getId()    { return id; }
    public String getName()  { return name; }
    public String getMajor() { return major; }
      
    public ArrayList<Subject> getSubjects() { return subjects; }

    
     
     // إضافة مادة جديدة للطالب
    public void addSubject(Subject subject) {       
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
    }
}
