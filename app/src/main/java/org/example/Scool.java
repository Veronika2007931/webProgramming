package org.example;

import java.util.ArrayList;
import java.util.List;

class Scool{
    private String Name;
    private String Location;

     public Scool(String Name, String Location){
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

    }