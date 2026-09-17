import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNo;
    private double[] marks;
    private double total;
    private double percentage;
    private char grade;
    private String remarks;

    public Student(String name, int rollNo, double[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        calculatePerformance();
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public char getGrade() {
        return grade;
    }

    private void calculatePerformance() {
        this.total = 0;
        for (double mark : marks) {
            this.total += mark;
        }
        this.percentage = this.total / marks.length;

        if (percentage >= 90) {
            this.grade = 'A';
            this.remarks = "Outstanding Performance";
        } else if (percentage >= 75) {
            this.grade = 'B';
            this.remarks = "Very Good Effort";
        } else if (percentage >= 60) {
            this.grade = 'C';
            this.remarks = "Good, but scope for improvement";
        } else if (percentage >= 40) {
            this.grade = 'D';
            this.remarks = "Satisfactory / Needs Attention";
        } else {
            this.grade = 'F';
            this.remarks = "Needs Immediate Improvement";
        }
    }

    public void displayReportCard() {
        System.out.println("\n------------------------------------");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Marks       : ");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("  Subject " + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Total Marks : " + total);
        System.out.println("Percentage  : " + String.format("%.2f", percentage) + "%");
        System.out.println("Grade       : " + grade);
        System.out.println("Remarks     : " + remarks);
        System.out.println("------------------------------------");
    }
}

public class StudentReportCard {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        while (true) {
            System.out.println("\n===== Student Report Card System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Report Cards");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Show Grade Distribution");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllReports();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    showGradeDistribution();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer roll number.");
            scanner.next();
        }
        int rollNo = scanner.nextInt();

        System.out.print("Enter number of subjects: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number of subjects.");
            scanner.next();
        }
        int numSubjects = scanner.nextInt();

        double[] marks = new double[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Please enter valid marks.");
                scanner.next();
            }
            marks[i] = scanner.nextDouble();
        }

        studentList.add(new Student(name, rollNo, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewAllReports() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : studentList) {
            student.displayReportCard();
        }
    }

    private static void searchStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.print("Enter Roll Number to search: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid roll number.");
            scanner.next();
        }
        int rollNo = scanner.nextInt();

        for (Student student : studentList) {
            if (student.getRollNo() == rollNo) {
                student.displayReportCard();
                return;
            }
        }

        System.out.println("Student with Roll Number " + rollNo + " not found.");
    }

    private static void showGradeDistribution() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (Student student : studentList) {
            switch (student.getGrade()) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
                case 'F': countF++; break;
            }
        }

        System.out.println("\n--- Grade Distribution ---");
        System.out.println("Grade A : " + countA);
        System.out.println("Grade B : " + countB);
        System.out.println("Grade C : " + countC);
        System.out.println("Grade D : " + countD);
        System.out.println("Grade F : " + countF);
    }
}