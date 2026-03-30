package org.example;

import java.util.ArrayList;
import java.util.List;

class School{
    private String Name;
    private String Location;

     public School(String Name, String Location){
        setName(Name);
        setLocation(Location);
        
    }

public String getName(){
    return this.Name;
}
public String getLocation(){
    return this.Location;
}

public void setName(String name){
    this.Name = name;
}

public void setLocation(String location){
    this.Location = location;
}
    List<Student> students = new ArrayList<>();
    
    public void addStudent(Student student) {
        students.add(student);
    }
    public void StudentsList(){
        for (Student student : students){
            System.out.print(student.getFirstName() + " " + student.getLastName() );
        }
    }

    public List<Subject> allSubjects = new ArrayList<>();

   
    public void addSubject(Subject subject) {
        this.allSubjects.add(subject);
    }

public Student findStudent(String fName, String lName){
 for(Student s : students){
  if(s.getFirstName().equalsIgnoreCase(fName)&&
  s.getLastName().equalsIgnoreCase(lName)){
    return s;
  }
 }
 return null;
} }