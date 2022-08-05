package student.project;

import static java.lang.System.out;
import java.text.DecimalFormat;

/**
 * @author Neo
 */
public class StudentAdmission {
    private String applicantFName;
    private String applicantLName;
    private String applicantID;
    private double avgMarks;
   
    StudentAdmission(){
        applicantFName = "";
        applicantLName = "";
        applicantID = "";
        avgMarks = 0.0;
    }
    StudentAdmission(String name,String lastName,String id,double avg){
        applicantFName = name;
        applicantLName = lastName;
        applicantID = id;
        avgMarks = avg;
    }
    public String getName(){return applicantFName;}
    public String getLName(){return applicantLName;}
    public String getID(){return applicantID;}
    public double getAverage(){
       return avgMarks; // grades i.e. Math + Science + etc / numModules
    }
    
    public void printDetails(){
        DecimalFormat twoDec = new DecimalFormat("#.##");
        out.println("Name: " + this.getName());
        out.println("Last Name: " + this.getLName());
        out.println("ID: " + this.getID());
        out.println("Overall Average Attained: " + twoDec.format(this.getAverage()) +
                "%");
    }
}// end of cls