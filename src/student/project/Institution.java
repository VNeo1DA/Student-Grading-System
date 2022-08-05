/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.project;

//Parent Class, other specific class will derive the basics from this one
public class Institution {
    //simply
    private String name;
    //unique ID, differentiates ID
    private String institutionID;
    
    Institution(){
        name = "";
        institutionID = "";
    }
    Institution(String nameP,String institutionIDPar){
        name = nameP;
        institutionID = institutionIDPar;
    }
    public String getName(){
        return name;
    }
    public String getID(){
        return institutionID;
    }

    public void setName(String nameP){
        name = nameP;
    }
    public void setInstitutionID(String idP){
        institutionID = idP;
    }
}
