package courses.java.oop3;

import courses.java.oop2.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Catalogue {
    HashMap<String, Double> students;

    public Catalogue(HashMap<String, Double> students) {
        this.students = students;
    }

    public Catalogue() {
        this.students = new HashMap<>();
    }

    public void printStudents(){
        for (String student : students.keySet()) {
            System.out.println("- Student: " + student);
            System.out.println("-- Grade: " + students.get(student));
        }
    }

    public void addStudent(String name, Double grade) {
        if (students.containsKey(name)) {
            System.out.println("Student already exists! Used change grade method to adjust the grade!");
        }
        else {
            if (grade >= 0 || grade <= 10)
                students.put(name, grade);
            else
                System.out.println("Grade must be between 0 -> 10 ");
        }
    }

    public boolean searchStudent(String name) {
        if (students.containsKey(name)) {
            System.out.println("- Student: " + name);
            System.out.println("-- Grade: " + students.get(name));
            return true;
        }
        else {
            System.out.printf("Student %s does not appear registered in the catalogue%n", name);
            return false;
        }
    }

    public void deleteStudent(String name) {
        if(searchStudent(name)) {
            students.remove(name);
            System.out.println("Deleting student completed !");
        }
    }

    private static Comparator<String> getCompByName()
    {
        Comparator comp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2)
            {
                return s1.compareTo(s2);
            }
        };
        return comp;
    }

    private static Comparator<Double> getCompByGrade()
    {
        Comparator comp = new Comparator<Double>(){
            @Override
            public int compare(Double s1, Double s2)
            {
                return s1.compareTo(s2);
            }
        };
        return comp;
    }

    public void orderStudentsName() {
        ArrayList<String> studentList = new ArrayList<>();
        studentList.addAll(students.keySet());
        studentList.sort(getCompByName());
        Utils.printList(studentList);
    }

    public void orderStudentsGrade() {
        ArrayList<Double> gradeList = new ArrayList<>();
        gradeList.addAll(students.values());
        gradeList.sort(getCompByGrade());
        Utils.printList(gradeList);
    }
}
