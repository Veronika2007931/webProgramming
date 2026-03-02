package main.java.org.example;


class Scool{
    public string Name;
    public string Location;

    List<String> students = new ArrayList<>();
    
    public void addStudent(Student student) {
        students.add(student);
    }
    public void StudentsList(){
        for (String stdent : students){
            System.out.print(student.firstName + " " + student.lastName );
        }
    }

    }