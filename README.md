#  Student Report Card System

A lightweight, robust Java console application for managing student academic performance, calculating grades, and presenting report card summaries.

---

##  Project Overview

The **Student Report Card System** is an interactive Java console application designed to streamline academic evaluation and record-keeping for students. Built with clean, object-oriented Java principles, the application enables users to register student profiles, record marks across dynamic numbers of subjects, automatically calculate performance metrics, and analyze class grade distributions.

---

##  Key Features

- **Dynamic Student Entry:** Register students with custom roll numbers, names, and subject counts.
- **Automated Performance Calculation:** Automatically computes total marks, percentage, and assigned letter grades.
- **Individual Report Cards:** Generates formatted individual report cards for all enrolled students.
- **Search Functionality:** Instant lookup by unique Student Roll Number.
- **Grade Distribution Summary:** Analyzes and counts performance breakdown across all letter grades (A, B, C, D, F).
- **Input Validation:** Built-in safeguards against non-integer menu selections or invalid score formats.

---

##  Grading Scale

| Percentage Range | Grade Assigned | Academic Standard |
| :--- | :---: | :--- |
| **90% – 100%** | **A** | Outstanding / Distinction |
| **75% – 89.99%** | **B** | Very Good |
| **60% – 74.99%** | **C** | Good / Satisfactory |
| **40% – 59.99%** | **D** | Pass |
| **Below 40%** | **F** | Fail |

---

##  Tech Stack & Requirements

- **Programming Language:** Java (JDK 8 or higher)
- **Standard Packages:** java.util.ArrayList, java.util.Scanner

---

##  Getting Started

### 1. Prerequisites
Ensure Java JDK is installed on your machine. You can verify your installation by running:

 Console Interface Example-

	===== Student Report Card System =====
	1. Add Student
	2. View All Report Cards
	3. Search Student by Roll Number
	4. Show Grade Distribution
	5. Exit
	Enter your choice: 1

	Enter Student Name: Alex Johnson
	Enter Roll Number: 101
	Enter number of subjects: 3
	Enter marks for Subject 1 (out of 100): 88.5
	Enter marks for Subject 2 (out of 100): 92.0
	Enter marks for Subject 3 (out of 100): 95.0
	Student added successfully!


 Class Structure
	Student: Encapsulates private attributes (name, rollNo, marks[], total, percentage, grade). Computes internal academic performance 	metrics upon initialization.

	StudentReportCard: Main controller class hosting the menu-driven system loop, input parsing, memory collection (	ArrayList<Student>), and report actions.
