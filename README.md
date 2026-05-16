# Student Management System (Java)

A console-based Java application for managing students, subjects, GPA calculations, and grade conversion.

This project was prepared for team coursework and focuses on clean structure, input safety, and easy extension.

---

## Overview

The system allows you to:

- Register students with ID, name, and major
- Assign subjects to students by ID
- Calculate GPA using weighted credit hours
- Display one student or all registered students
- Find and display the student with the highest GPA
- Convert numeric grades to letter grades (A-F)

The app runs in a looped text menu and includes strong input validation to prevent crashes.

---

## Features

- **Safe input handling** using `try-catch` and helper input methods
- **Validation rules** for common mistakes:
  - Reject empty names and majors
  - Reject invalid IDs and non-existent student IDs
  - Reject grades below 0 or above 100
  - Reject zero/negative credit hours
- **Weighted GPA formula** based on course credit hours
- **Simple modular design** split across 4 Java classes

---

## Project Structure

```
Java Project/
├── Main.java                     # Entry point + console menu + input handling
├── StudentManagementSystem.java  # Core system logic and student list operations
├── Student.java                  # Student model + subject list + GPA calculation
├── Subject.java                  # Subject model (name, credit hours, grade)
└── README.md                     # Documentation
```

---

## Class Responsibilities

### 1) Subject

Represents one subject/course record:

- `subjectName` (String)
- `creditHours` (int)
- `grade` (double)

Includes constructor, getters/setters, validation, and `toString()`.

### 2) Student

Represents a student profile:

- `id` (int)
- `name` (String)
- `major` (String)
- `subjects` (`ArrayList<Subject>`)

Includes:

- `addSubject(Subject s)`
- `calculateGPA()` (weighted)
- `displayStudentInfo()`

### 3) StudentManagementSystem

Holds all registered students and central operations:

- Add new student
- Assign subject by student ID
- Calculate one student GPA
- Display one student
- Display all students
- `calculateHighestGPA()`
- `convertToLetterGrade(double grade)`

### 4) Main

Application entry point and menu controller:

- Shows menu repeatedly until user exits
- Handles all user input
- Uses input helper methods to avoid invalid parsing crashes

---

## GPA Logic

The GPA is calculated as a weighted average using a precise, continuous **4.0 scale**:

1. Each 0-100 percentage grade is mapped to a grade point:
   - `90 - 100` -> `4.0`
   - `60 - 89` -> Continuous scale from `1.0` to `3.9` (e.g. `85` becomes `3.5`)
   - `< 60` -> `0.0`
2. The grade points are then multiplied by credit hours.

\[
\text{GPA} = \frac{\sum(\text{gradePoint} \times \text{creditHours})}{\sum(\text{creditHours})}
\]

If a student has no subjects, GPA is returned as `0.0`.

---

## Grade Conversion

Implemented in `convertToLetterGrade(double grade)`:

- `90 - 100` -> `A`
- `80 - 89` -> `B`
- `70 - 79` -> `C`
- `60 - 69` -> `D`
- `< 60` -> `F`

---

## Menu Options

- `1` Add Student
- `2` Add Subject
- `3` Display Info (single student)
- `4` Calculate GPA (single student)
- `5` Display All Students
- `8` Calculate Highest GPA
- `9` Convert Grade
- `0` Exit

---

## Build and Run

**Using the included batch script (Windows):**
Simply execute the batch script in your terminal to automatically compile and run:
```bash
.\run.bat
```

**Manually from the command line:**

```bash
javac *.java
java Main
```

---

## Example Flow

1. Add a student (Option 1)
2. Add one or more subjects for that student (Option 2)
3. Display student info (Option 3)
4. Calculate GPA (Option 4)
5. Check highest GPA in the system (Option 8)

---

## Notes for Team Development

- Keep IDs unique for each student.
- Reuse input helper methods when adding new menu options.
- Keep validation inside model/system classes (not only in `Main`) to avoid inconsistent data.
- If you extend the app (file save/load, search, sorting), keep the same separation of concerns used now.

---

## Future Improvements (Optional)

- Save/load data from files (CSV or JSON)
- Sort students by GPA or ID
- Add edit/delete student operations
- Add unit tests for validation and GPA logic

---

## Authoring

Prepared for a team Java coursework workflow with readability and maintainability in mind.
