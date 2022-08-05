package student.project;
/**
 * @author Neo
 * Client Application
 */
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Double.parseDouble;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class testBursaryApp {
    public static void main(String[]args){
       
        String nameOfFile = "Student-Grades1.txt";
        ArrayList<StudentAdmission> studentList = new ArrayList<>();
        /*Open CSV textfile and create Student Instances, Store in Array */
        try{
            processDetails(nameOfFile, studentList);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot find file name: " + nameOfFile);
        }
       /* catch(IOException e)
        {
        System.out.println("Problem with input from file: " + nameOfFile);
        }*/
        
        ScienceUniversity bursaryAdmissions = new ScienceUniversity("Science University",
                "UCT-WC:0010",10); //minimum of i.e. 10 bursaries available
     
        //Create HashMap to store courses offered & min average required
        HashMap<String, Double> modules = new HashMap<>();
        //call client custom method to help populate the courses into map
        loadBursaryCourses(modules);
        
        bursaryAdmissions.loadCoursesIntoMap(modules);
        
        /*Qualify students for limited space bursary, 
        only candidates that meet the minimum average for the science courses
        will be included in the UCT list of approved bursary beneficiaries*/
        qualifyStudents(studentList, bursaryAdmissions);
       
        /*print only the top candidates that qualified for the bursaries,
        this will be the ones with the highest average marks*/
        bursaryAdmissions.printAccepedStudents();
        
        /*call report to output only students who qualify for a specified
        course/who meet specified course's average*/
        bursaryAdmissions.printReport("Computer-Science");
        
        //Search for particular student in list
        boolean isInList;
        isInList = bursaryAdmissions.studentInList("204311");
        if(isInList)
            System.out.println("George is in the list of shortlisted students");
        else
            System.out.println("Student with that ID not found");
        StudentAdmission removeStudent = new StudentAdmission();
        removeStudent = bursaryAdmissions.removeStudent("057823");
        if(removeStudent==null){
            System.out.println("Student could not be removed from list, " +
                    "check if that student is actually on the list.");
        }else{
            System.out.println("Student with the following details removed: ");
            removeStudent.printDetails();
        }
        

        
    }
    //client helper function(1):
    //opens CSV textfile and creates Student Objects that store student details
    private static void processDetails(String nameOfFileP, ArrayList stuList)
    throws FileNotFoundException {
                Scanner inputStream = new Scanner(new File(nameOfFileP));
                //read entire line & discard
                String line = inputStream.nextLine(); 
                
                String fName = "",lName ="", idNum ="";
                
                double totalStudentAVG;
                int numSubjects = 7;

                while(inputStream.hasNextLine())
                {  //start to read actual data
                    line = inputStream.nextLine();
                    
                    String[] stuARY = line.split(",");

                    fName = stuARY[0];
                    lName = stuARY[1].trim();
                    idNum = stuARY[2].trim();
                   
                    totalStudentAVG = 0.0;

                    int lastIndex = stuARY.length;
                    for(int i = 3; i < lastIndex; i++)
                    {
                        totalStudentAVG += parseDouble(stuARY[i]);
                    }
                    totalStudentAVG = totalStudentAVG/numSubjects;
                    
                    StudentAdmission applicant = new StudentAdmission(fName, lName,
                    idNum,totalStudentAVG);
                    stuList.add(applicant);
                }
                inputStream.close();
    }

    /*client method loadCourses populates courses to external HashMap<xx, xx>,
    this HashMap<xx,xx> will be used to help initialize the internal HashMap<>*/
    private static void loadBursaryCourses(HashMap<String, Double> map){
        map.put("Astro-Physics", 85.0);
        map.put("Computer-Science", 75.0);
        map.put("Medicine", 80.0);
        map.put("Mechanical Engineering", 70.0);
        map.put("Micro-Biology", 72.0);        
    }   
    private static void qualifyStudents(ArrayList<StudentAdmission> candidates,
            ScienceUniversity allocatedSpace){
        //loop through candidates list & assign only the ones with the top averages
        for(StudentAdmission candidate: candidates){
            allocatedSpace.addApplicant(candidate);
        }    
    }
}