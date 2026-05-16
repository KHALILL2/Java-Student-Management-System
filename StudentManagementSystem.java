import java.util.ArrayList;

class StudentManagementSystem {
   private ArrayList<Student> students = new ArrayList<>();

   StudentManagementSystem() {
   }

   public void addStudent(Student var1) {
      if (var1 != null) {
         if (this.getStudentById(var1.getId()) != null) {
            throw new IllegalArgumentException("ID already exists");
         } else {
            this.students.add(var1);
         }
      }
   }

   public boolean removeStudent(int var1) {
      Student var2 = this.getStudentById(var1);
      if (var2 == null) {
         return false;
      } else {
         this.students.remove(var2);
         return true;
      }
   }

   public Student getStudentById(int var1) {
      for(Student var3 : this.students) {
         if (var3.getId() == var1) {
            return var3;
         }
      }

      return null;
   }

   public Student getTopGPAStudent() {
      if (this.students.isEmpty()) {
         return null;
      } else {
         Student var1 = (Student)this.students.get(0);

         for(int var2 = 1; var2 < this.students.size(); ++var2) {
            if (((Student)this.students.get(var2)).calculateGPA() > var1.calculateGPA()) {
               var1 = (Student)this.students.get(var2);
            }
         }

         return var1;
      }
   }

   public Student[] getAllStudents() {
      Student[] var1 = new Student[this.students.size()];

      for(int var2 = 0; var2 < this.students.size(); ++var2) {
         var1[var2] = (Student)this.students.get(var2);
      }

      return var1;
   }

   public void displayAllStudents() {
      Student[] all = getAllStudents();
      if (all.length == 0) {
         System.out.println("No students in the system.");
         return;
      }
      for (Student s : all) {
         s.displayStudentInfo();
         System.out.println("-------------------------");
      }
   }

   public void calculateHighestGPA() {
      Student top = getTopGPAStudent();
      if (top != null) {
         System.out.println("Student with highest GPA:");
         top.displayStudentInfo();
      } else {
         System.out.println("No students available.");
      }
   }

   public Student findStudentById(int id) {
      return getStudentById(id);
   }

   public void assignSubjectToStudent(int id, Subject subject) {
      Student s = getStudentById(id);
      if (s != null) {
         s.addSubject(subject);
      }
   }

   public void displayStudentInfo(int id) {
      Student s = getStudentById(id);
      if (s != null) {
         s.displayStudentInfo();
      }
   }

   public double calculateStudentGPA(int id) {
      Student s = getStudentById(id);
      return s != null ? s.calculateGPA() : 0.0;
   }

   public String convertToLetterGrade(double grade) {
      if (grade >= 90) return "A";
      if (grade >= 80) return "B";
      if (grade >= 70) return "C";
      if (grade >= 60) return "D";
      return "F";
   }
}
