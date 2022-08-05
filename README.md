# Student-Grading-System
Grades Student Grades to determine potential bursary beneficiaries

Created with NetBeans

This is a simple Desktop Application (console only) that takes student details from a comma separated value text file, stores those student (grade 12 / matric) details in objects and stores only the best performing students i.e. Top 10 (based on highest overall subject marks obtained) in a Science University Class. This application uses a composition technique to store Student Objects in an Array based Data Strucrure belonging to a Science University Class. It demonstrates the use of (1) Inheritance (as Science University inherits from Institution - which can have other Universities that inherit from it),
(2) Composition: As the composite class (Science University) has components (StudentAdmission Class objects) that it stores & maintains, and these components are added based on pre-specified criteria (i.e. for a student object to be stored it must have an average of 70.0% or more) Other data structures used include a HashMap<> which helps with printing a report (acts as filter, e.g. filters which students qualified for Astro-Phyisics bursary, or Compuer-Science bursary)
