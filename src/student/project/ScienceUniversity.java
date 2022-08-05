package student.project;

import static java.lang.System.out;
import java.util.HashMap;

public class ScienceUniversity extends Institution{
    private int numOfApplicants = 0;
    private final double avgForBursary = 70.0;
    private static HashMap<String, Double> courses;
    //Applicants
    private StudentAdmission[]list;
    //Ctor
    ScienceUniversity(String nameP,String institutionIDPar,int capacity){
        super(nameP, institutionIDPar);
        list = new StudentAdmission[capacity];
    }

    public void addApplicant(StudentAdmission applicant){
        double avgMark = applicant.getAverage();
        if(numOfApplicants < list.length || avgMark >= avgForBursary)
        {
            if(numOfApplicants < list.length)
                numOfApplicants++;

            int currIndex = numOfApplicants - 1;
            while(currIndex > 0 && list[currIndex-1].getAverage() < avgMark)
            {
                list[currIndex] = list[currIndex-1];
                currIndex--;
            }
            list[currIndex] = applicant;
            }
    }

    public void loadCoursesIntoMap(HashMap<String, Double> externalMap){
        //method simply makes quick copy of external Map
        courses = new HashMap<>();
        courses.putAll(externalMap);
    }
    /*Method prints student objects that met the min average of 70%,
    all of them are output to the console*/
    public void printAccepedStudents(){
        if(list.length==0){
            out.println("No Students have been accepted for the bursary"
            + " as yet.");
        }else{
            out.println("The following students were accepted for the" +
                    " bursary program:");
            for(StudentAdmission applicant : list){ //rectify
                applicant.printDetails();
                out.println("----------------------------------------" +
                        "----------------------------");
            }
        }
    }
    //Helper method traverses the list of student objects in search
    //of a student with the supplied student id to see if it exists in list
    public boolean studentInList(String studentID){

        boolean isInList = false;
        
        String existingID = "";
        int i = 0;

        while(i < numOfApplicants && !isInList)
        {
            existingID = list[i].getID();
            if(existingID.equalsIgnoreCase(studentID))
                isInList = true;
            
            i++;
        }
        return isInList;
    } 
    /*remove*/
    
    public StudentAdmission removeStudent(String id){

        StudentAdmission studentDetails = null;
        if(numOfApplicants==0){
            System.out.println("List empty, cannot remove from empty list.");
            System.exit(0);
        }else{
            boolean isFound = false;
            String existingID = "";
            int i = 0;
            while(!isFound && i < numOfApplicants){     //Big O = n x n
              existingID = list[i].getID();
              if(existingID.equalsIgnoreCase(id)){
                  studentDetails = list[i];
                  isFound = true;
                  //move the list items to their appropriate places
                  for(int j = i; j < numOfApplicants - 1; j++)
                      list[j] = list[j+1];
                  list[numOfApplicants - 1] = null;
                  numOfApplicants--;                              
                }
                i++;
            }//end while()
    }
    return studentDetails;
    }
    //Using HashMap, this method takes a coursename i.e. Astro-Physics
    //traverses the list to check which student met the minimum average
    //required for that course and prints them to the screen
   
    public void printReport(String courseName){
        Double avgNeeded = null;
        if(courses.isEmpty()){
            System.out.println("Unfortunatley the list of courses cannot be + "
                    + "found. No report can be printed as the course names + "
                    + "and their averages are missing.");
            System.exit(0);
        }
        else{
            for(String course: courses.keySet()){
                if(courseName.equalsIgnoreCase(course))
                    avgNeeded = courses.get(course);
            }
            if(avgNeeded!=null){
                //output all students that qualified to study particular course
                // who meet average minimum required by bursary funding scheme
                System.out.println("The following students qualify for the "+ 
                        courseName + " bursary scheme");
                for(int j = 0; j < numOfApplicants; j++)
                    if(list[j].getAverage() >= avgNeeded.doubleValue())
                        list[j].printDetails();
                        System.out.println("_________________________________"+
                                "__________________________________________");
            }
        }
    }
}