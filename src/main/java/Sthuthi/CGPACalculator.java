package Sthuthi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CGPACalculator {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\gautham sambath\\IdeaProjects\\learning-workspace\\src\\main\\java\\Sthuthi\\input.csv";
        String detailFile = "C:\\Users\\gautham sambath\\IdeaProjects\\learning-workspace\\src\\main\\java\\Sthuthi\\studentDetail.csv";
        String outputFile = "output.csv";
        String line;
        String csvSplitBy = ",";
        List<Student> students = new ArrayList<>();

        Map<String, String[]> mapOfStudentDetails = getStudentDetailsFromFile(detailFile);
        String regist = "";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String registrationNumber = data[0];
                regist = registrationNumber;

                String[] subjects = getSubjects(data);
                List<String> subjectGrades = new ArrayList<>();

                for (String subject : subjects) {
                    subjectGrades.add(subject);
                }
                registrationNumber = registrationNumber.trim();
                if (mapOfStudentDetails.containsKey(registrationNumber)) {
                    String name = mapOfStudentDetails.get(registrationNumber)[1];
                    String division = mapOfStudentDetails.get(registrationNumber)[4];
                    students.add(new Student(registrationNumber, subjectGrades, name, division));
                } else {
                    students.add(new Student(registrationNumber, subjectGrades, "N/A", "N/A"));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(regist);
            e.printStackTrace();
        }

        students.sort(Comparator.comparingDouble(Student::getCGPA).reversed());

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.append("Registration Number,Subject Grades,CGPA,Name,Division\n");
            for (Student student : students) {
                writer.append(student.getRegistrationNumber()).append(",");
                writer.append(String.join(", ", student.getSubjectGrades())).append(",");
                writer.append(String.format("%.2f", student.getCGPA())).append(",");
                writer.append(student.getName()).append(",");
                writer.append(student.getDivision()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("CSV file with CGPA calculation has been created: " + outputFile);
    }

    private static Map<String, String[]> getStudentDetailsFromFile(String detailFile) {
        String line;
        Map<String, String[]> studentListMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(detailFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                studentListMap.put(data[0], data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentListMap;
    }

    private static String[] getSubjects(String[] data) {
        String[] subjects = new String[data.length - 1];
        int k = 0;
        for (int i = 1; i < data.length; i++) {
            subjects[k++] = data[i];
        }
        return subjects;
    }
}

class Subject {
    private final String code;
    private final String name;
    private final int credits;

    public Subject(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
}

class Student {
    private final String registrationNumber;
    private final String name;
    private final String division;
    private final List<String> subjectGrades;
    private final double cgpa;

    public Student(String registrationNumber, List<String> subjectGrades, String name, String division) {
        this.registrationNumber = registrationNumber;
        this.subjectGrades = subjectGrades;
        this.name = name;
        this.division = division;
        this.cgpa = calculateCGPA();
    }

    public String getName() {
        return name;
    }

    public String getDivision() {
        return division;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public List<String> getSubjectGrades() {
        return subjectGrades;
    }

    public double getCGPA() {
        return cgpa;
    }

    private double calculateCGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (String grade : subjectGrades) {
            grade = grade.replaceAll("\"", "").trim();
            int credits = getSubjectCredits(grade);
            totalCredits += credits;
            totalGradePoints += getCreditsGradePoints(grade) * credits;
        }

        return totalGradePoints / totalCredits;
    }

    private int getSubjectCredits(String grade) {
        // Implement the mapping for subject credits
        // You can use a switch statement or a map for this
        // Here, I'm using a simple if-else statement for demonstration
        if (grade.startsWith("MAT101")) {
            return 4;
        } else if (grade.startsWith("CYT100")) {
            return 4;
        } else if (grade.startsWith("EST110")) {
            return 3;
        } else if (grade.startsWith("EST120")) {
            return 4;
        } else if (grade.startsWith("HUN101")) {
            return 0;
        } else if (grade.startsWith("CYL120")) {
            return 1;
        } else if (grade.startsWith("ESL120")) {
            return 1;
        }

        return 0;
    }

    private double getCreditsGradePoints(String grade) {
        // Implement the mapping for grade points
        // You can use a switch statement or a map for this
        // Here, I'm using a simple if-else statement for demonstration
        if (grade.endsWith("(S)")) {
            return 10;
        } else if (grade.endsWith("(A+)")) {
            return 9;
        } else if (grade.endsWith("(A)")) {
            return 8.5;
        } else if (grade.endsWith("(B+)")) {
            return 8;
        } else if (grade.endsWith("(B)")) {
            return 7.5;
        } else if (grade.endsWith("(C+)")) {
            return 7;
        } else if (grade.endsWith("(C)")) {
            return 6.5;
        } else if (grade.endsWith("(D)")) {
            return 6;
        } else if (grade.endsWith("(P)")) {
            return 5;
        } else if (grade.endsWith("(F)")) {
            return 0;
        }

        return 0;
    }
}

